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
		
		ItemStack Art = new ItemStack(Material.matchMaterial(this.plugin.getConfig().getString("Settings.ArtifactItem")), i);
		ItemMeta ArtMeta = Art.getItemMeta();
		ArtMeta.addEnchant(Enchantment.DURABILITY, 1, true);
		ArtMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		ArrayList<String> ArtLore = new ArrayList();
		
		ItemStack HellStone = new ItemStack(Material.matchMaterial(this.plugin.getConfig().getString("Settings.HellstoneItem")), i);
		ItemMeta HellStoneMeta = HellStone.getItemMeta();
		HellStoneMeta.addEnchant(Enchantment.DURABILITY, 1, true);
		HellStoneMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		ArrayList<String> HellStoneLore = new ArrayList();
		
		if (s.equals("CommonArt")) {
			
		      int Count = this.plugin.getArtifacts("Common");
		      int an = 0;
		      
		      if (Count > 0) {
			      Random rand = new Random();
			      an = rand.nextInt(Count + 1); 
		      }
		         
		      ArtMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Artifacts.Common." + an + ".Name")));
		      ArtLore.add(" ");
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Artifacts.Common." + an + ".Description")));
		      ArtLore.add(" ");
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Information" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "Tier " + this.plugin.getMessage("Menus.SpacerColor") + "» " + this.plugin.getMessage("Menus.LoreColor") + "Common"));
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "Ores " + this.plugin.getMessage("Menus.SpacerColor") + "» " + this.plugin.getMessage("Menus.LoreColor") + "Coal"));
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "MorphMining"));
	          ArtMeta.setLore(ArtLore);
	          Art.setItemMeta(ArtMeta);
		      dropArt(p.getWorld(), p.getLocation(), Art);
		}
		if (s.equals("RareArt")) {
			  
			  int Count = this.plugin.getArtifacts("Rare");
		      int an = 0;
		      
		      if (Count > 0) {
			      Random rand = new Random();
			      an = rand.nextInt(Count + 1); 
		      }
		      
		      ArtMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Artifacts.Rare." + an + ".Name")));
		      ArtLore.add(" ");
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Artifacts.Rare." + an + ".Description")));
		      ArtLore.add(" ");
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Information" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "Tier " + this.plugin.getMessage("Menus.SpacerColor") + "» " + this.plugin.getMessage("Menus.LoreColor") + "Rare"));
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "Ores " + this.plugin.getMessage("Menus.SpacerColor") + "» " + this.plugin.getMessage("Menus.LoreColor") + "Redstone"));
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "MorphMining"));
	          ArtMeta.setLore(ArtLore);
	          Art.setItemMeta(ArtMeta);
		      dropArt(p.getWorld(), p.getLocation(), Art);
		}
		if (s.equals("LegendaryArt")) {
			  
			  int Count = this.plugin.getArtifacts("Legendary");
		      int an = 0;
		      
		      if (Count > 0) {
			      Random rand = new Random();
			      an = rand.nextInt(Count + 1); 
		      }
		      
		      ArtMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Artifacts.Legendary." + an+ ".Name")));
		      ArtLore.add(" ");
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Artifacts.Legendary." + an + ".Description")));
		      ArtLore.add(" ");
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Information" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "Tier " + this.plugin.getMessage("Menus.SpacerColor") + "» " + this.plugin.getMessage("Menus.LoreColor") + "Legendary"));
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "Ores " + this.plugin.getMessage("Menus.SpacerColor") + "» " + this.plugin.getMessage("Menus.LoreColor") + "Lapis"));
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "MorphMining"));
	          ArtMeta.setLore(ArtLore);
	          Art.setItemMeta(ArtMeta);
		      dropArt(p.getWorld(), p.getLocation(), Art);
		}
		if (s.equals("MythicArt")) {
			  
			  int Count = this.plugin.getArtifacts("Mythic");
		      int an = 0;
		      
		      if (Count > 0) {
			      Random rand = new Random();
			      an = rand.nextInt(Count + 1); 
		      }
		      
		      ArtMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Artifacts.Mythic." + an + ".Name")));
		      ArtLore.add(" ");
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Artifacts.Mythic." + an + ".Description")));
		      ArtLore.add(" ");
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Information" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "Tier " + this.plugin.getMessage("Menus.SpacerColor") + "» " + this.plugin.getMessage("Menus.LoreColor") + "Mythic"));
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "Ores " + this.plugin.getMessage("Menus.SpacerColor") + "» " + this.plugin.getMessage("Menus.LoreColor") + "Diamond, Emerald"));
		      ArtLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "MorphMining"));
	          ArtMeta.setLore(ArtLore);
	          Art.setItemMeta(ArtMeta);
		      dropArt(p.getWorld(), p.getLocation(), Art);
		}
		if (s.equals("HellStone")) {
			  
			  int Count = this.plugin.getArtifacts("HellStone");
		      int an = 0;
		      
		      if (Count > 0) {
			      Random rand = new Random();
			      an = rand.nextInt(Count + 1); 
		      }
		      
		      HellStoneMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Artifacts.HellStone." + an + ".Name")));
		      HellStoneLore.add(" ");
		      HellStoneLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Artifacts.HellStone." + an + ".Description")));
		      HellStoneLore.add(" ");
		      HellStoneLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Information" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
		      HellStoneLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "Tier " + this.plugin.getMessage("Menus.SpacerColor") + "» " + this.plugin.getMessage("Menus.LoreColor") + "HellStone"));
		      HellStoneLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "Ores " + this.plugin.getMessage("Menus.SpacerColor") + "» " + this.plugin.getMessage("Menus.LoreColor") + "Nether Quartz"));
		      HellStoneLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "MorphMining"));
		      HellStoneMeta.setLore(HellStoneLore);
		      HellStone.setItemMeta(HellStoneMeta);
		      dropArt(p.getWorld(), p.getLocation(), HellStone);
		}
	}
}

