package com.test;

import java.util.List;

public class IotDiscntEntity {


    /**
     * 资费ID 必填
     */
    private String productId;

    /**
     * 资费ID 必填
     */
    private String packageId;

    /**
     * 资费ID 必填
     */
    private String discntId;

    /**
     * 动作类型 必填
     */
    private String actionType;

    /**
     * 属性实体
     */
    private List properties;

    public IotDiscntEntity() {
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getDiscntId() {
        return discntId;
    }

    public void setDiscntId(String discntId) {
        this.discntId = discntId;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public List getProperties() {
        return properties;
    }

    public void setProperties(List properties) {
        this.properties = properties;
    }
}
