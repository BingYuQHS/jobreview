package com.flamingo.jrmessage.config;

import com.flamingo.jrmessage.enums.MqQueueEnum;
import lombok.Data;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * topic exchange
 * 生产者，将消息投递给Exchange，
 * 然后由Exchange将消息路由到对应的Queue上，供消费者消费
 * 策略有Direct策略(精确匹配)，Fanout策略(广播)，Topic策略(模糊匹配)...
 */
@Configuration
public class TopicRabbitMQConfig {

    /**
     * 消息队列，用来保存消息直到发送给消费者
     * 初始化邮箱验证码通道
     * @return
     */
    @Bean
    public Queue initEmailCodeQueue(){
        return new Queue(MqQueueEnum.EMAIL_CODE_QUEUE.getQueueName());
    }

    /**
     * 初始化短信验证码通道
     * @return
     */
    @Bean
    public Queue initMobileCodeQueue(){
        return new Queue(MqQueueEnum.MOBILE_CODE_QUEUE.getQueueName());
    }


    /**
     * 初始化邮件通道
     * @return
     */
    @Bean
    public Queue initEmailQueue(){
        return new Queue(MqQueueEnum.EMAIL_QUEUE.getQueueName());
    }

    /**
     * 初始化短信通道
     * @return
     */
    @Bean
    public Queue initMobileQueue(){
        return new Queue(MqQueueEnum.MOBILE_QUEUE.getQueueName());
    }

    /**
     * 初始化交换机
     * 交换机，用来接收生产者发送的消息并将这些消息路由给服务器中的队列
     * @return
     */
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange("topicExchange");
    }

    /**
     * # 匹配0个或多个单词
     * * 匹配1个单词
     * @param initEmailCodeQueue
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingExchangeEmailCode(Queue initEmailCodeQueue, TopicExchange exchange){
        return BindingBuilder.bind(initEmailCodeQueue).to(exchange).with("email.#");
    }

    @Bean
    Binding bindingExchangeEmail(Queue initEmailQueue, TopicExchange exchange){
        return BindingBuilder.bind(initEmailQueue).to(exchange).with("email.*");
    }

    /**
     * # 匹配0个或多个单词
     * * 匹配1个单词
     * @param initMobileCodeQueue
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingExchangeMobileCode(Queue initMobileCodeQueue, TopicExchange exchange){
        return BindingBuilder.bind(initMobileCodeQueue).to(exchange).with("mobile.#");
    }

    @Bean
    Binding bindingExchangeMobile(Queue initMobileQueue, TopicExchange exchange){
        return BindingBuilder.bind(initMobileQueue).to(exchange).with("mobile.*");
    }
}
