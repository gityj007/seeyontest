package com.seeyon.orgcenter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RestController
@RequestMapping(value="/test")
public class testController{

	@RequestMapping(value="/save", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> save(HttpServletRequest request) {
		Map<String,Object> result = new HashMap<>();
		result.put("name",123);
		result.put("age",1);
		return result;
	}
}
