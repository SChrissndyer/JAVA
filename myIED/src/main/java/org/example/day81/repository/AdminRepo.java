package org.example.day81.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.example.day81.model.AdminEntity;

public interface AdminRepo extends JpaRepository<AdminEntity, Integer> {
	Optional<AdminEntity> findByUsername(String username);
	Boolean existsByUsername(String username);
}
