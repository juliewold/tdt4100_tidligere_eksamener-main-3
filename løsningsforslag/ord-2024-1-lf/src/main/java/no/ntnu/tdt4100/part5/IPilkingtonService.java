package no.ntnu.tdt4100.part5;

import no.ntnu.tdt4100.CarPart;

/**
 * THIS IS SUPPLIED CODE, DO NOT MODIFY
 */
public interface IPilkingtonService {

    /**
     * Sends an order to Pilkington for the given car part
     * 
     * @param part the {@link CarPart} to order from Pilkington
     * @param amount the amount to order of the given car part
     * @throws IllegalArgumentException if the given car part is not a Pilkington product
     *                                  A part is not a Pilkington product if its part name 
     *                                  does not contain the word "window"
     */
    public void sendOrder(CarPart part, int amount);
}
