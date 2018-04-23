package me.morphie.MorphMining.Crates;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.morphie.MorphMining.Main;
import me.morphie.MorphMining.Archivist.Archivist;
import net.md_5.bungee.api.ChatColor;

public class CratesMenu implements Listener {
	private Main plugin;
	  
	public CratesMenu(Main plugin) {
		this.plugin = plugin;
	}
	
	public void openGUICrate(Player player) {
		Inventory Crate = Bukkit.createInventory(null, 54, ChatColor.DARK_RED + "" + ChatColor.BOLD + "Crate Analyzer");
		
		ItemStack Info = new ItemStack(Material.BOOK);
		ItemMeta InfoMeta = Info.getItemMeta();
		ArrayList<String> Infolore = new ArrayList();
		Infolore.add(ChatColor.GRAY + "Drop loot in then close!");
		InfoMeta.setLore(Infolore);
		
		InfoMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Information");
		Info.setItemMeta(InfoMeta);
		Crate.setItem(48, Info);
		
		ItemStack Back = new ItemStack(Material.ARROW);
		ItemMeta BackMeta = Back.getItemMeta();
		ArrayList<String> Backlore = new ArrayList();
	    Backlore.add(ChatColor.GRAY + "Click to go back!");
	    BackMeta.setLore(Backlore);
	    BackMeta.setDisplayName(ChatColor.RED +  "" + ChatColor.BOLD + "Back");
	    Back.setItemMeta(BackMeta);
	    Crate.setItem(50, Back);
	    
	    ItemStack Type = new ItemStack(Material.PAPER);
	    ItemMeta TypeMeta = Type.getItemMeta();
	    ArrayList<String> Typelore = new ArrayList();
	    Typelore.add(" ");
	    Typelore.add(ChatColor.RED + "Pile Of Rocks" + ChatColor.DARK_GRAY + ": " + ChatColor.GRAY + this.plugin.getConfig().getDouble("CrateOpenCost.PileOfRocks"));
	    Typelore.add(ChatColor.RED + "Ironed Out" + ChatColor.DARK_GRAY + ": " + ChatColor.GRAY + this.plugin.getConfig().getDouble("CrateOpenCost.IronedOut"));
	    Typelore.add(ChatColor.RED + "Miner's Dream" + ChatColor.DARK_GRAY + ": " + ChatColor.GRAY + this.plugin.getConfig().getDouble("CrateOpenCost.MinersDream"));
	    TypeMeta.setLore(Typelore);
	    TypeMeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Crate Types & Costs To Open!" + ChatColor.DARK_GRAY + ":");
	    Type.setItemMeta(TypeMeta);
	    Crate.setItem(4, Type);
	    
	    ItemStack redGlass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
	    ItemMeta redGlassMeta = redGlass.getItemMeta();
	    ArrayList<String> redGlasslore = new ArrayList();
	    redGlasslore.add(" ");
	    
	    redGlassMeta.setDisplayName(" ");
	    redGlass.setItemMeta(redGlassMeta);
	    Crate.setItem(0, redGlass);
	    Crate.setItem(8, redGlass);
	    Crate.setItem(10, redGlass);
	    Crate.setItem(11, redGlass);
	    Crate.setItem(12, redGlass);
	    Crate.setItem(14, redGlass);
	    Crate.setItem(15, redGlass);
	    Crate.setItem(16, redGlass);
	    Crate.setItem(19, redGlass);
	    Crate.setItem(21, redGlass);
	    Crate.setItem(22, redGlass);
	    Crate.setItem(23, redGlass);
	    Crate.setItem(25, redGlass);
	    Crate.setItem(28, redGlass);
	    Crate.setItem(29, redGlass);
	    Crate.setItem(30, redGlass);
	    Crate.setItem(32, redGlass);
	    Crate.setItem(33, redGlass);
	    Crate.setItem(34, redGlass);
	    Crate.setItem(39, redGlass);
	    Crate.setItem(40, redGlass);
	    Crate.setItem(41, redGlass);
	    Crate.setItem(45, redGlass);
	    Crate.setItem(53, redGlass);
	    
	    int x = 0;
	    while (x < 54) {
	    	if ((x != 0) && (x != 4) && (x != 8) && (x != 45) && (x != 48) && (x != 50) && (x != 53) && ((x < 10) || (x >= 13)) && ((x < 14) || (x >= 17)) && ((x < 19) || (x >= 26)) && ((x < 28) || (x >= 35)) && ((x < 39) || (x >= 42))) {
	    		ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
	    		ItemMeta glassMeta = glass.getItemMeta();
	        
	    		glassMeta.setDisplayName(" ");
	    		glass.setItemMeta(glassMeta);
	    		Crate.setItem(x, glass);
	        }
	      x++;
	    }
	    player.openInventory(Crate);
	}	
}
