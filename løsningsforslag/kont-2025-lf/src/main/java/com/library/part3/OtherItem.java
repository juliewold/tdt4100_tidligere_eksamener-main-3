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

    // TODO: Add any necessary fields you need here
    private String description;

    /**
     * Constructs an OtherItem with a description.
     *
     * @param description A brief description of the item.
     * @throws IllegalArgumentException if the description is null or empty.
     */
    public OtherItem(String description) {
        // TODO: Complete this constructor.
        super();
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty");
        }
        this.description = description;
    }

    /**
     * Describes the item.
     * @return A string description of the item.
     */
    public String getDescription() {
        return description;
    }

    @Override
    public String getItemType() {
        // TODO: Complete this method.
        return "Other";
    }

    @Override
    public boolean canReserve() {
        // TODO: Complete this method.
        return false; // OtherItems cannot be reserved
    }

    @Override
    public int getMaxLoanPeriod() {
        // TODO: Complete this method.
        return 1; // Other items can only be borrowed for one day
    }


}
