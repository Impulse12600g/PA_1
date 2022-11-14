package edu.ucdenver.app;

import edu.ucdenver.tournament.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * <p>
 * ServerApplication class. This is being used as the main controller for the project and application.
 * We decided to build both admin and client applications in one app. So instead of running method calls from
 * ClientWorker, all calls are being done in this class.
 * </p>
 */
public class ServerApplication {

    /**
     * <p>
     * txtCountryName variable for setting country name from app input
     * </p>
     */
    public TextField txtCountryName;

    /**
     * <p>
     * btnAddCountry variable for running add country process when the button is pushed
     * </p>
     */
    public Button btnAddCountry;

    /**
     * <p>
     * txtPlayerName variable for setting player name from app input
     * </p>
     */
    public TextField txtPlayerName;

    /**
     * <p>
     * txtPlayerAge variable for setting player age from app input
     * </p>
     */
    public TextField txtPlayerAge;

    /**
     * <p>
     * txtPlayerHeight variable for setting player height from app input
     * </p>
     */
    public TextField txtPlayerHeight;

    /**
     * <p>
     * txtPlayerWeight variable for setting player weight from app input
     * </p>
     */
    public TextField txtPlayerWeight;

    /**
     * <p>
     * btnPlayerAdd variable for running add player process when the button is pushed
     * </p>
     */
    public Button btnPlayerAdd;

    /**
     * <p>
     * txtTeamName variable for setting team name from app input
     * </p>
     */
    public TextField txtTeamName;

    /**
     * <p>
     * btnAddMatch variable for running add match process when the button is pushed
     * </p>
     */
    public Button btnAddMatch;

    /**
     * <p>
     * dtpMatchDate variable for setting a date in app input
     * </p>
     */
    public DatePicker dtpMatchDate;

    /**
     * <p>
     * txtTeamA variable for setting the first team in app input
     * </p>
     */
    public TextField txtTeamA;

    /**
     * <p>
     * txtTeamB variable for setting the second team in app input
     * </p>
     */
    public TextField txtTeamB;

    /**
     * <p>
     * txtAddReferee variable for setting the referee in app input
     * </p>
     */
    public TextField txtAddReferee;

    /**
     * <p>
     * txtTime variable used to set the time from app input
     * </p>
     */
    public TextField txtTime;

    /**
     * <p>
     * txtRefereeName variable for setting the name of the referee in app input
     * </p>
     */
    public TextField txtRefereeName;

    /**
     * <p>
     * btnAddReferee variable used to run the add referee process when the button is clicked
     * </p>
     */
    public Button btnAddReferee;

    /**
     * <p>
     * btnAddTeam variable used to run the add team process when the button is clicked
     * </p>
     */
    public Button btnAddTeam;

    /**
     * <p>
     * txtAddTeam variable for setting the team to add in app input
     * </p>
     */
    public TextField txtAddTeam;

    /**
     * <p>
     * btnAddRefereeToMatch variable to run add referee to match process when the button is clicked
     * </p>
     */
    public Button btnAddRefereeToMatch;

    /**
     * <p>
     * txtHour variable used as the new way for us to set the hour in our time for matches
     * </p>
     */
    public TextField txtHour;

    /**
     * <p>
     * txtMinute variable used as the new way for us to set the minute in our time for matches
     * </p>
     */
    public TextField txtMinute;

    /**
     * <p>
     * txtTournament variable used to set up the tournament in the app
     * </p>
     */
    public TextField txtTournament;

    /**
     * <p>
     * btnAddTournament variable used to start a new tournament when the button is clicked
     * </p>
     */
    public Button btnAddTournament;

    /**
     * <p>
     * txtTourEndHour variable used to set the end hour of a tournament
     * </p>
     */
    public TextField txtTourEndHour;

    /**
     * <p>
     * txtTourEndMin variable used to set the end minute of a tournament
     * </p>
     */
    public TextField txtTourEndMin;

    /**
     * <p>
     * txtTourStartHour variable used to set the start hour of a tournament
     * </p>
     */
    public TextField txtTourStartHour;

    /**
     * <p>
     * txtTourStartMin variable used to set the start minute of a tournament
     * </p>
     */
    public TextField txtTourStartMin;

    /**
     * <p>
     * dtpTourStartDate variable used to get the start date picker in app input for tournament
     * </p>
     */
    public DatePicker dtpTourStartDate;

    /**
     * <p>
     * dtpTourEndDate variable used to get the end date picker in app input for tournament
     * </p>
     */
    public DatePicker dtpTourEndDate;

    /**
     * <p>
     * btnLoadFromFile variable used to run load from file process when the button is clicked
     * </p>
     */
    public Button btnLoadFromFile;

