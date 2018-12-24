package services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import bean.TestCaseBean;
import util.DBdao;
import util.WebUtil;

/**
 * Servlet implementation class TestCaseList
 */
@WebServlet("/TestCaseList")
public class TestCaseList extends HttpServlet {
     
    public TestCaseList() {
        super();
    }
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int currPage=1;
		 
	        if(request.getParameter("page")!=null){
	            currPage=Integer.parseInt(request.getParameter("page"));
	        }
	        DBdao dao = new DBdao();
	        int next=currPage+1;
	        int pre=currPage-1;
	        List<TestCaseBean> list = dao.SeleCasePage(currPage);
	        JSONArray js=JSONArray.fromObject(list);
	        request.setAttribute("list", list);
	        int pages;  //总页数
	        int count=dao.caseCount(); //查询总记录数
	        if(count%TestCaseBean.PAGE_SIZE==0){
	            pages=count/TestCaseBean.PAGE_SIZE;
	        }else{
	            pages=count/TestCaseBean.PAGE_SIZE+1;
	        }
	        StringBuffer sb = new StringBuffer();
	        if(pre!=0){
	        	sb.append("<a href='TestCaseList?page="+pre+"'>"+"上一页"+"</a>");
	        }
	        else{
	        	sb.append("第一页");
	        }
	        //通过循环构建分页条
	        for(int i=1;i<=pages;i++){
	            if(i==currPage){   //判断是否为当前页
	                sb.append("『"+i+"』");  //构建分页条
	            }else{
	                sb.append("<a href='TestCaseList?page="+i+"'>"+i+"</a>"); //构建分页条
	            }
	            sb.append(" ");
	            
	        }
	        if(currPage!=pages){
	        	sb.append("<a href='TestCaseList?page="+next+"'>"+"下一页"+"</a>");
	        }else{
	        	sb.append("<a>最后一页</a>");
	        }
	        request.setAttribute("next", next);
	        request.setAttribute("bar", sb.toString());
	        request.getRequestDispatcher("testcase.jsp").forward(request, response);
	        response.getWriter().println(js.toString());
//			String strAllParam = null;
//			WebUtil util=new WebUtil();
//			strAllParam=util.getAllParameters(request);
//	//		System.out.println("param:"+strAllParam);
//			response.setContentType("text/html;charset=utf-8");  
//	        
//	        /** 设置响应头允许ajax跨域访问 **/  
//	        response.setHeader("Access-Control-Allow-Origin", "*");  
//	        /* 星号表示所有的异域请求都可以接受， */  
//	        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
//	   //     Map<String, String[]> params = request.getParameterMap();
//	        	//response.getWriter().print(params);
//	        	//System.out.println(params);
//	        	int currPage=1;
//		        if(request.getParameter("page")!=null){
//		            currPage=Integer.parseInt(request.getParameter("page"));
//		        }
//		        DBdao dao = new DBdao();
//		        List<TestCaseBean> list = dao.SeleCasePage(currPage);
//		        JSONArray js=JSONArray.fromObject(list);
//		        //request.setAttribute("js", js);
//		        response.getWriter().println(js);
		      
		      
	    }
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	
   
	}

}
