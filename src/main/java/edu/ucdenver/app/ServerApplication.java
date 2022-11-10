package edu.ucdenver.app;

import edu.ucdenver.tournament.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.Objects;

public class ServerApplication {
    public TextField txtCountryName;
    public Button btnAddCountry;
    public TextField txtPlayerName;
    public TextField txtPlayerAge;
    public TextField txtPlayerHeight;
    public TextField txtPlayerWeight;
    public Button btnPlayerAdd;
    public TextField txtTeamName;
    public Button btnAddMatch;
    public DatePicker dtpMatchDate;
    public TextField txtTeamA;
    public TextField txtTeamB;
    public TextField txtAddReferee;
    public TextField txtTime;
    public TextField txtRefereeName;
    public Button btnAddReferee;
    public Button btnAddTeam;
    public TextField txtAddTeam;
    public Button btnAddRefereeToMatch;
    public TextField txtHour;
    public TextField txtMinute;
    public TextField txtTournament;
    public Button btnAddTournament;
    public TextField txtTourEndHour;
    public TextField txtTourEndMin;
    public TextField txtTourStartHour;
    public TextField txtTourStartMin;
    public DatePicker dtpTourStartDate;
    public DatePicker dtpTourEndDate;
    public Button btnLoadFromFile;
    public Button btnExit;
    public Button btnSaveToFIle;
    public TextField txtAddPlayerTeamName;
    public TextField txtAddPlayerPlayerName;
    public TextField txtAddPlayerMatchTimeHour;
    public TextField txtAddPlayerMatchTimeMin;
    public DatePicker dtpAddPlayerMatchDate;
    public Button btnAddPlayerToMatch;
    public ListView <Match> lstMatchesOn;
    public TextField txtCountryNameToTeam;
    public TextField txtCountryNameToRef;
    public DatePicker dtpRecordMatchScoreDate;
    public TextField txtTeamAScore;
    public TextField txtTeamBScore;
    public Button btnSetMatchScore;
    public TextField dtpRecordMatchScoreHour;
    public TextField dtpRecordMatchScoreMinute;
    public Button btngetUpcomingMatches;
    public Tab tabUpcomingMatches;
    public TextField txtTeamNameMatches;
    public Button btnFindMatchesTeam;
    public ListView<Object> lstMatchesPerTeam;
    public DatePicker dtpDayOfMatch;
    public Button btnFindMatch;
    public ListView<Object> lstMatch;
    public DatePicker dtpDateOfMatches;
    public TextField txtTimeOfMatchHour;
    public TextField txtTimeOfMatchMin;
    public ListView<Object> lstOfLineups;
    public Button btnListOfLineups;
    private Tournament tournament;
    public static final String filename = "./tournament.ser";

    public ServerApplication(){
        tournament = new Tournament(null, null, null);
        this.lstMatchesOn = new ListView<>();

    }
    public void initialize(){
        // Add initialize fields: Lists, combo boxes, etc
        this.lstMatchesOn.setItems(FXCollections.observableArrayList(tournament.getUpcomingMatches()));

    }
    public void addTournament(ActionEvent actionEvent) {
        tournament = new Tournament(this.txtTournament.getText(),
                this.dtpTourStartDate.getValue().atTime(Integer.parseInt(txtTourStartHour.getText()) ,Integer.parseInt(txtTourStartMin.getText())),
                this.dtpTourEndDate.getValue().atTime(Integer.parseInt(txtTourEndHour.getText()) ,Integer.parseInt(txtTourEndMin.getText())));

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Tournament added Successfully");
        alert.show();

    }

    public void addCountry(ActionEvent actionEvent) {
        tournament.addCountry(this.txtCountryName.getText());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Country added Successfully");
        alert.show();
        for(Country c: tournament.getParticipatingCountries()){
            System.out.println(c.getCountryName());
        }
    } // Working
    public void addTeam(ActionEvent actionEvent) {
        tournament.addTeam(this.txtAddTeam.getText(), this.txtCountryNameToTeam.getText());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Team added Successfully");
        alert.show();

    } // Working
    public void addReferee(ActionEvent actionEvent) {
        tournament.addReferee(this.txtRefereeName.getText(), this.txtCountryNameToRef.getText());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Referee added Successfully");
        alert.show();
    } // Working
    public void addPlayer(ActionEvent actionEvent) {
        tournament.addPlayer(this.txtTeamName.getText(),this.txtPlayerName.getText(), Integer.parseInt(this.txtPlayerAge.getText()),
                Double.parseDouble(this.txtPlayerHeight.getText()), Double.parseDouble(this.txtPlayerWeight.getText()));
        System.out.println(tournament);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Player added Successfully");
        alert.show();
    } // Working
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

    public void AddRefereeToMatch(ActionEvent actionEvent) {
        tournament.addRefereeToMatch(this.dtpMatchDate.getValue().atTime(Integer.parseInt(txtHour.getText()) ,Integer.parseInt(txtMinute.getText())),
                this.txtRefereeName.getText());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Referee added Successfully to match");
        alert.show();
    }

    public void loadFromFile(ActionEvent actionEvent) {
        this.tournament = Tournament.loadFromFile(filename);
        this.initialize();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "File Loaded");
        alert.show();

    }
    public void exitApplication(ActionEvent actionEvent) {
        Stage stage = (Stage) this.btnExit.getScene().getWindow();
        stage.close();

    }
    public void saveToFIle(ActionEvent actionEvent) {
        tournament.saveToFile(filename);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "File saved");
        alert.show();

    }

    public void addPlayerToMatch(ActionEvent actionEvent) {
        tournament.addPlayerToMatch(this.dtpAddPlayerMatchDate.getValue().atTime(Integer.parseInt(txtAddPlayerMatchTimeHour.getText()) ,Integer.parseInt(txtAddPlayerMatchTimeMin.getText())),
                this.txtAddPlayerTeamName.getText(), this.txtAddPlayerPlayerName.getText());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Player successfully added to match!");
        alert.show();
    }

    public void setMatchScore(ActionEvent actionEvent) {
        tournament.setMatchScore(this.dtpRecordMatchScoreDate.getValue().atTime(Integer.parseInt(dtpRecordMatchScoreHour.getText()) ,Integer.parseInt(dtpRecordMatchScoreMinute.getText())),
                Integer.parseInt(this.txtTeamAScore.getText()), Integer.parseInt(this.txtTeamBScore.getText()));
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Match score set!");
        alert.show();
    }

    public void getUpcomingMatches(Event event) {
        if(this.tabUpcomingMatches.isSelected()) {
            this.lstMatch.setItems(FXCollections.observableArrayList
                    (tournament.getUpcomingMatches()));
        } lstMatch.refresh();
    }

    public void getMatchesOn(ActionEvent actionEvent) {
        this.lstMatchesOn.setItems(FXCollections.observableArrayList
                (tournament.getMatchesOn(this.dtpDayOfMatch.getValue())));
    }

    public void getMatchesFor(ActionEvent actionEvent) {
        this.lstMatchesPerTeam.setItems(FXCollections.observableArrayList
                (tournament.getMatchesFor(this.txtTeamNameMatches.getText())));
    }

    public void getMatchLineUps(ActionEvent actionEvent) {
        this.lstOfLineups.setItems(FXCollections.observableArrayList
                (tournament.getMatchLineUps(this.dtpDateOfMatches.getValue()
                        .atTime(Integer.parseInt(txtTimeOfMatchHour.getText()),
                                Integer.parseInt(txtTimeOfMatchMin.getText())))));
    }
}
