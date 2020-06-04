package com.learn.base;

import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

@Intercepts({@Signature(
        type= Executor.class,
        method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class PagePlugin implements Interceptor {
    private Properties properties = new Properties();
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("**************拦截到update方法*************");
        Object[] args = invocation.getArgs();
        MapperMethod.ParamMap paramMap = (MapperMethod.ParamMap)args[1];
        Object pageSize = paramMap.get("pageSize");
        Object pageNo = paramMap.get("pageNo");
        if(null != pageSize && null != pageNo){
            int pageNoInt = Integer.parseInt(pageNo.toString());
            int pageSizeInt = Integer.parseInt(pageSize.toString());
            int offSet = (pageNoInt-1)*pageSizeInt;

            RowBounds rowBounds =new RowBounds(offSet,Integer.parseInt(pageSize.toString()));
            args[2] = rowBounds;
        }
        Object returnObject = invocation.proceed();
        return returnObject;

    }

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
