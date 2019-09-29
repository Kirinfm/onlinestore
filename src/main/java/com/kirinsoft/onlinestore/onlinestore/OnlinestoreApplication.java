package com.kirinsoft.onlinestore.onlinestore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
public class OnlinestoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlinestoreApplication.class, args);
    }
}
