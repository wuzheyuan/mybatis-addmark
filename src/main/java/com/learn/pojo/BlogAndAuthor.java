package com.learn.pojo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BlogAndAuthor extends Blog {
    private Author author;
}
