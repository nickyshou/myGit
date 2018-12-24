package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {
	    private String url="jdbc:mysql://localhost:3306/testcase";
	    private String user="root";
	    private String password="";
	    private String  url2 = "jdbc:mysql://localhost:3306/testcase?"
	             + "serverTimezone=CTT&user=root&password=&useUnicode=true&characterEncoding=UTF-8";
	    private String driver="com.mysql.cj.jdbc.Driver";
	    
	    public Connection getCon() throws Exception{
	    	
	        Class.forName(driver);
	        Connection con=DriverManager.getConnection(url2);
	        return con;
	    }
	    
	    public static void getClose(Connection con) throws SQLException{
	        if(con!=null){
	            con.close();
	        }
	    }
	    
	    
	    
	   public static void main(String[] args) {
		   DButil db=new DButil();
	        try {
	           Connection con=db.getCon();
	            System.out.println("连接成功"+con);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            System.out.println("连接失败");
	        }
	        
	    }

}
