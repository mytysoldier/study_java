package com.myty.soldier.study_java.resolver;

import com.myty.soldier.study_java.model.Author;
import com.myty.soldier.study_java.model.Book;

import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class BookResolver implements GraphQLQueryResolver {

    public Book bookById(String bookId) {
        return new Book(bookId, "testbook", 1, new Author("001", "firstname", "lastname"));
    }

}
