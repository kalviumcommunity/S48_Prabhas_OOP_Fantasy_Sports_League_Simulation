// Class for Player (Cricketer)
class Player {

    static int totalPlayers = 0; // Static variable to keep track of total players

    String name;
    String role;
    int runs;
    int wickets;

    // Constructor
    Player(String name, String role, int runs, int wickets) {
        this.name = name;
        this.role = role;
        this.runs = runs;
        this.wickets = wickets;
        totalPlayers++;
    }

    // Method to calculate performance based on runs and wickets
    int calculatePerformance() {
        return (runs * 2) + (wickets * 10); 
    }

    // Method to display player information
    void displayInfo() {
        System.out.println("Player: " + name + ", Role: " + role 
                           + ", Runs: " + runs + ", Wickets: " + wickets 
                           + ", Performance: " + calculatePerformance());
    }

    static void displayTotalPlayers() {
        System.out.println("Total Players: " + totalPlayers);
    }

}

// Class for Team 
class Team {
    static int totalTeams = 0; // Static variable to keep track of total teams

    String teamName;
    Player[] players; 
    int playerCount;

    // Constructor
    Team(String teamName, int teamSize) {
        this.teamName = teamName;
        this.players = new Player[teamSize]; 
        this.playerCount = 0;
        totalTeams++;
    }

    // Method to add a player to the team
    void addPlayer(Player player) {
        if (playerCount < players.length) {
            players[playerCount] = player;
            playerCount++;
        } else {
            System.out.println("Team is full. Cannot add more players.");
        }
    }

    // Method to display team information
    void displayTeamInfo() {
        System.out.println("Team: " + teamName);
        for (int i = 0; i < playerCount; i++) {
            players[i].displayInfo();
        }
    }


    static void displayTotalTeams() {
        System.out.println("Total Teams: " + totalTeams);
    }

    static void displayAllTeams(Team[] teams) {
        System.out.println("Displaying all teams:");
        for (Team team : teams) {
            team.displayTeamInfo();
        }
    }

}

public class Main {
    public static void main(String[] args) {

        
        Team team1 = new Team("Royal Challengers Bengaluru", 3);
        Team team2 = new Team("Mumbai Indians", 3);

        // Creating Player objects
        Player player1 = new Player("Virat Kohli", "Batsman", 113, 0);
        Player player2 = new Player("ABDevilliers", "Batsman", 145, 0);
        Player player3 = new Player("Chahal", "Bowler", 10, 4);


        // Adding players to the team (array of objects)
        team1.addPlayer(player1);
        team1.addPlayer(player2);
        team1.addPlayer(player3);

        Player player4 = new Player("Rohit Sharma", "Batsman", 68, 0);
        Player player5 = new Player("Hardik Pandya", "All-Rounder", 45, 2);
        Player player6 = new Player("Trent Boult", "Bowler", 10, 4);

        team2.addPlayer(player4);
        team2.addPlayer(player5);
        team2.addPlayer(player6);


        // Displaying static information
        Player.displayTotalPlayers(); 
        Team.displayTotalTeams();

         // Displaying information of all teams using static method
         Team[] teams = {team1, team2};
         Team.displayAllTeams(teams);
    }
}
