package be.woutdev.economy.api.account;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Each player has one Account linked to their account using the players unique id
 *
 * You can fetch Account-objects for online and/or offline users in the EconomyAPI. Accounts will be automatically
 *   cached.
 */
public interface Account
{
    /**
     * Get the owner of the Account
     *
     * @return the uuid of the owner of this account
     */
    UUID getOwner();

    /**
     * Get the balance of this Account
     *
     * @return the balance (as a BigDecimal) of this account
     */
    BigDecimal getBalance();

    /**
     * Check if this account belongs to the server
     *
     * @return If this account belongs to the server
     */
    boolean isServer();
}
