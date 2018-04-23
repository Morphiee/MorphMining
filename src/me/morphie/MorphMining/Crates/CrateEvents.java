package me.morphie.MorphMining.Crates;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.morphie.MorphMining.Main;
import me.morphie.MorphMining.Archivist.Archivist;
import net.md_5.bungee.api.ChatColor;

public class CrateEvents implements Listener {
	
	private Main plugin;
	  
	public CrateEvents(Main plugin) {
		this.plugin = plugin;
	}
	
	public CrateRewards craterewards = new CrateRewards(this.plugin);
	
    @EventHandler
    public void onCrateRight(PlayerInteractEvent event) {
        final Player player = event.getPlayer();
        if (event.getAction() == null) {
          return;
        }
        if (event.getItem() == null) {
          return;
        }
        if (((event.getAction().equals(Action.RIGHT_CLICK_AIR)) || (event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) && (event.getItem().getType().equals(Material.PISTON_BASE)) && (event.getItem().hasItemMeta())) {
            ItemStack item = event.getItem();
            if (item.getItemMeta().getDisplayName().equals(ChatColor.GRAY + "" + ChatColor.BOLD + "Pile Of Rocks") || item.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "" + ChatColor.BOLD + "Ironed Out") || (item.getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Miner's Dream"))) {
            	new CratesMenu(this.plugin).openGUICrate(player);
            }
        }
    }
    
    @EventHandler
    public void onCrateLeft(PlayerInteractEvent event) {
        final Player player = event.getPlayer();
        if (event.getAction() == null) {
          return;
        }
        if (event.getItem() == null) {
          return;
        }
        if (((event.getAction().equals(Action.LEFT_CLICK_AIR)) || (event.getAction().equals(Action.LEFT_CLICK_BLOCK))) && (event.getItem().getType().equals(Material.PISTON_BASE)) && (event.getItem().hasItemMeta())) {
            ItemStack item = event.getItem();
            if (item.getItemMeta().getDisplayName().equals(ChatColor.GRAY + "" + ChatColor.BOLD + "Pile Of Rocks")) {
            	new CrateContents(this.plugin).openGUIRocks(player);
            }
            else if (item.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "" + ChatColor.BOLD + "Ironed Out")) {
            	new CrateContents(this.plugin).openGUIIron(player);
            }
            else if (item.getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Miner's Dream")) {
            	new CrateContents(this.plugin).openGUIDream(player);
            }    
        }
    }
    
