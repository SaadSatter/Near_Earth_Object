import javax.sql.DataSource;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.net.URL;
import java.io.*;

/**
 * @author Saad Satter
 */

/**
 * NeoViewer which allows a user to view datasets obtained from the NASA NeoW
 * API. This class contain a main() method which creates a database
 * and prompts the user to add a page to the database, sort the current
 * database, and display the database.
 */
public class NeoViewer {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        String command = "";
        System.out.println("Welcome to NEO Viewer!");
        NeoDatabase database = new NeoDatabase();
        while(!(command.equals("Q"))){
            System.out.println("  Option Menu:\n" +
                    "    A) Add a page to the database\n" +
                    "    S) Sort the database \n" +
                    "    P) Print the database as a table.\n" +
                    "    Q) Quit\n");
            System.out.print("Select a menu option: ");
            command = stdin.nextLine().toUpperCase();
            switch(command){
                case "A":{
                    System.out.print("Enter the page to load: ");
                    database.addAll(database.buildQueryURL(stdin.nextInt()));
                    System.out.println("Page Loaded");
                    stdin.nextLine();
                }break;
                case "S":{
                    System.out.println("  R) Sort by referenceID\n" +
                            "  D) Sort by diameter\n" +
                            "  A) Sort by approach date\n" +
                            "  M) Sort by miss distance\n");
                    System.out.print("Select a menu option: ");
                    switch(stdin.nextLine().toUpperCase()){
                        case "R": {
                            database.sort(new ReferenceIDComparator());
                        }break;
                        case "D":{
                            database.sort(new DiameterComparator());
                        }break;
                        case "A":{
                            database.sort(new ApproachDateComparator());
                        }break;
                        case "M":{
                            database.sort(new MissDistanceComparator());
                        }break;
                        default:{
                            System.out.println("Incorrect command");
                        }break;
                    }
                }break;
                case "P":{
                    database.printTable();
                }break;
                case "Q":{
                    boolean isBreak = true;
                }break;
                default: {
                    System.out.println("Invalid Command");
                }break;
            }
            System.out.println();
        }
    }
}
