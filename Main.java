// Abstract class for Player
abstract class Player {
    static int totalPlayers = 0; 

    protected String name;
    protected String role;
    protected int runs;
    protected int wickets;

    // Parameterized Constructor
    public Player(String name, String role, int runs, int wickets) {
        this.name = name;
        this.role = role;
        this.runs = runs;
        this.wickets = wickets;
        totalPlayers++;
        System.out.println("Parameterized constructor called for " + name);
    }

    // Abstract method to be implemented by subclasses
    abstract int calculatePerformance();

    // Virtual method to display player information
    void displayInfo() {
        System.out.println("Player: " + name + ", Role: " + role + ", Runs: " + runs + ", Wickets: " + wickets + ", Performance: " + calculatePerformance());
    }

    static void displayTotalPlayers() {
        System.out.println("Total Players: " + totalPlayers);
    }
}

// Class for Batsman that extends Player
class Batsman extends Player {
    public Batsman(String name, int runs) {
        super(name, "Batsman", runs, 0);
    }

    // Implementing the abstract method for calculating performance
    @Override
    int calculatePerformance() {
        return runs * 2;
    }
}

// Class for Bowler that extends Player
class Bowler extends Player {
    public Bowler(String name, int wickets) {
        super(name, "Bowler", 0, wickets);
    }

    // Implementing the abstract method for calculating performance
    @Override
    int calculatePerformance() {
        return wickets * 10;
    }
}

// Class for All-Rounder that extends Player
class AllRounder extends Player {
    public AllRounder(String name, int runs, int wickets) {
        super(name, "All-Rounder", runs, wickets);
    }

    // Implementing the abstract method for calculating performance
    @Override
    int calculatePerformance() {
        return (runs * 2) + (wickets * 10);
    }
}

// Class for Team
class Team {
    static int totalTeams = 0; // Static variable to keep track of total teams

    private String teamName;
    private Player[] players;
    private int playerCount;

    // Constructor
    public Team(String teamName, int teamSize) {
        this.teamName = teamName;
        this.players = new Player[teamSize];
        this.playerCount = 0;
        totalTeams++;
    }

    // Accessors (Getters)
    public String getTeamName() {
        return teamName;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    // Mutators (Setters)
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    // Method to add a player to the team
    public void addPlayer(Player player) {
        if (playerCount < players.length) {
            players[playerCount] = player;
            playerCount++;
        } else {
            System.out.println("Team is full. Cannot add more players.");
        }
    }

    // Method to display team information
    public void displayTeamInfo() {
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
