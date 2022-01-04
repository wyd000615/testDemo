package com.collection;

import org.omg.CosNaming.BindingIterator;

import java.util.HashMap;
import java.util.Map;

public class DicUtil {
    private static final   Map<String , Map<String,String>>   dicMap= new HashMap<>();
    static {
        //新增拼团活动状态
        String key = "ptActivityStatus";
        HashMap<String, String> valueMap = new HashMap<>();
        valueMap.put("0", "未开始");
        valueMap.put("1", "一开始");
        dicMap.put(key,valueMap);

    }
}
