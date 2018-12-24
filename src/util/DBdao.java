package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import bean.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
public class DBdao {
	/**
	 * @sees 此方法将获取的数据存入数据库。
	 * @author 寿志浩
	 * @date 2018-1-26
	 * @param Empbean
	 * @param 
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */

	public  ArrayList<TestCaseBean> SeleCaseByDes(String descrip){
		DButil dbu=new DButil();
		Statement sta=null;
		TestCaseBean bean=null;
		Connection con=null;
		ResultSet rs = null;
		ArrayList<TestCaseBean> list=new ArrayList<>();
		String sql="select * from cardinfo where msisdn = '"+descrip+"'";
		try {
			con=dbu.getCon();
			sta=con.createStatement();
			rs=sta.executeQuery(sql);
	           while(rs.next()){
	           bean = new TestCaseBean();
	           bean.setCaseID(rs.getString("caseID"));
	           bean.setModelName(rs.getString("modelName"));
	           bean.setTestCaseName(rs.getString("testCaseName"));
	           bean.setInterpret(rs.getString("interpret"));
	           bean.setDescrip(rs.getString("descrip"));
	           list.add(bean);
	           }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return list;
		
	} 
	
	public  ArrayList<TestCaseBean> SeleCase(){
		DButil dbu=new DButil();
		Statement sta=null;
		TestCaseBean bean=null;
		Connection con=null;
		ResultSet rs = null;
		ArrayList<TestCaseBean> list=new ArrayList<>();
		String sql="select * from  testcase order by modID limit ?,?";
		try {
			con=dbu.getCon();
			sta=con.createStatement();
			rs=sta.executeQuery(sql);
	           while(rs.next()){
	           bean = new TestCaseBean();
	           bean.setCaseID(rs.getString("caseID"));
	           bean.setModelName(rs.getString("modelName"));
	           bean.setTestCaseName(rs.getString("testCaseName"));
	           bean.setInterpret(rs.getString("interpret"));
	           bean.setDescrip(rs.getString("descrip"));
	           list.add(bean);
	           }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return list;
		
	} 
	/**
	 * @sees 此方法将获取数据库中卡信息的所有数据。
	 * @author 寿志浩
	 * @date 2018-11-26
	 * @param 
	 * @param 
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public static ArrayList<ProjectBean> SeleProj(){
			DButil dbu=new DButil();
			Statement sta=null;
			ProjectBean bean=null;
			Connection con=null;
			ResultSet rs = null;
			ArrayList<ProjectBean> list=new ArrayList<>();
			String sql="select * from project";
				try {
					con=dbu.getCon();
					sta=con.createStatement();
					rs=sta.executeQuery(sql);
					 while (rs.next()) {
			                bean = new ProjectBean();
			                bean.setProjectID(rs.getInt("projectID"));
			                bean.setProjectName(rs.getString("projectName"));
			                list.add(bean);			                
			            }
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					 try {
						 rs.close();
						 sta.close();
						 con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			return list;
		
	}
	//获取请求参数

	public  ArrayList<HistoryBean> SeleHistory(int page){
		DButil dbu=new DButil();
		PreparedStatement ps =null;  
		HistoryBean bean=null;
	
		Connection con=null;
		ResultSet rs = null;
		ArrayList<HistoryBean> list=new ArrayList<>();
		String sql="select * from history limit ?,? ";
		try {
			con=dbu.getCon();
			ps=con.prepareStatement(sql);
            ps.setInt(1,(page-1)*HistoryBean.PAGE_SIZE);
            ps.setInt(2,HistoryBean.PAGE_SIZE);
            rs=ps.executeQuery();
	           while(rs.next()){
		       bean = new HistoryBean();
	           bean.setCaseListID(rs.getInt("caseListID"));
	           bean.setCaseName(rs.getString("caseName"));
	           bean.setResult(rs.getString("result"));
	           bean.setFailures(rs.getString("failures"));
	           bean.setRunTime(rs.getString("runTime"));
	           list.add(bean);
	           }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 try {
				rs.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return list;
		
	} 
	//用例表分页查询
	public  ArrayList<TestCaseBean> SeleCasePage(int page){
		DButil dbu=new DButil();
		
		//Statement sta=null;
		TestCaseBean bean=null;
		Connection con=null;
		ResultSet rs = null;
        PreparedStatement ps =null;   
		ArrayList<TestCaseBean> list=new ArrayList<>();
		String sql="select * from  testcase  limit ?,?";
		try {
			con=dbu.getCon();
			ps=con.prepareStatement(sql);
            ps.setInt(1,(page-1)*TestCaseBean.PAGE_SIZE);
            ps.setInt(2,TestCaseBean.PAGE_SIZE);
            rs=ps.executeQuery();
			
	           while(rs.next()){
	           bean = new TestCaseBean();
	           bean.setCaseID(rs.getString("caseID"));
	           bean.setModelName(rs.getString("modelName"));
	           bean.setTestCaseName(rs.getString("testCaseName"));
	           bean.setInterpret(rs.getString("interpret"));
	           bean.setDescrip(rs.getString("descrip"));
	           list.add(bean);
	           }
	         return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 try {
				rs.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
		
	}
	
	/**
	 * @sees 此方法按月显示执行用例情况。
	 * @author 寿志浩
	 * @date 2018-11-26
	 * @param 
	 * @param 
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	
	public  ArrayList<DateBean> getMonth(){
		System.out.println("go");
		DButil dbu=new DButil();
		System.out.println("test");
		DateBean monbean=null;
		Statement sta=null;
		Connection con=null;
		ResultSet rs = null;
		ArrayList<DateBean> list=new ArrayList<>();
		String sql="select count(caseListID) AS total ,date_format(runTime, '%m') AS MONTH FROM history GROUP BY MONTH(runTime) ";
		try{
			con=dbu.getCon();
			sta=con.createStatement();;
            rs=sta.executeQuery(sql);
			while(rs.next())
			{
				monbean=new DateBean();
				monbean.setMonth(rs.getString("MONTH"));
				monbean.setCount(rs.getInt("total"));			
			list.add(monbean);
			}
			return list;
		}
		catch(Exception e)
		{
			
		}
		finally{
			 try {
				rs.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
	}
	
	public int caseCount(){
		int count=0;
		DButil dbu=new DButil();
		Statement sta=null;
		ProjectBean bean=null;
		Connection con=null;
		ResultSet rs = null;
		ArrayList<ProjectBean> list=new ArrayList<>();
		String sql="select count(*) from testcase";
			try {
				con=dbu.getCon();
				sta=con.createStatement();
				rs=sta.executeQuery(sql);
				if (rs.next()) {
		         	count=rs.getInt(1);	                
		            }
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				 try {
					 rs.close();
					 sta.close();
					 con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		return count;
	}
	public int historyCount(){
		int count=0;
		DButil dbu=new DButil();
		Statement sta=null;
		ProjectBean bean=null;
		Connection con=null;
		ResultSet rs = null;
		ArrayList<ProjectBean> list=new ArrayList<>();
		String sql="select count(*) from history";
			try {
				con=dbu.getCon();
				sta=con.createStatement();
				rs=sta.executeQuery(sql);
				if (rs.next()) {
		         	count=rs.getInt(1);	                
		            }
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				 try {
					 rs.close();
					 sta.close();
					 con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		return count;
	}
	
	public  ArrayList getResult(){
		System.out.println("go");
		DButil dbu=new DButil();
		System.out.println("test");
	
		Statement sta=null;
		Connection con=null;
		ResultSet rs = null;
		ArrayList list=new ArrayList();
		String sql="select result,count(result) num FROM history GROUP BY result ";
		try{
			con=dbu.getCon();
			sta=con.createStatement();;
            rs=sta.executeQuery(sql);
			while(rs.next())
			{
				Map map=new HashMap();
				map.put("result",rs.getString("result") );
				map.put("num",rs.getString("num") );
						
			list.add(map);
			}
			return list;
		}
		catch(Exception e)
		{
			
		}
		finally{
			 try {
				rs.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
	}
	public ArrayList getRuntime(){
		
		DButil dbu=new DButil();
	
		Statement sta=null;
		Connection con=null;
		ResultSet rs = null;
		ArrayList list=new ArrayList<String>();
		String sql="select DISTINCT runtime from history";
		try{
			con=dbu.getCon();
			sta=con.createStatement();;
            rs=sta.executeQuery(sql);
			while(rs.next())
			{
				
				list.add(rs.getString("runtime") );						
			
			}
			return list;
		}
		catch(Exception e)
		{
			
		}
		finally{
			 try {
				rs.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
	}
	
	public int extCount(){
		DButil dbu=new DButil();
		int count=0;
		Statement sta=null;
		Connection con=null;
		ResultSet rs = null;
		ArrayList list=new ArrayList<String>();
		String sql="select count(DISTINCT runtime) from history ";
		try {
			con=dbu.getCon();
			sta=con.createStatement();
			rs=sta.executeQuery(sql);
			if (rs.next()) {
	         	count=rs.getInt(1);	                
	            }
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 try {
				 rs.close();
				 sta.close();
				 con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	return count;
	}
   public static void main(String[] args) {
		 DButil dbu=new DButil();
		   DBdao dba=new DBdao();
		   
		   int casecount=dba.caseCount();
			ArrayList list=new ArrayList<>();
			Map map=new HashMap();
			
			JSONObject job=new JSONObject();
			job.put("count", casecount);
			//JSONArray js=JSONArray.fromObject(list);
			int count=dba.extCount();
			System.out.println(count);

   	}
  }

