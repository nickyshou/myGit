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
import net.sf.json.JSONObject;
import util.DBdao;

/**
 * Servlet implementation class ExtTimes
 */
@WebServlet("/ExtTimes")
public class ExtTimes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExtTimes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");  
        
        /** 设置响应头允许ajax跨域访问 **/  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
   //     Map<String, String[]> params = request.getParameterMap();
        	//response.getWriter().print(params);
        	//System.out.println(params);
       
	        DBdao dao = new DBdao();
	        ArrayList list = dao.getRuntime();
	        list.toString();
	        //String newlist="{\"cases\":"+list+"}";
	        JSONArray js=JSONArray.fromObject(list);
	        String str=js.toString();
	        str="{\"Times\":"+str+"}";
	        JSONObject jo=JSONObject.fromObject(str);
	        //request.setAttribute("js", js);
	        response.getWriter().println(jo);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
