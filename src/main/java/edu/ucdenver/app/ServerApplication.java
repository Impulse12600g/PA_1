package edu.ucdenver.app;

import edu.ucdenver.tournament.*;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.time.LocalDateTime;

public class ServerApplication {
    public TextField txtCountryName;
    public Button btnAddCountry;
    private Tournament tournament;

    public ServerApplication(){
        tournament = new Tournament();//FIXME temp CONSTRUCTOR
    }

/*
    public static void main(String[] args){
        LocalDateTime localDateTime1 = LocalDateTime.of(
                2024, 04, 24, 14, 33, 48, 123456789);
        LocalDateTime localDateTime2 = LocalDateTime.of(
                2024, 05, 24, 14, 33, 48, 123456789);
        Tournament tournament = new Tournament("Tester",localDateTime1, localDateTime2);
        tournament.addCountry("USA");
        tournament.addReferee("Jeff", "USA");
        //Team t = new Team("reee", tournament.getCountry("USA"));
        tournament.addTeam("reee", "USA");
        tournament.addPlayer("boobs","geoff", 45, 55.0, 3000);
    }

 */

    public void addCountry(ActionEvent actionEvent) {
        tournament.addCountry(this.txtCountryName.getText());
        System.out.println(tournament);
    }
}
