package com.seeyon.orgcenter.common.baseservice;


import java.util.List;

public interface BaseService<T> {
    // 通过实体类进行插入数据库
    int insert(T record);

    //批量插入
    int insertBatch(List list);

    // 根据主键进行删除数据
    int deleteByPrimaryKey(Object id);

    // 通过实体类进行插入数据库
    int insertSelective(T record);

    //插入或更新非空字段
    int saveOrUpdateSelective(T record);

    // 根据主键进行查询数据库
    T selectByPrimaryKey(Object id);

    // 通过条件查找
    List<T> selectByPrimarySelective(T record);

    // 根据实体类对象进行部分更新数据库
    int updateByPrimaryKeySelective(T record);

    // 根据实体类对象进行全部更新数据库
    int updateByPrimaryKey(T record);

    // 统计查询的数量
    //int selectCount(T record);
    //// 分页查询处理
    //List<T> select(T record, Page page);
}
