package com.educon.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.educon.entity.Parent;

public interface ParentRepo extends JpaRepository<Parent, Integer> {
}
