package util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class WebUtil {
	public  String getAllParameters(HttpServletRequest request)
    {
    Map<String, String[]> params = request.getParameterMap();  
    String queryString = "";  
    for (String key : params.keySet()) {  
        String[] values = params.get(key);  
        for (int i = 0; i < values.length; i++) {  
            String value = values[i];  
            queryString += key + "=" + value + "&";  
        }  
    }  
    // 去掉最后一个空格  
    queryString = queryString.substring(0, queryString.length() - 1);   
    return queryString;
    }
}
