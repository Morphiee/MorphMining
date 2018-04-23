package me.morphie.MorphMining.Shop;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.morphie.MorphMining.Main;
import me.morphie.MorphMining.Station;
import net.md_5.bungee.api.ChatColor;

public class ShopEvents implements Listener {
	
	private Main plugin;
	  
	public ShopEvents(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if (ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Mining Shop")) {
			Player player = (Player)event.getWhoClicked();
			if ((event.getCurrentItem() == null) || (!event.getCurrentItem().hasItemMeta())) {
				return;
			}
			switch (event.getCurrentItem().getType()) {
			case PAPER:
				event.setCancelled(true);
				break;
			case ARROW: 
				player.closeInventory();
				new Station(this.plugin).openGUIMining(player);
				break;
			case BOOK:
				event.setCancelled(true);
				break;
			}
			if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ")) {
				event.setCancelled(true);
				
			}
		}
	}
	
	@EventHandler
	public void onShopClose(InventoryCloseEvent event) {
		if (ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Mining Shop")) {
			Inventory inv = event.getInventory();
			Player player = (Player)event.getPlayer();
			
			int Artifacts = 0;
			int Money = 0;
			
			double CommonPrice = this.plugin.getConfig().getDouble("ArtifactPrice.Common");
			double RarePrice = this.plugin.getConfig().getDouble("ArtifactPrice.Rare");
			double LegendaryPrice = this.plugin.getConfig().getDouble("ArtifactPrice.Legendary");
			double MythicPrice = this.plugin.getConfig().getDouble("ArtifactPrice.Mythic");
			
			for (int i = 8; i <= 41; i++) {
				ItemStack item = inv.getItem(i);
				if (item != null) {
					if (item.hasItemMeta()) {
						int x = item.getAmount();
						while (x > 0) {
							
							x--;
							
							if (item.getItemMeta().getDisplayName().contains(ChatColor.stripColor("Common Artifact"))) {
				                  Main.econ.depositPlayer(player, CommonPrice);
				                  Artifacts++;
				                  Money = (int)(Money + CommonPrice);
							}
							else if (item.getItemMeta().getDisplayName().contains(ChatColor.stripColor("Rare Artifact"))) {
				                  Main.econ.depositPlayer(player, RarePrice);
				                  Artifacts++;
				                  Money = (int)(Money + RarePrice);
							}
							else if (item.getItemMeta().getDisplayName().contains(ChatColor.stripColor("Legendary Artifact"))) {
				                  Main.econ.depositPlayer(player, LegendaryPrice);
				                  Artifacts++;
				                  Money = (int)(Money + LegendaryPrice);
							}
							else if (item.getItemMeta().getDisplayName().contains(ChatColor.stripColor("Mythic Artifact"))) {
				                  Main.econ.depositPlayer(player, MythicPrice);
				                  Artifacts++;
				                  Money = (int)(Money + MythicPrice);
							}
						}
					}
			        else if ((!item.hasItemMeta()) || (!item.getItemMeta().hasDisplayName()) || (!item.getItemMeta().getDisplayName().equals(ChatColor.RED + "" + ChatColor.BOLD + "Information"))) {
			        	player.getInventory().addItem(new ItemStack[] { item });
			        }
				}
			}
			if ((Money != 0) && (Artifacts != 0)) {
				player.sendMessage(ChatColor.DARK_RED + "" + "Mining" + ChatColor.DARK_GRAY + ChatColor.BOLD + " >> " + ChatColor.GRAY + "You got " + ChatColor.RED + "$" + Money + ChatColor.GRAY + " from " + ChatColor.RED + Artifacts + ChatColor.GRAY + " artifacts!");
			}
		}	
	}
}
