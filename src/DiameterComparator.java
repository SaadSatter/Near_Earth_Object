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
 * DiameterComparator would compare two NearEarthObjects based on the
 * values of their diameter member variables
 */
public class DiameterComparator implements Comparator<NearEarthObject>{

    /**
     * This compares the NearEarthObjects by Diameter
     * @param left
     *  The left object
     * @param right
     * The right object
     * @return
     *  An integer, 1 if the left is greater, -1 if the left is smaller, and
     *  0 if they are the same
     */
    public int compare(NearEarthObject left, NearEarthObject right) {
        if(left.getAverageDiameter() > right.getAverageDiameter()){
            return 1;
        }
        else if (left.getAverageDiameter() < right.getAverageDiameter()){
            return -1;
        }
        return 0;
    }
}