	@EventHandler
	public void onCratePlace(BlockPlaceEvent event) {
		Player p = event.getPlayer();
		Block b = event.getBlockPlaced();
		
		if (b.getType().equals(Material.PISTON_BASE)) {
			ItemStack i = event.getItemInHand();
			if (i.getItemMeta().getDisplayName().equals(ChatColor.GRAY + "" + ChatColor.BOLD + "Pile Of Rocks") || i.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "" + ChatColor.BOLD + "Ironed Out") || i.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "" + ChatColor.BOLD + "Ironed Out") || i.getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Miner's Dream")) {
				event.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
	    if (ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Crate Analyzer")) {
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
	    		new Archivist(this.plugin).openGUIArch(player);
	    		break;
	    	case BOOK:
	    		event.setCancelled(true);
	    		break;
	    	}
	    	if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ")) {
	    		event.setCancelled(true);
	    	}
	   }
	   else if (ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Pile Of Rocks")) {
	    	Player player = (Player)event.getWhoClicked();
	    	event.setCancelled(true);
	    	if ((event.getCurrentItem() == null) || (!event.getCurrentItem().hasItemMeta())) {
	    		return;
	    	}
	    	switch (event.getCurrentItem().getType()) {
	    	case GOLD_NUGGET:
	    		break;
	    	case COAL_BLOCK: 
	    		break;
	    	case REDSTONE_BLOCK:
	    		break;
		   	case LAPIS_BLOCK:
				break;
		   	case STONE:
				break;
		  	}
	    }
	   	else if (ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Ironed Out")) {
	    	Player player = (Player)event.getWhoClicked();
	    	event.setCancelled(true);
	    	if ((event.getCurrentItem() == null) || (!event.getCurrentItem().hasItemMeta())) {
	    		return;
	    	}
	    	switch (event.getCurrentItem().getType()) {
	    	case GOLD_NUGGET:
	    		break;
	    	case ENCHANTED_BOOK: 
	    		break;
	    	case IRON_BLOCK:
	    		break;
		   	case GOLD_BLOCK:
				break;
		   	case RED_SHULKER_BOX:
				break;
		   	case QUARTZ_ORE:
				break;
		  	}
	    }
	   	else if (ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("A Miner's Dream")) {
	    	Player player = (Player)event.getWhoClicked();
	    	event.setCancelled(true);
	    	if ((event.getCurrentItem() == null) || (!event.getCurrentItem().hasItemMeta())) {
	    		return;
	    	}
	    	switch (event.getCurrentItem().getType()) {
	    	case GOLD_NUGGET:
	    		break;
	    	case ENCHANTED_BOOK: 
	    		break;
	    	case DIAMOND_BLOCK:
	    		break;
		   	case EMERALD_BLOCK:
				break;
		   	case BEACON:
				break;
		  	}
	    }
	}
	
	@EventHandler
	public void onCrateClose(InventoryCloseEvent event) {
		if (event.getInventory().getName().equals(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Crate Analyzer")) {
			Inventory inv = event.getInventory();
			Player player = (Player)event.getPlayer();
			double bal = Main.econ.getBalance(player);
			
			int Crates = 0;
			double rockCharge = this.plugin.getConfig().getDouble("CrateOpenCost.PileOfRocks");
			double ironCharge = this.plugin.getConfig().getDouble("CrateOpenCost.IronedOut");
			double dreamCharge = this.plugin.getConfig().getDouble("CrateOpenCost.MinersDream");
			int totalCharge = 0;
			int cancel = 0;
			
			for (int i = 8; i <= 41; i++) {
				ItemStack item = inv.getItem(i);
				if (item != null) {
					if (item.hasItemMeta()) {
						int x = item.getAmount();
						while (x > 0) {
							
							x--;

							if (item.getItemMeta().getDisplayName().contains(ChatColor.stripColor("Pile Of Rocks"))) {
								if (bal > 10) {
									Crates++;
						            totalCharge+=rockCharge;
						            Main.econ.withdrawPlayer(player, rockCharge);
						            craterewards.giveCrateReward(player, "Rocks");
								}
								else {
									if (item.getItemMeta().getDisplayName().contains(ChatColor.stripColor("Pile Of Rocks")) || item.getItemMeta().getDisplayName().contains(ChatColor.stripColor("Ironed Out")) || item.getItemMeta().getDisplayName().contains(ChatColor.stripColor("Miner's Dream"))) {
										player.getInventory().addItem(new ItemStack[] { item });
										cancel++;
										break;
									}
								}
							}
							else if (item.getItemMeta().getDisplayName().contains(ChatColor.stripColor("Ironed Out"))) {
								if (bal > 20) {
									Crates++;
						            totalCharge+=ironCharge;
						            Main.econ.withdrawPlayer(player, ironCharge);
						            craterewards.giveCrateReward(player, "Iron");
								}
								else {
									if (item.getItemMeta().getDisplayName().contains(ChatColor.stripColor("Pile Of Rocks")) || item.getItemMeta().getDisplayName().contains(ChatColor.stripColor("Ironed Out")) || item.getItemMeta().getDisplayName().contains(ChatColor.stripColor("Miner's Dream"))) {
										player.getInventory().addItem(new ItemStack[] { item });
										cancel++;
										break;
									}
								}
							}
							else if (item.getItemMeta().getDisplayName().contains(ChatColor.stripColor("Miner's Dream"))) {
								if (bal > 20) {
									Crates++;
						            totalCharge+=dreamCharge;
						            Main.econ.withdrawPlayer(player, dreamCharge);
						            craterewards.giveCrateReward(player, "Dream");
								}
								else {
									if (item.getItemMeta().getDisplayName().contains(ChatColor.stripColor("Pile Of Rocks")) || item.getItemMeta().getDisplayName().contains(ChatColor.stripColor("Ironed Out")) || item.getItemMeta().getDisplayName().contains(ChatColor.stripColor("Miner's Dream"))) {
										player.getInventory().addItem(new ItemStack[] { item });
										cancel++;
										break;
									}
								}
							}
						}
					}
			        else if ((!item.hasItemMeta()) || (!item.getItemMeta().hasDisplayName()) || (!item.getItemMeta().getDisplayName().equals(ChatColor.RED + "" + ChatColor.BOLD + "Information"))) {
			        	player.getInventory().addItem(new ItemStack[] { item });
			        }
				}
			}
			if (Crates != 0) {
				player.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Mining" + ChatColor.DARK_GRAY + ChatColor.BOLD + " >> " + ChatColor.GRAY + "You opened " + ChatColor.RED  + Crates + ChatColor.GRAY + " Crates at a price of" + ChatColor.RED + " $" + totalCharge);
			}
			else if (cancel > 0) {
				player.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "[" + ChatColor.RED + ChatColor.BOLD + "!" + ChatColor.DARK_GRAY + ChatColor.BOLD + "]" + ChatColor.RED + " Money required for crate analyzation!");
			}
		}	
	}
}
