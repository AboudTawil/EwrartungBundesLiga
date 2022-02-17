package com.example.bundesliga.beans;

import com.example.bundesliga.model.Erwartung;

import com.example.bundesliga.model.Game;

import com.example.bundesliga.model.Player;
import com.example.bundesliga.mymethode.Helper;
import com.example.bundesliga.service.ErwartungServiceImpl;

import com.example.bundesliga.service.GameServiceImpl;

import com.example.bundesliga.service.PlayerServiceImpl;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;


@ViewScoped
@Named
public class ErwartungBean {

    private List<Erwartung> erwartungList = new ArrayList<>();
    private List<Game> gameList = new ArrayList<>();

    @Autowired
    private ErwartungServiceImpl service;
    private Erwartung currentErwartung = new Erwartung();
    private Erwartung deleteErwartung = new Erwartung();
    @Autowired
    GameServiceImpl serviceGame;

    @Autowired
    private PlayerBean playerBean;

    @Autowired
    PlayerServiceImpl servicePlayer;


    private static int selectedGameID;

    public static int getSelectedGameID() {
        return selectedGameID;
    }

    public static void setSelectedGameID(int selectedGameID) {
        ErwartungBean.selectedGameID = selectedGameID;
    }

    @PostConstruct  // nach dem Konstruktor aufgerufen
    public void init() {
        System.out.println("init-->> Erwartung....GO");
        setErwartungList(service.find());
    }


    public void onSave() {
        System.out.println("**************************************************");
        System.out.println("onSave ...Erwartungen");

        service.attach(currentErwartung);
        setErwartungList(service.find());
        currentErwartung = new Erwartung();
    }


    public void onDelete() {
        service.remove(deleteErwartung.getId());
        setErwartungList(service.find());
    }


    public void onRowEdit(RowEditEvent<Erwartung> event) {
        Erwartung t = event.getObject();
        Erwartung updatedErwartung = service.update(t);
        System.out.println(" UPDATE .." + updatedErwartung);
        setErwartungList(service.find());

    }


    public List<Erwartung> getErwartungList() {
        return erwartungList;
    }

    public void setErwartungList(List<Erwartung> erwartungList) {
        this.erwartungList = erwartungList;
    }

    public Erwartung getCurrentErwartung() {
        return currentErwartung;
    }

    public void setCurrentErwartung(Erwartung currentErwartung) {
        this.currentErwartung = currentErwartung;
    }

    public Erwartung getDeleteErwartung() {
        return deleteErwartung;
    }

    public void setDeleteErwartung(Erwartung deleteErwartung) {
        this.deleteErwartung = deleteErwartung;
    }


    public void configCurrrentErwartungToSave(int gameId) {
        List<Game> list = new ArrayList<>();
        list.addAll(serviceGame.find());
        currentErwartung.setId_game(gameId);
        Game g = Helper.getGameById(gameId, list);

        currentErwartung.setHome_team(g.getHome_team());
        currentErwartung.setGast_team(g.getGast_team());
        currentErwartung.setPowerofgame(g.getPowerofgame());

//        currentErwartung.setHome_team(list.get(gameId-1).getHome_team());
//        currentErwartung.setGast_team(list.get(gameId-1).getGast_team());
//        currentErwartung.setPowerofgame(list.get(gameId-1).getPowerofgame());
        currentErwartung.setPunkte(-1);
    }

    public void refresh() {
        setErwartungList(service.find());

    }

    public void rechnen(Erwartung er) {

        System.out.println("**************START Rcchnen **************");
        List<Game> list = new ArrayList<>();
        list.addAll(serviceGame.find());
        int y = 0;
        int x = Helper.winPoints(er, list);
        if (x > 0) y = Helper.getFinalPoints(er, list);
        er.setPunkte(y);
        currentErwartung = er;
        onSave();
        List<Player> listPlayer = new ArrayList<>();
        listPlayer.addAll(servicePlayer.find());
        Player player = Helper.addPunkteToPlayer(er.getId_player(), listPlayer);
        player.addPoints(y);
        servicePlayer.attach(player);
        playerBean.refresh();
    }
}
