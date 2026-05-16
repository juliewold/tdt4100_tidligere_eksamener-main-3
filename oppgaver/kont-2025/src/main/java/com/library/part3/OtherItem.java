package com.library.part3;

import no.library.User;

/**
 * OtherItem represent items that users can borrow for one day.
 * They cannot be reserved.
 * The type is categorized as "Other",
 * and can be different things that the library
 * does not have a systematic way of categorizing.
 * 
 * It has a description that helps to identify it. 
 */
public class OtherItem extends LibraryItem  {

    // TODO: Add necessary fields

    /**
     * Constructs an OtherItem with a description.
     *
     * @param description A brief description of the item.
     * @throws IllegalArgumentException if the description is null or empty.
     */
    public OtherItem(String description) { 
        // TODO: Complete this constructor.
        
    }

    /**
     * Describes the item.
     * @return A string description of the item.
     */
    public String getDescription() {
        // TODO: Complete this method.
        return null;
    }

    @Override
    public String getItemType() {
        // TODO: Complete this method.
        return null;
    }

    @Override
    public boolean canReserve() {
        // TODO: Complete this method.
        return false;
    }

    @Override
    public int getMaxLoanPeriod() {
        // TODO: Complete this method.
        return 0;
    }


}
