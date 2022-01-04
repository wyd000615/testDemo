package com.tydic.cloud.shumei.controller;

import com.alibaba.fastjson.JSONObject;
import com.tydic.cloud.shumei.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 风控调用数美智能识别接口
 */
@RestController
@RequestMapping("/fk/shumei/text")
public class TextController {
    @Autowired
    TextService textService;

    @RequestMapping("/query")
    public String queryTextResult() {
        JSONObject json = new JSONObject();
        json.put("accessKey", "d3B6f1yaj52T5WzR5WtF");
        json.put("type", "ZHIBO");
        json.put("appId", "default");
        JSONObject data = new JSONObject();
        data.put("text", "傻逼");
        data.put("tokenId", UUID.randomUUID());
        json.put("data", data);
        String result = textService.queryTextResult(json);
        return result;
    }
}
