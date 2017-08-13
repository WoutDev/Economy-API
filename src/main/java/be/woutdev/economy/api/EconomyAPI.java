package be.woutdev.economy.api;

import be.woutdev.economy.api.account.Account;
import be.woutdev.economy.api.transaction.Transaction;
import be.woutdev.economy.api.transaction.TransactionFuture;
import be.woutdev.economy.api.transaction.TransactionType;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;
import org.bukkit.entity.Player;

/**
 * Use this to access all Economy API points, such as fetching Accounts and general Account information or create
 *   and submit Transactions
 *
 * @author Wout Ceulemans
 */
public abstract class EconomyAPI
{
    private static EconomyAPI api;

    /**
     * Get a players balance
     * The balance will be fetched from a cache, no database queries will be used
     *
     * @param p The online player
     * @return The players balance as a BigDecimal
     */
    public abstract BigDecimal getBalance(Player p);

    /**
     * Get a offline players balance
     * The balance will be fetched from a database and might block until it has its result or null
     *
     * @param uuid The offline players uuid
     * @return The offline players balance wrapped in an optional, being null if the player is not in the database
     */
    public abstract Optional<BigDecimal> getBalance(UUID uuid);

    /**
     * Get a players account
     *
     * @param p The online player
     * @return The players Account
     */
    public abstract Account getAccount(Player p);

    /**
     * Get a offline players account
     * The account -might- be fetched from the database and might block until it has its result or null
     * After one successful retrieval, the account will be cached and automatically retrieved instead using the cache
     *
     * @param uuid The offline players uuid
     * @return The offline players uuid wrapped in an optional, being null if the player is not in the database
     */
    public abstract Optional<Account> getAccount(UUID uuid);

    /**
     * Format the specified BigDecimal in the correct format, including the currency-sign, etc.
     *
     * @param amount The BigDecimal amount to format
     * @return A formatted string
     */
    public abstract String format(BigDecimal amount);

    /**
     * Transact the specified Transaction
     *
     * @param transaction The transaction
     * @return The result of the transaction, wrapped in a TransactionFuture
     */
    public abstract TransactionFuture transact(Transaction transaction);

    /**
     * Create a simple Transaction between a sender and recipient
     *
     * @param sender The sender of the Transaction
     * @param recipient The recipient of the Transaction
     * @param amount The amount to transfer from the sender to the recipient
     * @return The Transaction-object ready to be transferred
     */
    public abstract Transaction createTransaction(Account sender, Account recipient, BigDecimal amount);

    /**
     * Create a simple Transaction between the server and recipient
     *
     * @param recipient The recipient of the Transaction
     * @param type The type of transaction, being either WITHDRAW or DEPOSIT
     * @param amount The amount to transfer to/from the server's unlimited funds to/from the recipient
     * @return The Transaction-object ready to be transferred
     */
    public abstract Transaction createTransaction(Account recipient, TransactionType type, BigDecimal amount);

    /**
     * Get the EconomyAPI that should be automatically set by an implementation
     *
     * @return An EconomyAPI implementation or null if it hasn't been set
     */
    public static EconomyAPI getAPI()
    {
        return api;
    }

    /**
     * Set the EconomyAPI instance
     * Can only be set once!
     *
     * @param api The EconomyAPI implementation
     */
    public static void setAPI(EconomyAPI api)
    {
        if (EconomyAPI.api != null)
            throw new RuntimeException("Cannot change effectively final EconomyAPI instance!");

        EconomyAPI.api = api;
    }
}
