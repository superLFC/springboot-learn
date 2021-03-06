package pers.learn.helloworld.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.learn.helloworld.domain.Book;
import pers.learn.helloworld.enums.ServerStautsEnum;
import pers.learn.helloworld.model.Result;
import pers.learn.helloworld.model.vo.BookVo;
import pers.learn.helloworld.service.BookService;

import java.util.List;

@RestController
@Slf4j
@Api("hello")
public class HelloWorldController {

    @Autowired
    private BookService bookService;

    @GetMapping("/show/all")
    @ApiOperation(value = "查询所有book")
    public Result<BookVo> listAllBook() {
        List<BookVo> bookVoList = bookService.listAllBookView();
        return Result.success(bookVoList);
    }

    @ApiOperation(value = "新增book")
    @PostMapping(value = "/insert/book", produces = "application/json;charset=utf-8")
    public Result<String> insertBook(@RequestBody Book book) {
        try {
            bookService.insert(book);
            return Result.success("SUCCESS");
        } catch (Exception e){
            log.error("处理异常", e);
            return Result.fail(ServerStautsEnum.SERVER_ERROR);
        }
    }

    @PostMapping("/find/book")
    @ApiOperation(value = "根据ID查找book")
    public Result<Book> findById(@RequestParam(name = "id")Integer id) {
        BookVo vo = bookService.findById(id);
        return Result.success(vo);
    }
}
