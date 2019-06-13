package com.vivekvishwanath.zoos.repo;

import com.vivekvishwanath.zoos.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}
