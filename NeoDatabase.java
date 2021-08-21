import big.data.DataSource;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.net.URL;
import java.io.*;
import org.json.*;


public class NeoDatabase {
    public static final String API_KEY = "mCwy7NxRWorSYW51aBcJ097M4EeRITZOid6DP89P";
    public static final String API_ROOT = "https://api.nasa.gov/neo/rest/v1/neo/browse?";
    private ArrayList<NearEarthObject> array;

    /**
     * default empty constructor of NeoDatabase
     */
    public NeoDatabase() {
        this.array = new ArrayList<NearEarthObject>();
    }

    /**
     * builds a queryURL
     * @param pageNumber
     * @return String of the query
     * @throws IllegalArgumentException
     */
    public String buildQueryURL(int pageNumber) throws IllegalArgumentException {
        if (pageNumber < 0 || pageNumber > 715) {
            throw new IllegalArgumentException();
        }
        return API_ROOT + "page=" + pageNumber + "&api_key=" + API_KEY;
    }

    /**
     * accesses the information & append everything into a arraylist
     * @param queryURL
     * @throws IllegalArgumentException
     */
    public void addAll(String queryURL)
            throws IllegalArgumentException {

        if (queryURL == null) {
            throw new IllegalArgumentException();
        }
        String req = queryURL;

        try {
            URL getRequest = new URL(req); //Creates a URL object from the URL string
            JSONTokener tokener = new JSONTokener(getRequest.openStream());
            JSONObject root = new JSONObject(tokener);
            JSONArray n = root.getJSONArray("near_earth_objects");

            for (int i = 0; i < n.length(); i++) {
                JSONObject currn = (JSONObject) n.get(i);

                int referenceID = currn.getInt("neo_reference_id");
                String name = currn.getString("name");
                double absoluteMagnitude = currn.getDouble("absolute_magnitude_h");
                boolean isDangerous = currn.getBoolean("is_potentially_hazardous_asteroid");

                JSONObject closeApproachData = (JSONObject) currn.getJSONArray("close_approach_data").get(0);
                long closestDateTimestamp = closeApproachData.getLong("epoch_date_close_approach");
                String orbitingBody = closeApproachData.getString("orbiting_body");

                // Fetched using the
                // "near_earth_objects/estimated_diameter/kilometers/estimated_diameter_max" identifier.
                JSONObject estimatedDiameter = (JSONObject) currn.getJSONObject("estimated_diameter");
                JSONObject kilometers = (JSONObject) estimatedDiameter.getJSONObject("kilometers");
                double minDiameter = kilometers.optDouble("estimated_diameter_min");
                double maxDiameter = kilometers.optDouble("estimated_diameter_max");

                JSONObject missDistance = closeApproachData.getJSONObject("miss_distance");
                double k = missDistance.getDouble("kilometers");

                NearEarthObject newEarth = new NearEarthObject(
                        referenceID, name,
                        absoluteMagnitude, minDiameter,
                        maxDiameter, isDangerous,
                        closestDateTimestamp, k,
                        orbitingBody);
                array.add(newEarth);
            }
        } catch (IOException ex) {
            // todo
            // "could not be resolved by server"
            System.out.println(ex.getMessage());
            throw new IllegalArgumentException("The Website could not be Resolved by the server");
        } catch (JSONException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * sort Database based on intended Comparator
     * @param comp
     * @throws IllegalArgumentException
     */
    public void sort(Comparator<NearEarthObject> comp)
            throws IllegalArgumentException, EmptyArrayException {
        if (comp == null) {
            throw new IllegalArgumentException("The comparator is null");
        }

        if (array.isEmpty()) {
            throw new EmptyArrayException();
        }

    Collections.sort(array, comp);
    }

    /**
     * prints the table
     * @return Table
     */
    public void printTable() {
        System.out.println("     ID   |              Name            | Mag. | Diameter | Danger |         Close Date         |       Miss Dist       | Orbits\n" +
                "==================================================================================================================================================");
        for(NearEarthObject planet : array) {
            System.out.println(planet);
        }
    }
}
