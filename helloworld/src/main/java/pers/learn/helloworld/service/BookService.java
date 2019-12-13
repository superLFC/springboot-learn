package pers.learn.helloworld.service;

import pers.learn.helloworld.domain.Book;
import pers.learn.helloworld.model.vo.BookVo;

import java.util.List;

public interface BookService {

    List<BookVo> listAllBookView();

    void insert(Book book);

    BookVo findById(Integer id);

    BookVo convertBy(Book book);
}
