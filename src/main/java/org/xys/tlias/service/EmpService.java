package org.xys.tlias.service;

import org.xys.tlias.pojo.Emp;
import org.xys.tlias.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

//员工业务规则
public interface EmpService {

    /**
     * 条件分页查询
     * @param page     页码
     * @param pageSize 每页展示记录数
     * @param name     姓名
     * @param gender   性别
     * @param begin   开始时间
     * @param end     结束时间
     * @return
     */
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);


    /**
     * 批量删除操作
     * @param ids id集合
     */
    void delete(List<Integer> ids);

    /**
     * 保存员工信息
     * @param emp
     */
    void save(Emp emp);
}
