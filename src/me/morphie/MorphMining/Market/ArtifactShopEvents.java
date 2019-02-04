package me.morphie.MorphMining.Market;

import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.morphie.MorphMining.Main;
import me.morphie.MorphMining.Station;
import me.morphie.MorphMining.Files.playerFileMethods;
import net.md_5.bungee.api.ChatColor;

public class ArtifactShopEvents implements Listener {
	
	private Main plugin;
	  
	public ArtifactShopEvents(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if (ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Artifact Shop")) {
			Player player = (Player)event.getWhoClicked();
			if ((event.getCurrentItem() == null) || (!event.getCurrentItem().hasItemMeta())) {
				return;
			}
			switch (event.getCurrentItem().getType()) {
			case MAP:
				event.setCancelled(true);
				break;
			case REDSTONE: 
				player.closeInventory();
				new Market(this.plugin).openGUIMarket(player);
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
  public void onShopClose(InventoryCloseEvent event)
  {
    if (ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Artifact Shop"))
    {
      Inventory inv = event.getInventory();
      Player player = (Player)event.getPlayer();
      UUID uuid = player.getUniqueId();
      
      int Artifacts = 0;
      int Money = 0;
      
      double CommonPrice = this.plugin.getConfig().getDouble("ArtifactPrice.Common");
      double RarePrice = this.plugin.getConfig().getDouble("ArtifactPrice.Rare");
      double LegendaryPrice = this.plugin.getConfig().getDouble("ArtifactPrice.Legendary");
      double MythicPrice = this.plugin.getConfig().getDouble("ArtifactPrice.Mythic");
      double HellStonePrice = this.plugin.getConfig().getDouble("ArtifactPrice.HellStone");
      for (int i = 8; i <= 41; i++) {
        ItemStack item = inv.getItem(i);
        if (item != null) {
        	if (item.hasItemMeta()) {
  	          if (item.getType() == Material.GOLD_NUGGET || item.getType() == Material.FIREWORK_STAR) {
	            int x = item.getAmount();
	            while (x > 0) {
	              x--;
	              if (item.getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "Tier &8» &7Common")) || item.getItemMeta().getDisplayName().contains(ChatColor.GRAY + "" + ChatColor.BOLD + "Common Artifact")) {
	                Main.econ.depositPlayer(player, CommonPrice);
					new playerFileMethods(this.plugin).addMoney(player, uuid, "Stats.MoneyEarned", CommonPrice);
	                Artifacts++;
	                Money = (int)(Money + CommonPrice);
	              }
	              else if (item.getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "Tier &8» &7Rare")) || item.getItemMeta().getDisplayName().contains(ChatColor.AQUA + "" + ChatColor.BOLD + "Rare Artifact")) {
	                Main.econ.depositPlayer(player, RarePrice);
	                new playerFileMethods(this.plugin).addMoney(player, uuid, "Stats.MoneyEarned", RarePrice);
	                Artifacts++;
	                Money = (int)(Money + RarePrice);
	              }
	              else if (item.getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "Tier &8» &7Legendary")) || item.getItemMeta().getDisplayName().contains(ChatColor.GOLD + "" + ChatColor.BOLD + "Legendary Artifact")) {
	                Main.econ.depositPlayer(player, LegendaryPrice);
	                new playerFileMethods(this.plugin).addMoney(player, uuid, "Stats.MoneyEarned", LegendaryPrice);
	                Artifacts++;
	                Money = (int)(Money + LegendaryPrice);
	              }
	              else if (item.getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "Tier &8» &7Mythic")) || item.getItemMeta().getDisplayName().contains(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Mythic Artifact")) {
	                Main.econ.depositPlayer(player, MythicPrice);
	                new playerFileMethods(this.plugin).addMoney(player, uuid, "Stats.MoneyEarned", MythicPrice);
	                Artifacts++;
	                Money = (int)(Money + MythicPrice);
	              }
	              else if (item.getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "Tier &8» &7HellStone"))) {
		                Main.econ.depositPlayer(player, HellStonePrice);
		                new playerFileMethods(this.plugin).addMoney(player, uuid, "Stats.MoneyEarned", HellStonePrice);
		                Artifacts++;
		                Money = (int)(Money + HellStonePrice);
		              }
	            }
	          }
        	}
        	else if ((!item.hasItemMeta()) || (!item.getItemMeta().hasDisplayName()) || (!item.getItemMeta().getDisplayName().equals(ChatColor.RED + "" + ChatColor.BOLD + "Information"))) {
        		player.getInventory().addItem(new ItemStack[] { item });
        	}
          }
      	}
      	if ((Money != 0) && (Artifacts != 0)) {
      		player.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix() + ChatColor.GRAY + " You got " + HighlightColor() + "$" + Money + ChatColor.GRAY + " from " + HighlightColor() + Artifacts + ChatColor.GRAY + " artifacts!"));
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
