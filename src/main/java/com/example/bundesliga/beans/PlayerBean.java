package com.example.bundesliga.beans;

import com.example.bundesliga.model.Player;

import com.example.bundesliga.service.PlayerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@ViewScoped
@Named
public class PlayerBean {
    private List<Player> playrsList = new ArrayList<>();

    @Autowired
    private PlayerServiceImpl service;

    @Override
    public String toString() {
        return "PlayerBean{" +
                "currentPlayer=" + currentPlayer +
                '}';
    }

    private Player currentPlayer = new Player(); // To Save new Player
    private Player deletedPlayer = new Player();  // Player To delete
    @PostConstruct
    public void init(){
        System.out.println("init ... Create PlayerBean... ");
        setPlayrsList(service.find());


    }


    public void setPlayrsList(List<Player> playrsList) {
        this.playrsList = playrsList;
    }

    public List<Player> getPlayrsList() {
        return playrsList;
    }

    //Player Rückmeldung
    public void onSave(){
        System.out.println("onSave Aus Bean");
        if (currentPlayer.getPlayer_name() != ""){
            service.attach( currentPlayer);
            setPlayrsList(service.find());
            currentPlayer =new Player();
        }

    }
    public void refresh(){
        setPlayrsList(service.find());

    }
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Player getDeletePlayer() {
        return deletedPlayer;
    }

    public void setDeletePlayer(Player delPlayer) {
        this.deletedPlayer = delPlayer;
    }

    public void onDelete() {
        service.remove(deletedPlayer.getId());
        setPlayrsList(service.find());
    }
    public String getSpilerNameByID(int id){

        for (Player player:playrsList) {
            if(player.getId() ==id) return player.getPlayer_name();
        }

        return "";

    }

}
