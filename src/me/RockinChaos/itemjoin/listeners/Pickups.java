/*
 * ItemJoin
 * Copyright (C) CraftationGaming <https://www.craftationgaming.com/>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package me.RockinChaos.itemjoin.listeners;

import me.RockinChaos.itemjoin.handlers.ConfigHandler;
import me.RockinChaos.itemjoin.handlers.PlayerHandler;
import me.RockinChaos.itemjoin.utils.Utils;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;

public class Pickups implements Listener {

   /**
	* Prevents the player from picking up all items.
	* 
	* @param event - EntityPickupItemEvent
	*/
	@EventHandler(ignoreCancelled = true)
	private void onGlobalPickup(EntityPickupItemEvent event) {
	  	Entity entity = event.getEntity();
	  	if (entity instanceof Player) {
	  		Player player = (Player) event.getEntity();
	  		if (Utils.getUtils().containsIgnoreCase(ConfigHandler.getConfig().getPrevent("Pickups"), "TRUE") || Utils.getUtils().containsIgnoreCase(ConfigHandler.getConfig().getPrevent("Pickups"), player.getWorld().getName())
	  			|| Utils.getUtils().containsIgnoreCase(ConfigHandler.getConfig().getPrevent("Pickups"), "ALL") || Utils.getUtils().containsIgnoreCase(ConfigHandler.getConfig().getPrevent("Pickups"), "GLOBAL")) {
	  			if (ConfigHandler.getConfig().isPreventOP() && player.isOp() || ConfigHandler.getConfig().isPreventCreative() && PlayerHandler.getPlayer().isCreativeMode(player)) { } 
	  			else { event.setCancelled(true); }
	  		}
	  	}
	}
}