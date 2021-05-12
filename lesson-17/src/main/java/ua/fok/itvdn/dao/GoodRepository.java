package ua.fok.itvdn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.fok.itvdn.domain.Good;

import java.util.List;

/**
 * Created by maxim on 12.05.2021.
 */
public interface GoodRepository extends JpaRepository<Good, Long>, CrudRepository<Good, Long> {

    List<Good> findOrderByName(String name);

    List<Good> findOrderByPrice(double price);

}
