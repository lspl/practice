package com.abc.service;

import com.abc.bean.Depart;
import com.abc.repository.DepartRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author guangyan
 * @Date 2020/9/24
 */
@Service
public class DepartServiceImpl implements DepartService{
    @Resource
    private DepartRepository departRepository;

    /**
     * jpa插入策略
     * @param depart
     * 1. depart的id为null: save()执行的是插入操作
     * 2. depart的id不为null，且DB中该id存在：save()执行的是修改操作
     * 3. depart的id不为null, 但DB中该id不存在：save()执行的是插入操作，但其插入后的记录id值并不是这里指定的id,而是其根据指定的id
     *      生成策略所生成的
     * @return
     */
    @Override
    public boolean saveDepart(Depart depart) {
        Depart obj = departRepository.save(depart);
        return obj != null;
    }

    @Override
    public boolean removeDepartById(Integer id) {
        // 在db中指定的id如果不存在，该方法会抛出异常
        if (departRepository.existsById(id)) {
            departRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyDepart(Depart depart) {
        return saveDepart(depart);
    }

    @Override
    public Depart getDepartById(int id) {
        // 在db中指定的id如果不存在，该方法会抛出异常
        if (departRepository.existsById(id)) {
            return departRepository.getOne(id);
        }
        return null;
    }

    @Override
    public List<Depart> listAllParts() {
        return departRepository.findAll();
    }
}
