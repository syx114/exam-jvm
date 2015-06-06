package cn.yintai.test.controller;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import cn.yintai.test.dao.TestDao;
import cn.yintai.test.dao.TestDaoImpl;
import cn.yintai.test.po.Client;
import cn.yintai.test.po.Record;
import cn.yintai.test.utils.H2Test;

public class TestControllerTest {

	private TestDao testDao = new TestDaoImpl();
	@Before
	public void setUp() throws Exception {
		for(int i=0;i<5;i++){
			if(i<3){
				Record record = new Record();
				record.setOrderStatus(1);
				String uuid = H2Test.getUUID();
				Client client = new Client();
				client.setName(String.valueOf(i));
				testDao.createRecord(record, uuid, client);
			}else{
				Record record = new Record();
				record.setOrderStatus(0);
				String uuid = H2Test.getUUID();
				Client client = new Client();
				client.setName(String.valueOf(i));
				testDao.createRecord(record, uuid, client);
				
			}
		}
	}

	@Test
	public void testSelect() {
		fail("Not yet implemented");
	}

}
