package com.pavliuk.library.controller;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public abstract class AbstractController<T> {

    abstract public List<T> getAllAction();

    abstract public T getAction(@PathVariable() Long id);

    abstract public void saveAction(T t);

    abstract public void deleteAction(@PathVariable() Long id);
}
