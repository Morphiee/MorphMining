package me.morphie.MorphMining.MineLog;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.morphie.MorphMining.Main;
import net.md_5.bungee.api.ChatColor;

public class LogArtsMenu implements Listener {
	
	private Main plugin;
	  
	public LogArtsMenu(Main plugin) {
		this.plugin = plugin;
	}
	
	public void openGUIArtsLog(Player player) {
		Inventory ArtsLog = Bukkit.createInventory(null, 36, ChatColor.DARK_RED + "" + ChatColor.BOLD + "Miner's Log" + ChatColor.DARK_GRAY + ":" + ChatColor.RED + " Artifacts");
		
		ItemStack Common = new ItemStack(Material.GOLD_NUGGET);
  	  	ItemMeta CommonMeta = Common.getItemMeta();
  	  	CommonMeta.addEnchant(Enchantment.DURABILITY, 1, true);
  	  	CommonMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
	    ArrayList<String> Commonlore = new ArrayList();
	    Commonlore.add(" ");
	    Commonlore.add(ChatColor.RED + "Found In" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " COAL ORE");
	    Commonlore.add(ChatColor.RED + "Drop Chance" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " 20%");
	    Commonlore.add(ChatColor.RED + "Sell Price" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " $50");
	    CommonMeta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Common Artifact");
	    CommonMeta.setLore(Commonlore);
	    Common.setItemMeta(CommonMeta);
	    ArtsLog.setItem(10, Common);
	    
		ItemStack Rare = new ItemStack(Material.GOLD_NUGGET);
  	  	ItemMeta RareMeta = Rare.getItemMeta();
  	  	RareMeta.addEnchant(Enchantment.DURABILITY, 1, true);
  	  	RareMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
	    ArrayList<String> Rarelore = new ArrayList();
	    Rarelore.add(" ");
	    Rarelore.add(ChatColor.RED + "Found In" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " REDSTONE ORE");
	    Rarelore.add(ChatColor.RED + "Drop Chance" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " 15%");
	    Rarelore.add(ChatColor.RED + "Sell Price" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " $250");
	    RareMeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Rare Artifact");
	    RareMeta.setLore(Rarelore);
	    Rare.setItemMeta(RareMeta);
	    ArtsLog.setItem(12, Rare);
	    
		ItemStack Legend = new ItemStack(Material.GOLD_NUGGET);
  	  	ItemMeta LegendMeta = Legend.getItemMeta();
  	  	LegendMeta.addEnchant(Enchantment.DURABILITY, 1, true);
  	  	LegendMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
	    ArrayList<String> Legendlore = new ArrayList();
	    Legendlore.add(" ");
	    Legendlore.add(ChatColor.RED + "Found In" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " LAPIS ORE");
	    Legendlore.add(ChatColor.RED + "Drop Chance" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " 5%");
	    Legendlore.add(ChatColor.RED + "Sell Price" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " $750");
	    LegendMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Legendary Artifact");
	    LegendMeta.setLore(Legendlore);
	    Legend.setItemMeta(LegendMeta);
	    ArtsLog.setItem(14, Legend);
	    
		ItemStack Mythic = new ItemStack(Material.GOLD_NUGGET);
  	  	ItemMeta MythicMeta = Mythic.getItemMeta();
  	  	MythicMeta.addEnchant(Enchantment.DURABILITY, 1, true);
  	  	MythicMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
	    ArrayList<String> Mythiclore = new ArrayList();
	    Mythiclore.add(" ");
	    Mythiclore.add(ChatColor.RED + "Found In" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " DIAMOND ORE, EMERALD ORE");
	    Mythiclore.add(ChatColor.RED + "Drop Chance" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " 3%");
	    Mythiclore.add(ChatColor.RED + "Sell Price" + ChatColor.DARK_GRAY + ":" + ChatColor.GRAY + " $2500");
	    MythicMeta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Mythic Artifact");
	    MythicMeta.setLore(Mythiclore);
	    Mythic.setItemMeta(MythicMeta);
	    ArtsLog.setItem(16, Mythic);
	    
	    ItemStack Info = new ItemStack(Material.BOOK);
	    ItemMeta InfoMeta = Info.getItemMeta();
	    ArrayList<String> Infolore = new ArrayList();
	    Infolore.add(ChatColor.GRAY + "Hover over an artifact to");
	    Infolore.add(ChatColor.GRAY + "view all of its information!");
	    InfoMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Information");
	    InfoMeta.setLore(Infolore);
	    Info.setItemMeta(InfoMeta);
	    ArtsLog.setItem(30, Info);
	    
		ItemStack Back = new ItemStack(Material.ARROW);
		ItemMeta BackMeta = Back.getItemMeta();
		ArrayList<String> Backlore = new ArrayList();
	    Backlore.add(ChatColor.GRAY + "Click to go back!");
	    BackMeta.setLore(Backlore);
	    BackMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Back");
	    Back.setItemMeta(BackMeta);
	    ArtsLog.setItem(32, Back);
	    
	    ItemStack redGlass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
	    ItemMeta redGlassMeta = redGlass.getItemMeta();
	    ArrayList<String> redGlasslore = new ArrayList();
	    redGlasslore.add(" ");
	    redGlassMeta.setDisplayName(" ");
	    redGlass.setItemMeta(redGlassMeta);
	    ArtsLog.setItem(0, redGlass);
	    ArtsLog.setItem(8, redGlass);
	    ArtsLog.setItem(27, redGlass);
	    ArtsLog.setItem(35, redGlass);
	    
	    int x = 0;
	    while (x < 36)
	    {
	      if ((x != 0) && (x != 8) && (x != 27) && (x != 35) && (x != 32) && (x != 30) && (x != 16) && (x != 14) && (x != 12) && (x != 10))
	      {
	        ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
	        ItemMeta glassMeta = glass.getItemMeta();
	        
	        glassMeta.setDisplayName(" ");
	        glass.setItemMeta(glassMeta);
	        ArtsLog.setItem(x, glass);
	      }
	      x++;
	    }
	    
	    player.openInventory(ArtsLog);
	}
}