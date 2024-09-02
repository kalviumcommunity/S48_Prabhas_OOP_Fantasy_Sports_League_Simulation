// Class for Player (Cricketer)
class Player {

    static int totalPlayers = 0; // Static variable to keep track of total players

    private String name; 
    private String role;  
    private int runs;     
    private int wickets;  


    // Default constructor (no parameters)
    public Player() {
        this.name = "Unknown";
        this.role = "Unknown";
        this.runs = 0;
        this.wickets = 0;
        System.out.println("Default constructor called");
    }

    // Parameterized  Constructor
    Player(String name, String role, int runs, int wickets) {
        this.name = name;
        this.role = role;
        this.runs = runs;
        this.wickets = wickets;
        totalPlayers++;
        System.out.println("Parameterized constructor called for " + name);

    }

    // Accessors (Getters)
    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public int getRuns() {
        return runs;
    }

    public int getWickets() {
        return wickets;
    }

    // Mutators (Setters)
    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public void setWickets(int wickets) {
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

    static void displayTotalPlayers() {
        System.out.println("Total Players: " + totalPlayers);
    }

}

// Class for Team 
class Team {
    static int totalTeams = 0; // Static variable to keep track of total teams

    private String teamName;   
    private Player[] players;  
    private int playerCount;


    // Constructor
    Team(String teamName, int teamSize) {
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

          // Using default constructor
        Player player8 = new Player();
        player8.displayInfo();



        System.out.println("\nUpdating Hardik Pandya's runs...");
        player2.setRuns(50); // Modifying runs using setter
        player1.displayInfo();
        player2.displayInfo(); // Display updated info
    }
}
