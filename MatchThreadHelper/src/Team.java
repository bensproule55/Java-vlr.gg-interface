import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Team
{
  private int matchId;
  private int id;
  private String name;
  private String tag;
  private int roundsWon;
  private int roundsWonAtk;
  private int roundsWonDef;
  private boolean winner;
  private ArrayList<Player> players = new ArrayList<>();
  
  public Team(JSONObject team, int matchId) {
    this.matchId = matchId;
    id = team.getInt("team_id");
    name = team.getString("name");
    roundsWon = team.getInt("rounds_won");
    roundsWonAtk = team.getInt("rounds_won_atk");
    roundsWonDef = team.getInt("rounds_won_def");
    winner = team.getBoolean("is_winner");
    
    JSONArray players = team.getJSONArray("players");
    
    for(int i = 0; i < players.length(); i++) 
      this.players.add(new Player(players.getJSONObject(i), this.matchId));
  }
  
  public Player getPlayer(int i) {
    return players.get(i);
  }
  
  public int getId() {
    return id;
  }
  
  public String getName() {
    return name;
  }
  
  public String getTag() {
    return tag;
  }
  
  public int getRoundsWon() {
    return roundsWon;
  }
  
  public int getRoundsWonAtk() {
    return roundsWonAtk;
  }
  
  public int getRoundsWonDef() {
    return roundsWonDef;
  }
 
  public boolean isWinner() {
    return winner;
  }
  
  public String toString() {
    return "Team ID: " + id + "\nTeam Name: " + name + "\nRounds Won: " + roundsWon + "\nRounds Won Atk: " + roundsWonAtk + "\nRounds Won Def: " + roundsWonDef + "\nWinner: " + winner;
  }

}
