package com.vulpes.velox.repositories;

import com.vulpes.velox.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
  User getByEmail(String email);
  User getById(Long id);
  List<User> findAll();
  @Transactional
  void deleteUserById(Long id);
}

