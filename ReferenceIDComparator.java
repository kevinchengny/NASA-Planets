import java.util.Comparator;

public class ReferenceIDComparator implements java.util.Comparator<NearEarthObject> {

    /**
     * compares the two nearEarthObject based on intended Comparator configuration
     * @param left
     * @param right
     * @return 0, -1, or 1 depending on situtaion
     */
    public int compare(NearEarthObject left, NearEarthObject right) {
        if (left.getReferenceID() == right.getReferenceID()) {
            return 0;
        } else if (left.getReferenceID() < right.getReferenceID()) {
            return -1;
        } else {
            return 1;
        }
    }
}