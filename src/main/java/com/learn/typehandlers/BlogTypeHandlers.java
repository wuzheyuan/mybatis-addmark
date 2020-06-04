package com.learn.typehandlers;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BlogTypeHandlers extends BaseTypeHandler<List<Integer>> {

    public BlogTypeHandlers() {
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, List<Integer> integers, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, dealListToString(integers));
    }


    public List<Integer> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return convertToList(rs.getString(columnName));
    }

    public List<Integer> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return convertToList(rs.getString(columnIndex));
    }

    public List<Integer> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return convertToList(cs.getString(columnIndex));
    }

    private String dealListToString(List<Integer> parameter){
        if(parameter == null || parameter.size() == 0){
            return null;
        }else{
            String result = "";
            for(Integer param:parameter){
                result += param+",";
            }
            return result;
        }
    }
    private List<Integer> convertToList(String column){
        if(column != null && column.length() > 0){
            List<Integer> result = new ArrayList<Integer>();
            String[] arr = column.split(",");
            for(String a:arr){
                result.add(Integer.valueOf(a));
            }
            return result;
        }
        return null;
    }
}
