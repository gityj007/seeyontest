package com.seeyon.orgcenter.manage.account.service.impl;

import com.seeyon.orgcenter.common.ErrorEnum;
import com.seeyon.orgcenter.common.ResultBody;
import com.seeyon.orgcenter.common.baseservice.impl.BaseServiceImpl;
import com.seeyon.orgcenter.manage.account.entity.OrgAccount;
import com.seeyon.orgcenter.manage.account.mapper.OrgAccountMapper;
import com.seeyon.orgcenter.manage.account.service.IOrgAccountService;
import com.seeyon.orgcenter.util.SHA;
import org.springframework.stereotype.Service;

import java.util.List;



/**
 * <p>
 *   账号管理Service服务实现类
 * </p>
 *
 * @author yangjian
 * @since 2020-10-11
 */
@Service
public class OrgAccountServiceImpl extends BaseServiceImpl<OrgAccountMapper, OrgAccount> implements IOrgAccountService {



    /**
     * 更新账号密码
     *
     * @param id
     * @param Pass
     */
    @Override
    public void updatePass(Long id, String Pass) {
        OrgAccountMapper orgAccountMapper = getMapper();

        OrgAccount orgAccount=new OrgAccount();
        //条件
        orgAccount.setId(id);
        //更新值
        orgAccount.setCredentialValue(passEncryption("",Pass));

        orgAccountMapper.updateByPrimaryKeySelective(orgAccount);
    }

    /**
     * 获取账号IDByLoginInfo
     *
     * @param loginName
     * @param password
     * @return
     */
    @Override
    public ResultBody getAccountIdByLoginInfo(String loginName, String password) {
        String passCode =passEncryption("",password);
        OrgAccount orgAccountParam=new OrgAccount();
        orgAccountParam.setLoginName(loginName);
        orgAccountParam.setCredentialValue(passCode);
        List<OrgAccount> orgAccounts = selectByPrimarySelective(orgAccountParam);
        if(orgAccounts.size()==0){
           ResultBody resultBody = ResultBody.error(ErrorEnum.NOT_EXISTS);
           return resultBody;
        }else if(orgAccounts.size()>1){
            ResultBody resultBody = ResultBody.error(ErrorEnum.NOT_EXISTS);
            return resultBody;
        }
        ResultBody resultBody = ResultBody.success(orgAccounts.get(0).getId());
        resultBody.setMsg("请求成功！");
        return resultBody;
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
