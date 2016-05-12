package common.control;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.core.Controller;

public class TestControl extends Controller {
	public void index(){
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("9999999999", "99999999");
		renderJson(map);
    //	render("index.jsp");
	//	render("test.html");
	//	renderJsp("index.jsp");
	}

}
