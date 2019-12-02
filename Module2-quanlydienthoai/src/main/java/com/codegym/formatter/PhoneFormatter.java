package com.codegym.formatter;

import com.codegym.model.Phone;
import com.codegym.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class PhoneFormatter implements Formatter<Phone> {

    //Chuyển đổi từ id sang object
    private PhoneService phoneService;

    @Autowired
    public PhoneFormatter(PhoneService phoneService){
        this.phoneService = phoneService;
    }
    @Override
    public Phone parse(String text, Locale locale) throws ParseException {
        return phoneService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Phone object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}