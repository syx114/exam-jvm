package cn.yintai.test.dao;

import java.util.List;

import cn.yintai.test.po.Client;
import cn.yintai.test.po.Record;

public interface TestDao {
	
	/**
	 * 增加记录
	 * @param record
	 * @param name
	 * @throws Exception
	 */
	public void createRecord(Record record,String uuid,Client client) throws Exception;
	/**
	 * 增加客户信息
	 * @param client
	 * @throws Exception
	 */
	public void createClient(Client client,String uuid) throws Exception;
	/**
	 * 通过姓名查找客户信息
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public Client selectClientByName(String name) throws Exception;
	
	public Record selectRecordById(String id) throws Exception;
	public List<Record> selectRecordByStatus(Integer status);
	
}
