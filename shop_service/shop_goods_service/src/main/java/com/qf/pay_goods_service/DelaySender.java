package com.qf.pay_goods_service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName:DelaySender
 * @Author: Zhengbowen
 * @Description:
 * @Date: Created in 17:23 2020/7/5
 * @Modified
 * @VERSION 1.0
 */
@Component
public class DelaySender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendDelay(Order order){
        this.amqpTemplate.convertAndSend(RabbitMq.ORDER_DELAY_EXCHANGE,RabbitMq.ORDER_DELAY_ROUNTING_KEY,order,message -> {
            message.getMessageProperties().setExpiration(1*1000*60+"");
            return message;
        });
    }
}
