package edu.ucdenver.tournament;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.sound.sampled.Line;
import java.util.Scanner;
public class Tournament implements Serializable {
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private ArrayList<Country> participatingCountries;
    private ArrayList<Team> listTeams;
    private ArrayList<Referee> listReferees;
    private ArrayList<Match> listMatches;


    public static final String filename = "./tournament.ser";//load/save double check w javi

    public Tournament(String name, LocalDateTime startDate, LocalDateTime endDate){
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;

        this.participatingCountries = new ArrayList<>();
        this.listTeams = new ArrayList<>();
        this.listReferees = new ArrayList<>();
        this.listMatches = new ArrayList<>();

        // TODO potential exception handling if there is already a tournament at start date and end date
    }


    //fixme TEMPORARY CONSTRUCTOR FOR
    //public Tournament() {}

    public ArrayList<Country> getParticipatingCountries(){return participatingCountries;}
    public ArrayList<Team> getListTeams() {return listTeams;}
    public ArrayList<Referee> getListReferees(){return listReferees;}
    public ArrayList<Match> getListMatches(){return listMatches;}

    /////////////////////////////////////////////////////////////////////////////


    public void loadFromFile(String fileName){ //TODO add file operations
        try{
            File file = new File(fileName);
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String string;
            while((string = reader.readLine()) != null){
                // Do something with the file here
                System.out.println("Doing file stuff");
            }
            reader.close();
        } catch(Exception e){
            System.out.println("File does not exist");
            e.printStackTrace();
        }

    }
    public void saveToFile(String fineName){ //TODO finish file manipulation
        String things = "PLACEHOLDER"; // figure out what to write to file
        try{
            FileWriter writer = new FileWriter(fineName, false);
            writer.write(things);
            writer.close();
            System.out.println("Successfully overwritten file");
        } catch(IOException e){
            e.printStackTrace();
        }

    }
    public Country getCountry(String countryName) throws IllegalArgumentException{
        Country country;
        for(Country c: this.participatingCountries){
            if((c.getCountryName()).equalsIgnoreCase(countryName)){return c;}
        }
        throw new IllegalArgumentException("Country is not participating");
    }

    // requirement 4: Add participating country
    // Will check if the country is already on the list
    // Add new country to the list if not
    public void addCountry(String countryName){
        Country country = null;
        try{country = this.getCountry(countryName);}
        catch(IllegalArgumentException iae){
            this.participatingCountries.add(new Country(countryName));
        }
        if(country != null){
            throw new IllegalArgumentException("Country is already in the list");
        }
    }

//    public Team getTeam(String teamName) throws IllegalArgumentException{ // added getter for testing and setter
//        for(Team t: this.listTeams){
//            if((t.getName()).equals(teamName)){
//                return t;
//            }
//        }
//        return null;
//    }

    // Requirement 5: Add a team representing a country
    // Try to get the team, if successful, the team is already there
    // If not, loop through countries to find the matching country to assign team to
    // Add team to team list with participating country attribute
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
                        } else {
                            this.listTeams.add(new Team(teamName, c));
                        }
                    }
                }// If we cannot find the country, throw an exception
            } else {throw new IllegalArgumentException("Country not in the list");}
        }
    }
