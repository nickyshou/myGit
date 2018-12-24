package services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBdao;
import util.FileUtil;

/**
 * Servlet implementation class ReportList
 */
@WebServlet("/ReportList")
public class ReportList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList timelist=new ArrayList<>();
		ArrayList newlist=new ArrayList<>();
		String path="D:\\work\\workspace\\AutoCase\\WebContent";
		DBdao dba=new DBdao();
		FileUtil fu=new FileUtil();
		timelist=dba.getRuntime();
		newlist=fu.changeList(timelist);
		String[] filenames=fu.getAllFileName(path);
		List<String> list=Arrays.asList(filenames);
		ArrayList namelist=new ArrayList<>(list);
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<newlist.size();i++){
			if(namelist.contains(newlist.get(i))){
				 sb.append("<a href='"+newlist.get(i)+"'target=\"_blank\">执行报告"+newlist.get(i)+"</a>"+"</br>");
			}
			
		}
		request.setAttribute("list", sb.toString());
		request.getRequestDispatcher("ReportList.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
