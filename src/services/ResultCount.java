package services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.TestCaseBean;
import net.sf.json.JSONArray;
import util.DBdao;
import util.WebUtil;

/**
 * Servlet implementation class ResultCount
 */
@WebServlet("/ResultCount")
public class ResultCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultCount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strAllParam = null;
		
		
//		System.out.println("param:"+strAllParam);
		response.setContentType("text/html;charset=utf-8");  
        
        /** 设置响应头允许ajax跨域访问 **/  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
   //     Map<String, String[]> params = request.getParameterMap();
        	//response.getWriter().print(params);
        	//System.out.println(params);
        	int currPage=1;
	        if(request.getParameter("page")!=null){
	            currPage=Integer.parseInt(request.getParameter("page"));
	        }
	        DBdao dao = new DBdao();
	        ArrayList list = dao.getResult();
	        list.toString();
	        //String newlist="{\"cases\":"+list+"}";
	        JSONArray js=JSONArray.fromObject(list);
	        String str=js.toString();
	        str="{\"results\":"+str+"}";
	        
	        //request.setAttribute("js", js);
	        response.getWriter().println(str);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
