package com.jpl.service;

import com.jpl.pojo.Dept;
import com.jpl.pojo.Emp;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
//
public interface EmpService {
    List<Dept> showAll();
    int insert(Emp emp, MultipartFile file);
}
