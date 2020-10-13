package com.seeyon.orgcenter.common.baseservice.impl;


import com.seeyon.orgcenter.common.basemapper.BaseMapper;
import com.seeyon.orgcenter.common.baseservice.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public  class BaseServiceImpl<M extends BaseMapper<T>, T> implements BaseService<T>{
    @Autowired
    protected M baseMapper;

    public M getMapper(){
        return this.baseMapper;
    }

    // 插入设置，调用dao层函数
    public int insert(T record) {
        return baseMapper.insert(record);
    }

    // 插入非空字段
    public int insertSelective(T record) {
        return baseMapper.insertSelective(record);
    }

    // 通过主键进行查询
    public T selectByPrimaryKey(Object id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    // 通过条件查找
    public List<T> selectByPrimarySelective(T record) {
        return baseMapper.selectByPrimarySelective(record);
    }

    // 通过实体类进行部分更新处理
    public int updateByPrimaryKeySelective(T record) {
        return baseMapper.updateByPrimaryKey(record);
    }

    // 通过实体类对象进行全部更新处理
    public int updateByPrimaryKey(T record) {
        return baseMapper.updateByPrimaryKey(record);
    }

    // 查询数据，存储List
    public List<T> query(T record) {
        return baseMapper.selectByPrimarySelective(record);
    }

    // 统计数据
    public int selectCount(T record) {
        return baseMapper.selectCount(record);
    }

    // 根据主键进行删除
    public int deleteByPrimaryKey(Object id) {
        return baseMapper.deleteByPrimaryKey(id);
    }
}
