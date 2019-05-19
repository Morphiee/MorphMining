package me.morphie.MorphMining.Items;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.morphie.MorphMining.Main;
import me.morphie.MorphMining.Files.playerFileMethods;

public class TrashCanEvent implements Listener {
	
	private Main plugin;
	  
	public TrashCanEvent(Main plugin) {
		this.plugin = plugin;
	}
	
    @EventHandler
    public void TrashCanUse(PlayerInteractEvent event) {
        final Player player = event.getPlayer();
        if (event.getAction() == null) {
          return;
        }
        if (event.getItem() == null) {
          return;
        }
        if (((event.getAction().equals(Action.RIGHT_CLICK_AIR)) || (event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) && (event.getItem().getType().equals(Material.CAULDRON)) && (event.getItem().hasItemMeta())) {
            ItemStack item2 = event.getItem();
            if (ChatColor.stripColor(item2.getItemMeta().getDisplayName()).equals("TrashCan") && ChatColor.stripColor(item2.getItemMeta().getLore().get(8)).equals("MorphMining")) {
    	        event.setCancelled(true);
    	        Inventory inv = Bukkit.createInventory(null, 36, ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.TitleColor") + "TrashCan"));
    	        
    	        ItemStack item = new ItemStack(Material.BOOK);
    	        ItemMeta itemMeta = item.getItemMeta();
    	        ArrayList<String> itemLore = new ArrayList();
    	        itemLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Drop items in then close!"));
    	        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Information" + this.plugin.getMessage("Menus.SpacerColor") +":"));
    	        itemMeta.setLore(itemLore);
    	        item.setItemMeta(itemMeta);
    	        inv.setItem(30, item);
    	        
    	        ItemStack item3 = new ItemStack(Material.FURNACE);
    	        ItemMeta item3Meta = item3.getItemMeta();
    	        ArrayList<String> item3Lore = new ArrayList();
    	        item3Lore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Set some items to be"));
    	        item3Lore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "automatically trashed on pick up."));
    	        item3Lore.add(" ");
    	        item3Lore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "&oComing soon!"));
    	        item3Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Nullification" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
    	        item3Meta.setLore(item3Lore);
    	        item3.setItemMeta(item3Meta);
    	        inv.setItem(32, item3);
    	        
    		    ItemStack bGlass = new ItemStack(Material.LEGACY_STAINED_GLASS_PANE, 1, (short) + this.plugin.getConfig().getInt("Settings.MainGlassColor"));
    		    ItemMeta bGlassMeta = bGlass.getItemMeta();
    		    ArrayList<String> bGlasslore = new ArrayList();
    		    bGlasslore.add(" ");
    		    bGlassMeta.setDisplayName(" ");
    		    bGlass.setItemMeta(bGlassMeta);
    		    inv.setItem(27, bGlass);
    		    inv.setItem(31, bGlass);
    		    inv.setItem(35, bGlass);
    		    
    	        ItemStack Glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1, (short)15);
    	        ItemMeta GlassMeta = Glass.getItemMeta();
    	        GlassMeta.setDisplayName(" ");
    	        Glass.setItemMeta(GlassMeta);
    	        inv.setItem(28, Glass);
    	        inv.setItem(29, Glass);
    	        inv.setItem(33, Glass);
    	        inv.setItem(34, Glass);
    		    
