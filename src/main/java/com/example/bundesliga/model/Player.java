package com.example.bundesliga.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// Autoincrent
    private int id;

    private String player_name;
    private int points;



    public Player() {

    }

    public Player(String player_name) {
        this.player_name = player_name;
        this.points = 0;
    }
    public Player(String player_name, int points) {
        this.player_name = player_name;
        this.points = points;
    }

    public void addPoints(int points){
        this.points +=points;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", player_name='" + player_name + '\'' +
                ", points=" + points +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return id == player.id && points == player.points && Objects.equals(player_name, player.player_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, player_name, points);
    }
}
