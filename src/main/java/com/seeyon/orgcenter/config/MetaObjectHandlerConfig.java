package com.seeyon.orgcenter.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 *  <p>
 *      mybatis 配置默认值
 *  </p>
 *
 * @author yangjian
 */
@Component
public class MetaObjectHandlerConfig implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        Date currentDate = new Date();
        //默认未删除
        setFieldValByName("isDeleted", 0, metaObject);
        //默认启用
        setFieldValByName("isEnable", 1, metaObject);

        //创建时间默认当前时间
        setFieldValByName("createTime", currentDate, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Date currentDate = new Date();
        //修改时间
        setFieldValByName("updateTime", currentDate, metaObject);
    }
}
