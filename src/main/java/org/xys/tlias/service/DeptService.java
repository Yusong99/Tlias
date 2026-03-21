package org.xys.tlias.service;

import org.xys.tlias.pojo.Dept;

import java.util.List;

//部门业务规则
public interface DeptService {

    /**
     * 查询所有的部门数据
     * @return   存储Dept对象的集合
     */
    List<Dept> list();
}
