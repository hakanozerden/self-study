package com.example.market.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.example.market.dto.Trade;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author hakan.ozerden
 *
 */
@Service
public class TradeRabbitService {

	@Value("${rabbit.exchange}")
	private String exchange;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private ObjectMapper mapper;

	@EventListener
	public void listenTradeEvents(Trade trade) {
		try {
			var json = mapper.writeValueAsString(trade);
			rabbitTemplate.convertAndSend(exchange, null, json);
		} catch (JsonProcessingException e) {
			System.err.println("Error ocurred while processing trade object: " + e.getMessage());
		}
	}
}
