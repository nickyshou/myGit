package services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.TestCaseBean;
import bean.HistoryBean;
import util.DBdao;

/**
 * Servlet implementation class HistoryList
 */
@WebServlet("/HistoryList")
public class HistoryList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoryList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int currPage=1;
	        if(request.getParameter("page")!=null){
	            currPage=Integer.parseInt(request.getParameter("page"));
	        }
	        DBdao dao = new DBdao();
	        int next=currPage+1;
	        int pre=currPage-1;
	        List<HistoryBean> list = dao.SeleHistory(currPage);
	        request.setAttribute("list", list);
	        int pages;  //总页数
	        int count=dao.historyCount(); //查询总记录数
	        if(count%TestCaseBean.PAGE_SIZE==0){
	            pages=count/HistoryBean.PAGE_SIZE;
	        }else{
	            pages=count/HistoryBean.PAGE_SIZE+1;
	        }
	        StringBuffer sb = new StringBuffer();
	        //判断是否是第一页
	        if(pre!=0){
	        	sb.append("<a href='HistoryList?page="+pre+"'>"+"上一页"+"</a>");
	        }
	        else{
	        	sb.append("第一页");
	        }
	        //通过循环构建分页条
	        for(int i=1;i<=pages;i++){
	            if(i==currPage){   //判断是否为当前页
	                sb.append("『"+i+"』");  //构建分页条
	            }else{
	                sb.append("<a href='HistoryList?page="+i+"'>"+i+"</a>"); //构建分页条
	            }
	            sb.append(" ");
	        }
	        if(currPage!=pages){
	        	sb.append("<a href='HistoryList?page="+next+"'>"+"下一页"+"</a>");
	        }else{
	        	sb.append("<a>最后一页</a>");
	        }
	        request.setAttribute("next", next);
	        request.setAttribute("bar", sb.toString());;
	        request.getRequestDispatcher("History.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
