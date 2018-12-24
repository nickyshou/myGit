package services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DateBean;
import util.DBdao;
import util.FileUtil;

/**
 * Servlet implementation class NewReport
 */
@WebServlet("/NewReport")
public class NewReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewReport() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		FileUtil f=new FileUtil();
		
		DBdao du=new DBdao();
		ArrayList<DateBean> list=du.getMonth();
		ArrayList hlist=new ArrayList<>();
		hlist=du.getResult();
		String str=f.listToXml(list);
		String strh=f.hisToXML(hlist);
		String path="D:\\work\\workspace\\AutoCase\\WebContent\\xmlFile\\mouthData.xml";
		String hpath="D:\\work\\workspace\\AutoCase\\WebContent\\xmlFile\\resultData.xml";
		System.out.println(path);
		try {
			FileWriter writer = new FileWriter(path);
			BufferedWriter bw=new BufferedWriter(writer);
			FileWriter writerh= new FileWriter(hpath);
			BufferedWriter bwh=new BufferedWriter(writerh);
			bw.write(str);
			bwh.write(strh);
			
			 
			 bw.close();
			 bwh.close();
			System.out.println("写入完成！");
			//request.getRequestDispatcher("report.jsp");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("report.jsp");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
