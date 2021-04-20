package com.jpl.service;

import com.jpl.pojo.Dept;
import com.jpl.pojo.Emp;

import java.util.List;

public interface DeptService {
    List<Dept> findAll();
    List<Emp> findEmpByDeptId(Integer did);
}
