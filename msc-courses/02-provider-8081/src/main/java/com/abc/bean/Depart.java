package com.abc.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Author guangyan
 * @Date 2020/9/23
 */
@Data
@Entity  // 不给表指定名称，表名就使用类名
// HttpMessageConverter Jackson -> 完成java对象与json数据键的转换工作
// jpa的默认实现时hibernate, 而hibernate默认对于对象的查询时基于延迟加载的
// 延迟加载解释: 对于Depart depart = service.findById(5); 这里的depart实际是一个javasist动态代理对象，只有在实际访问的时候才会加载
// 真实对象，比如String name = depart.getName()
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "fieldHandler"})
public class Depart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键自动递增
    private Integer id;
    private String name;
}
