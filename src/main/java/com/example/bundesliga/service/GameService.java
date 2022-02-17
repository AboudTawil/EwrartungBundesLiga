package com.example.bundesliga.service;

import com.example.bundesliga.model.Game;


import java.util.List;

public interface GameService {

    Game attach(Game game);

    List<Game> find();

    void remove(int id);

    Game update(Game game);

}
