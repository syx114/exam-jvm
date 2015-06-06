package cn.yintai.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yintai.test.dao.TestDao;
import cn.yintai.test.po.Client;
import cn.yintai.test.po.Record;
import cn.yintai.test.service.TestServiceDao;
import cn.yintai.test.utils.H2Test;

@Controller
@RequestMapping("/json")
public class TestController {
	
	@Autowired 
	private TestServiceDao testServiceDao;
	@RequestMapping("/{name}/{price}/")
	public @ResponseBody Record test(@PathVariable("name") String name,@PathVariable("price") Double price){
		
		Record record = testServiceDao.test1(name, price);
		
		return record;
	}
	
	@RequestMapping("/{status}/")
	public @ResponseBody List<Record> select(@PathVariable("status") Integer status){
		
		List<Record> list = testServiceDao.selectRecordByStatus(status);
		return list;
	}
	
	
}
