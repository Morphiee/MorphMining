package me.morphie.MorphMining.Items;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.morphie.MorphMining.Files.playerFileMethods;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ComponentBuilder;
import me.morphie.MorphMining.Main;

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
            if (ChatColor.stripColor(item2.getItemMeta().getDisplayName()).equals("TrashCan") && ChatColor.stripColor(item2.getItemMeta().getLore().get(7)).equals("MorphMining")) {
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
    	        item3Lore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "&oClick for nullification menu!"));
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
        } else if (((event.getAction().equals(Action.LEFT_CLICK_AIR)) || (event.getAction().equals(Action.LEFT_CLICK_BLOCK))) && (event.getItem().getType().equals(Material.CAULDRON)) && (event.getItem().hasItemMeta())) {
            ItemStack item2 = event.getItem();
            if (ChatColor.stripColor(item2.getItemMeta().getDisplayName()).equals("TrashCan") && ChatColor.stripColor(item2.getItemMeta().getLore().get(7)).equals("MorphMining")) {
    	        event.setCancelled(true);
    	        new Nullification(this.plugin).openGUINullifier(player);
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
	public void nullifierClose(InventoryCloseEvent event) {
		if (ChatColor.stripColor(event.getView().getTitle()).equalsIgnoreCase("Nullification")) {
			if (event.getInventory().getItem(31) != null) {
				Player p = (Player) event.getPlayer();
				ItemStack item = event.getInventory().getItem(31);
				p.getInventory().addItem(new ItemStack[] { item });
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
			case WHITE_STAINED_GLASS_PANE:
				Double moneyCost;
				int gemCost;
				int currentGem = new playerFileMethods(this.plugin).getStat(uuid, "Stats.Gems");
				Double currentMoney = this.plugin.econ.getBalance(player);
				String name2 = event.getCurrentItem().getItemMeta().getDisplayName();
				if (name2.equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Slot 2" + this.plugin.getMessage("Menus.SpacerColor") + ":"))) {
					moneyCost = this.plugin.getConfig().getDouble("Trashcan.Slot2.CurrencyCost");
					gemCost = this.plugin.getConfig().getInt("Trashcan.Slot2.GemCost");
					if (currentGem >= gemCost && currentMoney >= moneyCost) {
						if (new playerFileMethods(this.plugin).getBoolean(uuid, "Trashcan.Nullifier.Slot2.Purchased") == false) {
							this.plugin.econ.withdrawPlayer(player, moneyCost);
							new playerFileMethods(this.plugin).removeInt(player, uuid, "Stats.Gems", gemCost);
							new playerFileMethods(this.plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot2.Purchased", true);
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Prefix") + this.plugin.getMessage("Trashcan.UpgradeMessage").replace("GEMS", "" + gemCost).replace("MONEY", "" + moneyCost)));
							new Nullification(plugin).openGUINullifier(player);
							event.setCancelled(true);
							break;
						}
					} else if (currentGem < gemCost) {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("InvalidGems")));
						event.setCancelled(true);
						break;
					} else if (currentMoney < moneyCost) {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("InvalidFunds")));
						event.setCancelled(true);
						break;
					}
				} else if (name2.equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Slot 3" + this.plugin.getMessage("Menus.SpacerColor") + ":"))) {
					moneyCost = this.plugin.getConfig().getDouble("Trashcan.Slot3.CurrencyCost");
					gemCost = this.plugin.getConfig().getInt("Trashcan.Slot3.GemCost");
					if (currentGem >= gemCost && currentMoney >= moneyCost) {
						if (new playerFileMethods(this.plugin).getBoolean(uuid, "Trashcan.Nullifier.Slot3.Purchased") == false) {
							this.plugin.econ.withdrawPlayer(player, moneyCost);
							new playerFileMethods(this.plugin).removeInt(player, uuid, "Stats.Gems", gemCost);
							new playerFileMethods(this.plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot3.Purchased", true);
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Prefix") + this.plugin.getMessage("Trashcan.UpgradeMessage").replace("GEMS", "" + gemCost).replace("MONEY", "" + moneyCost)));
							new Nullification(plugin).openGUINullifier(player);
							event.setCancelled(true);
							break;
						}
					} else if (currentGem < gemCost) {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("InvalidGems")));
						event.setCancelled(true);
						break;
					} else if (currentMoney < moneyCost) {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("InvalidFunds")));
						event.setCancelled(true);
						break;
					}
				} else if (name2.equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Slot 4" + this.plugin.getMessage("Menus.SpacerColor") + ":"))) {
					moneyCost = this.plugin.getConfig().getDouble("Trashcan.Slot4.CurrencyCost");
					gemCost = this.plugin.getConfig().getInt("Trashcan.Slot4.GemCost");
					if (currentGem >= gemCost && currentMoney >= moneyCost) {
						if (new playerFileMethods(this.plugin).getBoolean(uuid, "Trashcan.Nullifier.Slot4.Purchased") == false) {
							this.plugin.econ.withdrawPlayer(player, moneyCost);
							new playerFileMethods(this.plugin).removeInt(player, uuid, "Stats.Gems", gemCost);
							new playerFileMethods(this.plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot4.Purchased", true);
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Prefix") + this.plugin.getMessage("Trashcan.UpgradeMessage").replace("GEMS", "" + gemCost).replace("MONEY", "" + moneyCost)));
							new Nullification(plugin).openGUINullifier(player);
							event.setCancelled(true);
							break;
						}
					} else if (currentGem < gemCost) {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("InvalidGems")));
						event.setCancelled(true);
						break;
					} else if (currentMoney < moneyCost) {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("InvalidFunds")));
						event.setCancelled(true);
						break;
					}
				}
			}
			String name = event.getCurrentItem().getItemMeta().getDisplayName();
			if (name.equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Close" + this.plugin.getMessage("Menus.SpacerColor") + ":"))) {
				event.setCancelled(true);
				player.closeInventory();
			} else if (name.equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&cDisabled" + this.plugin.getMessage("Menus.SpacerColor") + ":"))) {
				new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Enabled", true);
				new Nullification(plugin).openGUINullifier(player);
				event.setCancelled(true);
			} else if (name.equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&aEnabled" + this.plugin.getMessage("Menus.SpacerColor") + ":"))) {
				new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Enabled", false);
				new Nullification(plugin).openGUINullifier(player);
				event.setCancelled(true);
			} else if (name.equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Slot 1" + this.plugin.getMessage("Menus.SpacerColor") + ":"))) {
				if (new playerFileMethods(plugin).getBoolean(uuid, "Trashcan.Nullifier.Slot1.Enabled") == false) {
					new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot1.Enabled", true);
					new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.LavaRepair.Enabled", false);
					new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.IronRepair.Enabled", false);
					new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot2.Enabled", false);
					new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot3.Enabled", false);
					new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot4.Enabled", false);
					new Nullification(plugin).openGUINullifier(player);
					event.setCancelled(true);
				} else {
					new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot1.Enabled", false);
					new Nullification(plugin).openGUINullifier(player);
					event.setCancelled(true);
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
					event.setCancelled(true);
				} else {
					new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot2.Enabled", false);
					new Nullification(plugin).openGUINullifier(player);
					event.setCancelled(true);
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
					event.setCancelled(true);
				} else {
					new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot3.Enabled", false);
					new Nullification(plugin).openGUINullifier(player);
					event.setCancelled(true);
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
					event.setCancelled(true);
				} else {
					new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot4.Enabled", false);
					new Nullification(plugin).openGUINullifier(player);
					event.setCancelled(true);
				}
			} else if (name.equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Activation" + this.plugin.getMessage("Menus.SpacerColor") + ":"))) {
				if (event.getClickedInventory().getItem(31) != null) {
					Material invItem = event.getClickedInventory().getItem(31).getType();
					ItemStack invItem2 = new ItemStack(event.getClickedInventory().getItem(31));
					if (new playerFileMethods(plugin).getBoolean(uuid, "Trashcan.Nullifier.Slot1.Enabled") == true) {
						if (invItem2 == new playerFileMethods(plugin).getMaterial(uuid, "Trashcan.Nullifier.Slot1.Material")) {
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("Trashcan.Nullifier.SameSlotItem")));
							new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot1.Enabled", false);
							new Nullification(plugin).openGUINullifier(player);
							event.setCancelled(true);
						}
						new playerFileMethods(plugin).addMaterial(player, uuid, "Trashcan.Nullifier.Slot1.Material", invItem2);
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Prefix") + this.plugin.getMessage("Trashcan.Nullifier.SlotItemAdd")));
						new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot1.Enabled", false);
						new Nullification(plugin).openGUINullifier(player);
						event.setCancelled(true);
					} else if (new playerFileMethods(plugin).getBoolean(uuid, "Trashcan.Nullifier.Slot2.Enabled") == true) {
						if (invItem2 == new playerFileMethods(plugin).getMaterial(uuid, "Trashcan.Nullifier.Slot2.Material")) {
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("Trashcan.Nullifier.SameSlotItem")));
							new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot2.Enabled", false);
							new Nullification(plugin).openGUINullifier(player);
							event.setCancelled(true);
						}
						new playerFileMethods(plugin).addMaterial(player, uuid, "Trashcan.Nullifier.Slot2.Material", invItem2);
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Prefix") + this.plugin.getMessage("Trashcan.Nullifier.SlotItemAdd")));
						new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot2.Enabled", false);
						new Nullification(plugin).openGUINullifier(player);
						event.setCancelled(true);
					} else if (new playerFileMethods(plugin).getBoolean(uuid, "Trashcan.Nullifier.Slot3.Enabled") == true) {
						if (invItem2 == new playerFileMethods(plugin).getMaterial(uuid, "Trashcan.Nullifier.Slot3.Material")) {
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("Trashcan.Nullifier.SameSlotItem")));
							new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot3.Enabled", false);
							new Nullification(plugin).openGUINullifier(player);
							event.setCancelled(true);
						}
						new playerFileMethods(plugin).addMaterial(player, uuid, "Trashcan.Nullifier.Slot3.Material", invItem2);
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Prefix") + this.plugin.getMessage("Trashcan.Nullifier.SlotItemAdd")));
						new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot3.Enabled", false);
						new Nullification(plugin).openGUINullifier(player);
						event.setCancelled(true);
					} else if (new playerFileMethods(plugin).getBoolean(uuid, "Trashcan.Nullifier.Slot4.Enabled") == true) {
						if (invItem2 == new playerFileMethods(plugin).getMaterial(uuid, "Trashcan.Nullifier.Slot4.Material")) {
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("Trashcan.Nullifier.SameSlotItem")));
							new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot4.Enabled", false);
							new Nullification(plugin).openGUINullifier(player);
							event.setCancelled(true);
						}
						new playerFileMethods(plugin).addMaterial(player, uuid, "Trashcan.Nullifier.Slot4.Material", invItem2);
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Prefix") + this.plugin.getMessage("Trashcan.Nullifier.SlotItemAdd")));
						new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot4.Enabled", false);
						new Nullification(plugin).openGUINullifier(player);
						event.setCancelled(true);
					} else if (new playerFileMethods(plugin).getBoolean(uuid, "Trashcan.LavaRepair.Enabled") == true) {
						if (invItem2.getType().equals(Material.LAVA_BUCKET)) {
							int lavaD = new playerFileMethods(this.plugin).getStat(uuid, "Trashcan.LavaRepair.Durability");
							if (lavaD < 100) {
								if (lavaD + 50 <= 100) {
									event.getClickedInventory().getItem(31).setType(Material.BUCKET);
									new playerFileMethods(this.plugin).addMoney(player, uuid, "Trashcan.LavaRepair.Durability", 50);
									player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Prefix") + this.plugin.getMessage("Trashcan.Nullifier.RepairMessage").replace("%DURABILITY%", "" + 50).replace("%REPAIRTYPE%", "Lava Tank")));
									new Nullification(plugin).openGUINullifier(player);
									event.setCancelled(true);
								} else {
									event.getClickedInventory().getItem(31).setType(Material.BUCKET);
									new playerFileMethods(this.plugin).addMoney(player, uuid, "Trashcan.LavaRepair.Durability", 100-lavaD);
									player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Prefix") + this.plugin.getMessage("Trashcan.Nullifier.RepairMessage").replace("%DURABILITY%", "" + (100 - lavaD)).replace("%REPAIRTYPE%", "Lava Tank")));
									new Nullification(plugin).openGUINullifier(player);
									event.setCancelled(true);
								}
							} else {
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("Trashcan.Nullifier.MaxRepairMessage").replace("%REPAIRTYPE%", "Lava Tank")));
								new Nullification(plugin).openGUINullifier(player);
								event.setCancelled(true);
							}
						} else {
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("Trashcan.Nullifier.InvalidRepairItem").replace("%ITEM%", "Lava Bucket")));
							event.setCancelled(true);
						}
					} else if (new playerFileMethods(plugin).getBoolean(uuid, "Trashcan.IronRepair.Enabled") == true) {
						if (invItem2.getType().equals(Material.IRON_INGOT)) {
							int lavaD = new playerFileMethods(this.plugin).getStat(uuid, "Trashcan.IronRepair.Durability");
							int itemA = invItem2.getAmount();
							if (lavaD < 100) {
								if ((itemA*5) + lavaD <= 100) {
									event.getInventory().remove(invItem2);
									new playerFileMethods(this.plugin).addMoney(player, uuid, "Trashcan.IronRepair.Durability", (itemA*5));
									player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Prefix") + this.plugin.getMessage("Trashcan.Nullifier.RepairMessage").replace("%DURABILITY%", "" + (itemA*5)).replace("%REPAIRTYPE%", "Structure Integrity")));
									new Nullification(plugin).openGUINullifier(player);
									event.setCancelled(true);
								} else {
									event.getInventory().remove(invItem2);
									new playerFileMethods(this.plugin).addMoney(player, uuid, "Trashcan.IronRepair.Durability", 100-lavaD);
									player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Prefix") + this.plugin.getMessage("Trashcan.Nullifier.RepairMessage").replace("%DURABILITY%", "" + (100 - lavaD)).replace("%REPAIRTYPE%", "Structure Integrity")));
									new Nullification(plugin).openGUINullifier(player);
									event.setCancelled(true);
								}
							} else {
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("Trashcan.Nullifier.MaxRepairMessage").replace("%REPAIRTYPE%", "Structure Integrity")));
								new Nullification(plugin).openGUINullifier(player);
								event.setCancelled(true);
							}
						} else {
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("Trashcan.Nullifier.InvalidRepairItem").replace("%ITEM%", "Iron Ingot")));
							event.setCancelled(true);
						}
					} else {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("Trashcan.Nullifier.ActivationErrorMessage")));
						event.setCancelled(true);
					}
				} else if (event.getClickedInventory().getItem(31) == null) {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("ErrorPrefix") + this.plugin.getMessage("Trashcan.Nullifier.ActivationErrorMessage")));
					event.setCancelled(true);
				}
			} else if (name.equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Structure Integrity" + this.plugin.getMessage("Menus.SpacerColor") + ":"))) {
				if (new playerFileMethods(plugin).getBoolean(uuid, "Trashcan.IronRepair.Enabled") == false) {
					new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.IronRepair.Enabled", true);
					new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.LavaRepair.Enabled", false);
					new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot1.Enabled", false);
					new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot2.Enabled", false);
					new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot3.Enabled", false);
					new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot4.Enabled", false);
					new Nullification(plugin).openGUINullifier(player);
					event.setCancelled(true);
				} else {
					new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.IronRepair.Enabled", false);
					new Nullification(plugin).openGUINullifier(player);
					event.setCancelled(true);
				}
			} else if (name.equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Lava Tank" + this.plugin.getMessage("Menus.SpacerColor") + ":"))) {
				if (new playerFileMethods(plugin).getBoolean(uuid, "Trashcan.LavaRepair.Enabled") == false) {
					new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.LavaRepair.Enabled", true);
					new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.IronRepair.Enabled", false);
					new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot1.Enabled", false);
					new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot2.Enabled", false);
					new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot3.Enabled", false);
					new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.Nullifier.Slot4.Enabled", false);
					new Nullification(plugin).openGUINullifier(player);
					event.setCancelled(true);
				} else {
					new playerFileMethods(plugin).setBoolean(player, uuid, "Trashcan.LavaRepair.Enabled", false);
					new Nullification(plugin).openGUINullifier(player);
					event.setCancelled(true);
				}
			} 
			if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ") || event.getCurrentItem().getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Item currently being nullified!"))) {
				event.setCancelled(true);
			}
		}
	}
	
	public void ActionBar (String message, Player player ) {
		player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new ComponentBuilder(ChatColor.translateAlternateColorCodes('&', message)).create());
	}
	
	@EventHandler
	public void onItemPickUp(PlayerPickupItemEvent event) {
		Player p = event.getPlayer();
		UUID uuid = p.getUniqueId();
		ItemStack null1Item = new playerFileMethods(plugin).getMaterial(uuid, "Trashcan.Nullifier.Slot1.Material");
		ItemStack null2Item = new playerFileMethods(plugin).getMaterial(uuid, "Trashcan.Nullifier.Slot2.Material");
		ItemStack null3Item = new playerFileMethods(plugin).getMaterial(uuid, "Trashcan.Nullifier.Slot3.Material");
		ItemStack null4Item = new playerFileMethods(plugin).getMaterial(uuid, "Trashcan.Nullifier.Slot4.Material");
		if (null1Item != null || null2Item != null || null3Item != null || null4Item != null) {
			if (checkTrashCan(p) == true) {
				if (new playerFileMethods(plugin).getBoolean(uuid, "Trashcan.Nullifier.Enabled") == true) {
					if (new playerFileMethods(this.plugin).getStat(uuid, "Trashcan.LavaRepair.Durability") > 0 && new playerFileMethods(this.plugin).getStat(uuid, "Trashcan.IronRepair.Durability") > 0) {
						ItemStack pickUpItem = event.getItem().getItemStack();
						int amt = pickUpItem.getAmount();
						if (pickUpItem.getType().equals(null1Item.getType()) || pickUpItem.getType().equals(null2Item.getType()) || pickUpItem.getType().equals(null3Item.getType()) || pickUpItem.getType().equals(null4Item.getType())) {
							ActionBar(this.plugin.getMessage("Trashcan.Nullifier.NullifierActionMessage").replace("AMMOUNT", "" + pickUpItem.getAmount()).replace("ITEM", pickUpItem.getType().name().toLowerCase()), p);
							event.getItem().remove();
							event.setCancelled(true);
							Random randRepair = new Random();
							int r = randRepair.nextInt(100);
							Random randRepair2 = new Random();
							int r2 = randRepair2.nextInt(100);
							if (r > 75) {
								new playerFileMethods(this.plugin).removeInt(p, uuid, "Trashcan.LavaRepair.Durability", 1);
							}
							if (r2 > 75) {
								new playerFileMethods(this.plugin).removeInt(p, uuid, "Trashcan.IronRepair.Durability", 1);
							}
						}
					} else {
						ActionBar(this.plugin.getMessage("Trashcan.Nullifier.NullifierRepairActionMessage"), p);
					}
				}
			}
		}
	}
	
	public Boolean checkTrashCan(Player p) {
		Inventory inv = p.getInventory();
	    for(int n = 0; n < inv.getSize(); n++){
	        ItemStack itm = inv.getItem(n);
	        if(itm != null){
	            if(itm.getType().equals(Material.CAULDRON)){
	            	if(itm.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "TrashCan"))) {
	            		return true;
	            	}
	            }
	        }
	    }
		return false;
	}
}
