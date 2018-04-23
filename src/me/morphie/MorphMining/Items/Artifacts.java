package me.morphie.MorphMining.Items;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.morphie.MorphMining.Main;
import net.md_5.bungee.api.ChatColor;

public class Artifacts implements Listener {
	
	private Main plugin;
	  
	public Artifacts(Main plugin) {
		this.plugin = plugin;
	}
	
    private void dropArt(World world, Location loc, ItemStack artifact) {
		loc.setY(loc.getY() + 2.0D);
	    world.dropItem(loc, artifact);
	}
	
	public void getArts(String s, Integer i, Player p) {
		
		ItemStack Art = new ItemStack(Material.GOLD_NUGGET, i);
		ItemMeta ArtMeta = Art.getItemMeta();
		ArtMeta.addEnchant(Enchantment.DURABILITY, 1, true);
		ArtMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		ArrayList<String> ArtLore = new ArrayList();
		
		if (s.equals("CommonArt")) {
			
		      int Count = 1;
		      while (this.plugin.getConfig().getString("Artifacts.Common." + Count + ".Name") != null) {
		        Count++;
		      }
		      
		      Random rand = new Random();
		      int an = rand.nextInt(Count);
		      
		      ArtMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Artifacts.Common." + an + ".Name")));
		      ArtLore.add(" ");
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Artifacts.Common." + an + ".Description")));
		      ArtLore.add(" ");
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', "&4Information&8:"));
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', "&cTier &8» &7Common"));
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', "&cOres &8» &7Coal"));
	          ArtMeta.setLore(ArtLore);
	          Art.setItemMeta(ArtMeta);
		      dropArt(p.getWorld(), p.getLocation(), Art);
		}
		if (s.equals("RareArt")) {
			  
		      int Count = 1;
		      while (this.plugin.getConfig().getString("Artifacts.Rare." + Count + ".Name") != null) {
		        Count++;
		      }
		      
		      Random rand = new Random();
		      int an = rand.nextInt(Count);
		      if(an == 0) {
		    	  an++;
		      }
		      
		      ArtMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Artifacts.Rare." + an + ".Name")));
		      ArtLore.add(" ");
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Artifacts.Rare." + an + ".Description")));
		      ArtLore.add(" ");
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', "&4Information&8:"));
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', "&cTier &8» &7Rare"));
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', "&cOres &8» &7Redstone"));
	          ArtMeta.setLore(ArtLore);
	          Art.setItemMeta(ArtMeta);
		      dropArt(p.getWorld(), p.getLocation(), Art);
		}
		if (s.equals("LegendaryArt")) {
			  
		      int Count = 1;
		      while (this.plugin.getConfig().getString("Artifacts.Legendary." + Count + ".Name") != null) {
		        Count++;
		      }
		      
		      Random rand = new Random();
		      int an = rand.nextInt(Count);
		      if(an == 0) {
		    	  an++;
		      }
		      
		      ArtMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Artifacts.Legendary." + an+ ".Name")));
		      ArtLore.add(" ");
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Artifacts.Legendary." + an + ".Description")));
		      ArtLore.add(" ");
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', "&4Information&8:"));
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', "&cTier &8» &7Legendary"));
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', "&cOres &8» &7Legendary"));
	          ArtMeta.setLore(ArtLore);
	          Art.setItemMeta(ArtMeta);
		      dropArt(p.getWorld(), p.getLocation(), Art);
		}
		if (s.equals("MythicArt")) {
			  
		      int Count = 1;
		      while (this.plugin.getConfig().getString("Artifacts.Mythic." + Count + ".Name") != null) {
		        Count++;
		      }
		      
		      Random rand = new Random();
		      int an = rand.nextInt(Count);
		      if(an == 0) {
		    	  an++;
		      }
		      
		      ArtMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Artifacts.Mythic." + an + ".Name")));
		      ArtLore.add(" ");
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Artifacts.Mythic." + an + ".Description")));
		      ArtLore.add(" ");
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', "&4Information&8:"));
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', "&cTier &8» &7Mythic"));
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', "&cOres &8» &7Emerald, Diamond"));
	          ArtMeta.setLore(ArtLore);
	          Art.setItemMeta(ArtMeta);
		      dropArt(p.getWorld(), p.getLocation(), Art);
		}
	}
}
