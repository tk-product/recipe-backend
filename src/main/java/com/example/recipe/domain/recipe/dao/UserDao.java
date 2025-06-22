package com.example.recipe.domain.recipe.dao;

import com.example.recipe.domain.recipe.entity.User;
import org.seasar.doma.BatchInsert;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@Dao
@ConfigAutowireable
public interface UserDao {
    @Insert
    int insert(User user);

    @BatchInsert
    int[] batchInsert(List<User> users);
}

