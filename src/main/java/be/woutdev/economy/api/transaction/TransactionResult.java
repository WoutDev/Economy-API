package be.woutdev.economy.api.transaction;

/**
 * The result of an Transaction
 */
public interface TransactionResult
{
    /**
     * Check if the transaction has succeeded
     *
     * @return If succeeded
     */
    boolean isSuccess();

    /**
     * Check what the status is of the transaction
     *
     * @return The status
     */
    TransactionStatus getStatus();

    /**
     * The status of a Transaction
     * Right after creating the Transaction the status is AWAITING_QUEUE, after submitting it's status changes into
     *   QUEUED and after processing its final status is either SUCCESS, FAILED_NOT_ENOUGH_FUNDS, FAILED_REACHED_LIMIT
     *   or CANCELLED (requires manual cancel before processing)
     *
     * @see Transaction
     */
    enum TransactionStatus
    {
        /**
         * Transaction succeeded
         */
        SUCCESS,

        /**
         * Transaction failed due not enough funds
         */
        FAILED_NOT_ENOUGH_FUNDS,

        /**
         * Transaction failed due money limit reached
         */
        FAILED_REACHED_LIMIT,

        /**
         * Transaction is cancelled
         */
        CANCELLED,

        /**
         * Transaction is awaiting processing
         */
        QUEUED,

        /**
         * Transaction is waiting to be queued
         */
        AWAITING_QUEUE
    }
}
