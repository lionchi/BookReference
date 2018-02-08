package ru.gavrilov.core;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "")
@EnableAutoConfiguration //Заменяет @EnableJpaRepositories,@EntityScan,@EnableJpaAuditing, так же пути можно явно указывать

public class SpringConfiguration {

}