package edu.ucdenver.app;

import edu.ucdenver.tournament.*;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDateTime;
import java.time.LocalTime;
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
    private Tournament tournament;

    public ServerApplication(){
        LocalDateTime localDateTime1 = LocalDateTime.of(
                2024, 04, 24, 14, 33, 48, 123456789);
        LocalDateTime localDateTime2 = LocalDateTime.of(
                2024, 05, 24, 14, 33, 48, 123456789);


        tournament = new Tournament("world cup", localDateTime1, localDateTime2);

    }

    public void addCountry(ActionEvent actionEvent) {
        tournament.addCountry(this.txtCountryName.getText());
        for(Country c: tournament.getParticipatingCountries()){
            System.out.println(c.getCountryName());
        }
    } // Working
    public void addTeam(ActionEvent actionEvent) {
        tournament.addTeam(this.txtAddTeam.getText(), this.txtCountryName.getText());

    } // Working
    public void addReferee(ActionEvent actionEvent) {
        tournament.addReferee(this.txtRefereeName.getText(), this.txtCountryName.getText());
    } // Working
    public void addPlayer(ActionEvent actionEvent) {
        tournament.addPlayer(this.txtTeamName.getText(),this.txtPlayerName.getText(), Integer.parseInt(this.txtPlayerAge.getText()),
                Double.parseDouble(this.txtPlayerHeight.getText()), Double.parseDouble(this.txtPlayerWeight.getText()));
        System.out.println(tournament);
    }

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
        //Team object to string
        //tournament.addReferee();//country
    }


    public void AddRefereeToMatch(ActionEvent actionEvent) {
        tournament.addRefereeToMatch(this.dtpMatchDate.getValue().atTime(LocalTime.ofSecondOfDay(Integer.parseInt(this.txtTime.getText()))),
                this.txtRefereeName.getText());

    }
}
