package Components;

import java.time.LocalDateTime;

public class Transaction implements Comparable<Transaction> {
    private final User user;              // User of the transaction
    private final Bus ticket;             // Bus (ticket) of the transaction
    private final LocalDateTime date;     // Date of the transaction

    public Transaction(User user, Bus ticket) {
        this.user = user;
        this.ticket = ticket;
        this.date = LocalDateTime.now();
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

    @Override
    public int compareTo(Transaction transaction) {
        return getDate().compareTo(transaction.getDate());
    }
}


