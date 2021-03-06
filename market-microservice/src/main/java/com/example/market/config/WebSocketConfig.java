package com.example.market.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

/**
 * 
 * @author hakan.ozerden
 *
 */
@Configuration
public class WebSocketConfig {

	@Bean
	public WebSocketClient client() {
		return new StandardWebSocketClient();
	}
}
