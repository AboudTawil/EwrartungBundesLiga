package com.example.bundesliga.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "erwartung")
public class Erwartung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// Autoincrent
    private int id;
    private int id_game;
    private int id_player;
    private int goals_home_team;
    private int goals_gast_team;
    private int punkte;
    private int powerofgame;
    private String home_team;
    private String gast_team;




    public Erwartung() {

    }

    public Erwartung( int id_player, int goals_home_team, int goals_gast_team,  int powerofgame) {

        this.id_player = id_player;
        this.goals_home_team = goals_home_team;
        this.goals_gast_team = goals_gast_team;
        this.punkte = 0;
        this.powerofgame = powerofgame;
    }


    public Erwartung( int id_player, int goals_home_team, int goals_gast_team) {
        this.id_player = id_player;
        this.goals_home_team = goals_home_team;
        this.goals_gast_team = goals_gast_team;
        this.punkte = 0;
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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_game() {
        return id_game;
    }

    public void setId_game(int id_game) {
        this.id_game = id_game;
    }

    public int getId_player() {
        return id_player;
    }

    public void setId_player(int id_player) {
        this.id_player = id_player;
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

    public int getPunkte() {
        return punkte;
    }

    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }

    public int getPowerofgame() {
        return powerofgame;
    }

    public void setPowerofgame(int powerofgame) {
        this.powerofgame = powerofgame;
    }



    @Override
    public String toString() {
        return "Erwartung{" +
                "id=" + id +
                ", id_game=" + id_game +
                ", id_player=" + id_player +
                ", goals_home_team=" + goals_home_team +
                ", goals_gast_team=" + goals_gast_team +
                ", punkte=" + punkte +
                ", powerofgame=" + powerofgame +
                ", home_team='" + home_team + '\'' +
                ", gast_team='" + gast_team + '\'' +
                               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Erwartung)) return false;
        Erwartung erwartung = (Erwartung) o;
        return id == erwartung.id && id_game == erwartung.id_game && id_player == erwartung.id_player && goals_home_team == erwartung.goals_home_team && goals_gast_team == erwartung.goals_gast_team && punkte == erwartung.punkte && powerofgame == erwartung.powerofgame && Objects.equals(home_team, erwartung.home_team) && Objects.equals(gast_team, erwartung.gast_team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, id_game, id_player, goals_home_team, goals_gast_team, punkte, powerofgame, home_team, gast_team);
    }
}
