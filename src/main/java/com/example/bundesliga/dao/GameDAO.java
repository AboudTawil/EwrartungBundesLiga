package com.example.bundesliga.dao;

import com.example.bundesliga.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameDAO extends JpaRepository <Game, Integer>{
}
