package com.tydic.cloud.shumei.service;

import com.alibaba.fastjson.JSONObject;

/**
 * 智能文本识别接口
 */
public interface TextService {
    /**
     * 调数美的智能文本识别接口
     * @return
     */
    String queryTextResult( JSONObject json) ;
}
