package edu.ucdenver.tournament;

import javax.imageio.IIOException;
import javax.sound.sampled.Line;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Match {
    private LocalDateTime dateTime;
    private int scoreTeamA;
    private int scoreTeamB;
    LineUp lineupA;
    LineUp lineupB;
    Team teamA;
    Team teamB;
    private ArrayList<Referee> listReferees; // TODO CHECK TO MAKE SURE THIS IS NEEDED for get refs list

    public Match(LocalDateTime dateTime, Team teamA, Team teamB){
        this.dateTime=dateTime;
        this.teamA = teamA;
        this.teamB = teamB;
        lineupA = new LineUp(teamA);
        lineupB = new LineUp(teamB);
        this.listReferees = new ArrayList<>(); // TODO CHECK TO MAKE SURE THIS IS NEEDED for get refs list

    }
    public LineUp getTeamA(){return lineupA;}
    public LineUp getTeamB(){return lineupB;}


    public LocalDateTime getDateTime(){return dateTime;}
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
        // TODO: test check for 11 players
        LineUp l = new LineUp(team);
        // check if team A
        if(l.getTeam() == this.teamA && lineupA.getPlayers().size() < 11){lineupA.addPlayer(player);}
        // Check if team B
        else if(l.getTeam() == this.teamB && lineupB.getPlayers().size() < 11){lineupB.addPlayer(player);}
        else{throw new IllegalArgumentException("Player is already on team");}
    }
    public List<Referee> getReferees(){return new ArrayList<>(listReferees);}
    public void addReferee(Referee referee){
        // Match referee requirement -> only four in a match
        // Referee cannot share team's country
        // TODO: TEST
        if(getReferees().size() == 4){
            throw new IllegalArgumentException("There are already 4 referees assigned to this match");
        }else if(referee.getCountry() == teamA.getCountry() || referee.getCountry() == teamB.getCountry()){
            throw new IllegalArgumentException("Referee cannot share a country as a team in the match");
        }else{this.listReferees.add(referee);} // Add referee to match referee list
    }
    public void setMatchScore(int  scoreTeamA, int scoreTeamB){
        this.scoreTeamA = scoreTeamA;
        this.scoreTeamB = scoreTeamB;
    }
}
