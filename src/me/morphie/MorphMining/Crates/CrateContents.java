package me.morphie.MorphMining.Crates;

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

public class CrateContents implements Listener {
	
	private Main plugin;
	  
	public CrateContents(Main plugin) {
		this.plugin = plugin;
	}
	
	public void openGUIRocks(Player player) {
		Inventory CrateRocks = Bukkit.createInventory(null, 9, ChatColor.GRAY + "" + ChatColor.BOLD + "Pile Of Rocks" + ChatColor.DARK_GRAY + ":" + ChatColor.DARK_RED + " Possible Winnings!");
		
			ItemStack Common = new ItemStack(Material.GOLD_NUGGET, 3);
	  	  	ItemMeta CommonMeta = Common.getItemMeta();
	  	  	CommonMeta.addEnchant(Enchantment.DURABILITY, 1, true);
	  	  	CommonMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
	  	  	CommonMeta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Common Artifact");
		    ArrayList<String> CommonLore = new ArrayList();
		    
		    CommonLore.add("");
		    CommonLore.add(ChatColor.DARK_RED + "BMCMines");
		    CommonLore.add(ChatColor.RED + "" + ChatColor.ITALIC + "Right click to open the mining market!");
		    
		    CommonMeta.setLore(CommonLore);
		    Common.setItemMeta(CommonMeta);
		    
	    	ItemStack Rare = new ItemStack(Material.GOLD_NUGGET, 1);
	    	ItemMeta RareMeta = Rare.getItemMeta();
	    	RareMeta.addEnchant(Enchantment.DURABILITY, 1, true);
	    	RareMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
	    	RareMeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Rare Artifact");
	        ArrayList<String> RareLore = new ArrayList();
	          
	        RareLore.add("");
	        RareLore.add(ChatColor.DARK_RED + "BMCMines");
	        RareLore.add(ChatColor.RED + "" + ChatColor.ITALIC + "Right click to open the mining market!");
	          
	        RareMeta.setLore(RareLore);
	        Rare.setItemMeta(RareMeta);
	        
	        ItemStack Coal = new ItemStack(Material.COAL_BLOCK, 4);
	        
	        ItemStack Redstone = new ItemStack(Material.REDSTONE_BLOCK, 4);
	        
	        ItemStack Lapis = new ItemStack(Material.LAPIS_BLOCK, 2);
	        
	        ItemStack Andesite = new ItemStack(Material.STONE, 16, (short)5);
	        
	        CrateRocks.setItem(0, Common);
	        CrateRocks.setItem(1, Rare);
	        CrateRocks.setItem(2, Coal);
	        CrateRocks.setItem(3, Redstone);
	        CrateRocks.setItem(4, Lapis);
	        CrateRocks.setItem(5, Andesite);
	        
	        player.openInventory(CrateRocks);
	}
	
	public void openGUIIron(Player player) {
		Inventory  CrateIron = Bukkit.createInventory(null, 9, ChatColor.YELLOW + "" + ChatColor.BOLD + "Ironed Out" + ChatColor.DARK_GRAY + ":" + ChatColor.DARK_RED + " Possible Winnings!");
		
	  	  	ItemStack Rare = new ItemStack(Material.GOLD_NUGGET, 3);
	  	  	ItemMeta RareMeta = Rare.getItemMeta();
	  	  	RareMeta.addEnchant(Enchantment.DURABILITY, 1, true);
	  	  	RareMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
	  	  	RareMeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Rare Artifact");
	  	  	ArrayList<String> RareLore = new ArrayList();
        
	  	  	RareLore.add("");
	  	  	RareLore.add(ChatColor.DARK_RED + "BMCMines");
	  	  	RareLore.add(ChatColor.RED + "" + ChatColor.ITALIC + "Right click to open the mining market!");
        
	  	  	RareMeta.setLore(RareLore);
	  	  	Rare.setItemMeta(RareMeta);
	  	  	
	  	  	ItemStack Legendary = new ItemStack(Material.GOLD_NUGGET);
	  	  	ItemMeta LegendaryMeta = Legendary.getItemMeta();
	  	  	LegendaryMeta.addEnchant(Enchantment.DURABILITY, 1, true);
	  	  	LegendaryMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
    	  	LegendaryMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Legendary Artifact");
    	  	ArrayList<String> LegendaryLore = new ArrayList();
          
    	  	LegendaryLore.add("");
    	  	LegendaryLore.add(ChatColor.DARK_RED + "BMCMines");
    	  	LegendaryLore.add(ChatColor.RED + "" + ChatColor.ITALIC + "Right click to open the mining market!");
          
    	  	LegendaryMeta.setLore(LegendaryLore);
          	Legendary.setItemMeta(LegendaryMeta);
          	
          	ItemStack unBook = new ItemStack(Material.ENCHANTED_BOOK);
          	ItemMeta unBookMeta = unBook.getItemMeta();
          	unBookMeta.addEnchant(Enchantment.DURABILITY, 3, true);
          	unBook.setItemMeta(unBookMeta);
          	
          	ItemStack Iron = new ItemStack(Material.IRON_BLOCK, 2);
          	
          	ItemStack Gold = new ItemStack(Material.GOLD_BLOCK, 2);
          	
          	ItemStack Quartz = new ItemStack(Material.QUARTZ_ORE, 6);
          	
          	ItemStack Shulker = new ItemStack(Material.RED_SHULKER_BOX);
          	
          	CrateIron.setItem(0, Rare);
          	CrateIron.setItem(1, Legendary);
          	CrateIron.setItem(2, unBook);
          	CrateIron.setItem(3, Iron);
          	CrateIron.setItem(4, Gold);
          	CrateIron.setItem(5, Quartz);
          	CrateIron.setItem(6, Shulker);
        
	  	  	player.openInventory(CrateIron);
	}
	
