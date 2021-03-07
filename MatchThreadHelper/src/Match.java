import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.UnexpectedPage;
import com.gargoylesoftware.htmlunit.WebClient;

public class Match
{
  private int matchId;
  private int eventId;
  private int mapsPlayed;
  private ArrayList<Map> maps = new ArrayList<>();
  private String teamOne;
  private String teamTwo;
  private String winner;
  private String link;
  
  public Match(int id, String apiToken) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
    link = "https://api.vlr.gg/match/"+ id +"?token=" + apiToken;
    WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER);
    UnexpectedPage page = webClient.getPage(link);
    webClient.close();
    String raw = page.getWebResponse().getContentAsString();
    JSONObject match = new JSONObject(raw);
    infoGrab(match);
  }
  
  private void infoGrab(JSONObject match) {
    matchId = match.getJSONObject("info").getInt("match_id");
    eventId = match.getJSONObject("info").getInt("event_id");
    
    JSONArray teams = match.getJSONArray("teams");
    
    teamOne = teams.getJSONObject(0).getString("name");
    teamTwo = teams.getJSONObject(1).getString("name"); 
    mapsPlayed = teams.getJSONObject(0).getInt("maps_won") + teams.getJSONObject(1).getInt("maps_won");
    
    if (teams.getJSONObject(0).getBoolean("is_winner"))
      winner = teamOne;
    else 
      winner = teamTwo;
    
    JSONArray maps = match.getJSONArray("maps");
    
    for(int i = 0; i < maps.length(); i++) {
      if((i + 1) <= mapsPlayed)
        this.maps.add(new Map(maps.getJSONObject(i), i + 1, matchId));
    }
  }
  
  public Map getMap(int mapNumber) {
    return maps.get(mapNumber);
  }
  
  public String getVs() {
    return teamOne + " Vs. " + teamTwo;
  }

  public int getMatchId() {
    return matchId;
  }
  
  public int getEventId() {
    return eventId;
  }
  
  public String toString() {
   return "Event Id: " + eventId + "\nMatch Id: " + matchId + "\nTeams Playing: " + teamOne + " and " + teamTwo + "\nTotal Maps Played: " + mapsPlayed + "\nWinner: " + winner;
  }

}
