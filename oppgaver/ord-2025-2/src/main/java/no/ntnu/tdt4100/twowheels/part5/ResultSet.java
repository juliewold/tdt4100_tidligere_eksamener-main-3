/**
 * THIS IS SUPPLIED CODE - DO NOT MODIFY THE CODE BELOW
 * 
 */

package no.ntnu.tdt4100.twowheels.part5;

import java.util.List;

import no.ntnu.tdt4100.twowheels.BikeComponent;
import no.ntnu.tdt4100.twowheels.IBikeComponent;

/**
 * The <code>ResultSet</code> class contains a list of {@link BikeComponent}
 * objects, and a list of line numbers for errors.
 */

public record ResultSet(List<IBikeComponent> components, List<Integer> linesWithErrors) {
}