    	        player.openInventory(inv);
            }
        }
    }
    
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if (ChatColor.stripColor(event.getView().getTitle()).equalsIgnoreCase("Trashcan")) {
			Player player = (Player)event.getWhoClicked();
			if ((event.getCurrentItem() == null) || (!event.getCurrentItem().hasItemMeta())) {
				return;
			}
			switch (event.getCurrentItem().getType()) {
			case BOOK:
				if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Information" + this.plugin.getMessage("Menus.SpacerColor") + ":"))) {
					event.setCancelled(true);
					break;
				}
			case FURNACE:
				if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Nullification" + this.plugin.getMessage("Menus.SpacerColor") + ":"))) {
					new Nullification(plugin).openGUINullifier(player);
					break;
				}
			}
			if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ")) {
				event.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void nullifierClick(InventoryClickEvent event) {
		if (ChatColor.stripColor(event.getView().getTitle()).equalsIgnoreCase("Nullification")) {
			Player player = (Player)event.getWhoClicked();
			UUID uuid = player.getUniqueId();
			if ((event.getCurrentItem() == null) || (!event.getCurrentItem().hasItemMeta())) {
				return;
			}
			switch (event.getCurrentItem().getType()) {
			case RED_STAINED_GLASS_PANE:
				new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Enabled", true);
				new Nullification(plugin).openGUINullifier(player);
				event.setCancelled(true);
				break;
			case LIME_STAINED_GLASS_PANE:
				new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Enabled", false);
				new Nullification(plugin).openGUINullifier(player);
				event.setCancelled(true);
				break;
			case FLINT_AND_STEEL:
				if (new playerFileMethods(plugin).getBoolean(uuid, "Trashcan.LavaRepair.Enabled") == false) {
					new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.LavaRepair.Enabled", true);
					new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.IronRepair.Enabled", false);
					new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot1.Enabled", false);
					new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot2.Enabled", false);
					new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot3.Enabled", false);
					new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot4.Enabled", false);
					new Nullification(plugin).openGUINullifier(player);
					event.setCancelled(true);
					break;
				} else {
					new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.LavaRepair.Enabled", false);
					new Nullification(plugin).openGUINullifier(player);
					event.setCancelled(true);
					break;
				}
			case ANVIL:
				if (new playerFileMethods(plugin).getBoolean(uuid, "Trashcan.IronRepair.Enabled") == false) {
					new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.IronRepair.Enabled", true);
					new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.LavaRepair.Enabled", false);
					new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot1.Enabled", false);
					new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot2.Enabled", false);
					new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot3.Enabled", false);
					new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot4.Enabled", false);
					new Nullification(plugin).openGUINullifier(player);
					event.setCancelled(true);
					break;
				} else {
					new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.IronRepair.Enabled", false);
					new Nullification(plugin).openGUINullifier(player);
					event.setCancelled(true);
					break;
				}
			case STRUCTURE_VOID:
				String name = event.getCurrentItem().getItemMeta().getDisplayName();
				event.setCancelled(true);
				if (name.equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Slot 1" + this.plugin.getMessage("Menus.SpacerColor") + ":"))) {
					if (new playerFileMethods(plugin).getBoolean(uuid, "Trashcan.Nullifier.Slot1.Enabled") == false) {
						new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot1.Enabled", true);
						new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.LavaRepair.Enabled", false);
						new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.IronRepair.Enabled", false);
						new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot2.Enabled", false);
						new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot3.Enabled", false);
						new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot4.Enabled", false);
						new Nullification(plugin).openGUINullifier(player);
						break;
					} else {
						new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot1.Enabled", false);
						new Nullification(plugin).openGUINullifier(player);
						break;
					}
				} else if (name.equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Slot 2" + this.plugin.getMessage("Menus.SpacerColor") + ":"))) {
					if (new playerFileMethods(plugin).getBoolean(uuid, "Trashcan.Nullifier.Slot2.Enabled") == false) {
						new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot2.Enabled", true);
						new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.LavaRepair.Enabled", false);
						new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.IronRepair.Enabled", false);
						new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot1.Enabled", false);
						new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot3.Enabled", false);
						new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot4.Enabled", false);
						new Nullification(plugin).openGUINullifier(player);
						break;
					} else {
						new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot2.Enabled", false);
						new Nullification(plugin).openGUINullifier(player);
						break;
					}
				} else if (name.equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Slot 3" + this.plugin.getMessage("Menus.SpacerColor") + ":"))) {
					if (new playerFileMethods(plugin).getBoolean(uuid, "Trashcan.Nullifier.Slot3.Enabled") == false) {
						new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot3.Enabled", true);
						new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.LavaRepair.Enabled", false);
						new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.IronRepair.Enabled", false);
						new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot1.Enabled", false);
						new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot2.Enabled", false);
						new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot4.Enabled", false);
						new Nullification(plugin).openGUINullifier(player);
						break;
					} else {
						new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot3.Enabled", false);
						new Nullification(plugin).openGUINullifier(player);
						break;
					}
				} else if (name.equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Slot 4" + this.plugin.getMessage("Menus.SpacerColor") + ":"))) {
					if (new playerFileMethods(plugin).getBoolean(uuid, "Trashcan.Nullifier.Slot4.Enabled") == false) {
						new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot4.Enabled", true);
						new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.LavaRepair.Enabled", false);
						new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.IronRepair.Enabled", false);
						new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot1.Enabled", false);
						new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot2.Enabled", false);
						new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot3.Enabled", false);
						new Nullification(plugin).openGUINullifier(player);
						break;
					} else {
						new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot4.Enabled", false);
						new Nullification(plugin).openGUINullifier(player);
						break;
					}
				}
			case WHITE_STAINED_GLASS_PANE:
				Double moneyCost = this.plugin.getConfig().getDouble("Trashcan.Slot2.CurrencyCost");
				int gemCost = this.plugin.getConfig().getInt("Trashcan.Slot2.GemCost");
				int currentGem = new playerFileMethods(this.plugin).getStat(uuid, "Stats.Gems");
				Double currentMoney = this.plugin.econ.getBalance(player);
				String name2 = event.getCurrentItem().getItemMeta().getDisplayName();
				event.setCancelled(true);
				if (name2.equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Slot 2" + this.plugin.getMessage("Menus.SpacerColor") + ":"))) {
					if (currentGem >= gemCost && currentMoney >= moneyCost) {
						this.plugin.econ.withdrawPlayer(player, moneyCost);
						new playerFileMethods(this.plugin).removeInt(player, uuid, "Stats.Gems", gemCost);
						new playerFileMethods(this.plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot2.Purchased", true);
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Prefix") + this.plugin.getMessage("Trashcan.UpgradeMessage").replace("GEMS", "" + gemCost).replace("MONEY", "" + moneyCost)));
						new Nullification(plugin).openGUINullifier(player);
						break;
					} else if (currentGem < gemCost) {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("InvalidGems")));
						break;
					} else if (currentMoney < moneyCost) {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("InvalidFunds")));
						break;
					}
				} else if (name2.equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Slot 3" + this.plugin.getMessage("Menus.SpacerColor") + ":"))) {
					if (currentGem >= gemCost && currentMoney >= moneyCost) {
						this.plugin.econ.withdrawPlayer(player, moneyCost);
						new playerFileMethods(this.plugin).removeInt(player, uuid, "Stats.Gems", gemCost);
						new playerFileMethods(this.plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot3.Purchased", true);
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Prefix") + this.plugin.getMessage("Trashcan.UpgradeMessage").replace("GEMS", "" + gemCost).replace("MONEY", "" + moneyCost)));
						new Nullification(plugin).openGUINullifier(player);
						break;
					} else if (currentGem < gemCost) {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("InvalidGems")));
						break;
					} else if (currentMoney < moneyCost) {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("InvalidFunds")));
						break;
					}
				} else if (name2.equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Slot 4" + this.plugin.getMessage("Menus.SpacerColor") + ":"))) {
					if (currentGem >= gemCost && currentMoney >= moneyCost) {
						this.plugin.econ.withdrawPlayer(player, moneyCost);
						new playerFileMethods(this.plugin).removeInt(player, uuid, "Stats.Gems", gemCost);
						new playerFileMethods(this.plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot4.Purchased", true);
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Prefix") + this.plugin.getMessage("Trashcan.UpgradeMessage").replace("GEMS", "" + gemCost).replace("MONEY", "" + moneyCost)));
						new Nullification(plugin).openGUINullifier(player);
						break;
					} else if (currentGem < gemCost) {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("InvalidGems")));
						break;
					} else if (currentMoney < moneyCost) {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("InvalidFunds")));
						break;
					}
				}
			}
			if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ") || event.getCurrentItem().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Item currently being nullified!"))) {
				event.setCancelled(true);
			}
		}
	}
}
