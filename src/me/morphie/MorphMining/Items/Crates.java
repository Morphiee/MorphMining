package me.morphie.MorphMining.Items;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.morphie.MorphMining.Main;
import net.md_5.bungee.api.ChatColor;

public class Crates implements Listener {
	
	private Main plugin;
	  
	public Crates(Main plugin) {
		this.plugin = plugin;
	}
	
	public static ItemStack Crate(String s, Integer i) {
		if (s.equals("RockCrate")) {
        	ItemStack Rock = new ItemStack(Material.PISTON_BASE, i);
        	ItemMeta RockMeta = Rock.getItemMeta();
        	RockMeta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Pile Of Rocks");
          	ArrayList<String> RockLore = new ArrayList();
          	RockLore.add("");
          	RockLore.add(ChatColor.DARK_RED + "MorphMining");
          	RockLore.add(ChatColor.GRAY + "Right-Click to open analyzation menu!");
          	RockLore.add(ChatColor.GRAY + "Left-Click to view possible winnings!");
          	RockMeta.setLore(RockLore);
          	Rock.setItemMeta(RockMeta);
          	return Rock;
		}
		if (s.equals("IronCrate")) {
        	ItemStack Iron = new ItemStack(Material.PISTON_BASE, i);
        	ItemMeta IronMeta = Iron.getItemMeta();
        	IronMeta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Ironed Out");
          	ArrayList<String> IronLore = new ArrayList();
          	IronLore.add("");
          	IronLore.add(ChatColor.DARK_RED + "MorphMining");
          	IronLore.add(ChatColor.GRAY + "Right-Click to open analyzation menu!");
          	IronLore.add(ChatColor.GRAY + "Left-Click to view possible winnings!");
          	IronMeta.setLore(IronLore);
          	Iron.setItemMeta(IronMeta);
          	return Iron;
		}
		if (s.equals("DreamCrate")) {
        	ItemStack Dream = new ItemStack(Material.PISTON_BASE, i);
        	ItemMeta DreamMeta = Dream.getItemMeta();
        	DreamMeta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Miner's Dream");
          	ArrayList<String> DreamLore = new ArrayList();
          	DreamLore.add("");
          	DreamLore.add(ChatColor.DARK_RED + "MorphMining");
          	DreamLore.add(ChatColor.GRAY + "Right-Click to open analyzation menu!");
          	DreamLore.add(ChatColor.GRAY + "Left-Click to view possible winnings!");
          	DreamMeta.setLore(DreamLore);
          	Dream.setItemMeta(DreamMeta);
          	return Dream;
		}
		return null;
	}
}
