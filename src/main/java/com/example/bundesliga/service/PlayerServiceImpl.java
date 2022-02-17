package com.example.bundesliga.service;

import com.example.bundesliga.dao.PlayerDAO;

import com.example.bundesliga.model.Player;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService{

    @Autowired
    private PlayerDAO dao;

    @Override
    public Player attach(Player player) {
        return dao.save(player);
    }


    @Override
    public List<Player> find() {

        return dao.findAll();
    }


    @Override
    public void remove(int id) {
    dao.deleteById(id);
    }
}
