package com.codegym.service;

import com.codegym.model.Category;
import com.codegym.model.Phone;
import jdk.nashorn.internal.runtime.arrays.IteratorAction;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface PhoneService {
    Iterable<Phone> findAll();
    Phone findById(Long id);
    void save(Phone phone);
    void remove(Long id);
    //Hiển thị danh sách thể loại
    Iterable<Phone> findAllByCategory(Category category);
    //Phân trang
    Page<Phone> findAll(Pageable pageable);
    Page<Phone> findAllByNameContaining(String name,Pageable pageable);
}
