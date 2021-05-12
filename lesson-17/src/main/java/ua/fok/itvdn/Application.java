package ua.fok.itvdn;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ua.fok.itvdn.domain.Customer;
import ua.fok.itvdn.domain.Good;
import ua.fok.itvdn.service.CustomerService;
import ua.fok.itvdn.service.GoodService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws ParseException {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		GoodService service = ctx.getBean(GoodService.class);

		Good good = new Good();
		good.setName("Смартфон");
		good.setPrice(220);
		good.setQuantity(2);

		service.save(good);

		System.out.println(service.findById(1L));
		service.findAll();


	}
}
