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
 * ApproachDateComparator would compare two NearEarthObjects based on the
 * values of their date member variables
 */
public class ApproachDateComparator implements Comparator<NearEarthObject>{

    /**
     * This compares the NearEarthObjects by their Date by using the
     * compareTo function in the Date class
     * @param left
     *  The left object
     * @param right
     * The right object
     * @return
     *  An integer, 1 if the left is greater, -1 if the left is smaller, and
     *  0 if they are the same
     */
    public int compare(NearEarthObject left, NearEarthObject right) {
        return (left.getClosestApproachDate().compareTo(right.getClosestApproachDate()));
    }
}
