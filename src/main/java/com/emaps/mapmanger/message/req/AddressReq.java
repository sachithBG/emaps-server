package com.emaps.mapmanger.message.req;

public class AddressReq {
    private String house_no;
    private String street_address;
    private String city;
    private String state;
    private  String zipcode;
    private String country;

    public AddressReq() {

    }

    public AddressReq(String house_no, String street_address, String city, String state, String zipcode, String country) {
        this.house_no = house_no;
        this.street_address = street_address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.country = country;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getHouse_no() {
        return house_no;
    }

    public void setHouse_no(String house_no) {
        this.house_no = house_no;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
