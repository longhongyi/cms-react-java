package com.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionManager;

import java.io.IOException;
import java.io.InputStream;

public class SqlManager {
    static SqlSessionManager sqlSessionManager=null;
    static {
        try {
            InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionManager=SqlSessionManager.newInstance(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static <T>T getSqlMapper (Class<T> className) throws IOException {
        T sqlMapper=sqlSessionManager.getMapper(className);
        return sqlMapper;
    }
}
