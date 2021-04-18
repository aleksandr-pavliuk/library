package com.pavliuk.library.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public abstract class AbstractController<T> {

    abstract public T getAction(@PathVariable() Long id);

    abstract public void saveAction(T t);

    abstract public void updateAction(@RequestBody T t, @PathVariable() Long id);

    abstract public void deleteAction(@PathVariable() Long id);
}
