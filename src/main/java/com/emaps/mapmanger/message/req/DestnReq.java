package com.emaps.mapmanger.message.req;

public class DestnReq {

    private String address;

    private Double lat;

    private Double lng;

    public DestnReq() {
    }

    public DestnReq(String address, Double lat, Double lng) {
        this.address = address;
        this.lat = lat;
        this.lng = lng;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
}
