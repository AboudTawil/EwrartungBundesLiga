package com.example.bundesliga.model;


import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// Autoincrent
    private int id;
    private String home_team;
    private String gast_team;
    private int goals_home_team;
    private int goals_gast_team;
    private int flag;
    private int gameover;
    private int tag;
    private int powerofgame;
    private int maxP;
    private int mittelP;


    public Game() {
    }

    public Game(String home_team, String gast_team) {
        this.home_team = home_team;
        this.gast_team = gast_team;
        this.goals_home_team = -9; // -9 for new game ,nicht berichnet
        this.goals_gast_team = -9;
        this.flag = 100; //100  -->> for new game ,nicht berichnet
        this.gameover = 0; // 0nicht fertig ,5 fertig
        this.tag = 0;
        this.powerofgame = -1;
        this.maxP = getMaxPunkte(powerofgame);
        this.mittelP = getMittlePunkte(powerofgame);
    }



    public int getId() {
        return id;
    }

    public String getHome_team() {
        return home_team;
    }

    public void setHome_team(String home_team) {
        this.home_team = home_team;
    }

    public String getGast_team() {
        return gast_team;
    }

    public void setGast_team(String gast_team) {
        this.gast_team = gast_team;
    }

    public int getGoals_home_team() {
        return goals_home_team;
    }

    public void setGoals_home_team(int goals_home_team) {
        this.goals_home_team = goals_home_team;
    }

    public int getGoals_gast_team() {
        return goals_gast_team;
    }

    public void setGoals_gast_team(int goals_gast_team) {
        this.goals_gast_team = goals_gast_team;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getGameover() {
        return gameover;
    }

    public void setGameover(int gameover) {
        this.gameover = gameover;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public int getPowerofgame() {
        return powerofgame;
    }

    public void setPowerofgame(int powerofgame) {
        this.powerofgame = powerofgame;
    }

    public int getMaxP() {
        return maxP;
    }

    public void setMaxP(int maxP) {
        this.maxP = maxP;
    }

    public int getMittelP() {
        return mittelP;
    }

    public void setMittelP(int mittelP) {
        this.mittelP = mittelP;
    }


    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", home_team='" + home_team + '\'' +
                ", gast_team='" + gast_team + '\'' +
                ", goals_home_team=" + goals_home_team +
                ", goals_gast_team=" + goals_gast_team +
                ", flag=" + flag +
                ", gameover=" + gameover +
                ", tag=" + tag +
                ", powerofgame=" + powerofgame +
                ", maxP=" + maxP +
                ", mittelP=" + mittelP +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;
        Game game = (Game) o;
        return id == game.id && goals_home_team == game.goals_home_team && goals_gast_team == game.goals_gast_team && flag == game.flag && gameover == game.gameover && tag == game.tag && powerofgame == game.powerofgame && maxP == game.maxP && mittelP == game.mittelP && Objects.equals(home_team, game.home_team) && Objects.equals(gast_team, game.gast_team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, home_team, gast_team, goals_home_team, goals_gast_team, flag, gameover, tag, powerofgame, maxP, mittelP);
    }


    public int getMaxPunkte(int powerOgGame){
        int mPunkte=0;
        switch (powerOgGame){
            case 10: mPunkte = 10;
                break;
            case 7 : mPunkte = 7;
                break;
            case 4 : mPunkte  =4;
                break;
            case 2: mPunkte = 2;
                break;
            case 0 :mPunkte =1;
                break;

        }
        return mPunkte;

    }

    public int getMittlePunkte(int powerOgGame){
        int mPunkte=0;
        switch (powerOgGame){
            case 10: mPunkte = 5;
                break;
            case 7 : mPunkte = 4;
                break;
            case 4 : mPunkte  =3;
                break;
            case 2: mPunkte = 2;
                break;
            case 0 :mPunkte =1;
                break;
        }
        return mPunkte;

    }

}
