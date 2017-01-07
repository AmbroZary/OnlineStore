package finances.domain.TransactionAggregate;

import common.Interfaces.Entity;

import java.util.Date;

public class Transaction extends Entity{

    private Order order;
    private Date transactionDate;

    public Transaction(int id, Order order, Date transactionDate) {
        super(id);
        this.order = order;
        this.transactionDate = transactionDate;
    }

    public Transaction(Order order, Date transactionDate) {
        this.order = order;
        this.transactionDate = transactionDate;
    }

    public Transaction() {
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
}
