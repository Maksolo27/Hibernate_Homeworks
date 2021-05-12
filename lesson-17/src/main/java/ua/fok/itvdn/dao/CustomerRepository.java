package ua.fok.itvdn.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import ua.fok.itvdn.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>, CrudRepository<Customer, Long>{

	List<Customer> findByEmail(String email);

	List<Customer> findByDate(Date date);
		
}
