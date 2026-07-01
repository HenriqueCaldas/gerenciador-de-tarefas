package org.luis;

import org.luis.repository.DatabaseConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GerenciadorDeTarefasApplication {
    public static void main(String[] sender) {

        DatabaseConfig.inicializarBanco();

        SpringApplication.run(GerenciadorDeTarefasApplication.class, sender);
    }

}