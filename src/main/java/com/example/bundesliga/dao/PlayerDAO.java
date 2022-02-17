package com.example.bundesliga.dao;

import com.example.bundesliga.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerDAO extends JpaRepository<Player, Integer> {

}
