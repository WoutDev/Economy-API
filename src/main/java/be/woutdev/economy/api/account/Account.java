package be.woutdev.economy.api.account;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Each player has one or multiple Account(s) linked using the players unique id and account id.
 * You can fetch Account-objects for online and/or offline users in the Economy-API.
 *
 * @author Wout Ceulemans
 * @version 2.0
 */
public interface Account
{
    /**
     * Get the owner of the Account.
     *
     * @return the uuid of the owner of this account.
     */
    UUID getOwner();

    /**
     * Get the account id of this account.
     * This id should be player unique and should start from 1 for every player.
     *
     * @return The unique account id of this account.
     */
    long getId();

    /**
     * Get the balance of this Account.
     *
     * @return the balance (as a BigDecimal) of this account.
     */
    BigDecimal getBalance();

    /**
     * Check if this account belongs to the server.
     * Every server has one account which is used for administrative tasks and has unlimited balance.
     *
     * @return If this account belongs to the server.
     */
    boolean isServer();
}
