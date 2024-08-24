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
}

public class Main {
    public static void main(String[] args) {

        
        Team team = new Team("Royal Challengers Bengaluru", 3);

        // Creating Player objects
        Player player1 = new Player("Virat Kohli", "Batsman", 113, 0);
        Player player2 = new Player("ABDevilliers", "Batsman", 145, 0);
        Player player3 = new Player("Chahal", "Bowler", 10, 4);
        Player player4 = new Player("Chris Gayle", "All-Rounder", 70, 2);


        // Adding players to the team (array of objects)
        team.addPlayer(player1);
        team.addPlayer(player2);
        team.addPlayer(player3);
        team.addPlayer(player4);


        // Displaying team information
        team.displayTeamInfo();
        Player.displayTotalPlayers(); 
        Team.displayTotalTeams();
    }
}
