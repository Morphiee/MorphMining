package me.morphie.morphmining.DataLog;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;
import me.morphie.morphmining.MorphMining;

public class LogMenu implements Listener {
	
	private MorphMining plugin;
	  
	public LogMenu(MorphMining plugin) {
		this.plugin = plugin;
	}

	public void openGUIMineLog(Player player) {
		Inventory MineLog = Bukkit.createInventory(null, 36, ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.TitleColor") + "DataLog"));
		
		ItemStack Art = new ItemStack(Material.matchMaterial(this.plugin.getConfig().getString("Settings.ArtifactItem")));
  	  	ItemMeta ArtMeta = Art.getItemMeta();
	    ArrayList<String> Artlore = new ArrayList();
		Artlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Click to view all artifacts"));
		Artlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "in the given tier."));
		ArtMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Artifact Types"));
		ArtMeta.setLore(Artlore);
	    Art.setItemMeta(ArtMeta);
	    MineLog.setItem(10, Art);
	    
		ItemStack Common = new ItemStack(Material.BRICK);
  	  	ItemMeta CommonMeta = Common.getItemMeta();
	    ArrayList<String> Commonlore = new ArrayList();
	    Commonlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Click to view all Common artifacts!"));
	    CommonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Common Artifacts"));
	    CommonMeta.setLore(Commonlore);
	    Common.setItemMeta(CommonMeta);
	    MineLog.setItem(12, Common);
		    
		ItemStack Rare = new ItemStack(Material.IRON_INGOT);
  	  	ItemMeta RareMeta = Rare.getItemMeta();
	    ArrayList<String> Rarelore = new ArrayList();
	    Rarelore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Click to view all Rare artifacts!"));
	    RareMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Rare Artifacts"));
	    RareMeta.setLore(Rarelore);
	    Rare.setItemMeta(RareMeta);
	    MineLog.setItem(13, Rare);
	    
		ItemStack Legend = new ItemStack(Material.GOLD_INGOT);
  	  	ItemMeta LegendMeta = Legend.getItemMeta();
	    ArrayList<String> Legendlore = new ArrayList();
	    Legendlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Click to view all Legendary artifacts!"));
	    LegendMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Legendary Artifacts"));
	    LegendMeta.setLore(Legendlore);
	    Legend.setItemMeta(LegendMeta);
	    MineLog.setItem(14, Legend);
	    
		ItemStack Mythic = new ItemStack(Material.DIAMOND);
  	  	ItemMeta MythicMeta = Mythic.getItemMeta();
	    ArrayList<String> Mythiclore = new ArrayList();
	    Mythiclore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Click to view all Mythic artifacts!"));
	    MythicMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Mythic Artifacts"));
	    MythicMeta.setLore(Mythiclore);
	    Mythic.setItemMeta(MythicMeta);
	    MineLog.setItem(15, Mythic);
	    
		ItemStack Hell = new ItemStack(Material.NETHER_BRICK);
  	  	ItemMeta HellMeta = Hell.getItemMeta();
	    ArrayList<String> Helllore = new ArrayList();
	    Helllore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Click to view all Hellstone artifacts!"));
	    HellMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Hellstone Artifacts"));
	    HellMeta.setLore(Helllore);
	    Hell.setItemMeta(HellMeta);
	    MineLog.setItem(16, Hell);
		     
		ItemStack Back = new ItemStack(Material.REDSTONE);
		ItemMeta BackMeta = Back.getItemMeta();
		ArrayList<String> Backlore = new ArrayList();
	    Backlore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Click to go back!"));
	    BackMeta.setLore(Backlore);
	    BackMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Back" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
	    Back.setItemMeta(BackMeta);
	    MineLog.setItem(30, Back);
	    
		ItemStack Info = new ItemStack(Material.BOOK);
		ItemMeta InfoMeta = Info.getItemMeta();
		ArrayList<String> Infolore = new ArrayList();
		Infolore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "Hover over each item for"));
		Infolore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") + "more information!"));
		InfoMeta.setLore(Infolore);
		InfoMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Information" + this.plugin.getMessage("Menus.SpacerColor") + ":"));
		Info.setItemMeta(InfoMeta);
		MineLog.setItem(32, Info);
	    
	    ItemStack bGlass = new ItemStack(Material.LEGACY_STAINED_GLASS_PANE, 1, (short) + this.plugin.getConfig().getInt("Settings.MainGlassColor"));
	    ItemMeta bGlassMeta = bGlass.getItemMeta();
	    ArrayList<String> bGlasslore = new ArrayList();
	    bGlasslore.add(" ");
	    bGlassMeta.setDisplayName(" ");
	    bGlass.setItemMeta(bGlassMeta);
	    MineLog.setItem(9, bGlass);
	    MineLog.setItem(11, bGlass);
	    MineLog.setItem(17, bGlass);
	    
	    int glass = 0;
	    while (glass < 36) {
	    	if ((glass != 9) && (glass != 10) && (glass != 11) && (glass != 12) && (glass != 13) && (glass != 14) && (glass != 15) && (glass != 16) && (glass != 17) && (glass != 30) && (glass != 32)) {
	            ItemStack Glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1, (short)15);
	            ItemMeta GlassMeta = Glass.getItemMeta();
	            GlassMeta.setDisplayName(" ");
	            Glass.setItemMeta(GlassMeta);
	            MineLog.setItem(glass, Glass);
	    	}
	    	glass ++;
	    }
	    
	    player.openInventory(MineLog);
	}
}	
