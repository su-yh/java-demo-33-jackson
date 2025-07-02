package com.suyh3301.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class JacksonEntity implements Serializable {
    private String name;
    private Integer age;
    private Date birth;
    private Long nullVar;
}
