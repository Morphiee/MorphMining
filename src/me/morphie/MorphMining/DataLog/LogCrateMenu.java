package me.morphie.MorphMining.MineLog;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.morphie.MorphMining.Main;
import net.md_5.bungee.api.ChatColor;

public class LogCrateMenu implements Listener {
	
	private Main plugin;
	  
	public LogCrateMenu(Main plugin) {
		this.plugin = plugin;
	}
	
	public void openGUICrateLog(Player player) {
		Inventory CratesLog = Bukkit.createInventory(null, 36, ChatColor.DARK_RED + "" + ChatColor.BOLD + "Miner's Log" + ChatColor.DARK_GRAY + ":" + ChatColor.RED + " Crates");
		
		ItemStack Rock = new ItemStack(Material.PISTON_BASE);
  	  	ItemMeta RockMeta = Rock.getItemMeta();
	    ArrayList<String> Rocklore = new ArrayList();
	    Rocklore.add(" ");
	    Rocklore.add(ChatColor.RED + "Found In" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " COAL ORE, REDSTONE ORE");
	    Rocklore.add(ChatColor.RED + "Drop Chance" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " 15%");
	    Rocklore.add(ChatColor.RED + "Open Cost" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " $10");
	    RockMeta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Pile Of Rocks");
	    RockMeta.setLore(Rocklore);
	    Rock.setItemMeta(RockMeta);
	    CratesLog.setItem(11, Rock);
	    
		ItemStack Iron = new ItemStack(Material.PISTON_BASE);
  	  	ItemMeta IronMeta = Iron.getItemMeta();
	    ArrayList<String> Ironlore = new ArrayList();
	    Ironlore.add(" ");
	    Ironlore.add(ChatColor.RED + "Found In" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " LAPIS ORE");
	    Ironlore.add(ChatColor.RED + "Drop Chance" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " 10%");
	    Ironlore.add(ChatColor.RED + "Open Cost" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " $20");
	    IronMeta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Ironed Out");
	    IronMeta.setLore(Ironlore);
	    Iron.setItemMeta(IronMeta);
	    CratesLog.setItem(13, Iron);
	    
		ItemStack Dream = new ItemStack(Material.PISTON_BASE);
  	  	ItemMeta DreamMeta = Dream.getItemMeta();
	    ArrayList<String> Dreamlore = new ArrayList();
	    Dreamlore.add(" ");
	    Dreamlore.add(ChatColor.RED + "Found In" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " DIAMOND ORE, EMERALD ORE");
	    Dreamlore.add(ChatColor.RED + "Drop Chance" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " 7%");
	    Dreamlore.add(ChatColor.RED + "Open Cost" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " $30");
	    DreamMeta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Miner's Dream");
	    DreamMeta.setLore(Dreamlore);
	    Dream.setItemMeta(DreamMeta);
	    CratesLog.setItem(15, Dream);
	    
	    ItemStack Info = new ItemStack(Material.BOOK);
	    ItemMeta InfoMeta = Info.getItemMeta();
	    ArrayList<String> Infolore = new ArrayList();
	    Infolore.add(ChatColor.GRAY + "Hover over a crate to");
	    Infolore.add(ChatColor.GRAY + "view all of its information!");
	    InfoMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Information");
	    InfoMeta.setLore(Infolore);
	    Info.setItemMeta(InfoMeta);
	    CratesLog.setItem(30, Info);
	    
		ItemStack Back = new ItemStack(Material.ARROW);
		ItemMeta BackMeta = Back.getItemMeta();
		ArrayList<String> Backlore = new ArrayList();
	    Backlore.add(ChatColor.GRAY + "Click to go back!");
	    BackMeta.setLore(Backlore);
	    BackMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Back");
	    Back.setItemMeta(BackMeta);
	    CratesLog.setItem(32, Back);
	    
	    ItemStack redGlass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
	    ItemMeta redGlassMeta = redGlass.getItemMeta();
	    ArrayList<String> redGlasslore = new ArrayList();
	    redGlasslore.add(" ");
	    redGlassMeta.setDisplayName(" ");
	    redGlass.setItemMeta(redGlassMeta);
	    CratesLog.setItem(0, redGlass);
	    CratesLog.setItem(8, redGlass);
	    CratesLog.setItem(27, redGlass);
	    CratesLog.setItem(35, redGlass);
	    
	    int x = 0;
	    while (x < 36)
	    {
	      if ((x != 0) && (x != 8) && (x != 27) && (x != 35) && (x != 32) && (x != 30) && (x != 11) && (x != 13) && (x != 15))
	      {
	        ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
	        ItemMeta glassMeta = glass.getItemMeta();
	        
	        glassMeta.setDisplayName(" ");
	        glass.setItemMeta(glassMeta);
	        CratesLog.setItem(x, glass);
	      }
	      x++;
	    }
	    
	    player.openInventory(CratesLog);
	}
}
