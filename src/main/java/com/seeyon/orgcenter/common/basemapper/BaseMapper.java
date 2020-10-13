package com.seeyon.orgcenter.common.basemapper;

import java.util.List;

public interface BaseMapper<T> {
    // 将数据插入数据库，插入对象为实体类对象
    int insert(T record);
    // 根据主键进行删除数据库数据，一次删除一条,返回数值
    int deleteByPrimaryKey(Object id);
    // 自定义插入列
    int insertSelective(T record);
    // 根据主键进行查找数据
    T selectByPrimaryKey(Object id);

    // 根据对象进行查询数据库，返回List列表
    List<T> selectByPrimarySelective(T record);

    // 根据实体类对象进行更新操作，可更新部分数据或者全部数据
    int updateByPrimaryKeySelective(T record);
    // 根据对象进行更新数据库，必须全部数据要进行更新
    int updateByPrimaryKey(T record);



    // 根据对象进行查询数据库，统计查出的数据有多哦少
    int selectCount(T record);
//    // 进行分页处理
//    List<T> select(Map map);
}
