package edu.ucdenver.tournament;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * Tournament Class
 * </p>
 */
public class Tournament implements Serializable {
    /**
     * <p>
     * String name variable for naming the tournament
     * </p>
     */
    private final String name;
    /**
     * <p>
     * LocalDateTime startDate variable for giving the tournament a start date
     * </p>
     */
    private final LocalDateTime startDate;
    /**
     * <p>
     * LocalDateTime endDate variable for giving the tournament an end date
     * </p>
     */
    private final LocalDateTime endDate;
    /**
     * <p>
     * ArrayList participatingCountries variable for holding a list of countries in the tournament
     * </p>
     */
    private final ArrayList<Country> participatingCountries;
    /**
     * <p>
     * ArrayList listTeams variable for holding a list of teams in the tournament (assigned to a country)
     * </p>
     */
    private final ArrayList<Team> listTeams;
    /**
     * <p>
     * ArrayList listReferees variable for holding a list of referees in the tournament (assigned to a country)
     * </p>
     */
    private final ArrayList<Referee> listReferees;
    /**
     * <p>
     * ArrayList listMatches variable for holding a list of matches in the tournament
     * </p>
     */
    private final ArrayList<Match> listMatches;

    /**
     * <p>
     * Tournament constructor
     * Will assign the tournament name, start date, end date, and new array lists on creation
     * </p>
     * @param name for setting the tournament name
     * @param startDate for setting the tournament startDate
     * @param endDate for setting the tournament endDate
     */
    public Tournament(String name, LocalDateTime startDate, LocalDateTime endDate){
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;

        this.participatingCountries = new ArrayList<>();
        this.listTeams = new ArrayList<>();
        this.listReferees = new ArrayList<>();
        this.listMatches = new ArrayList<>();

    }

    /**
     * <p>
     * getParticipatingCountries array list method
     * </p>
     * @return participatingCountries
     */
    public ArrayList<Country> getParticipatingCountries(){return participatingCountries;}
    /**
     * <p>
     * getListTeams array list method
     * </p>
     * @return listTeams
     */
    public ArrayList<Team> getListTeams() {return listTeams;}
    /**
     * <p>
     * getListReferees array list method
     * </p>
     * @return listReferees
     */
    public ArrayList<Referee> getListReferees(){return listReferees;}
    /**
     * <p>
     * getListMatches array list method
     * </p>
     * @return listMatches
     */
    public ArrayList<Match> getListMatches(){return listMatches;}

    /////////////////////////////////////////////////////////////////////////////

    /**
     * <p>
     * loadFromFile method
     * Will take the file and read it and create a new tournament based on the input stream
     * </p>
     * @param fileName stores the file name used to read from
     * @return tournament
     */
    public static Tournament loadFromFile(String fileName){
        Tournament tournament;
        ObjectInputStream ois = null;

        try{
            ois = new ObjectInputStream(new FileInputStream(fileName));
            tournament = (Tournament) ois.readObject();
        }
        catch(Exception e){
            throw new IllegalArgumentException("Cant be empty");
        }
        finally {
            if(ois != null){
                try{ois.close();}
                catch(IOException ioe){ioe.printStackTrace();}
            }
        }
        return tournament;
    } // Working

