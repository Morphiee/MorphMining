package me.morphie.MorphMining.Items;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.ChatColor;
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

public class Artifacts implements Listener {
	
	private Main plugin;
	  
	public Artifacts(Main plugin) {
		this.plugin = plugin;
	}
	
    private void dropArt(World world, Location loc, ItemStack artifact) {
		loc.setY(loc.getY() + 1.0D);
	    world.dropItem(loc, artifact);
	} 
    
	public void getArts(String s, Integer i, Player p) {
		
		ItemStack Art = new ItemStack(Material.GOLD_NUGGET, i);
		ItemMeta ArtMeta = Art.getItemMeta();
		ArtMeta.addEnchant(Enchantment.DURABILITY, 1, true);
		ArtMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		ArrayList<String> ArtLore = new ArrayList();
		
		ItemStack HellStone = new ItemStack(Material.FIREWORK_STAR, i);
		ItemMeta HellStoneMeta = HellStone.getItemMeta();
		HellStoneMeta.addEnchant(Enchantment.DURABILITY, 1, true);
		HellStoneMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		ArrayList<String> HellStoneLore = new ArrayList();
		
		if (s.equals("CommonArt")) {
			
		      int Count = 0;
		      while (plugin.getConfig().getString("Artifacts.Common." + Count + ".Name") != null) {
		        Count++;
		      }
		      
		      Random rand = new Random();
		      int an = rand.nextInt(Count);
		         
		      ArtMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Artifacts.Common." + an + ".Name")));
		      ArtLore.add(" ");
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Artifacts.Common." + an + ".Description")));
		      ArtLore.add(" ");
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.MainColor() + "Information&8:"));
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "Tier &8» &7Common"));
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "Ores &8» &7Coal"));
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.MainColor() + "MorphMining"));
	          ArtMeta.setLore(ArtLore);
	          Art.setItemMeta(ArtMeta);
		      dropArt(p.getWorld(), p.getLocation(), Art);
		}
		if (s.equals("RareArt")) {
			  
		      int Count = 0;
		      while (this.plugin.getConfig().getString("Artifacts.Rare." + Count + ".Name") != null) {
		        Count++;
		      }
		      
		      Random rand = new Random();
		      int an = rand.nextInt(Count);
		      
		      ArtMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Artifacts.Rare." + an + ".Name")));
		      ArtLore.add(" ");
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Artifacts.Rare." + an + ".Description")));
		      ArtLore.add(" ");
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.MainColor() + "Information&8:"));
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "Tier &8» &7Rare"));
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "Ores &8» &7Redstone"));
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.MainColor() + "MorphMining"));
	          ArtMeta.setLore(ArtLore);
	          Art.setItemMeta(ArtMeta);
		      dropArt(p.getWorld(), p.getLocation(), Art);
		}
		if (s.equals("LegendaryArt")) {
			  
		      int Count = 0;
		      while (this.plugin.getConfig().getString("Artifacts.Legendary." + Count + ".Name") != null) {
		        Count++;
		      }
		      
		      Random rand = new Random();
		      int an = rand.nextInt(Count);
		      
		      ArtMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Artifacts.Legendary." + an+ ".Name")));
		      ArtLore.add(" ");
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Artifacts.Legendary." + an + ".Description")));
		      ArtLore.add(" ");
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.MainColor() + "Information&8:"));
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "Tier &8» &7Legendary"));
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "Ores &8» &7Lapis"));
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.MainColor() + "MorphMining"));
	          ArtMeta.setLore(ArtLore);
	          Art.setItemMeta(ArtMeta);
		      dropArt(p.getWorld(), p.getLocation(), Art);
		}
		if (s.equals("MythicArt")) {
			  
		      int Count = 0;
		      while (this.plugin.getConfig().getString("Artifacts.Mythic." + Count + ".Name") != null) {
		        Count++;
		      }
		      
		      Random rand = new Random();
		      int an = rand.nextInt(Count);
		      
		      ArtMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Artifacts.Mythic." + an + ".Name")));
		      ArtLore.add(" ");
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Artifacts.Mythic." + an + ".Description")));
		      ArtLore.add(" ");
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.MainColor() + "Information&8:"));
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "Tier &8» &7Mythic"));
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "Ores &8» &7Emerald, Diamond"));
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.MainColor() + "MorphMining"));
	          ArtMeta.setLore(ArtLore);
	          Art.setItemMeta(ArtMeta);
		      dropArt(p.getWorld(), p.getLocation(), Art);
		}
		if (s.equals("HellStone")) {
			  
		      int Count = 0;
		      while (this.plugin.getConfig().getString("Artifacts.HellStone." + Count + ".Name") != null) {
		        Count++;
		      }
		      
		      Random rand = new Random();
		      int an = rand.nextInt(Count);
		      
		      HellStoneMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Artifacts.HellStone." + an + ".Name")));
		      HellStoneLore.add(" ");
		      HellStoneLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Artifacts.HellStone." + an + ".Description")));
		      HellStoneLore.add(" ");
		      HellStoneLore.add(ChatColor.translateAlternateColorCodes('&', this.MainColor() + "Information&8:"));
		      HellStoneLore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "Tier &8» &7HellStone"));
		      HellStoneLore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "Ores &8» &7Nether Quartz"));
		      HellStoneLore.add(ChatColor.translateAlternateColorCodes('&', this.MainColor() + "MorphMining"));
		      HellStoneMeta.setLore(HellStoneLore);
		      HellStone.setItemMeta(HellStoneMeta);
		      dropArt(p.getWorld(), p.getLocation(), HellStone);
		}
	}
	
    public String Prefix() {
    	return this.plugin.messagescfg.messagesCFG.getString("Messages.Misc.Prefix");
    }
    
    public String GUIColor() {
    	return this.plugin.messagescfg.messagesCFG.getString("Messages.Misc.GUIColor");
    }
    
    public String ItemColor() {
    	return this.plugin.messagescfg.messagesCFG.getString("Messages.Misc.ItemColor");
    }
    
    public String MainColor() {
    	return this.plugin.messagescfg.messagesCFG.getString("Messages.Misc.MainColor");
    }
    
    public String TextColor() {
    	return this.plugin.messagescfg.messagesCFG.getString("Messages.Misc.TextColor");
    }
    
    public String HighlightColor() {
    	return this.plugin.messagescfg.messagesCFG.getString("Messages.Misc.HighlightColor");
    }
    
    public String ErrorPrefix() {
    	return this.plugin.messagescfg.messagesCFG.getString("Messages.ErrorMessages.Prefix");
    }
}

