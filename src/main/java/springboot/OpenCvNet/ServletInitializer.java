package springboot.OpenCvNet;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer{

	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		 	  
		 // 注意这里要指向原先用main方法执行的Application启动类
	        return builder.sources(OpenCvNetApplication.class);
	    }
		
}
