package com.zplus.activemq.domain;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.*;

import javax.jms.Queue;

@Configuration
@EnableJms
public class ActiveMQConfig
{
    @Value("${jsa.activemq.broker.url}")
    String broker_url;

    @Value("${jsa.activemq.broker.username}")
    String username;

    @Value("${jsa.activemq.broker.password}")
    String password;

    /*
     * Initial ConnectionFactory
     */
    @Bean
    public ActiveMQConnectionFactory connectionFactory()
    {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(broker_url);
        connectionFactory.setUserName(username);
        connectionFactory.setPassword(password);
        return connectionFactory;
    }
    
    @Bean
    public Queue queue()
    {
        return new ActiveMQQueue("monitor.system.queue");
    }

    @Bean // Serialize message content to json using TextMessage
    public MessageConverter jacksonJmsMessageConverter() 
    {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }
    
    @Bean
    public JmsTemplate jmsTemplate ()
    {
        JmsTemplate jmsTemplate =new JmsTemplate();
        jmsTemplate.setMessageConverter(jacksonJmsMessageConverter());
        jmsTemplate.setConnectionFactory(connectionFactory());
        jmsTemplate.setDeliveryMode(2);
        return jmsTemplate;
    }

    /*@Bean(name = "jsaFactory")
    public JmsListenerContainerFactory<?> jsaFactory(ConnectionFactory connectionFactory,
                                                     DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        //factory.setMessageConverter(jacksonJmsMessageConverter());
        //factory.setPubSubDomain(true);
        configurer.configure(factory, connectionFactory);
        return factory;
    }*/

    /*@Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        //factory.setMessageConverter(jacksonJmsMessageConverter());
        factory.setConcurrency("1-2");
        return factory;
    }*/
}
