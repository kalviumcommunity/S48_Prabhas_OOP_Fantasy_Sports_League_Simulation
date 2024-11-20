// Abstract Class Player
 abstract class Player {
    private String name;
    private String role;

    // Static field to track total players
    private static int totalPlayers = 0;

    public Player(String name, String role) {
        this.name = name;
        this.role = role;
        totalPlayers++;
    }

    public abstract double calculatePerformance();

    public void displayInfo() {
        System.out.println("Player: " + name + ", Role: " + role + ", Performance: " + calculatePerformance());
    }

    public static void displayTotalPlayers() {
        System.out.println("Total Players: " + totalPlayers);
    }

    public String getName() {
        return name;
    }
}

// Subclass Batsman
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

// Subclass Bowler
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

// Subclass AllRounder
class AllRounder extends Player {
    private int runs;
    private int wickets;

    public AllRounder(String name, int runs, int wickets) {
        super(name, "All-Rounder");
        this.runs = runs;
        this.wickets = wickets;
    }

    @Override
    public double calculatePerformance() {
        return (runs * 1.2) + (wickets * 2.5);
    }
}

// Class Team
class Team {
    private String teamName;
    private Player[] players;
    private int playerCount;

    // Static field to track total teams
    private static int totalTeams = 0;

    public Team(String teamName, int maxPlayers) {
        this.teamName = teamName;
        this.players = new Player[maxPlayers];
        this.playerCount = 0;
        totalTeams++;
    }

    public void addPlayer(Player player) {
        if (playerCount < players.length) {
            players[playerCount++] = player;
        } else {
            System.out.println("Team " + teamName + " is full.");
        }
    }

    public void displayTeamInfo() {
        System.out.println("Team: " + teamName);
        for (int i = 0; i < playerCount; i++) {
            players[i].displayInfo();
        }
    }

    public static void displayTotalTeams() {
        System.out.println("Total Teams: " + totalTeams);
    }

    public static void displayAllTeams(Team[] teams) {
        System.out.println("\nDisplaying Information of All Teams:");
        for (Team team : teams) {
            team.displayTeamInfo();
            System.out.println();
        }
    }
}

// Main Class
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
        Team.displayTotalTeams();

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
