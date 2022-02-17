package com.example.bundesliga.dao;

import com.example.bundesliga.model.Erwartung;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ErwartungDAO extends JpaRepository<Erwartung, Integer> {
}
