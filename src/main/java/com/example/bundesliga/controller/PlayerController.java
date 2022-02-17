package com.example.bundesliga.controller;

import com.example.bundesliga.model.Player;
import com.example.bundesliga.service.PlayerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerServiceImpl service;


    @RequestMapping
    public List<Player> getAllPlayers(){
        return service.find();
    }


}
