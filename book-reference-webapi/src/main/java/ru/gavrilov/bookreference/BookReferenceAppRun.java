package ru.gavrilov.bookreference;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import ru.gavrilov.core.SpringConfiguration;

@SpringBootApplication(scanBasePackages = "")
@Import(SpringConfiguration.class)
public class BookReferenceAppRun {
    public static void main(String[] args) {
        SpringApplication.run(BookReferenceAppRun.class,args);
    }
}