    /**
     * <p>
     * btnExit variable used to run the exit process of the app
     * </p>
     */
    public Button btnExit;

    /**
     * <p>
     * btnSaveToFile variable used to run the save to file process when the button is clicked
     * </p>
     */
    public Button btnSaveToFIle;

    /**
     * <p>
     * txtAddPlayerTeamName variable to set the player team name in app input
     * </p>
     */
    public TextField txtAddPlayerTeamName;

    /**
     * <p>
     * txtAddPlayerPlayerName variable used to set the player name in app input
     * </p>
     */
    public TextField txtAddPlayerPlayerName;

    /**
     * <p>
     * txtAddPlayerMatchTimeHour variable used to set the time and hour of a match in add player
     * </p>
     */
    public TextField txtAddPlayerMatchTimeHour;

    /**
     * <p>
     * txtAddPlayerMatchTimeMin variable used to set the time and minute of the match in add player
     * </p>
     */
    public TextField txtAddPlayerMatchTimeMin;

    /**
     * <p>
     * dtpAddPlayerMatchDate date picker used in add player to find a match day
     * </p>
     */
    public DatePicker dtpAddPlayerMatchDate;

    /**
     * <p>
     * btnAddPlayerToMatch to run the add player to match process when button is clicked
     * </p>
     */
    public Button btnAddPlayerToMatch;

    /**
     * <p>
     * lstMatchesOn list view for client side viewing the matches on a particular date
     * </p>
     */
    public ListView <String> lstMatchesOn;

    /**
     * <p>
     * txtCountryNameToTeam variable to set the team country name in app input
     * </p>
     */
    public TextField txtCountryNameToTeam;

    /**
     * <p>
     * txtCountryNameToRef variable to set the country name to a referee
     * </p>
     */
    public TextField txtCountryNameToRef;

    /**
     * <p>
     * dtpRecordMatchScoreDate variable to pick the date of a match in add score
     * </p>
     */
    public DatePicker dtpRecordMatchScoreDate;

    /**
     * <p>
     * txtTeamAScore variable to set the score of the first team of the match
     * </p>
     */
    public TextField txtTeamAScore;

    /**
     * <p>
     * txtTeamBScore variable to set the score of the second team of the match
     * </p>
     */
    public TextField txtTeamBScore;

    /**
     * <p>
     * btnSetMatchScore variable for running the set score process when the button is clicked
     * </p>
     */
    public Button btnSetMatchScore;

    /**
     * <p>
     * dtpRecordMatchScoreHour variable for setting the hour of a score match field
     * </p>
     */
    public TextField dtpRecordMatchScoreHour;

    /**
     * <p>
     * dtpRecordMatchScoreMinute variable for setting the minute of a score match field
     * </p>
     */
    public TextField dtpRecordMatchScoreMinute;

    /**
     * <p>
     * btngetUpcomingMatches variable for running the get upcoming match process when button is clicked
     * </p>
     */
    public Button btngetUpcomingMatches;

    /**
     * <p>
     * tabUpcomingMatches used to get into the upcoming matches tab
     * </p>
     */
    public Tab tabUpcomingMatches;

    /**
     * <p>
     * txtTeamNameMatches variable used to set the team name in matches field
     * </p>
     */
    public TextField txtTeamNameMatches;

    /**
     * <p>
     * btnFindMatchesTeam used to start the find matches per team process
     * </p>
     */
    public Button btnFindMatchesTeam;

    /**
     * <p>
     * lstMatchesPerTeam list view to show the list of matches for a desired team
     * </p>
     */
    public ListView<Object> lstMatchesPerTeam;

    /**
     * <p>
     * dtpDayOfMatch variable for choosing the day of a match
     * </p>
     */
    public DatePicker dtpDayOfMatch;

    /**
     * <p>
     * btnFindMatch used to start the find match process
     * </p>
     */
    public Button btnFindMatch;

    /**
     * <p>
     * lastMatch list view to list all matches
     * </p>
     */
    public ListView<Object> lstMatch;

    /**
     * <p>
     * dtpDateOfMatches date picker for selecting the date of a match
     * </p>
     */
    public DatePicker dtpDateOfMatches;

    /**
     * <p>
     * txtTimeOfMatchHour to set the hour of a match
     * </p>
     */
    public TextField txtTimeOfMatchHour;

    /**
     * <p>
     * txtTimeOfMatchMin to set the minute of a match
     * </p>
     */
    public TextField txtTimeOfMatchMin;

    /**
     * <p>
     * listOfLineups list view to show a list of desired lineups
     * </p>
     */
    public ListView<Object> lstOfLineups;

    /**
     * <p>
     * btnListOfLineups used to start the get lineups process when the button is clicked
     * </p>
     */
    public Button btnListOfLineups;

