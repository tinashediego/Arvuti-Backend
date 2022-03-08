package com.tinlee.app.rest.Repo;

import com.tinlee.app.rest.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Long> {
}
