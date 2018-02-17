package ru.gavrilov.core.mappers;

import fr.xebia.extras.selma.Selma;

public class MapperFactory {

    public static <T>  T createMapper (Class<T> typeMapperClass){
        if (typeMapperClass == AuthorMapper.class){
            return (T) Selma.builder(AuthorMapper.class).build();
        } else if (typeMapperClass == BookMapper.class) {
            return (T) Selma.builder(BookMapper.class).build();
        } else {
            return  (T) Selma.builder(UserMapper.class).build();
        }
    }
}
