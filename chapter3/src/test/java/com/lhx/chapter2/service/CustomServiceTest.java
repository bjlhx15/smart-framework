package com.lhx.chapter2.service;

import com.lhx.chapter2.helper.DatabaseDbcpHelper;
import com.lhx.chapter2.model.Customer;
import org.junit.Assert;
import org.junit.Before;

import java.io.*;
import java.util.List;

public class CustomServiceTest {
    private final CustomService customService;

    public CustomServiceTest() {
        this.customService = new CustomService();
    }

    @Before
    public void init() throws IOException {
        String file = "sql/customer_init.sql";
        DatabaseDbcpHelper.excuteSqlFile(file);
    }

    @org.junit.Test
    public void getCustomerList() throws Exception {
        List<Customer> customerList = customService.getCustomerList("");
        Assert.assertEquals(2, customerList.size());
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