package com.myty.soldier.study_java.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Book {
    private String id;
    private String name;
    private int pageCount;
    private Author author;
}
