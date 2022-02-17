package com.example.bundesliga.mymethode;


import com.example.bundesliga.model.Erwartung;
import com.example.bundesliga.model.Game;
import com.example.bundesliga.model.Player;

import com.example.bundesliga.service.ErwartungServiceImpl;

import com.example.bundesliga.service.PlayerServiceImpl;
import org.primefaces.component.gmap.GMap;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@ViewScoped
@Named
public class Helper {


    private static List<Erwartung> erwartungList = new ArrayList<>();
    private static List<Player> playerList = new ArrayList<>();


    @Autowired
    private ErwartungServiceImpl serviceErwartung;
    @Autowired
    private PlayerServiceImpl servicePlayer;

    public Helper() {

    }

    public static List<Erwartung> getErwartungList() {
        return erwartungList;
    }
    @PostConstruct
    public void init(){

    }


    public static void setErwartungList(List<Erwartung> erwartungList) {
        Helper.erwartungList = erwartungList;
    }



    public static Player addPunkteToPlayer(int id,List<Player> playerList ){
        int res =0;
        for (Player player:playerList
             ) {if (player.getId() == id) {
            return player;
        }

        }
        return null;
    }

    public  static int  winPoints(Erwartung erw,List<Game> gameList){
        System.out.println("************ inside Winpoint");
        int idgame=erw.getId_game();
        Game g =new Game();
        g = getGameById(idgame,gameList);

        int flagGame = g.getFlag();
        int flagErwartung = erw.getGoals_home_team()-erw.getGoals_gast_team();
//
//             int flagGame = gameList.get(idgame-1).getFlag();
//            int flagErwartung = erw.getGoals_home_team()-erw.getGoals_gast_team();
            if((flagErwartung > 0 && flagGame > 0) || (flagErwartung == 0 && flagGame == 0) ||
           (flagErwartung < 0 && flagGame < 0) ) return  +5;

        return 0;
    }

    public static List<Player> sortByPoints(List<Player> list){


        for (int i=0 ; i< list.size()-1;i++){

            for (int j=i+1 ; j < list.size();j++){

                Player tmpPlayer = new Player();
                if(list.get(i).getPoints() < list.get(j).getPoints() )
                {
                tmpPlayer.setPoints(list.get(i).getPoints());
                tmpPlayer.setId(list.get(i).getId());
                tmpPlayer.setPlayer_name(list.get(i).getPlayer_name());


                list.get(i).setPoints(list.get(j).getPoints());
                list.get(i).setId(list.get(j).getId());
                list.get(i).setPlayer_name(list.get(j).getPlayer_name());

                list.get(j).setPoints(tmpPlayer.getPoints());
                list.get(j).setId(tmpPlayer.getId());
                list.get(j).setPlayer_name(tmpPlayer.getPlayer_name());
                }

            }

        }
        return  list;

    }

    public static int getFinalPoints(Erwartung erwartung,List<Game> gameList){
        int res=0;
       // int gameid =erwartung.getId_game()-1;

        Game game =getGameById(erwartung.getId_game(),gameList);
        System.out.println(" Game Id :" +game.getId());

        int gHome =game.getGoals_home_team();
        int gHast =game.getGoals_gast_team();

        System.out.println(gHome);
        System.out.println(erwartung.getGoals_home_team());

        System.out.println(gHast);
        System.out.println(erwartung.getGoals_gast_team());

        if(gHome == erwartung.getGoals_home_team() &&
                gHast == erwartung.getGoals_gast_team()
            )
        {res= game.getMaxP();}
        else {        res=  game.getMittelP();}
        return res;
    }

    public static Game getGameById(int id, List<Game> gameList){
        Game g=new Game();

        for (Game game:gameList
             ) {
            if (game.getId()==id) g=game;

        }
                return g;
    }



    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }
}
