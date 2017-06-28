package com.allen.demo.Redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Allen on 2017/6/28.
 */
@SpringBootApplication
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                            MessageListenerAdapter listenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter, new PatternTopic("chat"));

        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

    @Bean
    Receiver receiver(CountDownLatch latch) {
        return new Receiver(latch);
    }

    @Bean
    CountDownLatch latch() {
        return new CountDownLatch(1);
    }

    @Bean
    StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
        return new StringRedisTemplate(connectionFactory);
    }

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);
        CountDownLatch latch = ctx.getBean(CountDownLatch.class);
        LOGGER.info("Sending message.....");
        template.convertAndSend("chat", "Hello from Redis");

        latch.await();
        System.exit(0);
    }

    /*错误结果
2017-06-28 11:28:28.199  WARN 6928 --- [           main] ationConfigEmbeddedWebApplicationContext : Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'container' defined in com.allen.demo.Redis.Application: Unsatisfied dependency expressed through method 'container' parameter 1; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'listenerAdapter' defined in com.allen.demo.Redis.Application: Unsatisfied dependency expressed through method 'listenerAdapter' parameter 0; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'receiver' defined in com.allen.demo.Redis.Application: Unsatisfied dependency expressed through method 'receiver' parameter 0; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'java.util.concurrent.CountDownLatch' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {}
    * 1. application.properties 的ldap 配置文件忘记屏蔽
    * 2. MessageListenerAdapter 写成 MessageListener
    * 3. @Autowired
    public Receiver(CountDownLatch latch) {
        this.latch = latch;
    } 忘记配置注解字段 @Autowired
    *
    * */
}
