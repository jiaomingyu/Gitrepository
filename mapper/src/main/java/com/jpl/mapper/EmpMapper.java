package com.jpl.mapper;

import com.jpl.pojo.Emp;

import java.util.List;
//
public interface EmpMapper {
    int insertEmp(Emp emp);
    List<Emp> findEmpByDeptId(Integer did);
}
