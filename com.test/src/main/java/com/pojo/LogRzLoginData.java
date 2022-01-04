package com.pojo;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogRzLoginData {

    private static Logger LOGGER = Logger.getLogger(LogRzLoginData.class);

    private String titleName;//按钮名称
    private String mobile;//用户号码
    private String pordId;//主套餐
    private String provinceCode;//省份
    private String cityCode;//地市
    private String netType;//网别
    private String loginTime;//登录时间
    private String loginType;//登录类型
    private String loginState;//登录状态
    private String imei;//IMEI
    private String userIp;//IP
    private String appid;//APPID
    private String iccid;//ICCID
    private String imsi;//IMSI
    private String mac;//MAC
    private String meid;//MEID
    private String lat;//经度
    private String lon;//纬度
    private String deviceBrand;//终端品牌
    private String deviceModel;//终端型号
    private String os;//终端操作系统
    private String osVersion;//终端操作系统版本
    private String screen;//屏幕分辩率
    private String memorySpace;//手机内存
    private String phoneSpace;//手机存储空间
    private Timestamp insertTime;//写表时间
    private String Hkey;
    private String loginTimeFormat;
    private String isAlarm;//是否属于告警数据
    private String ip;//IP
    private String agencyId;
    private String changeImeiFlag;// 换机标识 1本次登录和上次登录相比换机 0 本次登录和上次登录相比未换机


    @Override
    public String toString() {
        return "LogRzLoginData{" +
                "titleName='" + titleName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", pordId='" + pordId + '\'' +
                ", provinceCode='" + provinceCode + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", netType='" + netType + '\'' +
                ", loginTime='" + loginTime + '\'' +
                ", loginType='" + loginType + '\'' +
                ", loginState='" + loginState + '\'' +
                ", imei='" + imei + '\'' +
                ", userIp='" + userIp + '\'' +
                ", appid='" + appid + '\'' +
                ", iccid='" + iccid + '\'' +
                ", imsi='" + imsi + '\'' +
                ", mac='" + mac + '\'' +
                ", meid='" + meid + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                ", deviceBrand='" + deviceBrand + '\'' +
                ", deviceModel='" + deviceModel + '\'' +
                ", os='" + os + '\'' +
                ", osVersion='" + osVersion + '\'' +
                ", screen='" + screen + '\'' +
                ", memorySpace='" + memorySpace + '\'' +
                ", phoneSpace='" + phoneSpace + '\'' +
                ", insertTime=" + insertTime +
                ", Hkey='" + Hkey + '\'' +
                ", loginTimeFormat='" + loginTimeFormat + '\'' +
                ", isAlarm='" + isAlarm + '\'' +
                ", ip='" + ip + '\'' +
                ", agencyId='" + agencyId + '\'' +
                ", changeImeiFlag='" + changeImeiFlag + '\'' +
                '}';
    }

    public String getPordId() {
        return pordId;
    }

    public void setPordId(String pordId) {
        this.pordId = pordId;
    }

    public String getChangeImeiFlag() {
        return changeImeiFlag;
    }

    public void setChangeImeiFlag(String changeImeiFlag) {
        this.changeImeiFlag = changeImeiFlag;
    }

    public String getIsAlarm() {
        return isAlarm;
    }

    public void setIsAlarm(String isAlarm) {
        this.isAlarm = isAlarm;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    public String toStringFormat() {
        return "{" +
                "mobile='" + mobile + '\'' +
                ", imei='" + imei + '\'' +
                ", userIp='" + userIp + '\'' +
                ", appid='" + appid + '\'' +
                ", iccid='" + iccid + '\'' +
                ", imsi='" + imsi + '\'' +
                ", mac='" + mac + '\'' +
                ", meid='" + meid + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                '}';
    }

    public String getLoginTimeFormat() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = "";
        try {
            if (getLoginTime().contains(".")) {
                int i = getLoginTime().indexOf(".");
                String substring = getLoginTime().substring(0, i);
                if (String.valueOf(System.currentTimeMillis()).length() == substring.length()) {
                    date = format.format(new Date(Long.parseLong(substring)));
                } else if (String.valueOf(System.currentTimeMillis() / 1000).length() == substring.length()) {
                    date = format.format(new Date(Long.parseLong(substring) * 1000));
                }
            } else {
                date = format.format(new Date(Long.parseLong(getLoginTime())));
            }
        } catch (Exception e) {
            date = format.format(new Date(System.currentTimeMillis()));
            LOGGER.error("time error:" + getLoginTime(), e);
        }
        return date;
    }

    public void setLoginTimeFormat(String loginTimeFormat) {
        this.loginTimeFormat = loginTimeFormat;
    }

    public String getHkey() {
        String s = getMobile().length() <= 3 ? getMobile() :
                getMobile().substring(getMobile().length() - 3) + ""
                        + getMobile().substring(0, getMobile().length() - 3);
        if (StringUtils.isEmpty(s)) {
            s = "0";
        }
        return s;
    }

    public void setHkey(String hkey) {
        Hkey = getMobile().length() <= 3 ? (StringUtils.isEmpty(getMobile()) ? "0" : getMobile()) :
                getMobile().substring(getMobile().length() - 3) + ""
                        + getMobile().substring(0, getMobile().length() - 3);
    }

    public Timestamp getInsertTime() {
        return new Timestamp(System.currentTimeMillis());
    }

    public void setInsertTime(Timestamp insertTime) {
        this.insertTime = new Timestamp(System.currentTimeMillis());
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getNetType() {
        return netType;
    }

    public void setNetType(String netType) {
        this.netType = netType;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getLoginState() {
        return loginState;
    }

    public void setLoginState(String loginState) {
        this.loginState = loginState;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getMeid() {
        return meid;
    }

    public void setMeid(String meid) {
        this.meid = meid;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getDeviceBrand() {
        return deviceBrand;
    }

    public void setDeviceBrand(String deviceBrand) {
        this.deviceBrand = deviceBrand;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getMemorySpace() {
        return memorySpace;
    }

    public void setMemorySpace(String memorySpace) {
        this.memorySpace = memorySpace;
    }

    public String getPhoneSpace() {
        return phoneSpace;
    }

    public void setPhoneSpace(String phoneSpace) {
        this.phoneSpace = phoneSpace;
    }



}