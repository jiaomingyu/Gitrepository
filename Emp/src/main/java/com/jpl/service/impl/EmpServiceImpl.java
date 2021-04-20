package com.jpl.service.impl;

import com.jpl.dubbo.service.DeptDubboService;
import com.jpl.dubbo.service.EmpDubboService;
import com.jpl.pojo.Dept;
import com.jpl.pojo.Emp;
import com.jpl.service.EmpService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@Service
public class EmpServiceImpl implements EmpService {
    @Reference
    private DeptDubboService deptDubboService;
    @Reference
    private EmpDubboService empDubboService;
    @Override
    public List<Dept> showAll() {
        return deptDubboService.findAllDept();
    }

    @Override
    public int insert(Emp emp, MultipartFile file) {
        try {
            //通过Spring容器获取HttpServletRequest对象
            HttpServletRequest request=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            //通过HttpServletRequest对像 获取上传图片路径
            String path=request.getServletContext().getRealPath("/img");
            System.out.println("path=="+path);
            //为了上传到服务器中的图片名不重复 编写随机数
            long l = System.currentTimeMillis();
            Random random=new Random();
            String fileName=l+""+random.nextInt(1000);
            String oldName=file.getOriginalFilename();
            //通过图片原名获取图片的后缀名
            fileName+=oldName.substring(oldName.lastIndexOf("."));
            File pathFile = new File(path);
            //第一次上传图片检查目录是否存在 如果不存在 创建响应目录
            if(!pathFile.exists()){
                pathFile.mkdir();
            }
            //图片上传
            file.transferTo(new File(path,fileName));
            //封装Emp对象 把图片路径封装到emp对象
            emp.setPhoto("http://localhost:8081/img/"+fileName);
            //把Emp保存到数据库
            return empDubboService.insertEmp(emp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
