package de.ait.services;

import de.ait.model.User;
import de.ait.repositories.UserRepository;
import de.ait.repositories.UserRepositoryFileImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
    UserRepository repository;
    UserService service;
    final String EXIST_USER_EMAIL= "jack13@mail.com";
    final String NOT_EXIST_USER_EMAIL= "ann@mail.com";

    @BeforeEach
    void setUp() {
        repository = Mockito.mock(UserRepository.class);
        service = new UserServiceImpl(repository);

        Mockito.when(repository.findAll()).thenReturn(List.of(
                new User(1L, "jack1", "jack1@mail.com"),
                new User(2L, "jack2", "jack2@mail.com"),
                new User(3L, "jack3", "jack3@mail.com"),
                new User(4L, "jack4", "jac4k@mail.com")
                ));
Mockito.when(repository.findByEmail("jack3@mail.com")).thenReturn(new User(3L,"jack3","jack3@mail.com"));
        Mockito.when(repository.findByEmail("jack13@mail.com")).thenReturn(null);
    }
    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllUsers() {
        List<User> expected = List.of(
                new User(1L, "jack1", "jack1@mail.com"),
                new User(2L, "jack2", "jack2@mail.com"),
                new User(3L, "jack3", "jack3@mail.com"),
                new User(4L, "jack4", "jac4k@mail.com")
        );
        List<User> actual = service.getAllUsers();
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void checkIfUserExistTest(){
        Assertions.assertAll(
                ()->Assertions.assertTrue(service.checkIfUserExist(EXIST_USER_EMAIL)),
        ()->Assertions.assertTrue(service.checkIfUserExist(NOT_EXIST_USER_EMAIL)));

    }
    @Test
    void normale_create_user(){
        User user=new User("ann", NOT_EXIST_USER_EMAIL);
        service.createUser("ann", NOT_EXIST_USER_EMAIL);
        Mockito.verify(repository,Mockito.times(1)).save(user);

    }
}