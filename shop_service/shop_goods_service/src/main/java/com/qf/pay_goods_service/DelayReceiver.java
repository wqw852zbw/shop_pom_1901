package com.qf.pay_goods_service;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.impl.AMQImpl;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * @ClassName:DelayReceiver
 * @Author: Zhengbowen
 * @Description:
 * @Date: Created in 17:16 2020/7/5
 * @Modified
 * @VERSION 1.0
 */
public class DelayReceiver {
    @RabbitListener(queues = {RabbitMq.ORDER_QUEUE_NAME})
    public void orderDelayQueue(Order order, Message message, Channel channel){
        if (order.getOrderStatus() == 0){
            order.setOrderStatus(2);
        }else if (order.getOrderStatus() ==1){

        }else if (order.getOrderStatus() == 2);
    }
}
