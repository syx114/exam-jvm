package test.h2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.h2.tools.Server;
import org.junit.Test;


public class H2 {
	
	public class H2Demo {
	    private Server server;
	    private String port = "8082";
	    private String dbDir = "jdbc:h2:tcp://192.168.0.36/~/test";
	    private String user = "sa";
	    private String password = "";
	    public void startServer() {
	        try {
	            System.out.println("正在启动h2...");
	            server = Server.createTcpServer(
	                    new String[] { "-tcpPort", port }).start();
	        } catch (SQLException e) {
	            System.out.println("启动h2出错：" + e.toString());
	            e.printStackTrace();
	            throw new RuntimeException(e);
	        }
	    }

	    @Test
	    public void stopServer() {
	        if (server != null) {
	            System.out.println("正在关闭h2...");
	            server.stop();
	            System.out.println("关闭成功.");
	        }
	    }

	    @Test
	    public void useH2() {
	        try {
	            Class.forName("org.h2.Driver");
	            Connection conn = DriverManager.getConnection(dbDir,
	                    user, password);
	            Statement stat = conn.createStatement();
	            // insert data
//	            stat.execute("CREATE TABLE TEST(NAME VARCHAR)");
	            stat.execute("INSERT INTO TEST VALUES('Hello World')");
	            // use data
	            ResultSet result = stat.executeQuery("select name from test ");
	            int i = 1;
	            while (result.next()) {
	                System.out.println(i++ + ":" + result.getString("name"));
	            }
	            result.close();
	            stat.close();
	            conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @Test
	    public void h2test(String[] args) {
	        H2Demo h2 = new H2Demo();
//	        h2.startServer();
	        h2.useH2();
//	        h2.stopServer();
	        System.out.println("==END==");
	    }
	}
}
