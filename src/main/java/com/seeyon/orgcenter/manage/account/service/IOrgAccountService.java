package com.seeyon.orgcenter.manage.account.service;

import com.seeyon.orgcenter.common.ResultBody;
import com.seeyon.orgcenter.manage.account.entity.OrgAccount;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestParam;

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
     * 获取账号IDByLoginInfo
     * @param loginName
     * @param password
     * @return
     */
   ResultBody getAccountIdByLoginInfo( String loginName,  String password);

    /**
     * 密码加密
     * @return
     */
    String passEncryption(String className,String Pass);


}
