package com.boo.exercise04.mockito.junit5;

import com.boo.exercise01.mocktio.CustomerService;
import com.boo.exercise01.mocktio.Customer;
import com.boo.exercise01.mocktio.CustomerDao;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerDao customerDao;

    @InjectMocks
    private CustomerService customerService;

    @Test
    @DisplayName("Create customer with not existing phone, stored successfully")
    void createCustomer_not_existing_phone_successfully() {
        // given
        val phone = "12345678";
        val joe = Customer.builder().name("Joe").phone(phone).build();
        val bob = Customer.builder().name("Bob").phone(phone).build();
        when(customerDao.exists(phone)).thenReturn(false);
        when(customerDao.save(joe)).thenReturn(true);
        // a unnecessary stubbing, 'Bob' is not used in this test
        when(customerDao.save(bob)).thenReturn(true);
        // when
        boolean customerSaved = customerService.addCustomer(joe);
        // then
        assertTrue(customerSaved);
    }
}