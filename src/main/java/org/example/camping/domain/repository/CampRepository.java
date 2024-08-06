package org.example.camping.domain.repository;

import org.example.camping.domain.entity.Camp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampRepository extends JpaRepository<Camp, Long> {
}
