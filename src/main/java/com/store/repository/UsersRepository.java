package com.store.repository;

import com.store.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<UserModel,Long> {
    Optional<UserModel> findByLogin(String login);
}
