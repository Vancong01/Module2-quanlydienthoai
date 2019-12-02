package com.codegym.service.impl;

import com.codegym.model.Category;
import com.codegym.model.Phone;
import com.codegym.repository.PhoneRepository;
import com.codegym.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public Iterable<Phone> findAll() {

        return phoneRepository.findAll();
    }

    @Override
    public Phone findById(Long id) {
        return phoneRepository.findOne(id);
    }

    @Override
    public void save(Phone phone) {
        phoneRepository.save(phone);
    }

    @Override
    public void remove(Long id) {
        phoneRepository.delete(id);
    }

    //Hiển thị danh sách thêm vào option
    @Override
    public Iterable<Phone> findAllByCategory(Category category) {
        return phoneRepository.findAllByCategory(category);
    }
    //Phân trang
    @Override
    public Page<Phone> findAll(Pageable pageable) {
        return phoneRepository.findAll(pageable);
    }


    @Override
    public Page<Phone> findAllByNameContaining(String name, Pageable pageable) {
        return phoneRepository.findAllByNameContaining(name,pageable);
    }
}
