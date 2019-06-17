package com.kk.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionManager;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtils {

    static InputStream in;
    static SqlSessionManager sqlSessionManager;

    static {
        try {
            in= Resources.getResourceAsStream("mybatis.xml");
            sqlSessionManager=SqlSessionManager.newInstance(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession(){
        return sqlSessionManager.openSession();
    }

}
