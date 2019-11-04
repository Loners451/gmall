package com.example.test;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;

import javax.jms.*;

/**
 * 提供者
 * @author Moses
 * @version 1.0
 * @date 2019/11/4 11:59
 */
public class TestMqProducer {
    public static void main(String[] args) {
        ConnectionFactory connect = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        try {
            Connection connection = connect.createConnection();
            connection.start();
            //第一个值表示是否使用事务，如果选择true，第二个值相当于选择0
            Session session = connection.createSession(true, Session.SESSION_TRANSACTED); //开启事务
            Queue testqueue = session.createQueue("TEST1");

            MessageProducer producer = session.createProducer(testqueue);
            TextMessage textMessage = new ActiveMQTextMessage();
            textMessage.setText("今天天气真好！");
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);
            producer.send(textMessage);
            session.commit();//提交事务
            connection.close();//关闭连接

        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
    }

