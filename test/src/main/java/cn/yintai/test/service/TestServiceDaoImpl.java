package cn.yintai.test.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import cn.yintai.test.dao.TestDao;
import cn.yintai.test.dao.TestDaoImpl;
import cn.yintai.test.po.Client;
import cn.yintai.test.po.Record;
import cn.yintai.test.utils.H2Test;

@Service
public class TestServiceDaoImpl implements TestServiceDao {

	@Autowired
	private TestDao testDao = new TestDaoImpl() ;
	
	public Record test1(String name,Double price){
		Client client = new Client();
		Record record = new Record();
		client.setName(name);
		record.setPrice(price);
		String uuid = H2Test.getUUID();
		try {
			testDao.createRecord(record,uuid, client);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			record = testDao.selectRecordById(uuid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return record;
	}

	@Override
	public List<Record> selectRecordByStatus(Integer status) {
		List<Record> list = testDao.selectRecordByStatus(status);
		return list;
	}
}
