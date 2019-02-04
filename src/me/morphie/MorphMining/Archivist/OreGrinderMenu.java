package me.morphie.MorphMining.Archivist;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.morphie.MorphMining.Main;
import me.morphie.MorphMining.Files.playerFileMethods;
import net.md_5.bungee.api.ChatColor;

public class OreGrinderMenu implements Listener {
	
	private Main plugin;
	  
	public OreGrinderMenu(Main plugin) {
		this.plugin = plugin;
	}

	public void openGUIOG(Player player) {
		Inventory Shop = Bukkit.createInventory(null, 36, ChatColor.translateAlternateColorCodes('&', this.GUIColor() + "Ore Grinder"));
		UUID uuid = player.getUniqueId();
		
		ItemStack Info = new ItemStack(Material.BOOK);
		ItemMeta InfoMeta = Info.getItemMeta();
		ArrayList<String> Infolore = new ArrayList();
		Infolore.add(ChatColor.GRAY + "Drop loot in then close!");
		Infolore.add(" ");
		Infolore.add(ChatColor.translateAlternateColorCodes('&', HighlightColor() + "Gems&8: &7" + new playerFileMethods(this.plugin).getStat(uuid, "Stats.Gems")));
		InfoMeta.setLore(Infolore);
		
		InfoMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Information" + "&8:"));
		Info.setItemMeta(InfoMeta);
		Shop.setItem(32, Info);
		
		ItemStack Back = new ItemStack(Material.REDSTONE);
		ItemMeta BackMeta = Back.getItemMeta();
		ArrayList<String> Backlore = new ArrayList();
	    Backlore.add(ChatColor.GRAY + "Click to go back!");
	    BackMeta.setLore(Backlore);
	    BackMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', ItemColor() + "Back&8:"));
	    Back.setItemMeta(BackMeta);
	    Shop.setItem(30, Back);
	    
	    ItemStack Prices = new ItemStack(Material.MAP);
	    ItemMeta PricesMeta = Prices.getItemMeta();
	    ArrayList<String> Priceslore = new ArrayList();
	    Priceslore.add(" ");
	    Priceslore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "Coal Ore " + "&8| &7" + plugin.getConfig().getInt("OreGrinder.CoalGemChance")));
	    Priceslore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "Iron Ore " + "&8| &7" + plugin.getConfig().getInt("OreGrinder.IronGemChance")));
	    Priceslore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "Gold Ore " +  "&8| &7" + plugin.getConfig().getInt("OreGrinder.GoldGemChance")));
	    Priceslore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "Redstone Ore " + "&8| &7" + plugin.getConfig().getInt("OreGrinder.RedstoneGemChance")));
	    Priceslore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "Lapis Ore " + "&8| &7" + plugin.getConfig().getInt("OreGrinder.LapisGemChance")));
	    Priceslore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "Diamond Ore " + "&8| &7" + plugin.getConfig().getInt("OreGrinder.DiamondGemChance")));
	    Priceslore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "Emerald Ore " + "&8| &7" + plugin.getConfig().getInt("OreGrinder.EmeraldGemChance")));
	    PricesMeta.setLore(Priceslore);
	    PricesMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Ores &8|" + this.ItemColor() + " Chance"));
	    Prices.setItemMeta(PricesMeta);
	    Shop.setItem(4, Prices);
	    
	    ItemStack bGlass = new ItemStack(Material.LEGACY_STAINED_GLASS_PANE, 1, (short) + this.plugin.getConfig().getInt("MainGlassColor"));
	    ItemMeta bGlassMeta = bGlass.getItemMeta();
	    ArrayList<String> bGlasslore = new ArrayList();
	    bGlasslore.add(" ");
	    bGlassMeta.setDisplayName(" ");
	    bGlass.setItemMeta(bGlassMeta);
	    Shop.setItem(0, bGlass);
	    Shop.setItem(8, bGlass);
	    Shop.setItem(27, bGlass);
	    Shop.setItem(35, bGlass);
	    
	    int x = 0;
	    while (x < 36)
	    {
	      if ((x != 30) && (x != 32) && (x != 0) && (x != 8) && (x != 10) && (x != 11) && (x != 4) && (x != 15) && (x != 16) && (x != 27) && (x != 35))
	      {
	        ItemStack glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1, (short)15);
	        ItemMeta glassMeta = glass.getItemMeta();
	        
	        glassMeta.setDisplayName(" ");
	        glass.setItemMeta(glassMeta);
	        Shop.setItem(x, glass);
	      }
	      x++;
	    }
	    
	    player.openInventory(Shop);
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
