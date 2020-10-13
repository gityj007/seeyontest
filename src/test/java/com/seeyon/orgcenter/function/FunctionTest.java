package com.seeyon.orgcenter.function;

import com.seeyon.orgcenter.manage.function.entity.OrgFunction;
import com.seeyon.orgcenter.manage.function.service.IOrgFunctionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FunctionTest{

	@Autowired
	private IOrgFunctionService orgFunctionService;

	@Test
	public void testGetAllOrgFunction(){
		List<OrgFunction> list = orgFunctionService.getList();
		for(OrgFunction orgFunction:list){
			System.out.println("对象ID："+orgFunction.getId());
		}
	}
}