	public void openGUIDream(Player player) {
		Inventory CrateDream = Bukkit.createInventory(null, 9, ChatColor.DARK_RED + "" + ChatColor.BOLD + "A Miner's Dream" + ChatColor.DARK_GRAY + ":" + ChatColor.DARK_RED + " Possible Winnings!");
		
	  	  	ItemStack Legendary = new ItemStack(Material.GOLD_NUGGET, 3);
	  	  	ItemMeta LegendaryMeta = Legendary.getItemMeta();
	  	  	LegendaryMeta.addEnchant(Enchantment.DURABILITY, 1, true);
	  	  	LegendaryMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
	  	  	LegendaryMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Legendary Artifact");
	        ArrayList<String> LegendaryLore = new ArrayList();
        
	        LegendaryLore.add("");
	        LegendaryLore.add(ChatColor.DARK_RED + "BMCMines");
	        LegendaryLore.add(ChatColor.RED + "" + ChatColor.ITALIC + "Right click to open the mining market!");
	        
	        LegendaryMeta.setLore(LegendaryLore);
	        Legendary.setItemMeta(LegendaryMeta);
	        
	        ItemStack Mythic = new ItemStack(Material.GOLD_NUGGET);
	        ItemMeta MythicMeta = Mythic.getItemMeta();
	        MythicMeta.addEnchant(Enchantment.DURABILITY, 1, true);
	        MythicMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
	        MythicMeta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Mythic Artifact");
	        ArrayList<String> MythicLore = new ArrayList();
	          
	        MythicLore.add("");
	        MythicLore.add(ChatColor.DARK_RED + "BMCMines");
	        MythicLore.add(ChatColor.RED + "" + ChatColor.ITALIC + "Right click to open the mining market!");
          
	        MythicMeta.setLore(MythicLore);
	        Mythic.setItemMeta(MythicMeta);
				
	        ItemStack mendBook = new ItemStack(Material.ENCHANTED_BOOK);
	        ItemMeta mendBookMeta = mendBook.getItemMeta();
	        mendBookMeta.addEnchant(Enchantment.MENDING, 1, true);
	        mendBook.setItemMeta(mendBookMeta);
	        
	        ItemStack effBook = new ItemStack(Material.ENCHANTED_BOOK);
	    	ItemMeta effBookMeta = effBook.getItemMeta();
	    	effBookMeta.addEnchant(Enchantment.DIG_SPEED, 5, true);
	    	effBook.setItemMeta(effBookMeta);
	    	
	    	ItemStack Diamond = new ItemStack(Material.DIAMOND_BLOCK, 1);
	    	
	    	ItemStack Emerald = new ItemStack(Material.EMERALD_BLOCK, 2);
	    	
	    	ItemStack Beacon = new ItemStack(Material.BEACON, 1);
	    	
	    	CrateDream.setItem(0, Legendary);
	    	CrateDream.setItem(1, Mythic);
	    	CrateDream.setItem(2, mendBook);
	    	CrateDream.setItem(3, effBook);
	    	CrateDream.setItem(4, Diamond);
	    	CrateDream.setItem(5, Emerald);
	    	CrateDream.setItem(6, Beacon);
	    	
	    	player.openInventory(CrateDream);
	}	
}
