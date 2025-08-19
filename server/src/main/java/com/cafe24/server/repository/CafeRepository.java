package com.cafe24.server.repository;

import com.cafe24.server.domain.user.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeRepository extends JpaRepository<Cafe, String> {
}