package common.control;
import com.jfinal.upload.UploadFile;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.text.DateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Spring;

import com.jfinal.core.Controller;
import com.jfinal.kit.PathKit;

import common.model.AppUserInfo;
import common.model.Blog;

public class BlogControl extends Controller {
public void welcomeimg(){
	 String jsonText = "{\"imgUrl\":\"http://pic.qiantucdn.com/58pic/17/86/21/69Q58PICXMi_1024.jpg\"," +
	 		"\"imgDate\":\"2017-9-21,00:00:00\"}";
	 
	 DateFormat df3 = DateFormat.getTimeInstance();
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("testdd", "1ssss23");
		//renderJson(jsonText);
		render("test.html");
		}
	
	public void index(){
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("test", "123");
		renderJson(map);
    //	render("index.jsp");
	//	render("test.html");
	//	renderJsp("index.jsp");
		renderJson("se");
	}
		
	public void form(){
		//render("form.jsp");
		
		//render("form8784848");
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("testdd", "1ssss23");
		//renderJson(map);
		render("form.jsp");
	}
	public void test(){
		//render("form.jsp");
		
		//render("form8784848");
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("testdd", "1ssss23");
		renderJson(map);
		//render("test.html");
	}
	
	@SuppressWarnings("null")
	public void testHttpSend() throws IOException{
		//render("form.jsp");
		
		URL  url=new URL( "http://localhost:8080/appapi/testHttpRecieve");
	    HttpURLConnection uRLConnection = null;  
	    uRLConnection =(HttpURLConnection)url.openConnection();
	    String  tokens="123456789"; 
		//setHttpServletRequest(request);
		//render("form8784848");
	    
	    uRLConnection.setRequestProperty("Authorization", tokens);
	    
	    uRLConnection.setDoOutput(true);
	    uRLConnection.setDoInput(true);
	    
	    
	    
		Map<String, Object> map =new HashMap<String, Object>();
		
		
		
		
		String strAuth=uRLConnection.getHeaderField("Authorization");
		String strAuthkey=uRLConnection.getRequestProperty("Authorization");
		map.put(strAuth, tokens);
		renderJson(map);
		//render("test.html");
	}
	public void testHttpRecieve() throws IOException{
		//render("form.jsp");
		 HttpURLConnection uRLConnection = null; 
		getPara("dd");
//		 uRLConnection=getRequest();
//			String strAuthkey=uRLConnection.getRequestProperty("Authorization");
//	   System.setOut(strAuthkey);
		//render("test.html");
	}
	public void reset_portrait() {
		render("reset_portrait.jsp");
		
		
	// getFile();
		
	}
	public void upload_portrait() {
		System.out.println(1);
		  UploadFile files = getFile(getPara("file"),"/img");
		//files.getUploadPath();
			System.out.println(2);
			System.out.println(files.getFileName());
	//	System.out.println(files.getUploadPath());
	//	System.out.println(files.getContentType());
	//	System.out.println(files.getParameterName());
	
	// getFile();
		
	}
	
	
	public void save(){
//		Map<String, Object> map =new HashMap<String, Object>();
//		map.put("test", "123");
//		renderJson(map);
//    	render("index.jsp");
		Blog blog= getModel(Blog.class,"blog");
		blog.save();
		//render("����ɹ�");
		String str;
		str=blog.toJson();
		renderJson(str);
		
	}
	public void login(){

		AppUserInfo userinfo=new AppUserInfo().findFirst("SELECT * from pt_app_userinfo where username =?", getPara("username"));
		if(userinfo==null)renderJson("{\"resultcode\":-1}");
		else if (!getPara("pwd").equals(userinfo.getStr("pwd")))renderJson("{\"resultcode\":-2}");
		else renderJson(userinfo.toJson().replaceAll(":null", ":\"\"").replace("{", "{\"resultcode\":0,"));
		
	
		
	}
	public void third_party_login(){
		String typestr = null;
		if(getPara("third_party_type")!=null)typestr= getPara("third_party_type");
		if (typestr.equals("weixin")){
		AppUserInfo userinfo=new AppUserInfo().findFirst("SELECT * from pt_app_userinfo where weixin_uni_id =?", getPara("third_party_str"));
		if (userinfo.getStr("username")!=null){renderJson(userinfo.toJson().replaceAll(":null", ":\"\"").replace("{", "{\"resultcode\":0,"));}
		else renderJson("{\"resultcode\":-2}");
		}
		
		
		
		else if (typestr.equals("qq")){
			AppUserInfo userinfo=new AppUserInfo().findFirst("SELECT * from pt_app_userinfo where qq_uni_id =?", getPara("third_party_str"));
			if (userinfo.getStr("username")!=null){renderJson(userinfo.toJson().replaceAll(":null", ":\"\"").replace("{", "{\"resultcode\":0,"));}
			else renderJson("{\"resultcode\":-2}");	
		}
		else if (typestr.equals("weibo")){
			AppUserInfo userinfo=new AppUserInfo().findFirst("SELECT * from pt_app_userinfo where weibo_uni_id =?", getPara("third_party_str"));
			if (userinfo.getStr("username")!=null){renderJson(userinfo.toJson().replaceAll(":null", ":\"\"").replace("{", "{\"resultcode\":0,"));}
			else renderJson("{\"resultcode\":-2}");
		}
		else renderJson("{\"resultcode\":-1}");
	}

}