    /**
     * <p>
     * tournament object of class Tournament to create tournaments
     * </p>
     */
    private Tournament tournament;

    /**
     * <p>
     * filename variable to hold the name of the file we use to store and load the app state
     * </p>
     */
    public static final String filename = "./tournament.ser";

    /**
     * <p>
     * ServerApplication constructor. Will create a new empty tournament on startup to help with load file handling.
     * Also sets our matchesOn list view to a new list view
     * </p>
     */
    public ServerApplication(){
        tournament = new Tournament(null, null, null);
        this.lstMatchesOn = new ListView<>();

    }

    /**
     * <p>
     * initialize method that will set the observable array list for the
     * matches on list to tournament.getUpcomingMatches()
     * </p>
     */
    public void initialize(){
        // Add initialize fields: Lists, combo boxes, etc
        this.lstMatchesOn.setItems(FXCollections.observableArrayList(tournament.getUpcomingMatches()));

    }

    /**
     * <p>
     * addTournament method to create a new tournament based on app input fields
     * </p>
     * @param actionEvent for when the action takes place of adding a tournament
     */
    public void addTournament(ActionEvent actionEvent) {
        tournament = new Tournament(this.txtTournament.getText(),
                this.dtpTourStartDate.getValue().atTime(Integer.parseInt(txtTourStartHour.getText()) ,Integer.parseInt(txtTourStartMin.getText())),
                this.dtpTourEndDate.getValue().atTime(Integer.parseInt(txtTourEndHour.getText()) ,Integer.parseInt(txtTourEndMin.getText())));

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Tournament added Successfully");
        alert.show();
    }

    /**
     * <p>
     * addCountry method to add a country to the tournament. We will output the country list to the console for ease of testing,
     * but the for loop can be commented out if needed
     * </p>
     * @param actionEvent for when the action takes place of adding a country
     */
    public void addCountry(ActionEvent actionEvent) {
        tournament.addCountry(this.txtCountryName.getText());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Country added Successfully");
        alert.show();
        for(Country c: tournament.getParticipatingCountries()){
            System.out.println(c.getCountryName());
        }
    } // Working

    /**
     * <p>
     * addTeam method to add a team to the tournament based on app input fields.
     * </p>
     * @param actionEvent for when the action takes place of adding a team
     */
    public void addTeam(ActionEvent actionEvent) {
        tournament.addTeam(this.txtAddTeam.getText(), this.txtCountryNameToTeam.getText());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Team added Successfully");
        alert.show();

    } // Working

    /**
     * <p>
     * addReferee to the tournament based on the app input fields
     * </p>
     * @param actionEvent for when the action takes place of adding a team
     */
    public void addReferee(ActionEvent actionEvent) {
        tournament.addReferee(this.txtRefereeName.getText(), this.txtCountryNameToRef.getText());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Referee added Successfully");
        alert.show();
    } // Working

    /**
     * <p>
     * addPlayer method to add a player to the tournament and to a team based on the app input fields
     * </p>
     * @param actionEvent for when the action takes place of adding a player
     */
    public void addPlayer(ActionEvent actionEvent) {
        tournament.addPlayer(this.txtTeamName.getText(),this.txtPlayerName.getText(), Integer.parseInt(this.txtPlayerAge.getText()),
                Double.parseDouble(this.txtPlayerHeight.getText()), Double.parseDouble(this.txtPlayerWeight.getText()));
        System.out.println(tournament);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Player added Successfully");
        alert.show();
    } // Working

    /**
     * <p>
     * addMatch method to add a match to the tournament based on app input fields.
     * This method will double check that the team names are not the same, then
     * loop through the tournament list and set teams
     * </p>
     * @param actionEvent for when the action takes place of adding a match
     */
    public void addMatch(ActionEvent actionEvent) {
        Team teamA = null;
        Team teamB = null;
        if(this.txtTeamA == this.txtTeamB){
            throw new IllegalArgumentException("The teams are the same");
        }
        for(Team t : tournament.getListTeams()){
            if(Objects.equals(t.getName(), this.txtTeamA.getText())){
                teamA = t;
            }
            if(Objects.equals(t.getName(), this.txtTeamB.getText())){
                teamB = t;
            }
        }
        if((teamA == null) ||( teamB == null)){
            throw new IllegalArgumentException("Team not found in tournament");
        }
        tournament.addMatch(this.dtpMatchDate.getValue().atTime(Integer.parseInt(txtHour.getText()) ,Integer.parseInt(txtMinute.getText())),
                teamA, teamB);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Match added Successfully");
        alert.show();
        //Team object to string
        //tournament.addReferee();//country
    } // Working

