package com.irsha.test.rabbitmq_demo;

import com.rabbitmq.client.*;

public class Send {
    private final static String EXC_NAME = "exchange";

    public void sendRabbitMQ(String[] txt) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXC_NAME, BuiltinExchangeType.DIRECT);

        String severity = getSeverity(txt);
        String message = getMessage(txt);

        channel.basicPublish(EXC_NAME,severity, null, message.getBytes("UTF-8"));
        System.out.println(" [x] Sent '" + message + "'");
        channel.close();
        connection.close();

    }

    private static String getSeverity(String[] txt) {
        if(txt.length<1){
            return "info";
        }
        return txt[0];
    }

    private static String getMessage(String[] strings){
        if (strings.length < 2)
            return "Hello World!";
        return joinStrings(strings, " ", 1);
    }

    private static String joinStrings(String[] strings, String delimiter, int startIndex) {
        int length = strings.length;
        if (length == 0) return "";
        if (length < startIndex) return "";
        StringBuilder words = new StringBuilder(strings[startIndex]);
        for (int i = startIndex + 1; i < length; i++) {
            words.append(delimiter).append(strings[i]);
        }
        return words.toString();
    }

}
