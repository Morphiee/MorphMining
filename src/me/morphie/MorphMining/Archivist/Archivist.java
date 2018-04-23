package me.morphie.MorphMining.Archivist;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.morphie.MorphMining.Main;
import me.morphie.MorphMining.Station;
import me.morphie.MorphMining.Crates.CratesMenu;
import me.morphie.MorphMining.MineLog.LogMenu;


public class Archivist implements Listener {
	private Main plugin;
	  
	public Archivist(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if (ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Archivist")) {
		      Player player = (Player)event.getWhoClicked();
		      event.setCancelled(true);
		      if ((event.getCurrentItem() == null) || (!event.getCurrentItem().hasItemMeta())) {
		    	  return;
		      }
		      switch (event.getCurrentItem().getType()) {
		      case END_CRYSTAL:
		    	  event.setCancelled(true);
		    	  break;
		      case PISTON_BASE:
		    	  player.closeInventory();
		    	  new CratesMenu(this.plugin).openGUICrate(player);
		    	  break;
		      case BOOK:
		    	  break;
		      case ARROW:
		    	  player.closeInventory();
		    	  new Station(this.plugin).openGUIMining(player);
		    	  break;
		      }
		      if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ")) {
		    	  event.setCancelled(true);
		      }
		}
	}
	
	public void openGUIArch(Player player) {
		Inventory Arch = Bukkit.createInventory(null, 54, ChatColor.DARK_RED + "" + ChatColor.BOLD + "Archivist");
		
		ItemStack Relic = new ItemStack(Material.END_CRYSTAL);
		ItemMeta RelicMeta = Relic.getItemMeta();
		ArrayList<String> Reliclore = new ArrayList();
		Reliclore.add(" ");
		Reliclore.add(ChatColor.GRAY + "Give the archivist");
		Reliclore.add(ChatColor.GRAY + "unidentified relics here!");
		Reliclore.add(" ");
		Reliclore.add(ChatColor.DARK_RED + "" + ChatColor.ITALIC + "Coming Soon!");
		RelicMeta.setLore(Reliclore);
		
	    RelicMeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Relic Analyzer");
	    Relic.setItemMeta(RelicMeta);
	    Arch.setItem(20, Relic);
	    
		ItemStack Crate = new ItemStack(Material.PISTON_BASE);
		ItemMeta CrateMeta = Crate.getItemMeta();
		ArrayList<String> Cratelore = new ArrayList();
		Cratelore.add("");
		Cratelore.add(ChatColor.GRAY + "Give the archivist");
		Cratelore.add(ChatColor.GRAY + "unopened crates here!");
		CrateMeta.setLore(Cratelore);
		
		CrateMeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Crate Analyzer");
		Crate.setItemMeta(CrateMeta);
		Arch.setItem(24, Crate);
		
		ItemStack Info = new ItemStack(Material.BOOK);
		ItemMeta InfoMeta = Info.getItemMeta();
		ArrayList<String> Infolore = new ArrayList();
		Infolore.add(ChatColor.GRAY + "The archivist identifies relics");
		Infolore.add(ChatColor.GRAY + "and opens crates!");
		InfoMeta.setLore(Infolore);
		
		InfoMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Information");
		Info.setItemMeta(InfoMeta);
		Arch.setItem(48, Info);
		
		ItemStack Back = new ItemStack(Material.ARROW);
		ItemMeta BackMeta = Back.getItemMeta();
		ArrayList<String> Backlore = new ArrayList();
	    Backlore.add(ChatColor.GRAY + "Click to go back!");
	    BackMeta.setLore(Backlore);
	    BackMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Back");
	    Back.setItemMeta(BackMeta);
	    Arch.setItem(50, Back);
	    
	    ItemStack redGlass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
	    ItemMeta redGlassMeta = redGlass.getItemMeta();
	    ArrayList<String> redGlasslore = new ArrayList();
	    redGlasslore.add(" ");
	    
	    redGlassMeta.setDisplayName(" ");
	    redGlass.setItemMeta(redGlassMeta);
	    Arch.setItem(10, redGlass);
	    Arch.setItem(11, redGlass);
	    Arch.setItem(12, redGlass);
	    Arch.setItem(14, redGlass);
	    Arch.setItem(15, redGlass);
	    Arch.setItem(16, redGlass);
	    Arch.setItem(19, redGlass);
	    Arch.setItem(21, redGlass);
	    Arch.setItem(23, redGlass);
	    Arch.setItem(25, redGlass);
	    Arch.setItem(28, redGlass);
	    Arch.setItem(29, redGlass);
	    Arch.setItem(30, redGlass);
	    Arch.setItem(32, redGlass);
	    Arch.setItem(33, redGlass);
	    Arch.setItem(34, redGlass);
	    
	    int glass = 0;
	    while (glass < 54) {
	    	if (((glass < 10) || (glass >= 13)) && ((glass < 14) || (glass >= 17)) && ((glass < 19) || (glass >= 22)) && ((glass < 23) || (glass >= 26)) && ((glass < 28) || (glass >= 31)) && ((glass < 32) || (glass >= 35)) && (glass != 48) && (glass != 50)) {
	            ItemStack Glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
	            ItemMeta GlassMeta = Glass.getItemMeta();
	            GlassMeta.setDisplayName(" ");
	            Glass.setItemMeta(GlassMeta);
	            Arch.setItem(glass, Glass);
	    	}
	    	glass ++;
	    }
	    player.openInventory(Arch);
	}
}
