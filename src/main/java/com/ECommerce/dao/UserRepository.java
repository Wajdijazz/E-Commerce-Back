package com.ECommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ECommerce.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{


}
