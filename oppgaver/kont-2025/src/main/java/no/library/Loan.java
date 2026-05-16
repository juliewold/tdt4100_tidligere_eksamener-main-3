package no.library;

import java.time.LocalDate;

import com.library.part3.LibraryItem;

/**
 * Hjelpeklasse for å representere et lån i biblioteksystemet.
 * IKKE ENDRE DENNE KLASSEN - DEN ER EN DEL AV EKSAMEN-RAMMEVERKET
 */
public class Loan {
    private final String userId;
    private final LibraryItem item;
    private final LocalDate loanDate;
    private final LocalDate expectedReturn;
    private LocalDate actualReturn;

    public Loan(String brukerId, LibraryItem item, LocalDate laanDato, int laanePeriodeDager) {
        if (brukerId == null || item == null || laanDato == null) {
            throw new IllegalArgumentException("UserId, item and loan date cannot be null");
        }
        if (laanePeriodeDager <= 0) {
            throw new IllegalArgumentException("Loan period must be positive");
        }

        this.userId = brukerId;
        this.item = item;
        this.loanDate = laanDato;
        this.expectedReturn = laanDato.plusDays(laanePeriodeDager);
        this.actualReturn = null;
    }

    public String getUserId() { return userId; }
    public LibraryItem getItem() { return item; }
    public LocalDate getLoanDate() { return loanDate; }
    public LocalDate getExpectedReturn() { return expectedReturn; }
    public LocalDate getActualReturn() { return actualReturn; }
    
    public boolean isReturned() {
        return actualReturn != null;
    }
    
    public void returnLoan(LocalDate returnDate) {
        if (returnDate == null) {
            throw new IllegalArgumentException("Returdato kan ikke være null");
        }
        if (returnDate.isBefore(loanDate)) {
            throw new IllegalArgumentException("Returdato kan ikke være før lånedato");
        }
        this.actualReturn = returnDate;
    }
    
    public boolean isOverdue(LocalDate dato) {
        return !isReturned() && dato.isAfter(expectedReturn);
    }
    
    public long daysDelayed(LocalDate dato) {
        if (!isOverdue(dato)) {
            return 0;
        }
        return dato.toEpochDay() - expectedReturn.toEpochDay();
    }

    @Override
    public String toString() {
        return String.format("Loan: %s to %s (from %s to %s)%s", 
            item.toString(), userId, loanDate, expectedReturn,
            isReturned() ? " - Returned " + actualReturn : "");
    }
}
