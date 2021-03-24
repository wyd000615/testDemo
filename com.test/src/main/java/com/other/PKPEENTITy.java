package com.other;

public class PKPEENTITy {
    private String pk;
    private String pe;
    private String order;
    private String unsubscribe;

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getPe() {
        return pe;
    }

    public void setPe(String pe) {
        this.pe = pe;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getUnsubscribe() {
        return unsubscribe;
    }

    public void setUnsubscribe(String unsubscribe) {
        this.unsubscribe = unsubscribe;
    }

    @Override
    public String toString() {
        return "PKPEENTITy{" +
                "pk='" + pk + '\'' +
                ", pe='" + pe + '\'' +
                ", order='" + order + '\'' +
                ", unsubscribe='" + unsubscribe + '\'' +
                '}';
    }
}
