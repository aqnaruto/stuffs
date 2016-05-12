package common.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;

import common.Interceptor.TestInterceptor;
import common.control.BlogControl;
import common.model.AppUserInfo;
import common.model.Blog;

public class commonconfig extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		System.out.println("configConstant");
		// TODO Auto-generated method stub
	//loadPropertyFile(PathKit.getRootClassPath()+"/resources/conn.properties");//����jdbc�����ļ�
		PropKit.use("conn.properties");
		me.setDevMode(false);
		me.setViewType(ViewType. JSP);
		me.setBaseViewPath("/WEB-INF");
	}

	@Override
	public void configRoute(Routes me) {
		// TODO Auto-generated method stub
		System.out.println(5);
		me.add("/appapi", BlogControl.class,"/");	
		//me.add("/sb", BlogControl.class);
	}

	@Override
	public void configPlugin(Plugins me) {
		// TODO Auto-generated method stub
//		C3p0Plugin c3p0Plugin = new C3p0Plugin(getProperty( "jdbcUrl"),
//				getProperty("user"), getProperty("password"));
//				me.add(c3p0Plugin);
//				ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
//				me.add(arp);
//				arp.addMapping("testblog", Blog.class);//
//				arp.addMapping("pt_app_userinfo", AppUserInfo.class);

	}

	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub
		//me.add(new Test());
	//	me.add(new TestInterceptor());
		System.out.println(8);
		
	}

	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub
	//	System.out.println(7);

	}
	public static void main(String args[]) throws ParseException{
//		String sDt = "04/16/2016 15:10:00";
//		SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
//		//String strTime = DateTime.Parse("1970-01-01").TotalMilliseconds.ToString();
//		Date dt2 = sdf.parse(sDt);
//		long lSysTime1 = dt2.getTime();
//		System.out.println(lSysTime1);
		System.out.println(3);
		JFinal.start("src/main/webapp", 8080,"/" ,5);
	}

}
