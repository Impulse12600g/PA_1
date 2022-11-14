package edu.ucdenver.tournament;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * Match class
 * </p>
 */
public class Match implements Serializable {

    /**
     * <p>
     * dateTime variable for holding the date, and the time of a match
     * </p>
     */
    private final LocalDateTime dateTime;

    /**
     * <p>
     * scoreTeamA variable to hold the score value of the first team
     * </p>
     */
    private int scoreTeamA;

    /**
     * <p>
     * scoreTeamB variable to hold the score value of the second team
     * </p>
     */
    private int scoreTeamB;

    /**
     * <p>
     * lineupA object to represent the first lineup of players in the match (tied to team A)
     * </p>
     */
    LineUp lineupA;

    /**
     * <p>
     * lineupB object to represent the second lineup of players in the match (tied to team B)
     * </p>
     */
    LineUp lineupB;

    /**
     * <p>
     * teamA object of class Team to represent the first team in the match
     * </p>
     */
    Team teamA;

    /**
     * <p>
     * teamB object of class Team to represent the second team in the match
     * </p>
     */
    Team teamB;

    /**
     * <p>
     * listReferees array list built of Referees that are assigned to the match
     * </p>
     */
    private final ArrayList<Referee> listReferees;

    /**
     * <p>
     * Match constructor used to build the Match object on a particular date and time, with two teams.
     * </p>
     * @param dateTime representing the date and time a match will take place
     * @param teamA representing the first team in the match
     * @param teamB representing the second team in the match
     */
    public Match(LocalDateTime dateTime, Team teamA, Team teamB){
        this.dateTime=dateTime;
        this.teamA = teamA;
        this.teamB = teamB;
        lineupA = new LineUp(teamA);
        lineupB = new LineUp(teamB);
        this.listReferees = new ArrayList<>();

    }

    /**
     * <p>
     * getTeamA getter method to retrieve the lineup of players on lineupA
     * </p>
     * @return lineupA representing the array list of players on lineupA
     */
    public LineUp getTeamA(){return lineupA;}

    /**
     * <p>
     * getTeamB getter method to retrieve the lineup of players on lineupB
     * </p>
     * @return lineupB representing the array list of players on lineupB
     */
    public LineUp getTeamB(){return lineupB;}

    /**
     * <p>
     * getDateTime getter method to retrieve the date and time assigned to a match
     * </p>
     * @return this.dateTime holds the date and time of a match object
     */
    public LocalDateTime getDateTime(){return this.dateTime;}

    /**
     * <p>
     * isUpcoming method that will use the dateTime variable and LocalDateTime to check if the match is after
     * the current time or not. Will return true or false.
     * </p>
     * @return True or False
     */
    public boolean isUpcoming(){
        // First one will aso check if the match is currently happening
        // Second check is just if the match is in the future
   //     return dateTime.isEqual(LocalDateTime.now()) || dateTime.isAfter(LocalDateTime.now());
        return dateTime.isAfter(LocalDateTime.now());
    }

    /**
     * <p>
     * addPlayer method to add a player to a lineup of the first or second team.
     * The method will first check if we are assigning to team A or team B.
     * Then once we find the team, we get the lineup or players on the team.
     * If the lineup is empty, we assign the player to the lineup.
     * If the lineup is not empty, we check if the player is already on the lineup, and
     * assign the player to the lineup if they are not already on it.
     * </p>
     * @param player object that will be assigned to the lineup
     * @param team object that is used to find which lineup we are assigning the player to
     */
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

    /**
     * <p>
     * getDate getter method to retrieve the date out of a match dateTime variable.
     * This was implemented for methods that are checking for just the date, and not the time of a match.
     * </p>
     * @return toLocalDate of match dateTime -> month and day of match
     */
    public LocalDate getDate(){
        return this.getDateTime().toLocalDate();
    }

    /**
     * <p>
     * getReferees getter method for retrieving the referees assigned to the match
     * </p>
     * @return null if the arrayList of match referees is empty, and returns the list of referees if it is not empty.
     */
    public List<Referee> getReferees(){
        if(listReferees.isEmpty()) return null;
        else return new ArrayList<>(this.listReferees);
    }

    /**
     * <p>
     * addReferee method that will add a referee to the match object.
     * We first check if there are already four referees assigned to the match and throw an exception
     * if there are. If not, we make sure that the referee is representing a different country than the two teams.
     * If the referee passes the checks, we assign the referee object to the match.
     * </p>
     * @param referee object of class Referee to be added to a match
     */
    public void addReferee(Referee referee){
        // Match referee requirement -> only four in a match
        // Referee cannot share team's country
        if(listReferees.size() == 4){
            throw new IllegalArgumentException("There are already 4 referees assigned to this match");
        }else if(referee.getCountry() == teamA.getCountry() || referee.getCountry() == teamB.getCountry()){
            throw new IllegalArgumentException("Referee cannot share a country as a team in the match");
        }else{this.listReferees.add(referee);} // Add referee to match referee list
    }

    /**
     * <p>
     * setMatchScore method to assign a score to the two teams.
     * This method only works if the match is in the past.
     * </p>
     * @param scoreTeamA representing the value to be assigned to the first team
     * @param scoreTeamB representing the value to be assigned to the second team
     */
    public void setMatchScore(int scoreTeamA, int scoreTeamB){
        this.scoreTeamA = scoreTeamA;
        this.scoreTeamB = scoreTeamB;
    }

    /**
     * <p>
     * getScoreTeamA getter method to retrieve the score of team A
     * </p>
     * @return this.scoreTeamA representing team A's score
     */
    public int getScoreTeamA(){return this.scoreTeamA;}

    /**
     * <p>
     * getScoreTeamB getter method to retrieve the score of team B
     * </p>
     * @return this.scoreTeamB representing team B's score
     */
    public int getScoreTeamB(){return this.scoreTeamB;}
}
