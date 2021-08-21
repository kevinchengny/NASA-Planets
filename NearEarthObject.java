import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DecimalFormat;

public class NearEarthObject {
    DecimalFormat decimal = new DecimalFormat("#.###");
    private int referenceID;
    private String name;
    private double absoluteMagnitude;
    private double averageDiameter;
    private boolean isDangerous;
    private Date closestApproachDate;
    private double missDistance;
    private String orbitingBody;

    /**
     * constructor for NearEarthObjects
     * @param referenceID
     * @param name
     * @param absoluteMagnitude
     * @param minDiameter
     * @param maxDiameter
     * @param isDangerous
     * @param closestDateTimestamp
     * @param missDistance
     * @param orbitingBody
     */
    public NearEarthObject(
            int referenceID, String name,
            double absoluteMagnitude, double minDiameter,
            double maxDiameter, boolean isDangerous,
            long closestDateTimestamp, double missDistance,
            String orbitingBody) {
        this.referenceID = referenceID;
        this.name = name;
        this.absoluteMagnitude = absoluteMagnitude;
        this.averageDiameter =
                Double.parseDouble(decimal.format((minDiameter + maxDiameter)/2));
        this.isDangerous = isDangerous;
        this.closestApproachDate = new Date(closestDateTimestamp);
        this.missDistance = missDistance;
        this.orbitingBody = orbitingBody;
    }

    /**
     * returns Reference ID
     * @return reference ID
     */
    public int getReferenceID() {
        return referenceID;
    }

    /**
     * sets reference ID
     * @param referenceID
     */
    public void setReferenceID(int referenceID) {
        this.referenceID = referenceID;
    }

    /**
     * gets name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * sets name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets absolute magnitude
     * @return absoluteMagnitude
     */
    public double getAbsoluteMagnitude() {
        return absoluteMagnitude;
    }

    /**
     * set absolute Magnitude
     * @param absoluteMagnitude
     */
    public void setAbsoluteMagnitude(double absoluteMagnitude) {
        this.absoluteMagnitude = absoluteMagnitude;
    }

    /**
     * gets average Diameter
     * @return averageDiameter
     */
    public double getAverageDiameter() {
        return averageDiameter;
    }

    /**
     * sets average Diameter
     * @param averageDiameter
     */
    public void setAverageDiameter(double averageDiameter) {
        this.averageDiameter = averageDiameter;
    }

    /**
     * returns is dangerous
     * @return isDangerous boolean
     */
    public boolean isDangerous() {
        return isDangerous;
    }

    /**
     * sets dangerous level
     * @param dangerous
     */
    public void setDangerous(boolean dangerous) {
        isDangerous = dangerous;
    }

    /**
     * gets closest approach date
     * @return closestApproachDate
     */
    public Date getClosestApproachDate() {
        return closestApproachDate;
    }

    /**
     * sets closest Approach Date
     * @param closestApproachDate
     */
    public void setClosestApproachDate(Date closestApproachDate) {
        this.closestApproachDate = closestApproachDate;
    }

    /**
     * gets miss Distance
     * @return missDistance
     */
    public double getMissDistance() {
        return missDistance;
    }

    /**
     * sets Miss Distance
     * @param missDistance
     */
    public void setMissDistance(double missDistance) {
        this.missDistance = missDistance;
    }

    /**
     * gets orbiting Body
     * @return orbitingBody
     */
    public String getOrbitingBody() {
        return orbitingBody;
    }

    /**
     * sets orbiting body
     * @param orbitingBody
     */
    public void setOrbitingBody(String orbitingBody) {
        this.orbitingBody = orbitingBody;
    }

    /**
     * returns String representation of NearEarthObject
     * @return String
     */
    @Override
    public String toString() {
        return String.format("%-12d%-30s%-8s%-11s%-9s%-32s%-25s%-10s",
                this.referenceID, this.name,
                this.absoluteMagnitude, this.averageDiameter,
                this.isDangerous, this.closestApproachDate,
                this.missDistance, this.orbitingBody);
    }
}

// todo
// approach date not work

