package com.boo.exercise01.mocktio;

public class CustomerDao {
    public boolean save(Customer customer) {
        return true;
    }

    public boolean exists(String phoneNumber) {
        return false;
    }
}
