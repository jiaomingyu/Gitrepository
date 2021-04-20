package com.jpl.dubbo.service;

import com.jpl.pojo.Emp;

import java.util.List;

public interface EmpDubboService {
    int insertEmp(Emp emp);
    List<Emp> findEmpByDeptId(Integer did);
}
