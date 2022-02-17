package com.example.bundesliga.service;

import com.example.bundesliga.model.Player;


import java.util.List;

public interface PlayerService {
    Player attach(Player player);

    List<Player> find();

    void remove(int id);
}
