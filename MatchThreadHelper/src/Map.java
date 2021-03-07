import org.json.JSONArray;
import org.json.JSONObject;

public class Map
{
  private int matchId;
  private String mapName;
  private String mapLink;
  private int mapNum;
  private Team teamOne;
  private Team teamTwo;
  private Team mapAdv;
  
  public Map(JSONObject map, int mapNum, int matchId) {
    this.mapNum = mapNum;
    this.matchId = matchId;
    
    mapName = map.getString("name"); 
    mapLink = map.getString("link");
    
    JSONArray teams = map.getJSONArray("teams");
    
    teamOne = new Team(teams.getJSONObject(0), this.matchId);
    teamTwo = new Team(teams.getJSONObject(1), this.matchId);
    
    if(teamOne.getRoundsWon() + teamTwo.getRoundsWon() == 0) {
      if(teamOne.isWinner()) {
        mapAdv = teamOne;
      } else {
        mapAdv = teamTwo;
      }
    }
    
    
  }
  
  public Team getTeamOne() {
    return teamOne;
  }
  
  public Team getTeamTwo() {
    return teamTwo;
  }
  
  public Team getMapAdv() {
    return mapAdv;
  }
  
  public String getMap() {
    return mapName;
  }
  
  public String getMapLink() {
    return mapLink;
  }
  
  public void setMatchId(int id) {
    matchId = id;
  }
  
  public String toString() {
    return "Map Link: " + mapLink + "\nMap: " + mapName + "\nMap Number: " + mapNum;
  }

}
