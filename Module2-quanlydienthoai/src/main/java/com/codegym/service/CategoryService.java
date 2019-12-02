package com.codegym.service;

import com.codegym.model.Category;

import java.util.List;

public interface CategoryService {
    Iterable<Category> findAll();
    Category findById(Long id);
    void save(Category category);
    void remove(Long id);
}
