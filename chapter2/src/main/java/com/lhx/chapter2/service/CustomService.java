package com.lhx.chapter2.service;

import com.lhx.chapter2.helper.DatabaseDbcpHelper;
import com.lhx.chapter2.helper.DatabaseHelper;
import com.lhx.chapter2.model.Customer;

import java.util.List;
import java.util.Map;

/**
 * 提供用户服务
 */
public class CustomService {
    /**
     * 获取用户列表
     *
     * @param keyword
     * @return
     */
    public List<Customer> getCustomerList(String keyword) {
        String sql="select * from customer";
        return DatabaseDbcpHelper.queryEntityList(Customer.class,sql);
    }

    /**
     * 获取单个用户
     *
     * @param id
     * @return
     */
    public Customer getCustomer(long id) {
        String sql="select * from customer where id =?";
        return DatabaseDbcpHelper.queryEntity(Customer.class,sql,id);
    }

    /**
     * 创建用户
     *
     * @param filedMap
     * @return
     */
    public boolean createCustomer(Map<String, Object> filedMap) {
        return DatabaseDbcpHelper.insertEntity(Customer.class,filedMap);
    }

    /**
     * 更新用户
     *
     * @param id
     * @param filedMap
     * @return
     */
    public boolean updateCustomer(long id, Map<String, Object> filedMap) {
        return DatabaseDbcpHelper.updateEntity(Customer.class,id,filedMap);
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    public boolean deleteCustomer(long id) {
        return DatabaseDbcpHelper.deleteEntity(Customer.class,id);
    }
}
