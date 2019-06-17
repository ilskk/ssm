package com.kk.converter;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


//set:java->db get:db->java
//BaseTypeHandler<Java类型>
public class MySexConverter extends BaseTypeHandler<Boolean> {

    /**
     * java(boolean)->db(int)
     * @param ps PreparedStatement对象
     * @param i PreparedStatement对象参数位置
     * @param parameter java值
     * @param jdbcType jdbc类型
     * @throws SQLException
     */
    @Override
    public void setParameter(PreparedStatement ps, int i, Boolean parameter, JdbcType jdbcType) throws SQLException {
        if(parameter){
            ps.setInt(i,1);
        }else {
            ps.setInt(i,0);
        }
    }

    //db(int)->java(boolean)
    @Override
    public Boolean getResult(ResultSet rs, String columnName) throws SQLException {
        return rs.getInt(columnName)==1?true:false;
    }

    @Override
    public Boolean getResult(ResultSet rs, int columnIndex) throws SQLException {
        return rs.getInt(columnIndex)==1?true:false;
    }

    @Override
    public Boolean getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return cs.getInt(columnIndex)==1?true:false;
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Boolean aBoolean, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public Boolean getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return null;
    }

    @Override
    public Boolean getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public Boolean getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }

    @Override
    public void setConfiguration(Configuration c) {
        super.setConfiguration(c);
    }
}
