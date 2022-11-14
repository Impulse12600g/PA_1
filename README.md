## README - PA1

- By Josh Mansito and Kelvin Lal

### Implementation Requirements:

1. **WORKING:** Load from file
2. **WORKING:** Save to file
3. **WORKING:** Create a new tournament 
4. **WORKING:** Add a participating country 
5. **WORKING:** Add a national team representing a country
6. **WORKING:** Add referees to the tournament 
7. **WORKING:** Add a player to team squad 
8. **WORKING:** Add a match to date/time between two teams
9. **WORKING:** Assign a referee to a match 
10. **WORKING:** Add a player to a team's lineup in a match 
11. **WORKING:** Record the score of a completed match 
12. **WORKING:** Get upcoming matches 
13. **WORKING:** Get a list of matches at particular date 
14. **WORKING:** Get list of all games for a team 
15. **WORKING:** Get lineups for a match 

---------------------------------------------------------

### Structure:

This application was designed using intellij and scene builder.  
Modeling our project after the University class project, we  
decided to create separate admin and client tabs in one single app,  
instead of having two different applications. 

We have implemented the server into our project, and have elected  
to run all app protocols through the ServerApplication.java file,   
mirroring the in class project, instead of through the ClientWorker.

You will find most method implementation in Tournament.java  
and all application functionality in ServerApplication.java.

Application design code is in the admin.fxml file. 

---------------------------------------------------------

### Design:

We have implemented a clean GUI design with all functions going through  
one singular application. The top of the app will allow the user to  
select if they want the admin panel, or client panel. Interior tabs  
will allow navigation to all functions required of the project. 

(The assignment states "the gui designed is entirely up to your team"  
so we ran with it)

---------------------------------------------------------

### Testing Instructions:

Run the ServerApplication to launch the application  
The admin Add Tournament tab will be the first thing you see.  
Adding fields requires others to be entered first, so work left to  
right in the tabs. The application will alert you when something was  
added successfully, and the terminal will let you know if you tried to  
do something out of order. If you do, you can just continue in the app.  

You can push Save to File at any point to save the application state  
After at least saving a file once, you can select Load From File to  
return to your saved state. 

ADMIN STEPS:
- Enter the info in the add tournament tab and press "Add Tournament"
- Add Country: Add at least 3 countries. (1 team per, 4 refs for the other)  
- Add Referee: Add referees to a country. (A match requires 4)
- Add Team: Add a team name to a country.  
- Add Players: Add players to the team you want them on. 
- Add Matches: Enter information for match then add match. Time is hh:mm  
- Then you can add referees to the match you created in the same tab.
- Add Players to match: Add the player of a team to a match. They have to  
- already be in the system, and the Match date and time have to be correct.
- Record Score: Record the score for a match that has already happened in the past.
- The match needs to be in the system and set on a day before your current day.
- **(Set the tournament to have started in the past for this)**

CLIENT STEPS:
- Upcoming Matches: Push the upcoming matches button to load all future matches
- Matches Per Day: Select a date you know has matches, and it will be displayed
- Matches Per Team: Enter the team name and press Find matches
- Match Lineups: Enter the Date and Time of a match  
**Testing Instructions are included in the app**

---------------------------------------------------------

### FOLDER STRUCTURE
- doc
  - index-files
- src
  - app
    - HelloApplication
    - ServerApplication
  - server
    - ClientWorker
    - Server
  - tournament
    - Country
    - Lineup
    - Match
    - Player
    - Referee
    - Team
    - Tournament

IMPORTANT NOTES:
- doc / index-files
  - holds the javadoc and html docs
- ServerApplication:
  - This is the main controller for the project, you will find all communication between the app and the methods here
- Server / ClientWorker:
  - You will find server / client communication here, even through we are not using the client worker on this version of the app
- Tournament:
  - This class holds the majority of the structure to the project. 
  - Methods and class manipulations happen here.
