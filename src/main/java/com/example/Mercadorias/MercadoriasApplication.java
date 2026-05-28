package com.example.Mercadorias;

import com.example.Mercadorias.view.MercadoriasMenu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MercadoriasApplication {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(MercadoriasApplication.class, args);

        MercadoriasMenu menu = context.getBean(MercadoriasMenu.class);
        menu.executa();
    }
}