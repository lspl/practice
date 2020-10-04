package com.abc.controller;

import com.abc.bean.Depart;
import com.abc.service.DepartService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author guangyan
 * @Date 2020/10/2
 */
@RestController
@RequestMapping("/provider/depart")
public class DepartController {
    @Resource
    private DepartService departService;

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
}
