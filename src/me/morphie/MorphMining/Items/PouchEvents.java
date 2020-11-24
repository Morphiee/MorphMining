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

import me.morphie.MorphMining.Files.playerFileMethods;
import net.md_5.bungee.api.ChatColor;
import me.morphie.MorphMining.Main;

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
            if (ChatColor.stripColor(item2.getItemMeta().getDisplayName()).equals("Miner's Pouch") && ChatColor.stripColor(item2.getItemMeta().getLore().get(6)).equals("MorphMining")) {
            	event.setCancelled(true);
            	new Pouch(this.plugin).openGUIPouch(player);
            }
        }
    }
    
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if (ChatColor.stripColor(event.getView().getTitle()).contains("Pouch: ")) {
			Player player = (Player)event.getWhoClicked();
			UUID uuid = player.getUniqueId();
			int Gems = new playerFileMethods(this.plugin).getStat(uuid, "Stats.Gems");
			double bal = Main.econ.getBalance(player);
			if ((event.getCurrentItem() == null) || (!event.getCurrentItem().hasItemMeta())) {
				return;
			}
			switch (event.getCurrentItem().getType()) {
			case WHITE_STAINED_GLASS_PANE:
				event.setCancelled(true);
				if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Common Capacity Upgrade"))) {
					if(Gems >= this.plugin.getConfig().getInt("Pouches.Common.GemCost")) {
						if(bal >= this.plugin.getConfig().getDouble("Pouches.Common.CurrencyCost")) {
							new playerFileMethods(this.plugin).removeInt(player, uuid, "Stats.Gems", this.plugin.getConfig().getInt("Pouches.Common.GemCost"));
							Main.econ.withdrawPlayer(player, this.plugin.getConfig().getDouble("Pouches.Common.CurrencyCost"));
							new playerFileMethods(this.plugin).setBoolean(player, uuid, "Pouch.CommonUpgrade", true);
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Prefix") + this.plugin.getMessage("Pouch.UpgradeMessage")));
							new Pouch(this.plugin).openGUIPouch(player);
							break;
						} else {
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("InvalidFunds")));
							break;
						}
					} else {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("InvalidGems")));
						break;
					}
				} else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Rare Capacity Upgrade"))) {
					if(Gems >= this.plugin.getConfig().getInt("Pouches.Rare.GemCost")) {
						if(bal >= this.plugin.getConfig().getDouble("Pouches.Rare.CurrencyCost")) {
							new playerFileMethods(this.plugin).removeInt(player, uuid, "Stats.Gems", this.plugin.getConfig().getInt("Pouches.Rare.GemCost"));
							Main.econ.withdrawPlayer(player, this.plugin.getConfig().getDouble("Pouches.Rare.CurrencyCost"));
							new playerFileMethods(this.plugin).setBoolean(player, uuid, "Pouch.RareUpgrade", true);
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Prefix") + this.plugin.getMessage("Pouch.UpgradeMessage")));
							new Pouch(this.plugin).openGUIPouch(player);
							break;
						} else {
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("InvalidFunds")));
							break;
						}
					} else {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("InvalidGems")));
						break;
					}
				} else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Legendary Capacity Upgrade"))) {
					if(Gems >= this.plugin.getConfig().getInt("Pouches.Legendary.GemCost")) {
						if(bal >= this.plugin.getConfig().getDouble("Pouches.Legendary.CurrencyCost")) {
							new playerFileMethods(this.plugin).removeInt(player, uuid, "Stats.Gems", this.plugin.getConfig().getInt("Pouches.Legendary.GemCost"));
							Main.econ.withdrawPlayer(player, this.plugin.getConfig().getDouble("Pouches.Legendary.CurrencyCost"));
							new playerFileMethods(this.plugin).setBoolean(player, uuid, "Pouch.LegendaryUpgrade", true);
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Prefix") + this.plugin.getMessage("Pouch.UpgradeMessage")));
							new Pouch(this.plugin).openGUIPouch(player);
							break;
						} else {
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("InvalidFunds")));
							break;
						}
					} else {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("InvalidGems")));
						break;
					}
				} else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Mythic Capacity Upgrade"))) {
					if(Gems >= this.plugin.getConfig().getInt("Pouches.Mythic.GemCost")) {
						if(bal >= this.plugin.getConfig().getDouble("Pouches.Mythic.CurrencyCost")) {
							new playerFileMethods(this.plugin).removeInt(player, uuid, "Stats.Gems", this.plugin.getConfig().getInt("Pouches.Mythic.GemCost"));
							Main.econ.withdrawPlayer(player, this.plugin.getConfig().getDouble("Pouches.Mythic.CurrencyCost"));
							new playerFileMethods(this.plugin).setBoolean(player, uuid, "Pouch.MythicUpgrade", true);
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Prefix") + this.plugin.getMessage("Pouch.UpgradeMessage")));
							new Pouch(this.plugin).openGUIPouch(player);
							break;
						} else {
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("InvalidFunds")));
							break;
						}
					} else {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("InvalidGems")));
						break;
					}
				}
				break;
			case EMERALD:
				event.setCancelled(true);
				int gemCost = this.plugin.getConfig().getInt("Pouches.AutoSell.GemCost");
				int pGems = new playerFileMethods(this.plugin).getStat(uuid, "Stats.Gems");
				if (pGems >= gemCost) {
					int commonArts = new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Common");
					int rareArts = new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Rare");
					int legendaryArts = new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Legendary");
					int mythicArts = new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Mythic");
					if (commonArts > 0 || rareArts > 0 || legendaryArts > 0 || mythicArts > 0) {
					    double CommonPrice = this.plugin.getConfig().getDouble("ArtifactPrice.Common");
					    double RarePrice = this.plugin.getConfig().getDouble("ArtifactPrice.Rare");
					    double LegendaryPrice = this.plugin.getConfig().getDouble("ArtifactPrice.Legendary");
					    double MythicPrice = this.plugin.getConfig().getDouble("ArtifactPrice.Mythic");
					    int addedArts = commonArts + rareArts + legendaryArts + mythicArts;
						double allArts = (commonArts * CommonPrice) + (rareArts * RarePrice) + (legendaryArts * LegendaryPrice) + (mythicArts * MythicPrice);
						Main.econ.depositPlayer(player, allArts);
						new playerFileMethods(this.plugin).removeInt(player, uuid, "Stats.Gems", gemCost);
						new playerFileMethods(this.plugin).setInt(player, uuid, "Pouch.Common", 0);
						new playerFileMethods(this.plugin).setInt(player, uuid, "Pouch.Rare", 0);
						new playerFileMethods(this.plugin).setInt(player, uuid, "Pouch.Legendary", 0);
						new playerFileMethods(this.plugin).setInt(player, uuid, "Pouch.Mythic", 0);
						new Pouch(this.plugin).openGUIPouch(player);
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Prefix") + this.plugin.getMessage("Pouch.AutoSell.Message").replace("MONEY", "" + allArts).replace("ARTIFACTS", "" + addedArts)));
						break;
					} else {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("Pouch.AutoSell.NoArtifacts")));
						break;	
					}
				} else {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("InvalidGems")));
					break;
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
			case STRUCTURE_VOID:
				event.setCancelled(true);
				break;
			}
			if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ")) {
				event.setCancelled(true);
			}
		}
	}
}
