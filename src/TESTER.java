import javax.sql.DataSource;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.net.URL;
import java.io.*;
public class TESTER {
    public static void main(String[] args){
        String req = NeoDatabase.API_ROOT + "page=" + 1 + "&api_key" +
                "=" + NeoDatabase.API_KEY;
        NeoDatabase list = new NeoDatabase();
        try {
            URL getRequest = new URL(req); //Creates a URL object from the URL string
            JSONTokener tokener = new JSONTokener(getRequest.openStream());
            JSONObject root = new JSONObject(tokener);
            JSONArray json = root.getJSONArray("near_earth_objects");
            ArrayList<JSONObject> myArrayList = new ArrayList<>();
            for(int i = 0; i < json.length(); i++) {
                myArrayList.add(json.getJSONObject(i));
            }
            String referenceID = "";
            String name = "";
            double absoluteMagnitude = 0, minDiameter = 0, maxDiameter = 0;
            boolean isDangerous;
            long closestDateTimestamp = 0;
            double missDistance = 0;
            String orbitingBody = "";
            for(int i = 0; i < myArrayList.size(); i++){
                referenceID = myArrayList.get(i).getString("neo_reference_id");
                name = myArrayList.get(i).getString("name");
                absoluteMagnitude = myArrayList.get(i).getDouble(
                        "absolute_magnitude_h");
                minDiameter = myArrayList.get(i).getJSONObject(
                        "estimated_diameter").getJSONObject("kilometers").getDouble("estimated_diameter_min");
                maxDiameter = myArrayList.get(i).getJSONObject(
                        "estimated_diameter").getJSONObject("kilometers").getDouble("estimated_diameter_max");
                isDangerous = myArrayList.get(i).getBoolean(
                        "is_potentially_hazardous_asteroid");
                ArrayList<JSONObject> bodies = new ArrayList<>();
                for(int j = 0; j < myArrayList.get(i).getJSONArray(
                        "close_approach_data").length(); j++){
                    bodies.add(myArrayList.get(i).getJSONArray(
                            "close_approach_data").getJSONObject(j));
                }
                for(int j = 0; j < bodies.size(); j++){
                    orbitingBody = bodies.get(j).getString("orbiting_body");
                    missDistance = bodies.get(j).getJSONObject("miss_distance").getDouble("kilometers");
                    closestDateTimestamp = bodies.get(j).getLong(
                            "epoch_date_close_approach");
                    int id = Integer.parseInt(referenceID);
                    NearEarthObject neo = new NearEarthObject(id,name,
                            absoluteMagnitude,minDiameter,maxDiameter,isDangerous
                            ,closestDateTimestamp,missDistance,orbitingBody);
                    list.add(neo);
                }


            }
            list.printTable();
        } catch(IOException ex) {
            System.out.println("Issue encountered");
        } catch(JSONException ex) {
            System.out.println("JSON Issue encountered");
        }
    }
}
