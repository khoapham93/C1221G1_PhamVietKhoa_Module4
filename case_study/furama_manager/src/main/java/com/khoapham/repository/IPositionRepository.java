package com.khoapham.repository;

import com.khoapham.models.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepository extends JpaRepository<Position, Integer> {

}
