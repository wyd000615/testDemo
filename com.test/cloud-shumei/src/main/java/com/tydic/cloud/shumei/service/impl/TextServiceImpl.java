package com.tydic.cloud.shumei.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.tydic.cloud.shumei.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class TextServiceImpl implements TextService {
    @Autowired
    RestTemplate restTemplate;
    //@Value("${text.service.url}")
    private String textServiceUrl="http://10.242.31.125:19091/v2/saas/anti_fraud/text";

    @Override
    public String queryTextResult(JSONObject json) {
        String url = textServiceUrl;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        HttpEntity<Map<String, Object>> objectHttpEntity = new HttpEntity<>(json, headers);
        String strbody = restTemplate.exchange(url, HttpMethod.POST, objectHttpEntity, String.class).getBody();
        Object weatherResponse = JSONObject.parseObject(strbody, Object.class);
        return weatherResponse.toString();
    }
}
