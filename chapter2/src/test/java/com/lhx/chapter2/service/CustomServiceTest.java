package com.lhx.chapter2.service;

import com.lhx.chapter2.model.Customer;
import org.junit.Assert;

import java.util.List;

import static org.junit.Assert.*;

public class CustomServiceTest {
    private final CustomService customService;

    public CustomServiceTest() {
        this.customService = new CustomService();
    }

    @org.junit.Test
    public void getCustomerList() throws Exception {
        List<Customer> customerList = customService.getCustomerList("");
        Assert.assertEquals(2,customerList.size());
    }

    @org.junit.Test
    public void getCustomer() throws Exception {
    }

    @org.junit.Test
    public void createCustomer() throws Exception {
    }

    @org.junit.Test
    public void updateCustomer() throws Exception {
    }

    @org.junit.Test
    public void deleteCustomer() throws Exception {
    }

}