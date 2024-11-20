import java.util.ArrayList;

// Abstract Player class
abstract class Player {
    private String name;
    private String role;
    private static int totalPlayers = 0;

    public Player(String name, String role) {
        this.name = name;
        this.role = role;
        totalPlayers++;
    }

    // Abstract method for calculating performance, to be implemented by subclasses
    public abstract double calculatePerformance();

    // Display player information
    public void displayInfo() {
        System.out.println(role + ": " + name);
    }

    // Static method to display total players
    public static void displayTotalPlayers() {
        System.out.println("Total Players: " + totalPlayers);
    }
}

// Batsman class extends Player
class Batsman extends Player {
    private int runs;

    public Batsman(String name, int runs) {
        super(name, "Batsman");
        this.runs = runs;
    }

    @Override
    public double calculatePerformance() {
        return runs * 1.5;
    }
}

// Bowler class extends Player
class Bowler extends Player {
    private int wickets;

    public Bowler(String name, int wickets) {
        super(name, "Bowler");
        this.wickets = wickets;
    }

    @Override
    public double calculatePerformance() {
        return wickets * 2.0;
    }
}

// AllRounder class extends Player
class AllRounder extends Player {
    private int runs;
    private int wickets;

    public AllRounder(String name, int runs, int wickets) {
        super(name, "AllRounder");
        this.runs = runs;
        this.wickets = wickets;
    }

    @Override
    public double calculatePerformance() {
        return (runs * 1.5) + (wickets * 2.0);
    }
}

// Team class to manage players
class Team {
    private String teamName;
    private int maxPlayers;
    private ArrayList<Player> players;

    public Team(String teamName, int maxPlayers) {
        this.teamName = teamName;
        this.maxPlayers = maxPlayers;
        this.players = new ArrayList<>();
    }

    // Add player to the team
    public void addPlayer(Player player) {
        if (players.size() < maxPlayers) {
            players.add(player);
        } else {
            System.out.println("Cannot add more players to the team.");
        }
    }

    // Display team information and player performance
    public void displayTeamInfo() {
        System.out.println("Team: " + teamName);
        for (Player player : players) {
            player.displayInfo();
            System.out.println("Performance: " + player.calculatePerformance());
        }
    }

    // Static method to display all teams
    public static void displayAllTeams(Team[] teams) {
        for (Team team : teams) {
            team.displayTeamInfo();
        }
    }

    // Static method to display total teams
    public static void displayTotalTeams(Team[] teams) {
        System.out.println("Total Teams: " + teams.length);
    }
}

// Main class to test the implementation
public class Main {
    public static void main(String[] args) {

        // Creating two teams
        Team team1 = new Team("Royal Challengers Bengaluru", 3);
        Team team2 = new Team("Mumbai Indians", 3);

        // Creating Player objects with inheritance
        Player player1 = new Batsman("Virat Kohli", 113);
        Player player2 = new Batsman("AB de Villiers", 145);
        Player player3 = new Bowler("Yuzvendra Chahal", 4);

        Player player4 = new Batsman("Rohit Sharma", 68);
        Player player5 = new AllRounder("Hardik Pandya", 45, 2);
        Player player6 = new Bowler("Trent Boult", 4);

        // Adding players to the teams
        team1.addPlayer(player1);
        team1.addPlayer(player2);
        team1.addPlayer(player3);

        team2.addPlayer(player4);
        team2.addPlayer(player5);
        team2.addPlayer(player6);

        // Displaying static information
        Player.displayTotalPlayers();
        Team.displayTotalTeams(new Team[]{team1, team2});

        // Displaying information of all teams using static method
        Team[] teams = {team1, team2};
        Team.displayAllTeams(teams);

        // Demonstrate abstract class and virtual function
        System.out.println("\nDemonstrating Abstract Class and Virtual Function:");
        Player player7 = new Batsman("Shikhar Dhawan", 100);
        Player player8 = new Bowler("Rashid Khan", 5);

        player7.displayInfo();
        player8.displayInfo();
    }
}
