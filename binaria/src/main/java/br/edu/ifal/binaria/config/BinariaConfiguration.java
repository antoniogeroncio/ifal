package br.edu.ifal.binaria.config;

import br.edu.ifal.binaria.entity.DicionarioInteiro;
import br.edu.ifal.binaria.entity.DicionarioString;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BinariaConfiguration {

    @Bean
    public DicionarioInteiro dicionarioInteiro(){
        return new DicionarioInteiro();
    }

    @Bean
    public DicionarioString dicionarioString(){
        return new DicionarioString();
    }
}
