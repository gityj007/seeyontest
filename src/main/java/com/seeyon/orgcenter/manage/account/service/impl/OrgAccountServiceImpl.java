package com.seeyon.orgcenter.manage.account.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.seeyon.orgcenter.manage.account.entity.OrgAccount;
import com.seeyon.orgcenter.manage.account.mapper.OrgAccountMapper;
import com.seeyon.orgcenter.manage.account.service.IOrgAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seeyon.orgcenter.util.SHA;
import org.springframework.stereotype.Service;

/**
 * <p>
 *   账号管理Service服务实现类
 * </p>
 *
 * @author yangjian
 * @since 2020-10-11
 */
@Service
public class OrgAccountServiceImpl extends ServiceImpl<OrgAccountMapper, OrgAccount> implements IOrgAccountService {

    /**
     * 更新账号密码
     *
     * @param id
     * @param Pass
     */
    @Override
    public void updatePass(Integer id, String Pass) {
        OrgAccountMapper orgAccountMapper = getBaseMapper();
        //条件
        UpdateWrapper<OrgAccount> orgAccountUpdateWrapper = new UpdateWrapper<>();
        orgAccountUpdateWrapper.eq("id",id);
        //更新值
        OrgAccount orgAccount=new OrgAccount();
        orgAccount.setCredentialValue(passEncryption("",Pass));
        orgAccountMapper.update(orgAccount,orgAccountUpdateWrapper);
    }

    /**
     * 密码加密
     *
     * @return
     */
    @Override
    public String passEncryption(String className, String Pass) {
        return SHA.getCode(Pass);
    }
}
