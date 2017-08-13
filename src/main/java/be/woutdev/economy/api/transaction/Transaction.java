package be.woutdev.economy.api.transaction;

import be.woutdev.economy.api.account.Account;
import java.math.BigDecimal;

/**
 * An economic transaction between two parties
 */
public interface Transaction {
    /**
     * Get the recipient of the transaction
     *
     * @return The account of the recipient
     */
    Account getRecipient();

    /**
     * Get the sender of the transaction
     *
     * @return The account of the sender
     */
    Account getSender();

    /**
     * The type of transaction, either DEPOSIT or WITHDRAW
     * If the type is DEPOSIT, the 'sender deposits money to the recipient'
     * If the type is WITHDRAW, the 'sender withdraws money from the recipient'
     *
     * @return The type of transaction
     */
    TransactionType getType();

    /**
     * The amount of money (in BigDecimal) to be transacted
     *
     * @return The amount in BigDecimal
     */
    BigDecimal getAmount();

    /**
     * The result of the transaction
     *
     * @return The result
     * @see TransactionResult
     */
    TransactionResult getResult();
}
