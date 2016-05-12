package common.Interceptor;

import com.jfinal.aop.Invocation;
import com.jfinal.aop.Interceptor;;

public class TestInterceptor implements Interceptor {

	public void intercept(Invocation ai) {
		String uri = ai.getActionKey(); // 默认就是ActionKey
		System.out.println(uri);
		if(uri=="/appapi"){
			System.out.println("****invoke****");
			ai.invoke();
		return;
		
		}
		System.out.println("********"+uri+"********");
	}
	
}
