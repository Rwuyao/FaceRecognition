package springboot.OpenCvNet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

@EnableWebSocket
@Configuration
public class websocketconfig  {
	
	@Bean
    public ServerEndpointExporter serverEndpointExporter() {
		ServerEndpointExporter s1 = new ServerEndpointExporter();
		s1.setServerContainer(createWebSocketContainer().getObject());
		return s1 ;
    }	
	@Bean
    public ServletServerContainerFactoryBean createWebSocketContainer() {
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        container.setMaxTextMessageBufferSize(240000);
        container.setMaxBinaryMessageBufferSize(240000);
        return container;
    }
	
	
}
