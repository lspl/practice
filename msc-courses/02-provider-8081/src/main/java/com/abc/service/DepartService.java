package com.abc.service;

import com.abc.bean.Depart;

import java.util.List;

/**
 * @Author guangyan
 * @Date 2020/9/24
 */
public interface DepartService {
    boolean saveDepart(Depart depart);
    boolean removeDepartById(Integer id);
    boolean modifyDepart(Depart depart);
    Depart getDepartById(int id);
    List<Depart> listAllParts();
}
