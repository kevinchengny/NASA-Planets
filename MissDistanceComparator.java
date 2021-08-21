public class MissDistanceComparator implements java.util.Comparator<NearEarthObject> {

    /**
     * compares the two nearEarthObject based on intended Comparator configuration
     * @param left
     * @param right
     * @return 0, -1, or 1 depending on situtaion
     */
    public int compare(NearEarthObject left, NearEarthObject right) {
        if (left.getMissDistance() == right.getMissDistance()) {
            return 0;
        } else if (left.getMissDistance() < right.getMissDistance()) {
            return -1;
        } else {
            return 1;
        }
    }
}