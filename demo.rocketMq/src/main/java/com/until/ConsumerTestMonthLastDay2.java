package com.until;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsumerTestMonthLastDay2 {

    public static DefaultMQPushConsumer initSuccessConsumerOrder() {

        DefaultMQPushConsumer defaultMQPushConsumer = new DefaultMQPushConsumer("successConsumer");
        defaultMQPushConsumer.setNamesrvAddr("192.168.94.131:9876");
        try {
            defaultMQPushConsumer.subscribe("IotMonthLastDayTopic", "*");
            defaultMQPushConsumer
                    .setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
            defaultMQPushConsumer.setConsumeMessageBatchMaxSize(100);
            defaultMQPushConsumer.setConsumeThreadMax(100);
            defaultMQPushConsumer.registerMessageListener((MessageListenerOrderly) (msgs, context) -> {
                //每个月 月底开启
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                //获取当前时间
                long currTime = System.currentTimeMillis();
                String currTimeStr = sdf.format(new Date(currTime));
                System.out.println("==currTimeStr==" + currTimeStr);
                Timestamp currMonthLastDayTimestamp = DataUntil.getCurrMonthLastDayTimestamp();
                String currMonthLastDayTimestampStr = sdf.format(new Date(currMonthLastDayTimestamp.getTime()));
                System.out.println("==currMonthLastDayTimestampStr==" + currMonthLastDayTimestampStr);
                // if (currMonthLastDayTimestampStr.equals(currTimeStr)) {

                context.setAutoCommit(true);
                for (MessageExt msg : msgs) {
                    try {
                        long currTime2 = System.currentTimeMillis();
                        //System.out.println(currTime2);
                       // if (String.valueOf(currTime2).endsWith("2")) {
                            System.out.println("="+currTime2+"==yyyyy==="+msg);
                            return ConsumeOrderlyStatus.SUCCESS;

                        //}
                        //return null;
                    } catch (Exception e) {
                       // return ConsumeOrderlyStatus.SUCCESS;
                    }
                }
                // }
                return null;
            });
            defaultMQPushConsumer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        return defaultMQPushConsumer;
    }

    private static void processMessage(MessageExt msg) {
        String reqJson = new String(msg.getBody(), StandardCharsets.UTF_8);
        System.out.println("====xxxxx=====" + reqJson);
    }


    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer defaultMQPushConsumer = initSuccessConsumerOrder();
    }

}
