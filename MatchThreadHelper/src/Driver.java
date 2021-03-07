import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;

public class Driver
{
  public static void printLine() {
    System.out.println("----------------------------------");
  }
  
  public static void printGap() {
    System.out.println();
  }
  
  public static void mapAndTeamTest(Match match) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
    Match test1 = match;
    System.out.println(test1.getMap(0).toString());
    printLine();
    System.out.println(test1.getMap(0).getTeamOne().toString());
    printLine();
    System.out.println(test1.getMap(0).getTeamTwo().toString());
    printGap();
    printGap();
    printGap();
    System.out.println(test1.getMap(1).toString());
    printLine();
    System.out.println(test1.getMap(1).getTeamOne().toString());
    printLine();
    System.out.println(test1.getMap(1).getTeamTwo().toString());
    
  }
  
  public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
    
    Event testE = new Event(77, Constants.API_TOKEN);
    testE.dump();
    
    //Match testM = new Match(1297, Constants.API_TOKEN);
    /*
    Match test2 = new Match(1343, Constants.API_TOKEN);
    mapAndTeamTest(test1);
    System.out.println(test1.toString());
    printLine();
    System.out.println(test1.getMap(0));
    printLine();
    System.out.println(test1.getMap(0).getTeamOne());
    printLine();
    System.out.println(test1.getMap(0).getTeamOne().getPlayer(0)); 
    */
    
    //Event test1 = new Event(77, Constants.API_TOKEN);
    //test1.dump();
    //System.out.println(test1.getEvent());
  }

}
