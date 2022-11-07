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
        tournament.addReferee("Jeff", "USA");
        //Team t = new Team("reee", tournament.getCountry("USA"));
        tournament.addTeam("reee", "USA");
        tournament.addPlayer("boobs","geoff", 45, 55.0, 3000);
//
//        for (Referee te : tournament.getListReferees()){
//            System.out.println(te);
//        }
        //System.out.println(tournament);
    }
}
