package no.ntnu.tdt4100.part5;

import java.util.Map;

import no.ntnu.tdt4100.CarPart;
/**
 * A car unit that consists of a map of car parts and the amount of parts, a model name and a vin
 * The map of parts is used to keep track of the parts that are used to produce the car unit
 * The key of the map is the part and the value is the amount of that part that is used to manufacture
 * this car unit
 * 
 * THIS IS SUPPLIED CODE, DO NOT EDIT THIS CODE
 * 
 * @param parts a {@link Map} of car parts and the amount of parts necessary for production of this unit
 * @param modelName the model name of the car unit
 * @param vin the vin of the car unit
 */
public record CarUnit(Map<CarPart, Integer> parts, String modelName, String vin) {}
