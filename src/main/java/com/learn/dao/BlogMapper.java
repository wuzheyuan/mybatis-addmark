package com.learn.dao;


import com.learn.pojo.Blog;
import com.learn.pojo.BlogAndAuthor;

public interface BlogMapper {
    int deleteByPrimaryKey(Integer bid);

    int insert(Blog record);

    int insertSelective(Blog record);

    Blog selectByPrimaryKey(Integer bid);
    BlogAndAuthor selectBlogAndAuthor(Integer bid);
    BlogAndAuthor selectBlogWithAuthorQuery(Integer bid);

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKey(Blog record);

}