    /**
     * <p>
     * saveToFile method
     * Will use the output stream to same the file to the given fileName parameter
     * </p>
     * @param fileName stores the file name used to read from
     */
    public void saveToFile(String fileName){
        ObjectOutputStream oos = null;

        try{
            oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(this);
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        finally {
            if(oos != null){
                try{
                    oos.close();
                }
                catch(IOException ioe){
                    ioe.printStackTrace();
                }
            }
        }
    } // Working

    /**
     * <p>
     * addCountry method
     * Search for the country on the list
     * Add to the list if it is not already there
     * </p>
     * @param countryName will hold the name of the country we are adding
     */
    public void addCountry(String countryName){
        if(this.participatingCountries.isEmpty()){
            this.participatingCountries.add(new Country(countryName));
        } else {
            for(Country c: this.participatingCountries){
                if(Objects.equals(c.getCountryName(), countryName)){
                    throw new IllegalArgumentException("Country is already in the list");
                }
            }
            this.participatingCountries.add(new Country(countryName));
        }
    } // Working

    /**
     * <p>
     * addTeam method will first try to find the team, if successful, will show that the team is already in the list.
     * If it is not, it will loop through the countries to find the matching destination for the team.
     * Once found, add the team to the list representing the country.
     * </p>
     * @param teamName holds the team name to be added
     * @param country represents the country we want to assign teamName to
     */
    public void addTeam(String teamName, String country){
        // loop through countries
        for(Country c: this.participatingCountries){
            // if we find the country
            if(Objects.equals(c.getCountryName(), country)){
                if(this.listTeams.isEmpty()){
                    this.listTeams.add(new Team(teamName, c));
                }else {
                    for (Team t : this.listTeams) {
                        if (Objects.equals(t.getName(), teamName)) {
                            throw new IllegalArgumentException("Team is already in the list");
                        }
                    }
                    this.listTeams.add(new Team(teamName, c));
                }// If we cannot find the country, throw an exception
            }
        }
    } // Working

    /**
     * <p>
     * addReferee method to add referee to the tournament
     * Will check for the referee first and display a message if the referee is already in the list.
     * If not in the list, find destination country and assign referee to it
     * </p>
     * @param name holds the name of the referee to add
     * @param country represents the destination country to assign referee to
     */
    public void addReferee (String name, String country){
        // check for country
        for(Country c: this.participatingCountries){
            // if we find the country
            if(Objects.equals(c.getCountryName(), country)){
                // add if the list is empty
                if(this.listReferees.isEmpty()){
                    this.listReferees.add(new Referee(name, c));
                } else {
                    for(Referee r: this.listReferees){
                        if(Objects.equals(r.getName(), name)){
                            throw new IllegalArgumentException("Referee is already in the tournament");
                        }
                    }
                    this.listReferees.add(new Referee(name, c));
                }
            }
        }
    } // Working

    /**
     * <p>
     * addPlayer method to add a player to a national team's squad.
     * Will loop through teams and check if the team is empty, and if the player is already on it.
     * Will add the player if the squad is empty or if the player is not already on it (matching name)
     * </p>
     * @param teamName holds the name of the team we are assigning the player to
     * @param playerName represents the name of the player to be assigned
     * @param age to assign to the player
     * @param height to assign to the player
     * @param weight to assign to the player
     */
    public void addPlayer(String teamName, String playerName, int age, double height, double weight){
        for(Team t : this.listTeams) {
            if(Objects.equals(teamName, t.getName())){
                // check if the squad is empty
                if(t.getSquad() == null){
                    t.addPlayer(playerName, age, height,  weight);
                } else {
                    for(Player p: t.getSquad()) {
                        if ((p.getName()).equals(playerName)) {
                            throw new IllegalArgumentException("Player is already on a team");
                        }
                    }
                    t.addPlayer(playerName, age, height, weight);
               }
            }
        }
    } // working

    /**
     * <p>
     * addMatch method to add a match on a particular date and time to the tournament.
     * Match has to be between two different national teams.
     * Will first loop through the matches and make sure there is not a match at that time already.
     * Then will make sure the teams exist in the tournament.
     * If they are both found and not the same, we create a new match between those teams, at the selected date/time.
     * </p>
     * @param dateTime for assigning the date and time of the match
     * @param teamAName holds the name of the first team in the match
     * @param teamBName holds the name of the second team in the match
     */
    public void addMatch(LocalDateTime dateTime, Team teamAName, Team teamBName){
        boolean teamAFound = false;
        boolean teamBFound = false;

        // Make sure the match does not already exist
        for(Match m : this.listMatches){
            if(dateTime.equals(m.getDateTime())){
                throw new IllegalArgumentException("There is already a match at that time");
            }
        }
        // Make sure both teams are in the team list
        for(Team t: this.listTeams){
            if(t == teamAName){teamAFound = true;}
            if(t == teamBName){teamBFound = true;}
        }
        // Throw exception is either team is not found
        if(!teamAFound){throw new IllegalArgumentException("First team is not in the tournament");}
        if(!teamBFound){throw new IllegalArgumentException("Second team is not in the tournament");}
        // Make sure teams are not the same
        if(teamAName == teamBName){throw new IllegalArgumentException("Teams cannot be the same");}

        // Add match if you get to this point
        this.listMatches.add(new Match(dateTime, teamAName, teamBName));
        } // Working

    /**
     * <p>
     * addRefereeToMatch method to add a referee to a particular match.
     * There are four referees required for a match, so we are not accepting any more than that.
     * First loops through referees to find the referee in the tournament referees list.
     * Then loop through the matches and add the referee to the match.
     * We are throwing an exception if the referee or match are not found.
     * </p>
     * @param dateTime for find the match we are assigning a referee to
     * @param refereeName holds the name of the referee in the list that we are assigning to a match
     */
    public void addRefereeToMatch(LocalDateTime dateTime, String refereeName){
        // Loop through referees to make sure referee is in the list
        // Find the match that matches the time
        // Add referee to match
        boolean refFound = false;
        boolean matchFound = false;
        try{
            for(Referee r: listReferees){ // Check for referee in list
                if(Objects.equals(r.getName(), refereeName)){
                    refFound = true;
                    for(Match m: listMatches){ // check for match in list
                        if(m.getDateTime().isEqual(dateTime)){
                            matchFound = true;
                            m.addReferee(r);
                        }
                    }
                }
            }
        } catch(Exception e){
            if(!refFound){throw new IllegalArgumentException("Referee was not found");}
            if(!matchFound){throw new IllegalArgumentException("Match was not found");}
        }
    } // Working

    /**
     * <p>
     * addPlayerToMatch method to add a player to a team's lineup for a particular match.
     * We first loop through the matches.
     * Then we check and make sure the match is valid by checking the 4 referee requirement.
     * If we find the correct match, we check for the correct team.
     * We get the players from that team and make sure the player is not already on the lineup.
     * If the player is not, we can then assign the player to the correct lineup.
     * </p>
     * @param dateTime holds the date and time we want to find the match and lineups in
     * @param teamName represents the team that has the lineup for the match
     * @param playerName represents the player we want to add to the lineup
     */
    public void addPlayerToMatch(LocalDateTime dateTime, String teamName, String playerName){
        for(Match m: listMatches){
            // Will not let the match happen (add players) without four referees
            if(m.getReferees().size() != 4){
                throw new IllegalArgumentException("You need four referees to create a match!");
            }
            // Find correct match
            if(m.getDateTime().equals(dateTime)){
                // Check for team A
                if(Objects.equals(m.teamA.getName(), teamName)){
                    // Get players from team A
                    if(m.lineupA.getPlayers() != null) {
                        for (Player p : m.lineupA.getPlayers()) {
                            // if player already on lineup, throw exception
                            if (Objects.equals(p.getName(), playerName)) {
                                // throw exception if player is already there
                                throw new IllegalArgumentException("Player already on team");
                            }
                        }
                    }// add player if not already there
                    for (Player pA : m.teamA.getSquad()) {
                        if (Objects.equals(pA.getName(), playerName)) {
                            m.addPlayer(pA, m.teamA);
                        }
                    }
                // Check for team B
                } else if(Objects.equals(m.teamB.getName(), teamName)){
                    // Get players from team B
                    if(m.lineupB.getPlayers() != null) {
                        for (Player p : m.lineupB.getPlayers()) {
                            // if player already on lineup, throw exception
                            if (Objects.equals(p.getName(), playerName)) {
                                throw new IllegalArgumentException("Player already on team");
                            }
                        }
                    }// add player if not already there
                    for (Player pB : m.teamB.getSquad()) {
                        if (Objects.equals(pB.getName(), playerName)) {
                            m.addPlayer(pB, m.teamB);
                        }
                    }
                } else {throw new IllegalArgumentException("Team name not found");}
            }
        }
    } // Working

    /**
     * <p>
     * setMatchScore method to set the score for a past match.
     * Match must not be upcoming.
     * Will first loop through the matches and find the one we want to set the score for.
     * Then will check to make sure the match is not upcoming.
     * If the match is in the past, we will set the score for both teams.
     * </p>
     * @param dateTime represents the match date we are looking for
     * @param teamAScore holds the value we want to assign to the first team's score
     * @param teamBScore holds the value we want to assign to the second team's score
     */
    public void setMatchScore(LocalDateTime dateTime, int teamAScore, int teamBScore){//uml gives just variable types
        for(Match m: listMatches){
            // find the match that matches the dateTime
            if(m.getDateTime().equals(dateTime)){
                if(!m.isUpcoming()){
                    // set the score if match is not upcoming, throw exception if it hasn't happened yet
                    m.setMatchScore(teamAScore, teamBScore);
                } else {throw new IllegalArgumentException("Match has not happened yet");}
            }
        }
    } // Working

    /**
     * <p>
     * getUpcomingMatches method will return an array list of all tournament matches in the future.
     * Will first loop through the listMatches list, then check if it is upcoming.
     * If the match is upcoming, add it to the new upcoming list to be returned.
     * </p>
     * @return upcoming list that holds all upcoming matches in the tournament
     */
    public ArrayList<String> getUpcomingMatches(){
        ArrayList<String> upcoming = new ArrayList<>();
        for(Match m: listMatches){
            if(m.isUpcoming()){
                upcoming.add(m.lineupA.getTeam().getName() + " vs " + m.lineupB.getTeam().getName() + " at " + m.getDateTime());
            }
        }
        return upcoming;
    } // Working

    /**
     * <p>
     * getMatchesOn method will return an array list of all tournament matches on a particular date.
     * Will first loop through the listMatches list, then check if the date matches the one we want.
     * If the match is the one on the given date, add it to our new array list matchesOn.
     * </p>
     * @param date represents the date we want all matches for
     * @return matchesOn list that holds all matches in the tournament for the date given
     */
    public List<String> getMatchesOn(LocalDate date){
        ArrayList<String> matchesOn = new ArrayList<>();
        for(Match m: listMatches){
            if(m.getDate().equals(date)){
                matchesOn.add(m.lineupA.getTeam().getName() + " vs " + m.lineupB.getTeam().getName() + " at " + m.getDate());
            }
        }
        return matchesOn;
    } // Working

    /**
     * <p>
     * getMatchesFor method will return an array list of all tournament matches for a given team.
     * Will first loop through the listMatches list, then check if it holds the team we are looking for.
     * If the match has the team, we then run our isFutureMatch check then assign the match to the array list.
     * </p>
     * @param teamName represents the team we want matches for
     * @return matchesForTeam list that holds all matches in the tournament for the given team
     */
    public List<String> getMatchesFor(String teamName){
        ArrayList<String> matchesForTeam = new ArrayList<>();
        for(Match m: listMatches){
            // check for team A, run ifFuture method to assign correct string
            if(Objects.equals(m.teamA.getName(), teamName)){isFutureMatch(matchesForTeam, m);}
                // Check for team B, run ifFuture method to assign correct string
             else if(Objects.equals(m.teamB.getName(), teamName)){isFutureMatch(matchesForTeam, m);}
        }
        // If no teams were added throw exception
        if(matchesForTeam.isEmpty()){throw new IllegalArgumentException("No matches for that team");}
        else {return matchesForTeam;}
    } // Working

    /**
     * <p>
     * isFutureMatch method built to check if the given match is in the future or not.
     * It will take in the array list and the match we are checking, then run a check on if it is in the future or not.
     * If it is, we add the string to the array list showing when they play.
     * If it is not, we add the string to the array list showing what the score of the match was.
     * </p>
     * @param matchesForTeam ArrayList that we are adding the string to for client display
     * @param m represents the match that we are currently checking
     */
    private void isFutureMatch(ArrayList<String> matchesForTeam, Match m) {
        if(m.getDateTime().isAfter(LocalDateTime.now())){
            matchesForTeam.add(m.lineupA.getTeam().getName() + " vs " + m.lineupB.getTeam().getName() +
                    " They play on: " + m.getDateTime());
        } else { // include score for past matches
            matchesForTeam.add(m.lineupA.getTeam().getName() + " vs " + m.lineupB.getTeam().getName() +
                    " Score of: " + m.getScoreTeamA() + " to " + m.getScoreTeamB());
        }
    } // Working

    /**
     * <p>
     * getMatchLineUps method will return an array list of all match lineups for a given date.
     * Will first loop through the matches, then check if we find one on the given date.
     * If the match found, then we add the string of both lineups vs each other to the new array list.
     * </p>
     * @param date represents the date of the matches we are looking for
     * @return lineUps list that holds the two lineUps for matches on the given date
     */
    public List<String> getMatchLineUps(LocalDateTime date){
        ArrayList<String> lineUps = new ArrayList<>();
        for(Match m: listMatches){
            // Add both lineups to arraylist if the match is on the given date
            if(m.getDateTime().equals(date)){
                lineUps.add(m.lineupA.getTeam().getName() + " vs " + m.lineupB.getTeam().getName());
//                lineUps.add(m.lineupB.getTeam().getName());
            }
        }
        // If no lineups were added throw exception
        if(lineUps.isEmpty()){
            throw new IllegalArgumentException("No lineups for that date");
        } else {
            return lineUps;
        }
    } // Working

}
