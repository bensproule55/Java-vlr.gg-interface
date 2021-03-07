import org.json.JSONException;

@SuppressWarnings("serial")
public class NullAttributeException extends JSONException
{
  public NullAttributeException(String attribute, String player, int matchId, Throwable err) {
    super(attribute + " was null for " + player + " in match: " + matchId, err);
  }

}
