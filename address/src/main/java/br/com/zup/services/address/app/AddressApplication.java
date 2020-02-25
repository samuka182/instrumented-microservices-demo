package br.com.zup.services.address.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients(basePackages = "br.com.zup.services")
@SpringBootApplication
@ComponentScan(value = "br.com.zup.services")
public class AddressApplication {

    public static void main(String[] args) {
        SpringApplication.run(AddressApplication.class, args);
    }

}
