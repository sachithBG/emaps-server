package com.emaps.mapmanger.message.req;


import java.util.HashSet;
import java.util.Set;

public class OriginReq {

    private Double lat;

    private Double lng;

    private Set<DestnReq> destnReq = new HashSet<>();

    public OriginReq() {
    }

    public OriginReq(Double lat, Double lng, Set<DestnReq> destnReq) {
        this.lat = lat;
        this.lng = lng;
        this.destnReq = destnReq;
    }


    public Set<DestnReq> getDestnReq() {
        return destnReq;
    }

    public void setDestnReq(Set<DestnReq> destnReq) {
        this.destnReq = destnReq;
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
