package be.woutdev.economy.api.transaction;

/**
 * The result of a Transaction.
 *
 * @author Wout Ceulemans
 * @version 1.0
 */
public interface TransactionResult
{
    /**
     * Check if the transaction has succeeded.
     *
     * @return If the transaction is a success.
     */
    boolean isSuccess();

    /**
     * Get the status of the transaction.
     *
     * @return The status.
     * @see TransactionStatus
     */
    TransactionStatus getStatus();

    /**
     * The status of a Transaction.
     * Right after creating the Transaction the status is AWAITING_QUEUE, after submitting it's status changes into
     *   QUEUED and after processing its final status is either SUCCESS, FAILED_NOT_ENOUGH_FUNDS, FAILED_REACHED_LIMIT
     *   or CANCELLED (requires manual cancel before processing).
     *
     * @author Wout Ceulemans
     * @version 1.0
     * @see Transaction
     */
    enum TransactionStatus
    {
        /**
         * Transaction succeeded.
         */
        SUCCESS,

        /**
         * Transaction failed due not enough funds.
         */
        FAILED_NOT_ENOUGH_FUNDS,

        /**
         * Transaction failed due money limit reached.
         */
        FAILED_REACHED_LIMIT,

        /**
         * Transaction was cancelled.
         */
        CANCELLED,

        /**
         * Transaction is awaiting processing.
         */
        QUEUED,

        /**
         * Transaction is waiting to be queued.
         */
        AWAITING_QUEUE
    }
}
