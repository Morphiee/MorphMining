package me.morphie.MorphMining.MineLog;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.morphie.MorphMining.Main;
import me.morphie.MorphMining.Station;
import me.morphie.MorphMining.MineLog.LogArtsMenu;
import net.md_5.bungee.api.ChatColor;


public class LogEvents implements Listener {
	
	private Main plugin;
	  
	public LogEvents(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if (ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Miner's Log")) {
			Player player = (Player)event.getWhoClicked();
			if ((event.getCurrentItem() == null) || (!event.getCurrentItem().hasItemMeta())) {
				return;
			}
			switch (event.getCurrentItem().getType()) {
			case GOLD_NUGGET:
				player.closeInventory();
				new LogArtsMenu(this.plugin).openGUIArtsLog(player);
				break;
			case PISTON_BASE:
				event.setCancelled(true);
				new LogCrateMenu(this.plugin).openGUICrateLog(player);
				break;
			case END_CRYSTAL:
				event.setCancelled(true);
				break;
			case BONE:
				event.setCancelled(true);
				break;
			case BARRIER:
				event.setCancelled(true);
				break;
			case ARROW: 
				player.closeInventory();
				new Station(this.plugin).openGUIMining(player);
				break;
			}
			if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ")) {
				event.setCancelled(true);
			}
		}
		else if (ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Miner's Log: Artifacts")) {
			Player player = (Player)event.getWhoClicked();
			if ((event.getCurrentItem() == null) || (!event.getCurrentItem().hasItemMeta())) {
				return;
			}
			switch (event.getCurrentItem().getType()) {
			case GOLD_NUGGET:
				event.setCancelled(true);
				break;
			case BOOK:
				event.setCancelled(true);
				break;
			case ARROW: 
				player.closeInventory();
				new LogMenu(this.plugin).openGUIMineLog(player);
				break;
			}
			if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ")) {
				event.setCancelled(true);
			}
		}
		else if (ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Miner's Log: Crates")) {
			Player player = (Player)event.getWhoClicked();
			if ((event.getCurrentItem() == null) || (!event.getCurrentItem().hasItemMeta())) {
				return;
			}
			switch (event.getCurrentItem().getType()) {
			case PISTON_BASE:
				event.setCancelled(true);
				break;
			case BOOK:
				event.setCancelled(true);
				break;
			case ARROW: 
				player.closeInventory();
				new LogMenu(this.plugin).openGUIMineLog(player);
				break;
			}
			if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ")) {
				event.setCancelled(true);
			}
		}
	}
}
	    
