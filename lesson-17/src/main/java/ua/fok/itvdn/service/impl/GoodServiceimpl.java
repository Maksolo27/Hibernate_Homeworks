package ua.fok.itvdn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.fok.itvdn.dao.GoodRepository;
import ua.fok.itvdn.domain.Good;
import ua.fok.itvdn.service.GoodService;

import java.util.List;

/**
 * Created by maxim on 12.05.2021.
 */
@Service
public class GoodServiceimpl implements GoodService {

    @Autowired
    private GoodRepository goodRepository;


    @Override
    public Good save(Good good) {
        return goodRepository.saveAndFlush(good);
    }

    @Override
    public Good findById(Long id) {
        return goodRepository.getOne(id);
    }


    @Override
    public Good update(Good good) {
        return goodRepository.save(good);
    }

    @Override
    public void deleteById(Long id) {
        goodRepository.deleteById(id);
    }

    @Override
    public List<Good> findAll() {
        return goodRepository.findAll();
    }

    @Override
    public List<Good> findByName(String name) {
        return goodRepository.findOrderByName(name);
    }

    @Override
    public List<Good> findByPrice(double price) {
        return goodRepository.findOrderByPrice(price);
    }
}
