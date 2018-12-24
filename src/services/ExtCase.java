package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExtCase
 */
@WebServlet("/ExtCase")
public class ExtCase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExtCase() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Process proc = null;
		String path="D:\\work\\workspace\\AutoCase\\runPython.bat";
	    try {
            proc = Runtime.getRuntime().exec(path);
        	BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        	String line = null;
        	while ((line = in.readLine()) != null)
        		{ 
        		System.out.println(line); 
        		}
        		in.close(); 
        		proc.waitFor(); } 
	    	catch (IOException e) 
	    		{ e.printStackTrace(); } 
	    	catch (InterruptedException e) 
	    		{ e.printStackTrace(); } 
	
}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
