package me.morphie.MorphMining.DataLog;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.morphie.MorphMining.Main;
import me.morphie.MorphMining.Station;
import me.morphie.MorphMining.DataLog.LogArtsMenu;
import net.md_5.bungee.api.ChatColor;


public class LogEvents implements Listener {
	
	private Main plugin;
	  
	public LogEvents(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if (ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Datalog")) {
			Player player = (Player)event.getWhoClicked();
			if ((event.getCurrentItem() == null) || (!event.getCurrentItem().hasItemMeta())) {
				return;
			}
			switch (event.getCurrentItem().getType()) {
			case GOLD_NUGGET:
				event.setCancelled(true);
				break;
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
				if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Information" + "&8:"))) {
					event.setCancelled(true);
					break;
				} else {
					player.closeInventory();
					new DatalogRecipe(this.plugin).openGUIDR(player);
					break;	
				}
			case FLOWER_POT:
				player.closeInventory();
				new PouchRecipe(this.plugin).openGUIPR(player);
				break;	
			case CAULDRON:
				player.closeInventory();
				new TrashRecipe(this.plugin).openGUITR(player);
				break;	
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
			if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ")) {
				event.setCancelled(true);
			}
		}
		else if (event.getInventory().getName().contains("Common Artifacts") || event.getInventory().getName().contains("Rare Artifacts") || event.getInventory().getName().contains("Legendary Artifacts") || event.getInventory().getName().contains("Mythic Artifacts") || event.getInventory().getName().contains("HellStone Artifacts")) {
			Player player = (Player)event.getWhoClicked();
			if ((event.getCurrentItem() == null) || (!event.getCurrentItem().hasItemMeta())) {
				return;
			}
			switch (event.getCurrentItem().getType()) {
			case GOLD_NUGGET:
				event.setCancelled(true);
				break;
			case FIREWORK_STAR:
				event.setCancelled(true);
				break;
			case BOOK:
				event.setCancelled(true);
				break;
			case REDSTONE: 
				player.closeInventory();
				new LogMenu(this.plugin).openGUIMineLog(player);
				break;
			}
			if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ")) {
				event.setCancelled(true);
			}
		} 
		else if (event.getInventory().getName().contains("DataLog Recipe")) {
			Player player = (Player)event.getWhoClicked();
			if ((event.getCurrentItem() == null) || (!event.getCurrentItem().hasItemMeta())) {
				return;
			}
			switch (event.getCurrentItem().getType()) {
			case LEATHER:
				event.setCancelled(true);
				break;
			case BOOK:
				event.setCancelled(true);
				break;
			case REDSTONE: 
				player.closeInventory();
				new LogMenu(this.plugin).openGUIMineLog(player);
				break;
			}
			if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ")) {
				event.setCancelled(true);
			}
		}
		else if (event.getInventory().getName().contains("Pouch Recipe")) {
			Player player = (Player)event.getWhoClicked();
			if ((event.getCurrentItem() == null) || (!event.getCurrentItem().hasItemMeta())) {
				return;
			}
			switch (event.getCurrentItem().getType()) {
			case LEATHER:
				event.setCancelled(true);
				break;
			case BOOK:
				event.setCancelled(true);
				break;
			case FLOWER_POT:
				event.setCancelled(true);
				break;
			case ENDER_CHEST:
				event.setCancelled(true);
				break;
			case ENDER_EYE:
				event.setCancelled(true);
				break;
			case REDSTONE: 
				player.closeInventory();
				new LogMenu(this.plugin).openGUIMineLog(player);
				break;
			}
			if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ")) {
				event.setCancelled(true);
			}
		}
		else if (event.getInventory().getName().contains("Trashcan Recipe")) {
			Player player = (Player)event.getWhoClicked();
			if ((event.getCurrentItem() == null) || (!event.getCurrentItem().hasItemMeta())) {
				return;
			}
			switch (event.getCurrentItem().getType()) {
			case IRON_INGOT:
				event.setCancelled(true);
				break;
			case BOOK:
				event.setCancelled(true);
				break;
			case FLOWER_POT:
				event.setCancelled(true);
				break;
			case CAULDRON:
				event.setCancelled(true);
				break;
			case LAVA_BUCKET:
				event.setCancelled(true);
				break;
			case REDSTONE: 
				player.closeInventory();
				new LogMenu(this.plugin).openGUIMineLog(player);
				break;
			}
			if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ")) {
				event.setCancelled(true);
			}
		}
	}
	
    public String Prefix() {
    	return this.plugin.messagescfg.messagesCFG.getString("Messages.Misc.Prefix");
    }
    
    public String GUIColor() {
    	return this.plugin.messagescfg.messagesCFG.getString("Messages.Misc.GUIColor");
    }
    
    public String ItemColor() {
    	return this.plugin.messagescfg.messagesCFG.getString("Messages.Misc.ItemColor");
    }
    
    public String MainColor() {
    	return this.plugin.messagescfg.messagesCFG.getString("Messages.Misc.MainColor");
    }
    
    public String TextColor() {
    	return this.plugin.messagescfg.messagesCFG.getString("Messages.Misc.TextColor");
    }
    
    public String HighlightColor() {
    	return this.plugin.messagescfg.messagesCFG.getString("Messages.Misc.HighlightColor");
    }
    
    public String ErrorPrefix() {
    	return this.plugin.messagescfg.messagesCFG.getString("Messages.ErrorMessages.Prefix");
    }
}
	    
