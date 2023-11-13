//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package de.ait.repositories;

import de.ait.model.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserRepositoryFileImplTest {



    private UserRepository userRepository;
    private String testFileName = "testfile.txt";

    @BeforeEach
    public void setUp() {
        userRepository = new UserRepositoryFileImpl(testFileName);
    }

    @Test
    public void testSaveUser() throws Exception {
        User userToSave = new User(1L,"John Doe", "john@example.com");
        userRepository.save(userToSave);

        // Считываем данные из файла и проверяем их
        try (BufferedReader reader = new BufferedReader(new FileReader(testFileName))) {
            String line = reader.readLine();
            String[] data = line.split(";");
            assertEquals(userToSave.getId().toString(), data[0]);
            assertEquals(userToSave.getName(), data[1]);
            assertEquals(userToSave.getEmail(), data[2]);
        }
    }

    @Test
    public void testSaveUsers() throws Exception {
        User user1 = new User(1L,"John Doe", "john@example.com");
        User user2 = new User(2L,"Jane Smith", "jane@example.com");

        userRepository.save(user1);
        userRepository.save(user2);

        // Считываем данные из файла и проверяем их
        try (BufferedReader reader = new BufferedReader(new FileReader(testFileName))) {
            String line1 = reader.readLine();
            String line2 = reader.readLine();

            String[] data1 = line1.split(";");
            String[] data2 = line2.split(";");

            assertEquals(user1.getId().toString(), data1[0]);
            assertEquals(user1.getName(), data1[1]);
            assertEquals(user1.getEmail(), data1[2]);

            assertEquals(user2.getId().toString(), data2[0]);
            assertEquals(user2.getName(), data2[1]);
            assertEquals(user2.getEmail(), data2[2]);
        }
    }

    @AfterEach
    public void tearDown() {
        // Удалить временный файл после выполнения теста
        File file = new File(testFileName);
        if (file.exists()) {
            file.delete();
        }
    }
}