package com.tydic.cloud.shumei;

import com.tydic.cloud.risk.api.comment.HbaseUtil;
import com.tydic.cloud.risk.api.mq.KafkaProducerServiceImpl;
import com.tydic.cloud.risk.api.utils.MysqlDataUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EnableScheduling
@ServletComponentScan
public class CloudShumeiApplication {

    public static void main(String[] args) {
       // SpringApplication.run(CloudShumeiApplication.class, args);
    }

}