//
//    public Referee getReferee(String name) throws IllegalArgumentException{
//        for(Referee r: this.listReferees){
//            if((r.getName()).equalsIgnoreCase(name)){return r;}
//        }
//        throw new IllegalArgumentException("Referee is not in the list");
//    }

    // Requirement 6: Add referee to the tournament
    // Similar to add team. Check if the referee is already in the list or not
    // If not -> assign to the referee list with their assigned country
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
                        } else {
                            this.listReferees.add(new Referee(name, c));
                        }
                    }
                }
            } else {throw new IllegalArgumentException("Country not in the list");}
        }
    }


    // Requirement 7: Add a player to a national team squad
    // TODO: Make sure there are only 35 players on a squad
    // Will make sure player is not already on team (same name)
    public void addPlayer(String teamName, String playerName, int age, double height, double weight){

        try{
            for(Team t : this.listTeams) {
                if(Objects.equals(teamName, t.getName())){
                    for(Player p: t.getSquad()) {
                   if ((p.getName()).equals(playerName)) {
                       throw new IllegalArgumentException("Player is already on a team");
                   }else{
                       t.addPlayer(playerName, age, height,  weight);
                   }
               }
            }
            }
        }catch (IllegalArgumentException iae){
            iae.printStackTrace();
        }
    }
    // Requirement 8: Add a match on a particular date and time between two national teams
    // Only one match at a time -> throw exception if there is already a match at that time, team not found, same teams
    //TODO: TEST EXCEPTIONS
    public void addMatch(LocalDateTime dateTime, Team teamAName, Team teamBName){
        boolean teamAFound = false;
        boolean teamBFound = false;

        // Make sure the match does not already exist
        for(Match m : this.listMatches){
            if(dateTime == m.getDateTime()){
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
        }

    // Requirement 9: Assign referee to a match
    // 4 referees required for a match
    // Ref country cannot be the same as a team's country.
    // Throw exceptions for those two fields, and one if the ref is not in the system
    // Currently, exceptions are being handled in Match
    // TODO: TEST
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
                        if(m.getDateTime() == dateTime){
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
    }

    // TODO Requirement 10: Add a player to the team's lineup for a particular match
    // 11 players from the team's squad (no subs) -> implemented in Match
    // Player must be in national team's squad
    // Exception handling for above
    public void addPlayerToMatch(LocalDateTime dateTime, String teamName, String playerName){

        for(Match m: listMatches){
            // Find correct match
            if(m.getDateTime() == dateTime){
                // Check for team A
                if(Objects.equals(m.teamA.getName(), teamName)){
                    // Get players from team A
                    for(Player p: m.lineupA.getPlayers()){
                        // if player already on lineup, throw exception
                        if(Objects.equals(p.getName(), playerName)){
                            throw new IllegalArgumentException("Player already on team");
                            // add player if not already there
                        } else {
                            m.addPlayer(p, m.teamA);
                        }
                    }
                    // Check for team B
                } else if(Objects.equals(m.teamB.getName(), teamName)){
                    // Get players from team B
                    for(Player p: m.lineupB.getPlayers()){
                        // if player already on lineup, throw exception
                        if(Objects.equals(p.getName(), playerName)){
                            throw new IllegalArgumentException("Player already on team");
                            // add player if not already there
                        } else {
                            m.addPlayer(p, m.teamB);
                        }
                    }
                } else {throw new IllegalArgumentException("Team name not found");}
            } else {throw new IllegalArgumentException("Match not found");}
        }
    }

    // Requirement 11: Record the score of a completed match
    // Match date/time in the past
    // Only record final score <- should just be able to do if the match is in the past, and user reliant?
    // Exception handling if a match is not found for the date, and if it is not in the past
    // TODO: TEST
    public void setMatchScore(LocalDateTime dateTime, int teamAScore, int teamBScore){//uml gives just variable types
        for(Match m: listMatches){
            // find the match that matches the dateTime
            if(m.getDateTime() == dateTime){
                if(!m.isUpcoming()){
                    // set the score if match is not upcoming, throw exception if it hasn't happened yet
                    m.setMatchScore(teamAScore, teamBScore);
                } else {throw new IllegalArgumentException("Match has not happened yet");}
            } else {throw new IllegalArgumentException("Match could not be found at that time");}
        }
    }

    // TODO: Requirement 12: List of upcoming matching
    // List the date/time, and name of the two teams for each game
    //FIXME: Currently making a list of matches that are upcoming, do we call the specific output required
    // here or in the GUI?
    public List<Match> getUpcomingMatches(){
        ArrayList<Match> upcoming = new ArrayList<>();
        for(Match m: listMatches){
            if(m.isUpcoming()){
                upcoming.add(m);
            }
        }
        return upcoming;
    }

    // Requirement 13: Get list of matches on a particular date, without time
    // TODO: TEST
    public List<Match> getMatchesOn(LocalDateTime date){
        ArrayList<Match> matchesOn = new ArrayList<>();
        for(Match m: listMatches){
            if(m.getDateTime() == date){
                matchesOn.add(m);
            }
        }
        return matchesOn;
    }
    // Requirement 14: Get list of all games for a specific team, past matches include the score
    // TODO: TEST
    public List<Match> getMatchesFor(String teamName){
        ArrayList<Match> matchesForTeam = new ArrayList<>();
        for(Match m: listMatches){
            // check for team A
            if(Objects.equals(m.teamA.getName(), teamName)){
                matchesForTeam.add(m);
                }
                // Check for team B
             else if(Objects.equals(m.teamB.getName(), teamName)){
                matchesForTeam.add(m);
                }
        }
        // If no teams were added throw exception
        if(matchesForTeam.isEmpty()){
            throw new IllegalArgumentException("No matches for that team");
        } else {
            return matchesForTeam;
        }
    }
    // Requirement 15: Get the lineups for a match (either past of future)
    // TODO: TEST
    public List<LineUp> getMatchLineUps(LocalDateTime date){
        ArrayList<LineUp> lineUps = new ArrayList<>();
        for(Match m: listMatches){
            // Add both lineups to arraylist if the match is on the given date
            if(m.getDateTime() == date){
                lineUps.add(m.lineupA);
                lineUps.add(m.lineupB);
            }
        }
        // If no lineups were added throw exception
        if(lineUps.isEmpty()){
            throw new IllegalArgumentException("No lineups for that date");
        } else {
            return lineUps;
        }
    }

}
