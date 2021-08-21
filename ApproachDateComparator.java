import java.util.Date;
public class ApproachDateComparator implements java.util.Comparator<NearEarthObject> {

    /**
     * compares the two nearEarthObject based on intended Comparator configuration
     * @param left
     * @param right
     * @return 0, -1, or 1 depending on situation
     */
    public int compare(NearEarthObject left, NearEarthObject right) {
        if (left.getClosestApproachDate() == right.getClosestApproachDate()) {
            return 0;
        } else if (left.getClosestApproachDate().before(right.getClosestApproachDate())) {
            return -1;
        } else {
            return 1;
        }

    }
}