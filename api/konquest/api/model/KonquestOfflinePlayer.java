package konquest.api.model;

import org.bukkit.OfflinePlayer;


/**
 * Represents an offline player in Konquest.
 * This interface wraps around Bukkit's OfflinePlayer interface.
 * 
 * @author Rumsfield
 *
 */
public interface KonquestOfflinePlayer {

	/**
	 * Get the OfflinePlayer instance represented by this object.
	 * 
	 * @return The offline player
	 */
	public OfflinePlayer getOfflineBukkitPlayer();
	
	/**
	 * Get the player's current kingdom.
	 * 
	 * @return The current kingdom
	 */
	public KonquestKingdom getKingdom();
	
	/**
	 * Get the player's exile kingdom. This is the previous kingdom that the player was a member of.
	 * 
	 * @return The exile kingdom
	 */
	public KonquestKingdom getExileKingdom();
	
	/**
	 * Get whether the player is a barbarian.
	 * 
	 * @return True when the player is a barbarian, else false
	 */
	public boolean isBarbarian();
	
}
