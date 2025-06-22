package com.example.recipe.app.aa03.service;

import com.example.recipe.common.service.BaseService;
import com.example.recipe.domain.recipe.dao.UserDao;
import com.example.recipe.domain.recipe.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CsvService extends BaseService {
    private final UserDao userDao;

    public void processCsv(MultipartFile file) throws Exception {
        List<User> users = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {

            String line;
            boolean isFirst = true;
            while ((line = reader.readLine()) != null) {
                if (isFirst) {
                    isFirst = false;
                    continue;
                } // Skip header

                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    User user = new User();
                    user.setName(parts[0]);
                    user.setEmail(parts[1]);
                    user.setPassword(parts[2]);
                    users.add(user);
                }
            }
        }

        userDao.batchInsert(users);
    }
}
