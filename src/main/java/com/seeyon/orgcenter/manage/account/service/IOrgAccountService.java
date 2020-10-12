package com.seeyon.orgcenter.manage.account.service;

import com.seeyon.orgcenter.manage.account.entity.OrgAccount;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  账号管理Service
 * </p>
 *
 * @author yangjian
 * @since 2020-10-11
 */
public interface IOrgAccountService extends IService<OrgAccount> {


    /**
     * 更新账号密码
     * @param id
     * @param Pass
     */
   void updatePass(Long id,String Pass);

    /**
     * 密码加密
     * @return
     */
    String passEncryption(String className,String Pass);


}
