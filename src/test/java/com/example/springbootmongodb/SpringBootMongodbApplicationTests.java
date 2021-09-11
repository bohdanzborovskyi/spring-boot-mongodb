package com.example.springbootmongodb;

import com.example.springbootmongodb.service.DBService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(classes = MongoDBApplication.class)
class SpringBootMongodbApplicationTests {

    @Autowired
    DBService dbService;

    @Test
    void contextLoads()
    {

    }

    @Test
    public void getFilmCategories()
    {
        assertThat(dbService.getAllFilmCategorySortByName().size()).isEqualTo(3);
    }

    @Test
    public void getFilmByLanguage()
    {
        assertThat(dbService.getAllFilmByLanguage("Spanish").size()).isEqualTo(1);
    }

    @Test
    public void getActorByFilm()
    {
        assertThat(dbService.getAllActorByFilmTitle("Next movie").get(0).getFirstName()).isEqualTo("Kamor");
        assertThat(dbService.getAllActorByFilmTitle("Next movie").get(0).getLastName()).isEqualTo("Fuente");
    }

}
