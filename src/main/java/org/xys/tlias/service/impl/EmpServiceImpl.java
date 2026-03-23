package org.xys.tlias.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xys.tlias.mapper.EmpMapper;
import org.xys.tlias.pojo.Emp;
import org.xys.tlias.pojo.PageBean;
import org.xys.tlias.service.EmpService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

//员工业务实现类
@Slf4j
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper  empMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        //1、获取总记录数
        //Long count = empMapper.count();

        //2、获取分页查询结果列表
        //Integer start = (page - 1) * pageSize;//计算起始索引 , 公式: (页码-1)*页大小
        //List<Emp> empList = empMapper.list(page, pageSize);

        //3、封装PageBean对象
        //return new PageBean(count, empList);

        // 设置分页参数
        PageHelper.startPage(page, pageSize);
        // 执行分页查询
        //执行条件分页查询
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        // 获取分页结果
        Page<Emp> p = (Page<Emp>) empList;
        //封装PageBean
        return new PageBean(p.getTotal(), p.getResult());
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void save(Emp emp) {
        //补全数据
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        //调用添加方法
        empMapper.insert(emp);
    }

}
