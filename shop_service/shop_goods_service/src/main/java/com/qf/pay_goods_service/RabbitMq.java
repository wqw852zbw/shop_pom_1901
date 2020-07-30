package com.qf.pay_goods_service;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * @ClassName:RabbitMq
 * @Author: Zhengbowen
 * @Description:
 * @Date: Created in 16:38 2020/7/5
 * @Modified
 * @VERSION 1.0
 */
@Configuration
public class RabbitMq {

    /**
     * 延时队列名称
      */
    public static final String ORDER_DELAY_QUEUE = "user.oder.delay.queue";


    /**
     * deadLetter发送到exchange
     */
    public static final String ORDER_DELAY_EXCHANGE = "user.oder.delay.exchange";

    /**
     * 具体消息发送到rountingKey
     */
    public static final  String ORDER_DELAY_ROUNTING_KEY = "order_delay";


    public static final String ORDER_QUEUE_NAME = "user.oder.queue";
    public static final String ORDER_EXCHANGE_NAME = "user.oder.exchange";
    public static final String ORDER_ROUNTING_KEY = "order";

    /**
     * 延时队列配置
     * @return
     */
    @Bean
    public Queue delayOrderQueue(){
        HashMap<String, Object> params = new HashMap<>();
        params.put("x-dead-letter-exchange",ORDER_EXCHANGE_NAME);
        params.put("x-dead-letter-routing-key",ORDER_ROUNTING_KEY);
        return new Queue(ORDER_DELAY_QUEUE,true,false,false,params);
    }

    /**
     *
     * 声名一个交换机
     * @return
     */
    @Bean
    public DirectExchange orderDelayExchange(){
        return new DirectExchange(ORDER_DELAY_EXCHANGE);
    }


    @Bean
    public Binding dlxBinding(){
        return BindingBuilder.bind(delayOrderQueue()).to(orderDelayExchange()).with(ORDER_DELAY_ROUNTING_KEY);

    }
    @Bean
    public Queue orderQueue(){
        return new Queue(ORDER_QUEUE_NAME,true);
    }

    @Bean
    public TopicExchange orderTopicExchange(){
        return new TopicExchange(ORDER_EXCHANGE_NAME);

    }

    public Binding orderBingDing(){
        return BindingBuilder.bind(orderQueue()).to(orderTopicExchange()).with(ORDER_ROUNTING_KEY);
    }

}
