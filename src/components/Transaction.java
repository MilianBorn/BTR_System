package components;

import java.time.LocalDateTime;

public class Transaction implements Comparable<Transaction> {
    private final boolean isBooking;      // indicates if booking or cancellation
    private final User user;              // User of the transaction
    private final Bus ticket;             // Bus (ticket) of the transaction
    private final LocalDateTime date;     // Date of the transaction

    public Transaction(User user, Bus ticket, Boolean isBooking) {
        this.user = user;
        this.ticket = ticket;
        this.isBooking = isBooking;
        this.date = LocalDateTime.now();
    }

    // getters
    public String getType() {
        if (isBooking) {
            return "\u001B[32m" + "New booking" + "\u001B[0m"; // print in green
        } else {
            return "\u001B[31m" + "Cancellation" + "\u001B[0m"; // print in red
        }
    }
    public User getUser() {
        return user;
    }
    public Bus getTicket() {
        return ticket;
    }
    public LocalDateTime getDate() {
        return date;
    }

    @Override // makes transactions comparable by date
    public int compareTo(Transaction transaction) {
        return getDate().compareTo(transaction.getDate());
    }
}


