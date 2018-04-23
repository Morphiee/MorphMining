package me.morphie.MorphMining.Shop;

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

public class Shop implements Listener {
	
	private Main plugin;
	  
	public Shop(Main plugin) {
		this.plugin = plugin;
	}
	
	public void openGUIShop(Player player) {
		Inventory Shop = Bukkit.createInventory(null, 54, ChatColor.DARK_RED + "" + ChatColor.BOLD + "Mining Shop");
		
		ItemStack Info = new ItemStack(Material.BOOK);
		ItemMeta InfoMeta = Info.getItemMeta();
		ArrayList<String> Infolore = new ArrayList();
		Infolore.add(ChatColor.GRAY + "Drop loot in then close!");
		InfoMeta.setLore(Infolore);
		
		InfoMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Information");
		Info.setItemMeta(InfoMeta);
		Shop.setItem(48, Info);
		
		ItemStack Back = new ItemStack(Material.ARROW);
		ItemMeta BackMeta = Back.getItemMeta();
		ArrayList<String> Backlore = new ArrayList();
	    Backlore.add(ChatColor.GRAY + "Click to go back!");
	    BackMeta.setLore(Backlore);
	    BackMeta.setDisplayName(ChatColor.RED +  "" + ChatColor.BOLD + "Back");
	    Back.setItemMeta(BackMeta);
	    Shop.setItem(50, Back);
	    
	    ItemStack Prices = new ItemStack(Material.PAPER);
	    ItemMeta PricesMeta = Prices.getItemMeta();
	    ArrayList<String> Priceslore = new ArrayList();
	    Priceslore.add(" ");
	    Priceslore.add(ChatColor.RED + "Common" + ChatColor.DARK_GRAY + ": " + ChatColor.GRAY + this.plugin.getConfig().getDouble("ArtifactPrice.Common"));
	    Priceslore.add(ChatColor.RED + "Rare" + ChatColor.DARK_GRAY + ": " + ChatColor.GRAY + this.plugin.getConfig().getDouble("ArtifactPrice.Rare"));
	    Priceslore.add(ChatColor.RED + "Legendary" + ChatColor.DARK_GRAY + ": " + ChatColor.GRAY + this.plugin.getConfig().getDouble("ArtifactPrice.Legendary"));
	    Priceslore.add(ChatColor.RED + "Mythic" + ChatColor.DARK_GRAY + ": " + ChatColor.GRAY + this.plugin.getConfig().getDouble("ArtifactPrice.Mythic"));
	    PricesMeta.setLore(Priceslore);
	    PricesMeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Prices" + ChatColor.DARK_GRAY + ":");
	    Prices.setItemMeta(PricesMeta);
	    Shop.setItem(4, Prices);
	    
	    int x = 0;
	    while (x < 54)
	    {
	      if ((x != 48) && (x != 50) && ((x < 10) || (x >= 17)) && ((x < 19) || (x >= 26)) && ((x < 28) || (x >= 35)) && ((x < 37) || (x >= 44)) && (x != 4))
	      {
	        ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
	        ItemMeta glassMeta = glass.getItemMeta();
	        
	        glassMeta.setDisplayName(" ");
	        glass.setItemMeta(glassMeta);
	        Shop.setItem(x, glass);
	      }
	      x++;
	    }
	    
	    player.openInventory(Shop);
	}
}
