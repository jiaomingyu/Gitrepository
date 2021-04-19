package com.jpl.service.impl;

import com.jpl.dubbo.service.DeptDubboService;
import com.jpl.pojo.Dept;
import com.jpl.service.DeptService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Reference
    private DeptDubboService deptDubboService;
    @Override
    public List<Dept> findAll() {
        return deptDubboService.findAllDept();
    }
}
