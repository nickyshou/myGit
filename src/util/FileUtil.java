package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.io.FileInputStream;
import java.io.FileWriter;

import bean.*;
import java.lang.reflect.Field;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;
public class FileUtil {
	public static String[] getAllFileName(String path) {
	 File file = new File(path);
	 ArrayList<String> fileName=null;
     File[] files = file.listFiles();
     String[] names = file.list();
    
     for (File a : files) {
         if (a.isDirectory()) {
             getAllFileName(a.getAbsolutePath());
         }
     }
 	return names;
	}
	/*
	 * 查找文件目录中最文件命名最大(按Asc码排序)并包含report的文件
	*/
	public String maxFileName(String path){
		 File file = new File(path);
		 ArrayList<String> fileName=null;
	     File[] files = file.listFiles();
	     String[] names = file.list();
	     List<String> list=Arrays.asList(names);
	     list=new ArrayList<>(list);
	     Iterator<String> it=list.iterator();
	     while(it.hasNext()){
	    	 String str=(String)it.next();
	    	 if(str.contains("Report")!=true)
	    	 {
	    		 it.remove();
	    	 }
	     }
	     System.out.println(list.size());
//	     for(int j=0;j<=names.length-1;j++){
//	    	 String listname=list.get(j);
//	    	 if(list.get(j).contains("Report")!=true){
//	    			list.remove(listname);
//	    			j--;
//	    		 }
//	     }
	     String[] newNames=list.toArray(new String[list.size()]);
	     for(int i=0;i<=newNames.length-1;i++){
	    	
	    	 for(int index=0;index<newNames.length-1;index++){
	    		
	    		 
	    		 if(newNames[index].compareTo(newNames[index+1])>0){
	    			String temp=newNames[index];
	    			newNames[index]=newNames[index+1];
	    			newNames[index+1]=temp;
	    	 }	 
	     } 
	    	 
	}
	     return newNames[newNames.length-1];
	     
	}
	

	
	public String getStringFromTxt(String FileDir) throws IOException{
		String strResponseInfo= "";
		File dir = new File(FileDir);
		if (dir.isFile()&&dir.exists()) {
		String recFileName = FileDir ;

		//将文件中的数据读出
		InputStreamReader read = new InputStreamReader(new FileInputStream(recFileName), "UTF-8");
		BufferedReader bufferedReader = new BufferedReader(read);

		String str="";
		//按行读出文件中的数据
		while ((strResponseInfo = bufferedReader.readLine()) != null) {
		   System.out.println(strResponseInfo.toString().trim());
		   str+=strResponseInfo;
		}
		strResponseInfo=str;//将str赋值给strResponseInfo返回
		read.close();
		}
		return strResponseInfo;

	}
	

/**
 * @author 寿志浩
 * @功能 把list转换成XML格式
 */
	public String listToXml(List<DateBean> list) {
       
	      StringBuffer xmlnodes = new StringBuffer();
	        if (list != null && list.size() > 0) {
	            xmlnodes.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	            xmlnodes.append("<graph caption='Count in Month' xAxisName='month' yAxisName='Units' showNames='1' decimalPrecision='0' formatNumberScale='0'>");
	            for (int i = 0; i < list.size(); i++) {
	            	DateBean db = list.get(i);
	                xmlnodes.append("<set name='" +db.getMonth()  + "mouth' value='" + db.getCount()+"' color='AFD8F"+i+"' />");
	            }
	            xmlnodes.append("</graph>");
	        }

	        return xmlnodes.toString();
	    }
    
	public String hisToXML(ArrayList list){
		StringBuffer xmlnodes = new StringBuffer();
        if (list != null && list.size() > 0) {
            xmlnodes.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            xmlnodes.append("<graph caption='Count in Result' xAxisName='Result' yAxisName='Units' showNames='1' decimalPrecision='0' formatNumberScale='0'>");
            for (int i = 0; i < list.size(); i++) {
            	Map map = (Map) list.get(i);
            	int j=i+5;
                xmlnodes.append("<set name='" +map.get("result")  + "' value='" + map.get("num")+"' color='FF99"+i+""+j+"' />");
            }
            xmlnodes.append("</graph>");
        }

        return xmlnodes.toString();
	}
	
	public ArrayList<String> changeList(ArrayList<String> list){
		ArrayList newlist=new ArrayList<String>();
		for(int i=0;i<list.size();i++){
			String str=null;
			String newstr=null;
			str="Report_"+list.get(i).replaceAll(" ","_").replaceAll(":", "_");
			newstr=str.substring(0, str.length())+".html";
			newlist.add(newstr);
			
		}
		return newlist;
	}

	
	public static void main(String[] args) throws IOException  {
//		FileUtil f=new FileUtil();
//		DBdao du=new DBdao();
//		
//		ArrayList list=du.getRuntime();
//		ArrayList newlist=f.changeList(list);
//		for(int i=0;i<newlist.size();i++){
//			System.out.println(newlist.get(i));
//		}
	     	
	        
	    	
//		JSONArray js=JSONArray.fromObject(Tlist);
//		String str1=js.toString();
//		System.out.println(str1);
//		try {
//			FileWriter writer = new FileWriter("D:\\work\\workspace\\AutoCase\\WebContent\\xmlFile\\resultData.xml");
//			writer.write(str);
//			 writer.flush();
//			 writer.close();
//			System.out.println("写入完成！");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		Process proc = null;
	    String path=System.getProperty("user.dir")+"\\runPython.bat";
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
	
}
