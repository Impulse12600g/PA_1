package edu.ucdenver.app;

import edu.ucdenver.tournament.*;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDateTime;
import java.time.LocalTime;

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
    private Tournament tournament;

    public ServerApplication(){
        LocalDateTime localDateTime1 = LocalDateTime.of(
                2024, 04, 24, 14, 33, 48, 123456789);
        LocalDateTime localDateTime2 = LocalDateTime.of(
                2024, 05, 24, 14, 33, 48, 123456789);


        tournament = new Tournament("world cup", localDateTime1, localDateTime2);

    }
    /*
        tournament.addCountry("USA");
        tournament.addReferee("Jeff", "USA");
        //Team t = new Team("reee", tournament.getCountry("USA"));
        tournament.addTeam("reee", "USA");
        tournament.addPlayer("boobs","geoff", 45, 55.0, 3000);

     */

    public void addCountry(ActionEvent actionEvent) {
        tournament.addCountry(this.txtCountryName.getText());
        //System.out.println(tournament);
    }


    public void addPlayer(ActionEvent actionEvent) {
        tournament.addPlayer(this.txtTeamName.getText(),this.txtPlayerName.getText(), Integer.parseInt(this.txtPlayerAge.getText()),
                Double.parseDouble(this.txtPlayerHeight.getText()), Double.parseDouble(this.txtPlayerWeight.getText()));
        System.out.println(tournament);
    }
/*
    public void AddMatch(ActionEvent actionEvent) {
        tournament.addMatch(this.dtpMatchDate.getValue().atTime(LocalTime.ofSecondOfDay(Integer.parseInt(this.txtTime.getText()))),
                this.txtTeamA.getText(), this.txtTeamB.getText());//fixme
        //Team object to string
        //tournament.addReferee();//country
    }

    public void addReferee(ActionEvent actionEvent) {
    }

 */
}
