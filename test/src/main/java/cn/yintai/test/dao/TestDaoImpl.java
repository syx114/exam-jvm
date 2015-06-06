package cn.yintai.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.yintai.test.po.Client;
import cn.yintai.test.po.Record;
import cn.yintai.test.utils.H2;
import cn.yintai.test.utils.H2Test;

public class TestDaoImpl implements TestDao {

	
	private Connection conn = null;
	
	@Autowired
	private H2 h2;
	
	public void createRecord(Record record,String uuid,Client client) throws Exception {
			
		Connection con = H2Test.getConnection(conn);
		Client exClient = selectClientByName(client.getName());
		String clientUUID = null;
		String sqlr = "INSERT INTO Record(ID,PRICE,ORDERSTATUS,CLIENTID) VALUES(?,?,?,?)";
		PreparedStatement psr = con.prepareStatement(sqlr);
		try {
			//判断客户是否存在
			if(exClient==null){
				clientUUID = H2Test.getUUID();
				createClient(client,clientUUID);
			}else{
				clientUUID = client.getId();
			}
			
			//设置记录信息
			psr.setString(1, uuid);
			psr.setDouble(2, record.getPrice());
			//设置记录为交易等待支付状态，2代表等待支付，1为支付成功，0为支付失败
			psr.setInt(3, 2);	
			psr.setString(4, clientUUID);
			
			psr.execute();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				psr.close();
				con.close();
			}
			
		
	}
	
	public List<Record> selectRecordByStatus(Integer status) {
		Connection con = H2Test.getConnection(conn);
		String sql = "select * from Record where orderStatus = ?";
		List<Record> list = new ArrayList<Record>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, status);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Record record = new Record();
				record.setId(rs.getString("id"));
				record.setPrice(rs.getDouble("price"));
				record.setOrderStatus(rs.getInt("orderStatus"));
				record.setClientId(rs.getString("clientId"));
				list.add(record);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public Client selectClientByName(String name) throws Exception {
		
		
		Connection con = H2Test.getConnection(conn);
		String sql = "select * from Client where name = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		rs.last();        //指针移到最后一行 
		if(rs.getRow()== 0)
		  {
		    return null;
		  }
		 else
		  {
		    Client client = new Client();
		    client.setName(rs.getString("name"));
		    client.setId(rs.getString("id"));
		    return client;
		  }  
	}

	
	@Override
	public void createClient(Client client,String uuid) throws Exception {
		
		String sqlc = "INSERT INTO Client(ID,NAME) VALUES(?,?)";
		
		Connection con = H2Test.getConnection(conn);
		PreparedStatement ps = null;
		
		ps = con.prepareStatement(sqlc);
		//设置客户信息
		ps.setString(1, uuid);
		ps.setString(2, client.getName());
		ps.execute();
		
		ps.close();
		con.close();
		
	}

	@Override
	public Record selectRecordById(String id) throws Exception {
		Record record = new Record();
		String sql = "select * from Record where id = ?";
		Connection con = H2Test.getConnection(conn);
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			record.setId(rs.getString("id"));
			record.setPrice(rs.getDouble("price"));
			record.setOrderStatus(rs.getInt("orderStatus"));
			record.setClientId(rs.getString("clientId"));
		}
		return record;
	}

	

}
	

	

	
	
	
	
	
	
	
	//----------------------------------------------
	/*static Integer SIZE = 5;
	static List<Record> list = null;
	TestDaoImpl(){
		
	}
	static{
		Record rec1 = new Record();
		rec1.setId(1L);
		rec1.setOrderStatus(1);
		Record rec2 = new Record();
		rec1.setId(2L);
		rec1.setOrderStatus(1);
		Record rec3 = new Record();
		rec1.setId(3L);
		rec1.setOrderStatus(1);
		Record rec4 = new Record();
		rec1.setId(4L);
		rec1.setOrderStatus(0);
		Record rec5 = new Record();
		rec1.setId(5L);
		rec1.setOrderStatus(0);
		list = new ArrayList<Record>();
		list.add(rec1);
		list.add(rec2);
		list.add(rec3);
		list.add(rec4);
		list.add(rec5);
		
	}
	public void CreateRecord(Record record) {
		
	}
	public List<Record> selectRecordByStatus(Integer status) {
		List<Record> r = new ArrayList<Record>();
		for(int i=0;i<list.size();i++){
			int j = list.get(i).getOrderStatus();
			if(status==j){
				r.add(list.get(i));
			}
		}
		return r;
	}*/
	

