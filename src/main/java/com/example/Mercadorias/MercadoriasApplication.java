package com.example.Mercadorias;

import com.example.Mercadorias.view.MercadoriasMenu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MercadoriasApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MercadoriasApplication.class, args);

        MercadoriasMenu menu = new MercadoriasMenu();
        menu.executa();
    }
}