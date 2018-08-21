package com.watson.motocyclerentals.model;

/**
 * Created by Long on 2018/08/01.
 */
public class AddressEmbeddable {
    private String Address;
    private String City;
    private String postalCode;


    public AddressEmbeddable(String Address, String City, String postalCode) {
        this.Address = Address;
        this.City = City;
        this.postalCode = postalCode;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
