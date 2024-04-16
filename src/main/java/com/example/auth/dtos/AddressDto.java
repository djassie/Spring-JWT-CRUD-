package com.example.auth.dtos;

import com.example.auth.entities.User;

public class AddressDto {
    private int id;

    private String HouseNo;
    private String StreetAddress;

    private String zipCode;
    private String State;
    private String Country;
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHouseNo() {
        return HouseNo;
    }

    public void setHouseNo(String houseNo) {
        HouseNo = houseNo;
    }

    public String getStreetAddress() {
        return StreetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        StreetAddress = streetAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    @Override
    public String toString() {
        return "AddressDto{" +
                "id=" + id +
                ", HouseNo='" + HouseNo + '\'' +
                ", StreetAddress='" + StreetAddress + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", State='" + State + '\'' +
                ", Country='" + Country + '\'' +
                '}';
    }
}
