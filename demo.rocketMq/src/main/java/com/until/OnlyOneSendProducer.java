package com.until;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

public class OnlyOneSendProducer {
        public static void main(String[] args) throws Exception{
            //Instantiate with a producer group name.
            DefaultMQProducer producer = new DefaultMQProducer("ExampleProducerGroup");
            //Launch the instance.
            producer.setNamesrvAddr("192.168.94.128:9876");
            producer.start();
            for (int i = 0; i < 100; i++) {
                //Create a message instance, specifying topic, tag and message body.
                Message msg = new Message("TopicTest" /* Topic */,
                        "TagA" /* Tag */,
                        ("我是单向信息 " +
                                i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
                );
                //Call send message to deliver message to one of brokers.
                producer.sendOneway(msg);

            }
            //Shut down once the producer instance is not longer in use.
            producer.shutdown();
        }

}
