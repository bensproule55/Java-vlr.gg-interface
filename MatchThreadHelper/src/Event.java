import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.UnexpectedPage;
import com.gargoylesoftware.htmlunit.WebClient;

public class Event
{
  private String link;
  private HashMap<Integer, Match> matches = new HashMap<>();
  private ArrayList<Match> matchLists = new ArrayList<>();
  private ArrayList<Integer> ids = new ArrayList<>();
  private String series;
  private String subseries;
  
  public Event(int eventID, String apiToken) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
    link = "https://api.vlr.gg/matchlist/"+ eventID +"?token=" + apiToken;
    WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER);
    UnexpectedPage page = webClient.getPage(link);
    webClient.close();
    String raw = page.getWebResponse().getContentAsString();
    JSONArray event = new JSONArray(raw);
    for(int i = 0; i < event.length(); i++) {
      int id = event.getJSONObject(i).getInt("match_id");
      ids.add(id);
      Match match = new Match(id, Constants.API_TOKEN);
      matches.put(id, match);
    }
  }
  
  public Match getMatch(int id) {
    return matches.get(id);
  }
 
  public void dump() {
    matchLists.addAll(matches.values());
    for(int i = 0; i < matchLists.size(); i++) {
      System.out.println(matchLists.get(i).getMatchId() + " " + matchLists.get(i).getVs());
    }
  }
  
  public ArrayList getIds() {
    return ids;
  }
  
  public JSONObject getEvent() {
    return null;
  }

}
