import java.util.ArrayList;

// Class for Player 
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

    // Method to calculate performance
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
    ArrayList<Player> players;

    // Constructor
    Team(String teamName) {
        this.teamName = teamName;
        this.players = new ArrayList<>();
    }

    // Method to add a player to the team
    void addPlayer(Player player) {
        players.add(player);
    }

    // Method to display team information
    void displayTeamInfo() {
        System.out.println("Team: " + teamName);
        for (Player player : players) {
            player.displayInfo();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating Player objects
        Player player1 = new Player("Virat Kohli", "Batsman", 175, 0);
        Player player2 = new Player("Jasprit Bumrah", "Bowler", 10, 3);

        // Creating a Team object
        Team team1 = new Team("Royal Challengers Banglore");

        // Adding players to the team
        team1.addPlayer(player1);
        team1.addPlayer(player2);

        // Displaying team information
        team1.displayTeamInfo();
    }
}
