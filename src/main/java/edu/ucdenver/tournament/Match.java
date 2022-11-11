package edu.ucdenver.tournament;

import javax.imageio.IIOException;
import javax.sound.sampled.Line;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Match implements Serializable {
    private final LocalDateTime dateTime;
    private int scoreTeamA;
    private int scoreTeamB;
    LineUp lineupA;
    LineUp lineupB;
    Team teamA;
    Team teamB;
    private final ArrayList<Referee> listReferees;

    public Match(LocalDateTime dateTime, Team teamA, Team teamB){
        this.dateTime=dateTime;
        this.teamA = teamA;
        this.teamB = teamB;
        lineupA = new LineUp(teamA);
        lineupB = new LineUp(teamB);
        this.listReferees = new ArrayList<>();

    }
    public LineUp getTeamA(){return lineupA;}
    public LineUp getTeamB(){return lineupB;}


    public LocalDateTime getDateTime(){return this.dateTime;}
    public boolean isUpcoming(){
        // First one will aso check if the match is currently happening
        // Second check is just if the match is in the future
   //     return dateTime.isEqual(LocalDateTime.now()) || dateTime.isAfter(LocalDateTime.now());
        return dateTime.isAfter(LocalDateTime.now());
    }
    public void addPlayer(Player player, Team team){
        // team -> Lineup team
        // player -> player to add
        // check which team to add to
        // check if player is on team with LineUp listOfPlayers list
        // add if not
        // throw exception if player is in it

        // Check if team is team A
        if(Objects.equals(team.getName(), this.teamA.getName())){
            // Check lineup size for < 11
            if(lineupA.getPlayers() != null) {
                // Check for player already on lineup
                if(lineupA.getPlayers().size() < 11){
                    for(Player p: lineupA.getPlayers()){
                        if(Objects.equals(p.getName(), player.getName())){
                            throw new IllegalArgumentException("Player is already in match");
                        }
                    }
                    lineupA.addPlayer(player);
                }// Else, exception for more than 11
                else throw new IllegalArgumentException("Cannot have more than 11 players");
            } else {
                // If player is not on lineup, add them
                lineupA.addPlayer(player);
            }
            // repeat for lineup B
        } else if(Objects.equals(team.getName(), this.teamB.getName())){
            // Check lineup size for < 11
            if(lineupB.getPlayers() != null) {
                // Check for player already on lineup
                if(lineupB.getPlayers().size() < 11){
                    for(Player p: lineupB.getPlayers()){
                        if(Objects.equals(p.getName(), player.getName())){
                            throw new IllegalArgumentException("Player is already in match");
                        }
                    }
                    lineupB.addPlayer(player);
                }// Else, exception for more than 11
                else throw new IllegalArgumentException("Cannot have more than 11 players");
            } else {
                // If player is not on lineup, add them
                lineupB.addPlayer(player);
            }

        } else throw new IllegalArgumentException("Could not find team"); // If neither work, couldn't find team

    }
    public LocalDate getDate(){
        return this.getDateTime().toLocalDate();
    }
    public List<Referee> getReferees(){
        if(listReferees.isEmpty()) return null;
        else return new ArrayList<>(this.listReferees);

    }
    public void addReferee(Referee referee){
        // Match referee requirement -> only four in a match
        // Referee cannot share team's country
        // TODO: TEST
        if(listReferees.size() == 4){
            throw new IllegalArgumentException("There are already 4 referees assigned to this match");
        }else if(referee.getCountry() == teamA.getCountry() || referee.getCountry() == teamB.getCountry()){
            throw new IllegalArgumentException("Referee cannot share a country as a team in the match");
        }else{this.listReferees.add(referee);} // Add referee to match referee list
    }
    public void setMatchScore(int  scoreTeamA, int scoreTeamB){
        this.scoreTeamA = scoreTeamA;
        this.scoreTeamB = scoreTeamB;
    }
    public int getScoreTeamA(){return this.scoreTeamA;}
    public int getScoreTeamB(){return this.scoreTeamB;}
}
