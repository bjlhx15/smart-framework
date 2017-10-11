package com.lhx.chapter3.helper;

import com.lhx.chapter3.util.PropsUtil;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * db链接工具
 */
public class DatabaseHelper {
    private static final Logger log = LoggerFactory.getLogger(DatabaseHelper.class);

    private static final String DRIVER;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;

    private static final QueryRunner QUERY_RUNNER ;
    private static final ThreadLocal<Connection> CONNECTION_HOLDER ;

    static {
        QUERY_RUNNER = new QueryRunner();
        CONNECTION_HOLDER = new ThreadLocal<>();
        Properties conf = PropsUtil.loadProps("config.properties");
        DRIVER = conf.getProperty("jdbc.driver");
        URL = conf.getProperty("jdbc.url");
        USERNAME = conf.getProperty("jdbc.username");
        PASSWORD = conf.getProperty("jdbc.password");
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            log.error("类加载失败", e);
        }
    }

    public static Connection getConnection() {
        Connection conn = CONNECTION_HOLDER.get();
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                log.error("获取链接失败", e);
            } finally {
                CONNECTION_HOLDER.set(conn);
            }
        }
        return conn;
    }

    public static void closeConnection() {
        Connection conn = CONNECTION_HOLDER.get();
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                log.error("关闭链接失败", e);
            } finally {
                CONNECTION_HOLDER.remove();
            }
        }
    }

    public static <T> List<T> queryEntityList(Class<T> entityClass, String sql, Object... parmas) {
        List<T> entityList;
        try {
            entityList = QUERY_RUNNER.query(getConnection(), sql, new BeanListHandler<T>(entityClass), parmas);
        } catch (SQLException e) {
            log.error("查询实体失败", e);
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
        return entityList;
    }

    public static <T> T queryEntity(Class<T> entityClass, String sql, Object... parmas) {
        T entity;
        try {
            entity = QUERY_RUNNER.query(getConnection(), sql, new BeanHandler<T>(entityClass), parmas);
        } catch (SQLException e) {
            log.error("查询实体失败", e);
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
        return entity;
    }

    public static List<Map<String, Object>> excuteQuery(String sql, Object... parmas) {
        List<Map<String, Object>> result;
        try {
            result = QUERY_RUNNER.query(getConnection(), sql, new MapListHandler(), parmas);
        } catch (SQLException e) {
            log.error("查询失败", e);
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
        return result;
    }

    public static int excuteUpdate(String sql, Object... parmas) {
        int rows = 0;
        try {
            rows = QUERY_RUNNER.update(getConnection(), sql, parmas);
        } catch (SQLException e) {
            log.error("更新失败", e);
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
        return rows;
    }

    private static String getTableName(Class<?> entityClass) {
        return entityClass.getSimpleName();
    }

    public static <T> boolean insertEntity(Class<T> entityClass, Map<String, Object> filedMap) {
        if (MapUtils.isEmpty(filedMap)) {
            log.error("请求插入的map不能为空");
            return false;
        }

        String sql = "insert into " + getTableName(entityClass);
        StringBuilder columns = new StringBuilder("(");
        StringBuilder values = new StringBuilder("(");
        for (String filedName : filedMap.keySet()) {
            columns.append(filedName).append(", ");
            values.append("?, ");
        }
        columns.replace(columns.lastIndexOf(", "), columns.length(), ")");
        values.replace(values.lastIndexOf(", "), values.length(), ")");
        sql += columns + " values " + values;
        Object[] parmas = filedMap.values().toArray();
        return excuteUpdate(sql, parmas) == 1;
    }

    public static <T> boolean updateEntity(Class<T> entityClass, long id, Map<String, Object> filedMap) {
        if (MapUtils.isEmpty(filedMap)) {
            log.error("请求更新的map不能为空");
            return false;
        }

        String sql = "update " + getTableName(entityClass) + " set ";
        StringBuilder columns = new StringBuilder();
        for (String filedName : filedMap.keySet()) {
            columns.append(filedName).append("=?, ");
        }
        sql += columns.substring(0, columns.lastIndexOf(", ")) + "  where id=?";
        List<Object> paramsList = new ArrayList<>();
        paramsList.addAll(filedMap.values());
        paramsList.add(id);
        Object[] parmas = paramsList.toArray();
        return excuteUpdate(sql, parmas) == 1;
    }
    public static <T> boolean deleteEntity(Class<T> entityClass, long id) {
        String sql = "delete from  " + getTableName(entityClass) + " where id=? ";
        return excuteUpdate(sql, id) == 1;
    }
    public static void excuteSqlFile(String filePath) {
        String file = "sql/customer_init.sql";
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String sql;
        try {
            while ((sql = reader.readLine()) != null) {
                excuteUpdate(sql);
            }
        } catch (IOException e) {
            log.error("文件读取异常", e);
            throw new RuntimeException(e);
        }
    }
}
