import org.json.JSONObject;

public class Player
{
  private int matchId;
  private int id;
  private String alias;
  private String country;
  private String pageLink;
  private String agent;
  private int kills;
  private int deaths;
  private int assists;
  private int combatScore;
  private int econRating;
  
  public Player(JSONObject player, int matchId) throws NullAttributeException {
    this.matchId = matchId;
    id = player.getInt("player_id");
    alias = player.getString("alias");
    country = player.getString("country");
    pageLink = "https://www.vlr.gg/player/" + id + "/" + alias;
    JSONObject stats = player.getJSONObject("stats");
    try {
      agent = stats.getString("agent");
    } catch (Exception E) {
      System.out.println(new NullAttributeException("Agent", alias, this.matchId, E));
    }
    try {
      kills = stats.getInt("kills");
    } catch (Exception E) {
      System.out.println(new NullAttributeException("Kills", alias, this.matchId, E));
    }
    try {
      deaths = stats.getInt("deaths");
    } catch (Exception E) {
      System.out.println(new NullAttributeException("Deaths", alias, this.matchId, E));
    }
    try {
      assists = stats.getInt("assists");
    } catch (Exception E) {
      System.out.println(new NullAttributeException("Assits", alias, this.matchId, E));
    }
    try {
      combatScore = stats.getInt("combat_score");
    } catch (Exception E) {
      System.out.println(new NullAttributeException("Combat Score", alias, this.matchId, E));
    }
    try {
      econRating = stats.getInt("econ_rating");
    } catch (Exception E) {
      System.out.println(new NullAttributeException("Econ Rating", alias, this.matchId, E));
    }
    
    
  }
  
  public int getPlayerId() {
    return id;
  }
  
  public String getAlias() {
    return alias;
  }
  
  public String getCountry() {
    return country;
  }
  
  public String getPageLink() {
    return pageLink;
  }
  
  public String getAgent() {
    return agent;
  }
  
  public int getKills() {
    return kills;
  }
  
  public int getDeaths() {
    return deaths;
  }
  
  public int getAssists() {
    return assists;
  }
  
  public int getCombatScore() {
    return combatScore;
  }
  
  public int getEconRating() {
    return econRating;
  }
  
  public String toString() {
    return "Player ID: " + id + "\nAlias: " + alias + "\nVLR.gg Page: " + pageLink + "\nAgent: "
        + agent + "\nCombat Score: " + combatScore + "\nEcon Rating: " + econRating + "\nKills: "
        + kills + "\nDeaths: "+ deaths + "\nAssists: " + assists;
  }

}
