package me.morphie.MorphMining;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.morphie.MorphMining.Items.Artifacts;
import me.morphie.MorphMining.Items.Crates;
import net.md_5.bungee.api.ChatColor;

public class Dev implements Listener {
	
	private Main plugin;
	  
	public Dev(Main plugin) {
		this.plugin = plugin;
	}
	
	public void giveCrates(Player player, String s) {
		if (s.equals("rock")) {
	          
			player.getInventory().addItem(Crates.Crate("RockCrate", 1));
		}
		else if (s.equals("iron")) {
			
			player.getInventory().addItem(Crates.Crate("IronCrate", 1));
		}
		else if (s.equals("dream")) {
			
			player.getInventory().addItem(Crates.Crate("DreamCrate", 1));
		}
	}
	@EventHandler
	  public void onInventoryClick(InventoryClickEvent event)
	  {
	    if (ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Mining Dev Menu")) {
	      Player player = (Player)event.getWhoClicked();
	      if ((event.getCurrentItem() == null) || (!event.getCurrentItem().hasItemMeta())) {
	        return;
	      }
	      switch (event.getCurrentItem().getType()) {
	      case GOLD_NUGGET:
	    	new Artifacts(this.plugin).getArts("CommonArt", 1, player);
	    	new Artifacts(this.plugin).getArts("RareArt", 1, player);
	    	new Artifacts(this.plugin).getArts("LegendaryArt", 1, player);
	    	new Artifacts(this.plugin).getArts("MythicArt", 1, player);
	        event.setCancelled(true);
	        break;
	      case PISTON_BASE:
	    	giveCrates(player, "rock");
	    	giveCrates(player, "iron");
	    	giveCrates(player, "dream");
	    	event.setCancelled(true);
	        break;
	      }
	      if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ")) {
	        event.setCancelled(true);
	      }
	   }
    }
	
	public void openGUIDev(Player player) {
		Inventory Dev = Bukkit.createInventory(null, 27, ChatColor.DARK_RED + "" + ChatColor.BOLD + "Mining Dev Menu");
		
		ItemStack Common = new ItemStack(Material.GOLD_NUGGET);
		ItemMeta CommonMeta = Common.getItemMeta();
		ArrayList<String> Commonlore = new ArrayList();
		Commonlore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "Click to get all artifacts!");
		CommonMeta.setLore(Commonlore);
		
		CommonMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Artifacts");
		Common.setItemMeta(CommonMeta);
		
		ItemStack All = new ItemStack(Material.PISTON_BASE);
		ItemMeta AllMeta = All.getItemMeta();
		ArrayList<String> Alllore = new ArrayList();
		Alllore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "Give all crates!");
		AllMeta.setLore(Alllore);
		
		AllMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Crates");
		All.setItemMeta(AllMeta);
		
		Dev.setItem(11, Common);
		Dev.setItem(15, All);
		
	    int x = 0;
	    while (x < 27)
	    {
	      if ((x != 11) && (x != 15))
	      {
	        ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
	        ItemMeta glassMeta = glass.getItemMeta();
	        
	        glassMeta.setDisplayName(" ");
	        glass.setItemMeta(glassMeta);
	        Dev.setItem(x, glass);
	      }
	      x++;
	    }
	    
	    player.openInventory(Dev);

	}
}