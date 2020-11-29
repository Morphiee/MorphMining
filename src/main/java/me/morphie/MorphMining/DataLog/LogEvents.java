package me.morphie.MorphMining.DataLog;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.morphie.MorphMining.Station;
import me.morphie.MorphMining.DataLog.LogArtsMenu;
import net.md_5.bungee.api.ChatColor;
import me.morphie.MorphMining.Main;


public class LogEvents implements Listener {
	
	private Main plugin;
	  
	public LogEvents(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if (ChatColor.stripColor(event.getView().getTitle()).equalsIgnoreCase("Datalog")) {
			Player player = (Player)event.getWhoClicked();
			Material Artifact = Material.matchMaterial(this.plugin.getConfig().getString("Settings.ArtifactItem"));
			if ((event.getCurrentItem() == null) || (!event.getCurrentItem().hasItemMeta())) {
				return;
			}
			switch (event.getCurrentItem().getType()) {
			case SUGAR:
				event.setCancelled(true);
				break;
			case CRAFTING_TABLE:
				event.setCancelled(true);
				break;
			case STRUCTURE_VOID:
				event.setCancelled(true);
				break;
			case BOOK:
				if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Information" + this.plugin.getMessage("Menus.SpacerColor") + ":"))) {
					event.setCancelled(true);
					break;
				}
			case BRICK:
				player.closeInventory();
				new LogArtsMenu(this.plugin).openArtTierMenu(player, "Common");
				break;
			case IRON_INGOT:
				player.closeInventory();
				new LogArtsMenu(this.plugin).openArtTierMenu(player, "Rare");
				break;
			case GOLD_INGOT:
				player.closeInventory();
				new LogArtsMenu(this.plugin).openArtTierMenu(player, "Legendary");
				break;
			case DIAMOND:
				player.closeInventory();
				new LogArtsMenu(this.plugin).openArtTierMenu(player, "Mythic");
				break;
			case NETHER_BRICK:
				player.closeInventory();
				new LogArtsMenu(this.plugin).openArtTierMenu(player, "HellStone");
				break;
			case REDSTONE: 
				player.closeInventory();
				new Station(this.plugin).openGUIMining(player);
				break;
			}
			if (event.getCurrentItem().getType().equals(Material.matchMaterial(this.plugin.getConfig().getString("Settings.ArtifactItem")))) {
				event.setCancelled(true);
			}
			if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ")) {
				event.setCancelled(true);
			}
		}
		else if (ChatColor.stripColor(event.getView().getTitle()).contains("Common Artifacts") || event.getView().getTitle().contains("Rare Artifacts") || event.getView().getTitle().contains("Legendary Artifacts") || event.getView().getTitle().contains("Mythic Artifacts") || event.getView().getTitle().contains("HellStone Artifacts")) {
			Player player = (Player)event.getWhoClicked();
			if ((event.getCurrentItem() == null) || (!event.getCurrentItem().hasItemMeta())) {
				return;
			}
			switch (event.getCurrentItem().getType()) {
			case BOOK:
				event.setCancelled(true);
				break;
			case REDSTONE: 
				player.closeInventory();
				new LogMenu(this.plugin).openGUIMineLog(player);
				break;
			}
			if (event.getCurrentItem().getType().equals(Material.matchMaterial(this.plugin.getConfig().getString("Settings.ArtifactItem")))) {
				event.setCancelled(true);
			}
			if (event.getCurrentItem().getType().equals(Material.matchMaterial(this.plugin.getConfig().getString("Settings.HellstoneItem")))) {
				event.setCancelled(true);
			}
			if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ")) {
				event.setCancelled(true);
			}
		}
	}
}
	    
