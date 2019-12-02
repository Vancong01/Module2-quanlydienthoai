package com.codegym.repository;

import com.codegym.model.Category;
import com.codegym.model.Phone;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PhoneRepository extends PagingAndSortingRepository<Phone,Long> {
    Iterable<Phone> findAllByCategory(Category category);
    //Phân trang
    Page<Phone> findAllByNameContaining(String name, Pageable pageable);
}
