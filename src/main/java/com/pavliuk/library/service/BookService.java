package com.pavliuk.library.service;

import com.pavliuk.library.model.Book;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
@RestController
public interface BookService extends GeneralService<Book> {
}
