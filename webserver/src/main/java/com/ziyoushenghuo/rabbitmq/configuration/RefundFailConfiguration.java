package com.ziyoushenghuo.rabbitmq.configuration;

import com.ziyoushenghuo.rabbitmq.MQConstant;
import com.ziyoushenghuo.rabbitmq.QueueConfiguration;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RefundFailConfiguration extends QueueConfiguration{

    //重新发起退款的配置

    @Bean
    public Queue deadLetterRefundFailQueue() {
        Map<String, Object> arguments = new HashMap<>();
        arguments.put("x-dead-letter-exchange", MQConstant.DEFAULT_EXCHANGE);
        arguments.put("x-dead-letter-routing-key", MQConstant.ORDER_REFUND_FAIL_NAME);
        Queue queue = new Queue(MQConstant.DEAD_LETTER_QUEUE_REFUND_FAIL_NAME,true,false,false,arguments);
        return queue;
    }

    @Bean
    public Binding  deadLetterRefundFailBinding() {
        return BindingBuilder.bind(deadLetterRefundFailQueue()).to(defaultExchange()).with(MQConstant.DEAD_LETTER_QUEUE_REFUND_FAIL_NAME);
    }

    @Bean
    public Queue routeRefundFailQueue() {
        Queue queue = new Queue(MQConstant.ORDER_REFUND_FAIL_NAME,true,false,false);
        return queue;
    }

    @Bean
    public Binding  RefundFailQueueBinding() {
        return BindingBuilder.bind(routeRefundFailQueue()).to(defaultExchange()).with(MQConstant.ORDER_REFUND_FAIL_NAME);
    }

}
