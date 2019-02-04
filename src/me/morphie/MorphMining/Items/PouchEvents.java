package me.morphie.MorphMining.Items;

import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.morphie.MorphMining.Main;
import me.morphie.MorphMining.Files.playerFileMethods;
import net.md_5.bungee.api.ChatColor;

public class PouchEvents implements Listener {
	
	private Main plugin;
	  
	public PouchEvents(Main plugin) {
		this.plugin = plugin;
	}
	
    @EventHandler
    public void onPouchClick(PlayerInteractEvent event) {
        final Player player = event.getPlayer();
        if (event.getAction() == null) {
          return;
        }
        if (event.getItem() == null) {
          return;
        }
        if (((event.getAction().equals(Action.RIGHT_CLICK_AIR)) || (event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) && (event.getItem().getType().equals(Material.FLOWER_POT)) && (event.getItem().hasItemMeta())) {
            ItemStack item2 = event.getItem();
            if (item2.getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Miner's Pouch"))) {
            	event.setCancelled(true);
            	new Pouch(this.plugin).openGUIPouch(player);
            } else if (item2.getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', this.MainColor() + "MorphMining"))) {
            	event.setCancelled(true);
            	new Pouch(this.plugin).openGUIPouch(player);
            }
        }
    }
    
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if (ChatColor.stripColor(event.getInventory().getName()).contains("Pouch: ")) {
			Player player = (Player)event.getWhoClicked();
			UUID uuid = player.getUniqueId();
			int Gems = new playerFileMethods(this.plugin).getStat(uuid, "Stats.Gems");
			double bal = Main.econ.getBalance(player);
			if ((event.getCurrentItem() == null) || (!event.getCurrentItem().hasItemMeta())) {
				return;
			}
			switch (event.getCurrentItem().getType()) {
			case WHITE_STAINED_GLASS_PANE:
				if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Common Capacity Upgrade"))) {
					if(Gems >= this.plugin.getConfig().getInt("Pouches.Common.GemCost")) {
						if(bal >= this.plugin.getConfig().getDouble("Pouches.Common.CurrencyCost")) {
							new playerFileMethods(this.plugin).removeInt(player, uuid, "Stats.Gems", this.plugin.getConfig().getInt("Pouches.Common.GemCost"));
							Main.econ.withdrawPlayer(player, this.plugin.getConfig().getDouble("Pouches.Common.CurrencyCost"));
							new playerFileMethods(this.plugin).setBoolean(player, uuid, "Pouch.CommonUpgrade", true);
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix() + TextColor() + " Upgrade succesfully purchased!"));
							new Pouch(this.plugin).openGUIPouch(player);
						} else {
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', ErrorPrefix() + HighlightColor() + " Insufficient funds!"));
						}
					} else {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', ErrorPrefix() + HighlightColor() + " Insufficient gems!"));
					}
				} else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Rare Capacity Upgrade"))) {
					if(Gems >= this.plugin.getConfig().getInt("Pouches.Rare.GemCost")) {
						if(bal >= this.plugin.getConfig().getDouble("Pouches.Rare.CurrencyCost")) {
							new playerFileMethods(this.plugin).removeInt(player, uuid, "Stats.Gems", this.plugin.getConfig().getInt("Pouches.Rare.GemCost"));
							Main.econ.withdrawPlayer(player, this.plugin.getConfig().getDouble("Pouches.Rare.CurrencyCost"));
							new playerFileMethods(this.plugin).setBoolean(player, uuid, "Pouch.RareUpgrade", true);
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix() + TextColor() + " Upgrade succesfully purchased!"));
							new Pouch(this.plugin).openGUIPouch(player);
						} else {
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', ErrorPrefix() + HighlightColor() + " Insufficient funds!"));
						}
					} else {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', ErrorPrefix() + HighlightColor() + " Insufficient gems!"));
					}
				} else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Legendary Capacity Upgrade"))) {
					if(Gems >= this.plugin.getConfig().getInt("Pouches.Legendary.GemCost")) {
						if(bal >= this.plugin.getConfig().getDouble("Pouches.Legendary.CurrencyCost")) {
							new playerFileMethods(this.plugin).removeInt(player, uuid, "Stats.Gems", this.plugin.getConfig().getInt("Pouches.Legendary.GemCost"));
							Main.econ.withdrawPlayer(player, this.plugin.getConfig().getDouble("Pouches.Legendary.CurrencyCost"));
							new playerFileMethods(this.plugin).setBoolean(player, uuid, "Pouch.LegendaryUpgrade", true);
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix() + TextColor() + " Upgrade succesfully purchased!"));
							new Pouch(this.plugin).openGUIPouch(player);
						} else {
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', ErrorPrefix() + HighlightColor() + " Insufficient funds!"));
						}
					} else {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', ErrorPrefix() + HighlightColor() + " Insufficient gems!"));
					}
				} else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Mythic Capacity Upgrade"))) {
					if(Gems >= this.plugin.getConfig().getInt("Pouches.Mythic.GemCost")) {
						if(bal >= this.plugin.getConfig().getDouble("Pouches.Mythic.CurrencyCost")) {
							new playerFileMethods(this.plugin).removeInt(player, uuid, "Stats.Gems", this.plugin.getConfig().getInt("Pouches.Mythic.GemCost"));
							Main.econ.withdrawPlayer(player, this.plugin.getConfig().getDouble("Pouches.Mythic.CurrencyCost"));
							new playerFileMethods(this.plugin).setBoolean(player, uuid, "Pouch.MythicUpgrade", true);
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', Prefix() + TextColor() + " Upgrade succesfully purchased!"));
							new Pouch(this.plugin).openGUIPouch(player);
						} else {
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', ErrorPrefix() + HighlightColor() + " Insufficient funds!"));
						}
					} else {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', ErrorPrefix() + HighlightColor() + " Insufficient gems!"));
					}
				}
			case RED_STAINED_GLASS_PANE:
				new playerFileMethods(this.plugin).setBoolean(player, uuid, "Pouch.Enabled", true);
				new Pouch(this.plugin).openGUIPouch(player);
				break;
			case LIME_STAINED_GLASS_PANE:
				new playerFileMethods(this.plugin).setBoolean(player, uuid, "Pouch.Enabled", false);
				new Pouch(this.plugin).openGUIPouch(player);
				break;
			case BRICK:
				event.setCancelled(true);
				break;
			case IRON_INGOT:
				event.setCancelled(true);
				break;
			case GOLD_INGOT:
				event.setCancelled(true);
				break;
			case DIAMOND:
				event.setCancelled(true);
				break;
			case EMERALD:
				event.setCancelled(true);
				break;
			case STRUCTURE_VOID:
				event.setCancelled(true);
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
