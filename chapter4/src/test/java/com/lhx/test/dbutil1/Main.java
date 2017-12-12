package com.lhx.test.dbutil1;

public class Main {
//    public static void main(String[] args) {
//        ProductService productService = new ProductServiceImpl();
//        productService.updateProductPrice(1,3000);
//    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            ProductService productService = new ProductServiceImpl();
            ClientThread clientThread = new ClientThread(productService);
            clientThread.start();
        }
    }
}
