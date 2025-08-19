package com.cafe24.server.repository;

import com.cafe24.server.domain.user.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, String> {
}