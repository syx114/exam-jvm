package cn.yintai.test.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class H2{
	
    private static H2 instance=null;
    
    public static H2 getInstance(){
        if(instance==null){
            synchronized(H2.class){
                if(instance==null){
                    instance=new H2();
                }
            }
        }
        return instance;
    }
    
    private H2(){
    	Connection conn = null;
		Statement stat = null;
		Connection con = H2Test.getConnection(conn);
		try {
			stat = con.createStatement();
			stat.execute("DROP TABLE Record IF EXISTS");
			stat.execute("CREATE TABLE Record(ID VARCHAR PRIMARY KEY,CREATETIME DATE,PRICE DOUBLE,CLIENTID VARCHAR,ORDERSTATUS INT,ORDERTYPE INT,TRADETYPE INT)");
			stat.execute("DROP TABLE Client IF EXISTS");
			stat.execute("CREATE TABLE Client(ID VARCHAR PRIMARY KEY,NAME VARCHAR)");
			for(int i=0;i<5;i++){
				if(i<3){
					stat.execute("insert into Record(id,orderstatus) values("+i+",1)");
				} else {
					stat.execute("insert into Record(id,orderstatus) values("+i+",0)");
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}