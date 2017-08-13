package be.woutdev.economy.api.transaction;

import java.util.function.Consumer;

/**
 * The direct result of a Transaction being applied
 *
 * Transactions are asynchronous, this class represents the state of the processing of the Transaction
 */
public interface TransactionFuture
{
    /**
     * Cancel the Transaction if it hasn't been processed yet
     *
     * @return If the cancellation of the Transaction was successful
     */
    boolean cancel();

    /**
     * Check if the Transaction is cancelled
     *
     * @return If the Transaction is cancelled
     */
    boolean isCancelled();

    /**
     * Check if the Transaction has been processed
     * Please note that this will return true if the transaction failed as well!
     *
     * @return If the Transaction has been processed
     */
    boolean isDone();

    /**
     * Check if the Transaction has been processed and succeeded
     *
     * @return If the Transaction was successful
     */
    boolean isSuccess();

    /**
     * Get the Transaction-object linked to this TransactionFuture
     *
     * @return The Transaction-object
     */
    Transaction getTransaction();

    /**
     * Get the TransactionResult-object linked to the Transaction
     *
     * @return The TransactionResult-object linked to the Transaction
     */
    TransactionResult getResult();

    /**
     * Add a consumer that will be executed once the Transaction is cancelled or processed
     *
     * @param consumer The consumer to execute
     */
    void addListener(Consumer<Transaction> consumer);
}
