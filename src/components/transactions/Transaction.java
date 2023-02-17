package components.transactions;

import components.Bus;
import components.User;

import java.time.LocalDateTime;

public abstract class Transaction implements Comparable<Transaction> { // superclass of cancellations and bookings
    private final User user;              // User of the transaction
    private final Bus ticket;             // Bus (ticket) of the transaction
    private final LocalDateTime date;     // Date of the transaction

    public Transaction(User user, Bus ticket) {
        this.user = user;
        this.ticket = ticket;
        this.date = LocalDateTime.now();
    }

    // getters
    @ Override
    public abstract String toString();
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


