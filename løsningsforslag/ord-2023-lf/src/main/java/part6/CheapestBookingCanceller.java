package part6;

import java.util.List;

import part1.Aircraft;
import part3.Flight;
import part4.Booking;
import shared.BookingCanceller;
import shared.BookingClasses;
import shared.IBooking;
import shared.Passenger;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

// A class that implements the booking canceller interface
// This class cancels the bookings that have the lowest price
public class CheapestBookingCanceller implements BookingCanceller {

  /**
   * Cancel the number of bookings with the lowest price
   * @param bookings the list of bookings to cancel from
   * @param numberToCancel the number of bookings to cancel, can be assumed to be larger than 0
   */
  public void cancelBookings(List<IBooking> bookings, int numberToCancel) {
    // Sort the list of bookings by their price in ascending order
    Collections.sort(bookings, new Comparator<IBooking>() {
      public int compare(IBooking b1, IBooking b2) {
        return Double.compare(b1.getPrice(), b2.getPrice());
      }
    });
    // Loop through the first numberToCancel elements of the list
    for (int i = 0; i < numberToCancel && i < bookings.size(); i++) {
      // Get the booking at this index
      IBooking b = bookings.get(i);
      // Cancel the booking
      b.cancelBooking();
    }
  }
}