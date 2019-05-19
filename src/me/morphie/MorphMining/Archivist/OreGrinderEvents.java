package me.morphie.MorphMining.Archivist;

import java.util.Random;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.morphie.MorphMining.Main;
import me.morphie.MorphMining.Station;
import me.morphie.MorphMining.DataLog.LogArtsMenu;
import me.morphie.MorphMining.Files.playerFileMethods;
import me.morphie.MorphMining.Market.Market;
import net.md_5.bungee.api.ChatColor;

public class OreGrinderEvents implements Listener {
	
	private Main plugin;
	  
	public OreGrinderEvents(Main plugin) {
		this.plugin = plugin;
	}
	
    private void dropArt(World world, Location loc, ItemStack artifact) {
		loc.setY(loc.getY() + 1.0D);
	    world.dropItem(loc, artifact);
	} 
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if (ChatColor.stripColor(event.getView().getTitle()).equalsIgnoreCase("Ore Grinder")) {
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
				new Archivist().openGUIArch(player);
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
		if (ChatColor.stripColor(event.getView().getTitle()).equalsIgnoreCase("Ore Grinder")) {
			Inventory inv = event.getInventory();
			Player player = (Player)event.getPlayer();
			UUID uuid = player.getUniqueId();
	      
			int Ores = 0;
			int Gems = 0;
			int Min = 0;
	      
			for (int i = 8; i <= 21; i++) {
				ItemStack item = inv.getItem(i);
				if (item != null) {
	  	          	if (item.getType() == Material.COAL_ORE || item.getType() == Material.IRON_ORE || item.getType() == Material.GOLD_ORE || item.getType() == Material.REDSTONE_ORE || item.getType() == Material.LAPIS_ORE || item.getType() == Material.DIAMOND_ORE || item.getType() == Material.EMERALD_ORE) {
	  	          		int x = item.getAmount();
	  	          		while (x > 0) {
	  	          			x--;
	  	          			if (item.getType() == Material.COAL_ORE) {
	  	          				Ores++;
	  	          				Random random = new Random();
	  	          				int chance = random.nextInt(100);
	  	          				int coalChance = plugin.getConfig().getInt("OreGrinder.CoalGemChance");
	  	          				if (chance <= coalChance) {
	  	          					new playerFileMethods(this.plugin).setData(player, uuid, "Stats.Gems", 1);
	  	          					Gems++;
	  	          				} else if (chance >= coalChance) {
		  	          				ItemStack Coal = new ItemStack(Material.COAL, 1);
		  	          				dropArt(player.getWorld(), player.getLocation(), Coal);
		  	          				Min++;
	  	          				}
	  	          			}
	  	          			else if (item.getType() == Material.IRON_ORE) {
	  	          				Ores++;
	  	          				Random random = new Random();
	  	          				int chance = random.nextInt(100);
	  	          				int ironChance = plugin.getConfig().getInt("OreGrinder.IronGemChance");
	  	          				if (chance <= ironChance) {
	  	          					new playerFileMethods(this.plugin).setData(player, uuid, "Stats.Gems", 1);
	  	          					Gems++;
	  	          				} else if (chance >= ironChance) {
	  	          					ItemStack Iron = new ItemStack(Material.IRON_INGOT, 1);
	  	          					dropArt(player.getWorld(), player.getLocation(), Iron);
	  	          					Min++;
	  	          				}
	  	          			}
	  	          			else if (item.getType() == Material.GOLD_ORE) {
	  	          				Ores++;
	  	          				Random random = new Random();
	  	          				int chance = random.nextInt(100);
	  	          				int goldChance = plugin.getConfig().getInt("OreGrinder.GoldGemChance");
	  	          				if (chance <= goldChance) {
	  	          					new playerFileMethods(this.plugin).setData(player, uuid, "Stats.Gems", 1);
	  	          					Gems++;
	  	          				} else if (chance >= goldChance) {
		  	          				ItemStack Gold = new ItemStack(Material.GOLD_INGOT, 1);
		  	          				dropArt(player.getWorld(), player.getLocation(), Gold);
		  	          				Min++;
	  	          				}
	  	          			}
	  	          			else if (item.getType() == Material.REDSTONE_ORE) {
	  	          				Ores++;
	  	          				Random random = new Random();
	  	          				int chance = random.nextInt(100);
	  	          				int redstoneChance = plugin.getConfig().getInt("OreGrinder.RedstoneGemChance");
	  	          				if (chance <= redstoneChance) {
	  	          					new playerFileMethods(this.plugin).setData(player, uuid, "Stats.Gems", 1);
	  	          					Gems++;
	  	          				} else if (chance >= redstoneChance) {
		  	          				ItemStack Red = new ItemStack(Material.REDSTONE, 1);
		  	          				dropArt(player.getWorld(), player.getLocation(), Red);
		  	          				Min++;
	  	          				}
	  	          			}
	  	          			else if (item.getType() == Material.LAPIS_ORE) {
	  	          				Ores++;
	  	          				Random random = new Random();
	  	          				int chance = random.nextInt(100);
	  	          				int lapisChance = plugin.getConfig().getInt("OreGrinder.LapisGemChance");
	  	          				if (chance <= lapisChance) {
	  	          					new playerFileMethods(this.plugin).setData(player, uuid, "Stats.Gems", 1);
	  	          					Gems++;
	  	          				} else if (chance >= lapisChance) {
	  	          					ItemStack Lapis = new ItemStack(Material.LAPIS_LAZULI, 1);
	  	          					dropArt(player.getWorld(), player.getLocation(), Lapis);
	  	          					Min++;
	  	          				}
	  	          			}
	  	          			else if (item.getType() == Material.DIAMOND_ORE) {
	  	          				Ores++;
	  	          				Random random = new Random();
	  	          				int chance = random.nextInt(100);
	  	          				int diamondChance = plugin.getConfig().getInt("OreGrinder.DiamondGemChance");
	  	          				if (chance <= diamondChance) {
	  	          					new playerFileMethods(this.plugin).setData(player, uuid, "Stats.Gems", 1);
	  	          					Gems++;
	  	          				} else if (chance >= diamondChance) {
		  	          				ItemStack Dia = new ItemStack(Material.DIAMOND, 1);
		  	          				dropArt(player.getWorld(), player.getLocation(), Dia);
		  	          				Min++;
	  	          				}
	  	          			}
	  	          			else if (item.getType() == Material.EMERALD_ORE) {
	  	          				Ores++;
	  	          				Random random = new Random();
	  	          				int chance = random.nextInt(100);
	  	          				int emeraldChance = plugin.getConfig().getInt("OreGrinder.EmeraldGemChance");
	  	          				if (chance <= emeraldChance) {
	  	          					new playerFileMethods(this.plugin).setData(player, uuid, "Stats.Gems", 1);
	  	          					Gems++;
	  	          				} else if (chance >= emeraldChance) {
		  	          				ItemStack Em = new ItemStack(Material.EMERALD, 1);
		  	          				dropArt(player.getWorld(), player.getLocation(), Em);
		  	          				Min++;
	  	          				}
	  	          			}
	  	          		}
	  	          	}	
	  	          	else if (!item.getItemMeta().getDisplayName().equals(" ") || !item.hasItemMeta() || !item.getItemMeta().hasDisplayName()) {
	  	          		player.getInventory().addItem(new ItemStack[] { item });
	  	          	}
				}
	      	}
	      	if ((Gems != 0) && (Ores != 0)) {
	      		player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Prefix") + this.plugin.getMessage("OreGrinder.GemMessage").replace("GEMS", "" + Gems).replace("ORES", "" + Ores)));
	      	}
	      	if ((Gems == 0) && (Ores > 0)) {
	      		player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Prefix") + this.plugin.getMessage("OreGrinder.NoGemMessage").replace("ORES", "" + Ores)));
	      	}
	    }
	 }
}
