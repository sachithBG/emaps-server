package com.emaps.mapmanger.message.req;


public class UserReq {
    private String email;
    private AddressReq address;
    private OriginReq origin;

    public UserReq() {
    }

    public UserReq(String email, AddressReq address, OriginReq origin) {
        this.email = email;
        this.address = address;
        this.origin = origin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressReq getAddress() {
        return address;
    }

    public void setAddress(AddressReq address) {
        this.address = address;
    }

    public OriginReq getOrigin() {
        return origin;
    }

    public void setOrigin(OriginReq origin) {
        this.origin = origin;
    }
}
