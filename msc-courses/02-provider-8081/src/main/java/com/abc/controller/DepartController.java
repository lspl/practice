package com.abc.controller;

import com.abc.bean.Depart;
import com.abc.service.DepartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author guangyan
 * @Date 2020/10/2
 */
@Slf4j
@RestController
@RequestMapping("/provider/depart")
public class DepartController {
    @Resource
    private DepartService departService;
    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * post和put区别：https://blog.csdn.net/maxmao1024/article/details/79591726
     * 总结：put操作幂等，而post不是
     * @param depart
     * @return
     */
    @PostMapping("/save")
    public boolean saveHandler(@RequestBody Depart depart) {
        return departService.saveDepart(depart);
    }

    @DeleteMapping("/del/{id}")
    public boolean delHandler(@PathVariable("id") Integer id) {
        return departService.removeDepartById(id);
    }

    @PutMapping("/update")
    public boolean updateHandler(@RequestBody Depart depart) {
        return departService.modifyDepart(depart);
    }

    @GetMapping("/get/{id}")
    public Depart getHandler(@PathVariable("id") Integer id) {
        return departService.getDepartById(id);
    }

    @GetMapping("/list")
    public List<Depart> listHandler() {
        return departService.listAllParts();
    }

    @GetMapping("/discovery")
    private List<String> discoveryHandler() {
        List<String> services = discoveryClient.getServices();
        for (String name : services) {
            // 获取当前遍历微服务名称的所有提供者主机
            List<ServiceInstance> instances = discoveryClient.getInstances(name);
            // 遍历所有提供者主机的详情
            for (ServiceInstance instance : instances) {
                // 获取当前提供者的唯一标识
                String serviceId = instance.getServiceId();
                String instanceId = instance.getInstanceId();
                // 获取当前提供者主机的host
                String host = instance.getHost();
                Map<String, String> metadata = instance.getMetadata();
                log.info("serviceId:{}, instanceId:{}, host:{}, metadata:{}", serviceId, instanceId, host, metadata);
            }
        }
        return services;
    }
}
