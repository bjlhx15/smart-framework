package com.lhx.chapter3.controller;

import com.lhx.chapter3.model.Customer;
import com.lhx.chapter3.service.CustomService;
import com.lhx.smart.framework.annotation.Action;
import com.lhx.smart.framework.annotation.Controller;
import com.lhx.smart.framework.annotation.Inject;
import com.lhx.smart.framework.bean.Data;
import com.lhx.smart.framework.bean.Param;
import com.lhx.smart.framework.bean.View;

import java.util.List;
import java.util.Map;

/*
 * 处理客户管理相关请求
*/
@Controller
public class CustomerController {
    @Inject
    private CustomService customService;

    @Action("get:/customer")
    public View index(Param param) {
        List<Customer> customerList = customService.getCustomerList("");
        return new View("customer.jsp").addModel("customerlist", customerList);
    }

    @Action("get:/customer_show")
    public View show(Param param) {
        long id = param.getLong("id");
        Customer customer = customService.getCustomer(id);
        return new View("customer_show.jsp").addModel("customer", customer);
    }

    @Action("get:/customer_create")
    public View create(Param param) {
        return new View("customer_create.jsp");
    }

    @Action("post:/customer_create")
    public Data createSumbit(Param param) {
        Map<String, Object> paramMap = param.getParamMap();
        boolean result = customService.createCustomer(paramMap);
        return new Data(result);
    }

    @Action("get:/customer_edit")
    public View edit(Param param) {
        long id = param.getLong("id");
        Customer customer = customService.getCustomer(id);
        return new View("customer_edit.jsp").addModel("customer", customer);
    }

    @Action("post:/customer_edit")
    public Data editSumbit(Param param) {
        long id = param.getLong("id");
        Map<String, Object> paramMap = param.getParamMap();
        boolean result = customService.updateCustomer(id, paramMap);
        return new Data(result);
    }

    @Action("post:/customer_delete")
    public Data delete(Param param) {
        long id = param.getLong("id");
        boolean result = customService.deleteCustomer(id);
        return new Data(result);
    }
}
