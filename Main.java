// Class for Player (Cricketer)
class Player {
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
}

// Class for Team 
class Team {
    String teamName;
    Player[] players; 
    int playerCount;

    // Constructor
    Team(String teamName, int teamSize) {
        this.teamName = teamName;
        this.players = new Player[teamSize]; 
        this.playerCount = 0;
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
}

public class Main {
    public static void main(String[] args) {

        
        Team team = new Team("Mumbai Indians", 3);

        // Creating Player objects
        Player player1 = new Player("Rohit Sharma", "Batsman", 68, 0);
        Player player2 = new Player("Hardik Pandya", "All-Rounder", 45, 2);
        Player player3 = new Player("Trent Boult", "Bowler", 10, 4);

        // Adding players to the team (array of objects)
        team.addPlayer(player1);
        team.addPlayer(player2);
        team.addPlayer(player3);

        // Displaying team information
        team.displayTeamInfo();
    }
}
