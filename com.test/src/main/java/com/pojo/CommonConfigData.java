package com.pojo;



/**
 * 获取一些公共数据
 */
public class CommonConfigData {
    private String configType;
    private String configKey;
    private String configValue;
    private String configComment;

    @Override
    public String toString() {
        return "CommonConfigData{" +
                "configType='" + configType + '\'' +
                ", configKey='" + configKey + '\'' +
                ", configValue='" + configValue + '\'' +
                ", configComment='" + configComment + '\'' +
                '}';
    }

    public String getConfigType() {
        return configType;
    }

    public void setConfigType(String configType) {
        this.configType = configType;
    }

    public String getConfigKey() {
        return configKey;
    }

    public void setConfigKey(String configKey) {
        this.configKey = configKey;
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    public String getConfigComment() {
        return configComment;
    }

    public void setConfigComment(String configComment) {
        this.configComment = configComment;
    }
}
