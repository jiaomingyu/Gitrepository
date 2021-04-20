package com.jpl.service.impl;

import com.jpl.dubbo.service.DeptDubboService;
import com.jpl.dubbo.service.EmpDubboService;
import com.jpl.pojo.Dept;
import com.jpl.pojo.Emp;
import com.jpl.service.DeptService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.List;
//
@Service
public class DeptServiceImpl implements DeptService {
    @Reference
    private DeptDubboService deptDubboService;
    @Reference
    private EmpDubboService empDubboService;
    @Override
    public List<Dept> findAll() {
        return deptDubboService.findAllDept();
    }

    @Override
    public List<Emp> findEmpByDeptId(Integer did) {
        return empDubboService.findEmpByDeptId(did);
    }
}
