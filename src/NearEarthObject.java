import java.util.*;
/**
 * @author Saad Satter
 * @ID: 112911362
 * @email: saad.satter@stonybrook.edu
 * @Assignment #6
 * @Class: CSE 214
 * @Recitation: R03
 * @Instructor: James Finn
 */

/**
 * This class represents a record in the database of asteroids currently
 * tracked by NASA. It should be noted that this class will always be
 * constructed by the BigData library, and serves as a data container for the
 * information that is already hosted by the NeoW API.
 */

public class NearEarthObject {
    private int referenceID;

    private String name;

    private double absoluteMagnitude;

    private double averageDiameter;

    private boolean isDangerous;

    private Date closestApproachDate;

    private double missDistance;

    private String orbitingBody;

    /**
     * @brief
     *  Default Constructor.
     * @param referenceID
     * `Unique the ID of the NEO.
     *  Fetched using the "near_earth_objects/neo_reference_id" identifier.
     * @param name
     *  Unique name of the asteroid or orbital body.
     *  Fetched using the "near_earth_objects/name" identifier.
     * @param absoluteMagnitude
     *  Absolute brightness of the asteroid or orbital body in the sky.
     *  Fetched using the "near_earth_objects/absolute_magnitude_h" identifier.
     * @param minDiameter
     *  Estimated minimum diameter of the asteroid or orbital body in
     *      kilometers. This parameter should be used in conjunction with the
     *      maxDiameter parameter to calculate and initialize the
     *      averageDiameter member variable.
     *  Fetched using the
     *  "near_earth_objects/estimated_diameter/kilometers/estimated_diameter_min"
     *      identifier.
     * @param maxDiameter
     *  Estimated maximum diameter of the asteroid or orbital body in kilometers.
     *      This parameter should be used in conjunction with the minDiameter
     *       parameter to calculate and initialize the averageDiameter member
     *       variable.
     *  Fetched using the
     *      "near_earth_objects/estimated_diameter/kilometers/
     *      estimated_diameter_max" identifier.
     * @param isDangerous
     *  Boolean value indicating whether the astroid or orbital body is a
     *      potential impact threat.
     *  Fetched using the
     *      "near_earth_objects/is_potentially_hazardous_asteroid" identifier.
     * @param closestDateTimestamp
     *  Unix timestamp representing the date of closest approach. Note that
     *      this can be used to directly construct the closestApproachDate
     *      member variable, as the Date class provides a constructor taking a
     *      timestamp as a parameter.
     *  Fetched using the
     *      "near_earth_objects/close_approach_data/epoch_date_close_approach"
     *      identifier.
     * @param missDistance
     *  Distance in kilometers at which the asteroid or orbital body will
     *      pass by the Earth on the date of it's closest approach.
     * Fetched using the "near_earth_objects/close_approach_data
     *      /miss_distance/kilometers" identifier.
     * @param orbitingBody
     *  Planet or other orbital body which this NEO orbits.
     *  Fetched using the
     *      "near_earth_objects/close_approach_data/orbiting_body" identifier.
     */
    public NearEarthObject(int referenceID, String name,
                           double absoluteMagnitude, double minDiameter,
                           double maxDiameter, boolean isDangerous,
                           long closestDateTimestamp, double missDistance,
                           String orbitingBody){
        this.referenceID = referenceID;
        int index = name.indexOf("(");
        this.name = name.substring(index);
        this.absoluteMagnitude = absoluteMagnitude;
        this.isDangerous = isDangerous;
        this.missDistance = missDistance;
        this.averageDiameter = (minDiameter + maxDiameter)/2.0;
        this.closestApproachDate= new Date(closestDateTimestamp);
        this.orbitingBody = orbitingBody;

    }

    /**
     * @brief
     *  Getter for the referenceID data field
     * @return
     *  returns the Id
     */
    public int getReferenceID() {
        return referenceID;
    }

    /**
     * @brief
     *  Getter for the name data field
     * @return
     *  returns the name
     */
    public String getName() {
        return name;
    }

    /**
     * @brief
     *  Getter for the isDangerous data field
     * @return
     *  returns a boolean of either true or false
     */
    public boolean isDangerous() {
        return isDangerous;
    }

    /**
     * @brief
     *  Getter for the closesApproachDate data field
     * @return
     *  returns the Date of the
     */
    public Date getClosestApproachDate() {
        return closestApproachDate;
    }

    /**
     * @brief
     *  Getter for the absoluteMagnitude data field
     * @return
     *  returns the absoluteMagnitude
     */
    public double getAbsoluteMagnitude() {
        return absoluteMagnitude;
    }

    /**
     * @brief
     *  Getter for the absoluteMagnitude data field
     * @return
     *  returns the absoluteMagnitude
     */
    public double getAverageDiameter() {
        return averageDiameter;
    }

    /**
     * @brief
     *  Getter for the miss distance data field
     * @return
     *  returns the miss distance
     */
    public double getMissDistance() {
        return missDistance;
    }

    /**
     * @brief
     *  Getter for the orbiting body data field
     * @return
     *  returns the orbiting body
     */
    public String getOrbitingBody() {
        return orbitingBody;
    }

    /**
     * @brief
     *  Setter for the reference id data field
     * @param referenceID
     *  the Id you want to set
     */
    public void setReferenceID(int referenceID) {
        this.referenceID = referenceID;
    }

    /**
     * @brief
     *  Setter for the name data field
     * @param name
     *  the name you want to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @brief
     *  Setter for the absoluteMagnitude data field
     * @param absoluteMagnitude
     *  the absolute magnitude you want to set
     */
    public void setAbsoluteMagnitude(double absoluteMagnitude) {
        this.absoluteMagnitude = absoluteMagnitude;
    }

    /**
     * @brief
     *  Setter for the absoluteMagnitude data field
     * @param averageDiameter
     *  the absolute magnitude you want to set
     */
    public void setAverageDiameter(double averageDiameter) {
        this.averageDiameter = averageDiameter;
    }

    /**
     * @brief
     *  Setter for the closestApproachDate data field
     * @param closestApproachDate
     *  the date you want to set
     */
    public void setClosestApproachDate(Date closestApproachDate) {
        this.closestApproachDate = closestApproachDate;
    }

    /**
     * @brief
     *  Setter for the isDangerous data field
     * @param dangerous
     *  the boolean value you want to set
     */
    public void setDangerous(boolean dangerous) {
        isDangerous = dangerous;
    }

    /**
     * @brief
     *  Setter for the missDistance data field
     * @param missDistance
     *  the distance you want to set
     */
    public void setMissDistance(double missDistance) {
        this.missDistance = missDistance;
    }

    /**
     * @brief
     *  Setter for the orbitingBody data field
     * @param orbitingBody
     *  the orbitingBody you want to set
     */
    public void setOrbitingBody(String orbitingBody) {
        this.orbitingBody = orbitingBody;
    }

}
