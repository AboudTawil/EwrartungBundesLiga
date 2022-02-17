package com.example.bundesliga.model;

import java.util.Objects;

public class Team {
    private int id;
    private String teamName;
    private int teamNiveau;

    public Team(int id, String teamName, int teamNiveau) {
        this.id = id;
        this.teamName = teamName;
        this.teamNiveau = teamNiveau;
    }

    public Team() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTeamNiveau() {
        return teamNiveau;
    }

    public void setTeamNiveau(int teamNiveau) {
        this.teamNiveau = teamNiveau;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", teamName='" + teamName + '\'' +
                ", teamNiveau=" + teamNiveau +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Team)) return false;
        Team team = (Team) o;
        return id == team.id && teamNiveau == team.teamNiveau && Objects.equals(teamName, team.teamName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teamName, teamNiveau);
    }
}
