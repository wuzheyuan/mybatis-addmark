package com.learn.dao;

import com.learn.pojo.Blog;
import com.learn.pojo.BlogAndAuthor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogMapperExt extends BlogMapper {
    List<Blog> selectByName(@Param("name") String name, @Param("pageSize") Integer pageSize, @Param("pageNo") Integer pageNo);
}
