package com.lhx.test.dbutil1;

import com.lhx.test.dbutil1.ProductService;

public class ClientThread extends Thread {
    private ProductService productService;


    public ClientThread(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        productService.updateProductPrice(1, 3000);
    }
}
