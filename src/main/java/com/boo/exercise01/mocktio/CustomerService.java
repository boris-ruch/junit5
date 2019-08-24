package com.boo.exercise01.mocktio;

public class CustomerService {
    
    
    private final CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public boolean addCustomer(Customer customer){
        if(customerDao.exists(customer.getPhone())){
            return false;
        }
        return customerDao.save(customer);
    }
}