    /**
     * <p>
     * addRefereeToMatch method to add a referee to a match based on app input fields
     * </p>
     * @param actionEvent for when the action takes place of adding a referee to a match
     */
    public void AddRefereeToMatch(ActionEvent actionEvent) {
        tournament.addRefereeToMatch(this.dtpMatchDate.getValue().atTime(Integer.parseInt(txtHour.getText()) ,Integer.parseInt(txtMinute.getText())),
                this.txtRefereeName.getText());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Referee added Successfully to match");
        alert.show();
    }

    /**
     * <p>
     * loadFromFile method that will look for the filename in the project directory then run the
     * tournament loadFromFile method to return the app to that state.
     * </p>
     * @param actionEvent for when the action takes place of loading from a file
     */
    public void loadFromFile(ActionEvent actionEvent) {
        this.tournament = Tournament.loadFromFile(filename);
        this.initialize();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "File Loaded");
        alert.show();
    }

    /**
     * <p>
     * exitApplication method to exit the state and close the app when the button is pushed
     * </p>
     * @param actionEvent for when the action takes place of pressing the exit button
     */
    public void exitApplication(ActionEvent actionEvent) {
        Stage stage = (Stage) this.btnExit.getScene().getWindow();
        stage.close();
    }

    /**
     * <p>
     * saveToFile method for when the button is pushed in the app to save the state of the app to a file.
     * This method will call the tournament saveToFile method with the file name parameter
     * </p>
     * @param actionEvent for when the action takes place of saving to a file
     */
    public void saveToFIle(ActionEvent actionEvent) {
        tournament.saveToFile(filename);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "File saved");
        alert.show();
    }

    /**
     * <p>
     * addPlayerToMatch method that will add a player to a desired match based on app input fields
     * </p>
     * @param actionEvent for when the action takes place of adding a player to a match
     */
    public void addPlayerToMatch(ActionEvent actionEvent) {
        tournament.addPlayerToMatch(this.dtpAddPlayerMatchDate.getValue().atTime(Integer.parseInt(txtAddPlayerMatchTimeHour.getText()) ,Integer.parseInt(txtAddPlayerMatchTimeMin.getText())),
                this.txtAddPlayerTeamName.getText(), this.txtAddPlayerPlayerName.getText());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Player successfully added to match!");
        alert.show();
    }

    /**
     * <p>
     * setMatchScore method to call the tournament setMatchScore method with the app input fields
     * as parameters.
     * </p>
     * @param actionEvent for when the action takes place of setting the score of a match
     */
    public void setMatchScore(ActionEvent actionEvent) {
        tournament.setMatchScore(this.dtpRecordMatchScoreDate.getValue().atTime(Integer.parseInt(dtpRecordMatchScoreHour.getText()) ,Integer.parseInt(dtpRecordMatchScoreMinute.getText())),
                Integer.parseInt(this.txtTeamAScore.getText()), Integer.parseInt(this.txtTeamBScore.getText()));
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Match score set!");
        alert.show();
    }

    /**
     * <p>
     * getUpcomingMatches method that will update the observable array list for client to see the
     * upcoming matches
     * </p>
     * @param event for when the event takes place of wanting to get the upcoming matches
     */
    public void getUpcomingMatches(Event event) {
        if(this.tabUpcomingMatches.isSelected()) {
            this.lstMatch.setItems(FXCollections.observableArrayList
                    (tournament.getUpcomingMatches()));
        } lstMatch.refresh();
    }

    /**
     * <p>
     * getMatchesOn method that will update the observable array list of matches on a particular date.
     * </p>
     * @param actionEvent for when the action takes place of updating the list of matches for the client
     */
    public void getMatchesOn(ActionEvent actionEvent) {
        this.lstMatchesOn.setItems(FXCollections.observableArrayList
                (tournament.getMatchesOn(this.dtpDayOfMatch.getValue())));
    }

    /**
     * <p>
     * getMatchesFor method will update the observable array list of matches
     * for a particular team. Shown for the client.
     * </p>
     * @param actionEvent for when the action takes place of getting matches for a team
     */
    public void getMatchesFor(ActionEvent actionEvent) {
        this.lstMatchesPerTeam.setItems(FXCollections.observableArrayList
                (tournament.getMatchesFor(this.txtTeamNameMatches.getText())));
    }

    /**
     * <p>
     * getMatchLineups method to update the observable array list in the client.
     * This is determined by a specified team value.
     * </p>
     * @param actionEvent for when the action takes place of getting the lineups for a match
     */
    public void getMatchLineUps(ActionEvent actionEvent) {
        this.lstOfLineups.setItems(FXCollections.observableArrayList
                (tournament.getMatchLineUps(this.dtpDateOfMatches.getValue()
                        .atTime(Integer.parseInt(txtTimeOfMatchHour.getText()),
                                Integer.parseInt(txtTimeOfMatchMin.getText())))));
    }
}
