package com.tinlee.app.rest.Repo;

import com.tinlee.app.rest.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository <User,Long> {
}
