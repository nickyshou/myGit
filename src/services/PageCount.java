package services;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.FileUtil;

/**
 * Servlet implementation class PageCount
 */
@WebServlet("/PageCount")
public class PageCount extends HttpServlet {
   
    public PageCount() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		response.sendRedirect("/Report_2018-12-06_16_45_02.html");
		String path="D:\\work\\workspace\\AutoCase\\WebContent";
		System.out.println(path);
		FileUtil fu=new FileUtil();
		String max=fu.maxFileName(path);//获取文件夹中最新报表的地址
		System.out.println(max);
		request.getRequestDispatcher(max).forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
