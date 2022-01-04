package com.young.sizhou.houserent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SizhouHouseRentApplication {

    public static void main(String[] args) {
        SpringApplication.run(SizhouHouseRentApplication.class, args);
    }

}
