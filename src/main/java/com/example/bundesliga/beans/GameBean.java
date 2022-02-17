package com.example.bundesliga.beans;

import com.example.bundesliga.model.Erwartung;
import com.example.bundesliga.model.Game;

import com.example.bundesliga.model.Team;
import com.example.bundesliga.mymethode.Helper;
import com.example.bundesliga.service.ErwartungServiceImpl;
import com.example.bundesliga.service.GameServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@ViewScoped
@Named
public class GameBean {

    private List<Game> gameList = new ArrayList<>();
    private List<Team> teamList = new ArrayList<>();
    @Autowired
    private ErwartungBean erwartungBean;



    @Autowired
    private GameServiceImpl service;
    @Autowired
    private ErwartungServiceImpl serviceErwartung;

    private Game currentGame = new Game();
    private Game deletedGame = new Game();
    private Team currentHhometeam = new Team();
    private Team currentHGastteam = new Team();

    @PostConstruct
    public void init(){
        System.out.println("init ... Create GameBean... ");
        setGameList(service.find());
        setTeamList(createTeamListe());
        System.out.println(teamList.toString());


    }


    public void onSave(){
        System.out.println("onSave ..Game...Go");
        System.out.println("*************************************************************");
        if ( !(currentHhometeam.getTeamName().equals("") || currentHGastteam.getTeamName().equals("")) )
        {
            currentHhometeam.setTeamNiveau(getNiveauByName(currentHhometeam.getTeamName()));
            currentHGastteam.setTeamNiveau(getNiveauByName(currentHGastteam.getTeamName())); //
            currentGame.setHome_team(currentHhometeam.getTeamName());
            currentGame.setGast_team(currentHGastteam.getTeamName());
            currentGame.setGoals_gast_team(-9);
            currentGame.setGoals_home_team(-9);
            currentGame.setFlag(100);
            currentGame.setGameover(0);
            currentGame.setPowerofgame(currentHhometeam.getTeamNiveau()+currentHGastteam.getTeamNiveau());
            currentGame.setMaxP(currentGame.getMaxPunkte(currentGame.getPowerofgame()));
            currentGame.setMittelP(currentGame.getMittlePunkte(currentGame.getPowerofgame()));
            service.attach( currentGame);
            setGameList(service.find());
            currentGame = new Game();
        }


    }



    public void onDelete() {
        service.remove(deletedGame.getId());
        setGameList(service.find());
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }

    public Game getCurrentGame() {
        return currentGame;
    }

    public void setCurrentGame(Game currentGame) {
        this.currentGame = currentGame;
    }

    public Game getDeletedGame() {
        return deletedGame;
    }

    public void setDeletedGame(Game deletedGame) {
        this.deletedGame = deletedGame;
    }


    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    public List<Team> createTeamListe(){
        List<Team> list = new ArrayList<>();
        list.add(new Team(1,"FC Bayern München",5));
        list.add(new Team(2,"Borussia Dortmund",5));
        list.add(new Team(3,"SC Freiburg",5));
        list.add(new Team(4,"Bayer 04 Leverkusen",5));
        list.add(new Team(5,"1. FC Union Berlin",2));
        list.add(new Team(6,"VfL Wolfsburg",5));
        list.add(new Team(7,"RB Leipzig",5));
        list.add(new Team(8,"Mainz 05",2));
        list.add(new Team(9,"BM gladbach",2));
        list.add(new Team(10,"Hoffenheim",2));
        list.add(new Team(11,"Eintracht Frankfurt",2));
        list.add(new Team(12,"FC Köln",2));
        list.add(new Team(13,"Bochum 1848",0));
        list.add(new Team(14,"Hertha BSC",0));
        list.add(new Team(15,"FC Augsburg",0));
        list.add(new Team(16,"VfB Stuttgart",0));
        list.add(new Team(17,"Arminia Bielefeld",0));
        list.add(new Team(18,"SpVgg Greuther Fürth",0));
        return list;
    }


    public Team getCurrentHhometeam() {
        return currentHhometeam;
    }

    public void setCurrentHhometeam(Team currentHhometeam) {
        this.currentHhometeam = currentHhometeam;
    }

    public Team getCurrentHGastteam() {
        return currentHGastteam;
    }

    public void setCurrentHGastteam(Team currentHGastteam) {
        this.currentHGastteam = currentHGastteam;
    }

    public int getNiveauByName(String nameTeam){
        for (Team team:teamList){
            if(team.getTeamName().equals(nameTeam))
                return team.getTeamNiveau();
        }
       return 0;
    }
    public void test(int id){
        System.out.println("TEST *******");
        System.out.println(id);
        ErwartungBean.setSelectedGameID(5);
        System.out.println(currentGame);

    }
   public void configCurrrentGameToUpdate(int id){
       System.out.println("Game id to update" + id);
       currentGame.setId(id);
       Game g = Helper.getGameById(id,getGameList());

       currentGame.setHome_team(g.getHome_team());
       currentGame.setTag(g.getTag());
       currentGame.setPowerofgame(g.getPowerofgame());
       currentGame.setMaxP(g.getMaxP());
       currentGame.setGast_team(g.getGast_team());
       currentGame.setMittelP(g.getMittelP());


//       currentGame.setHome_team(gameList.get(id-1).getHome_team());
//       currentGame.setTag(gameList.get(id-1).getTag());
//       currentGame.setPowerofgame(gameList.get(id-1).getPowerofgame());
//       currentGame.setMaxP(gameList.get(id-1).getMaxP());
//       currentGame.setGast_team(gameList.get(id-1).getGast_team());
//       currentGame.setMittelP(gameList.get(id-1).getMittelP());

       currentGame.setGameover(5);

   }


    public void onGameOver(){
        System.out.println("**************   ON GAME OVER");
        List<Erwartung> erwartungList = new ArrayList<>();
        erwartungList.addAll(serviceErwartung.find());

        for (Erwartung erwartung:erwartungList
             ) {
            if( erwartung.getId_game() == currentGame.getId()) {
                erwartung.setPunkte(-5);
                erwartungBean.refresh();
            }
        }
        currentGame.setFlag(currentGame.getGoals_home_team()-currentGame.getGoals_gast_team());
        service.update( currentGame);
        currentGame = new Game();
        setGameList(service.find());
    }
}
