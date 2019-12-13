package pers.learn.helloworld.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import pers.learn.helloworld.domain.Book;
import pers.learn.helloworld.model.vo.BookVo;
import pers.learn.helloworld.reposity.BookRepository;
import pers.learn.helloworld.service.BookService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service("bookService")
@Slf4j
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookVo> listAllBookView() {
        List<Book> all = bookRepository.findAll();
        if (CollectionUtils.isEmpty(all)) {
            return Collections.emptyList();
        }
        List<BookVo> res = new ArrayList<>();
        all.stream().forEach(item -> {
            res.add(convertBy(item));
        });
        return res;
    }

    @Override
    public void insert(Book book) {
        bookRepository.save(book);
    }

    @Override
    public BookVo findById(Integer id) {
        Optional<Book> book = bookRepository.findById(id);
        Book res = book.orElse(null);
        return convertBy(res);
    }

    @Override
    public BookVo convertBy(Book book) {
        if (book == null) {
            return null;
        }
        BookVo vo = new BookVo();
        BeanUtils.copyProperties(book, vo);
        return vo;
    }
}
