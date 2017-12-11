package com.lhx.test;

import javax.xml.transform.Source;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductServiceImpl implements ProductService {

    private static final String Update_Product_sql = "update product set price=? where id=?";
    private static final String Insert_Log_sql = "insert into log(crerated,description)values(?,?)";

    @Override
    public void updateProductPrice(Long productId, int price) {
        try {
            Connection connection = DBUtil.getConnection();
            connection.setAutoCommit(false);
            updateProduct(connection,Update_Product_sql,productId,price);
            insertLog(connection,Update_Product_sql,"Create Product");
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.colseConnection();
        }
    }
    private void updateProduct(Connection connection,String sql,long productId,int price) throws Exception{
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1,price);
        pstmt.setLong(2,productId);
        int rows = pstmt.executeUpdate();
        if(rows!=0){
            System.out.println("update product success");
        }
    }
    private void insertLog(Connection connection,String sql,String msg) throws Exception{
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss").format(new Date()));
        pstmt.setString(2,msg);
        int rows = pstmt.executeUpdate();
        if(rows!=0){
            System.out.println("insert log success");
        }
    }
}
