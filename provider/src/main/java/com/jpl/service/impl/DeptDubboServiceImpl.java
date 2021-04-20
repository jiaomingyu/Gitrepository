package com.jpl.service.impl;

import com.jpl.dubbo.service.DeptDubboService;
import com.jpl.mapper.DeptMapper;
import com.jpl.pojo.Dept;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@Service
public class DeptDubboServiceImpl implements DeptDubboService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> findAllDept() {
        return deptMapper.findAll();
    }

}
