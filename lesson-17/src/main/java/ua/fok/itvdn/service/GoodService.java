package ua.fok.itvdn.service;

import ua.fok.itvdn.domain.Customer;
import ua.fok.itvdn.domain.Good;

import java.util.Date;
import java.util.List;

/**
 * Created by maxim on 12.05.2021.
 */
public interface GoodService  {


    Good save(Good good);

    Good findById(Long id);

    Good update(Good good);

    void deleteById(Long id);

    List<Good> findAll();

    List<Good> findByName(String name);

    List<Good> findByPrice(double price);

}
