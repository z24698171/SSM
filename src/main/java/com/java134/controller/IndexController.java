package com.java134.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.java134.mapper.CategoryMapper;
import com.java134.pojo.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletResponse;

// 告诉spring mvc这是一个控制器类
@Controller
@RequestMapping("")
public class IndexController {
	@Autowired
	CategoryMapper categoryMapper;

	@RequestMapping("/getData")
	@ResponseBody
	public Map<String,Object> redis() throws Exception {
		Map<String,Object> map=new HashMap<String,Object>();
		List<Blog> list=categoryMapper.list();
		if(list.size()!=0&&list!=null){
			map.put("msCode","0000");
			map.put("data",list);
		}
		return map;

	}

	@RequestMapping("/")
	public String index(Model model, HttpServletResponse response) {
		return "/index";
	}


}
