package com.springboot.webapp.repository;

import com.springboot.webapp.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    @Query("SELECT user from UserModel user where user.id > :id")
    List<UserModel> findAllMoreThan(@Param("id") Long id);

    List<UserModel> findByIdGreaterThan(@Param("id") Long id);

    List<UserModel> findByNomeIgnoreCase(@Param("nome") String nome);

}
