package ru.gavrilov.bookreference.controllers;

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ru.gavrilov.bookreference.BookReferenceAppRun;
import ru.gavrilov.core.users.model.User;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserControllerTestIT {

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void getAllUsers() throws Exception {
        ResponseEntity<List<User>> responseEntity = restTemplate.exchange("http://localhost:8080/api/users", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<User>>() {
                });
        List<User> actualList = responseEntity.getBody();
        assertThat(actualList.size(), is(2));
        List<Long> actualIds = actualList
                .stream()
                .map(user -> user.getId())
                .collect(collectingAndThen(toList(), ImmutableList::copyOf));
        assertThat(actualIds, containsInAnyOrder(1L, 2L));
    }

    @Test
    public void createUser() throws Exception {
        HttpEntity<User> request = new HttpEntity<>(new User("Иванов Иван", new Date(), false, 45, "lionchi", "545454", "test@mail.ru"));
        ResponseEntity<User> response = restTemplate
                .exchange("http://localhost:8080/api/users/create", HttpMethod.POST, request, User.class);

        User user = response.getBody();

        assertThat(user, notNullValue());
        assertThat(user.getId(), is(4L));
    }

    @Test
    public void getUserById() throws Exception {
        String transactionUrl = "http://localhost:8080/api/users/{id}";

        Map<String, Object> params = new HashMap<>();
        params.put("id", 1L);
        User user = restTemplate.getForObject(transactionUrl, User.class, params);

        assertEquals(java.util.Optional.of(1L).get(), user.getId());
    }

    @Test
    public void updateUser() throws Exception {
    }

    @Test
    public void deleteUser() throws Exception {
    }

}