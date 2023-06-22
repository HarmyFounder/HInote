package com.HarmyIndustries.HInote.repository;

import com.HarmyIndustries.HInote.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepo extends JpaRepository<User, String> {



}
