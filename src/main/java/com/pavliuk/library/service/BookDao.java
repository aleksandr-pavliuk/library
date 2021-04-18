package com.pavliuk.library.service;

import com.pavliuk.library.model.Book;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
@RestController
public interface BookDao extends GeneralDAO<Book> {
}
