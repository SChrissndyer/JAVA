package org.example.day81.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.example.day81.model.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Integer>  {
	Optional<UserEntity> findByEmail(String email);
	boolean existsByEmail(String email);
}
