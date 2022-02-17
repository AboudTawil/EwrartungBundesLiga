package com.example.bundesliga.service;

import com.example.bundesliga.dao.GameDAO;


import com.example.bundesliga.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class GameServiceImpl implements GameService{

    @Autowired
    private GameDAO dao;


    @Override
    public Game attach(Game game) {
        return dao.save(game);
    }

    @Override
    public List<Game> find() {
        List<Game> tmpList =dao.findAll();
        Collections.reverse(tmpList);
        return tmpList;
    }



    @Override
    public void remove(int id) {
        dao.deleteById(id);

    }

    @Override
    public Game update(Game game) {
        return dao.save(game);
    }
}
