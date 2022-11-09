package edu.ucdenver.app;

import edu.ucdenver.tournament.*;

import java.time.LocalDateTime;

public class ServerApplication {
    public static void main(String[] args){
        LocalDateTime localDateTime1 = LocalDateTime.of(
                2024, 04, 24, 14, 33, 48, 123456789);
        LocalDateTime localDateTime2 = LocalDateTime.of(
                2024, 05, 24, 14, 33, 48, 123456789);
        Tournament tournament = new Tournament("Tester",localDateTime1, localDateTime2);

        tournament.addCountry("USA");
        tournament.addCountry("Spain");
        tournament.addCountry("Portugal");

        tournament.addReferee("Jeff", "Portugal");

        tournament.addTeam("TEAMA", "USA");
        tournament.addTeam("TEAMB", "Spain");
        
        tournament.addPlayer("TEAMA","geoff", 45, 55.0, 3000);

    }
}
