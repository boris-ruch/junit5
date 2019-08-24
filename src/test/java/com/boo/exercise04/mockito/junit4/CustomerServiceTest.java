package com.boo.exercise04.mockito.junit4;

import com.boo.exercise01.mocktio.Customer;
import com.boo.exercise01.mocktio.CustomerDao;
import com.boo.exercise01.mocktio.CustomerService;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @Mock
    private CustomerDao customerDao;

    @InjectMocks
    private CustomerService customerService;

    @Test
    public void addCustomer() {
        //given
        val phone = "12345678";
        val joe = Customer.builder().name("Joe").phone(phone).build();
        val bob = Customer.builder().name("Bob").phone(phone).build();
        when(customerDao.exists(phone)).thenReturn(false);
        when(customerDao.save(joe)).thenReturn(true);
        when(customerDao.save(bob)).thenReturn(true);
        // when
        boolean customerSaved = customerService.addCustomer(joe);
        // then
        assertTrue(customerSaved);
    }
}