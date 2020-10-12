package com.seeyon.orgcenter.manage.account.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.seeyon.orgcenter.common.ErrorEnum;
import com.seeyon.orgcenter.common.ResultBody;
import com.seeyon.orgcenter.manage.account.entity.OrgAccount;
import com.seeyon.orgcenter.manage.account.mapper.OrgAccountMapper;
import com.seeyon.orgcenter.manage.account.service.IOrgAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seeyon.orgcenter.util.SHA;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

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
    public void updatePass(Long id, String Pass) {
        OrgAccountMapper orgAccountMapper = getBaseMapper();
        //条件
        UpdateWrapper<OrgAccount> orgAccountUpdateWrapper = new UpdateWrapper<OrgAccount>();
        orgAccountUpdateWrapper.eq("id",id);
        //更新值
        OrgAccount orgAccount=new OrgAccount();
        orgAccount.setCredentialValue(passEncryption("",Pass));
        orgAccountMapper.update(orgAccount,orgAccountUpdateWrapper);
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
        LambdaQueryWrapper<OrgAccount> queryWrapper=new LambdaQueryWrapper<OrgAccount>();
        queryWrapper.eq(OrgAccount::getLoginName,loginName).eq(OrgAccount::getCredentialValue,passCode).select(OrgAccount::getId);
        Map map=getMap(queryWrapper);
        if(map==null){
            ResultBody resultBody = ResultBody.error(ErrorEnum.NOT_EXISTS);
            return resultBody;
        }
        Optional<Object> id = Optional.ofNullable(map).map(m -> map.get("ID"));
        ResultBody resultBody = ResultBody.success(id);
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
