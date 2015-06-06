package cn.yintai.test.service;

import java.util.List;

import cn.yintai.test.po.Client;
import cn.yintai.test.po.Record;

public interface TestServiceDao {
	/**
	 * 业务一 创建交易记录
	 * @param name
	 * @param price
	 * @return
	 */
	public Record test1(String name,Double price);

	public List<Record> selectRecordByStatus(Integer status);

}
