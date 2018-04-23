package me.morphie.MorphMining.MineLog;

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

public class LogMenu implements Listener {
	
	private Main plugin;
	  
	public LogMenu(Main plugin) {
		this.plugin = plugin;
	}
	
	public void openGUIMineLog(Player player) {
		Inventory MineLog = Bukkit.createInventory(null, 27, ChatColor.DARK_RED + "" + ChatColor.BOLD + "Miner's Log");
		
		ItemStack Art = new ItemStack(Material.GOLD_NUGGET);
  	  	ItemMeta ArtMeta = Art.getItemMeta();
	    ArrayList<String> Artlore = new ArrayList();
		Artlore.add(ChatColor.GRAY + "Everything Artifacts!");
		ArtMeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Artifacts");
		ArtMeta.setLore(Artlore);
	    Art.setItemMeta(ArtMeta);
	    MineLog.setItem(10, Art);
		    
		ItemStack Crate = new ItemStack(Material.PISTON_BASE);
  	  	ItemMeta CrateMeta = Crate.getItemMeta();
	    ArrayList<String> Cratelore = new ArrayList();
		Cratelore.add(ChatColor.GRAY + "Everything Crates!");
		CrateMeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Crates");
		CrateMeta.setLore(Cratelore);
	    Crate.setItemMeta(CrateMeta);
	    MineLog.setItem(11, Crate);
		    
		ItemStack Relic = new ItemStack(Material.END_CRYSTAL);
  	  	ItemMeta RelicMeta = Relic.getItemMeta();
	    ArrayList<String> Reliclore = new ArrayList();
	    Reliclore.add(ChatColor.GRAY + "Everything Relics!");
	    Reliclore.add(ChatColor.DARK_RED + "" + ChatColor.ITALIC + "Coming Soon!");
	    RelicMeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Relics");
	    RelicMeta.setLore(Reliclore);
	    Relic.setItemMeta(RelicMeta);
	    MineLog.setItem(12, Relic);
		    
		ItemStack Fossil = new ItemStack(Material.BONE);
  	  	ItemMeta FossilMeta = Fossil.getItemMeta();
	    ArrayList<String> Fossillore = new ArrayList();
	    Fossillore.add(ChatColor.GRAY + "Everything Fossils!");
	    Fossillore.add(ChatColor.DARK_RED + "" + ChatColor.ITALIC + "Coming Soon!");
	    FossilMeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Fossils");
	    FossilMeta.setLore(Fossillore);
	    Fossil.setItemMeta(FossilMeta);
	    MineLog.setItem(13, Fossil);
		    
		ItemStack Barrier = new ItemStack(Material.BARRIER);
  	  	ItemMeta BarrierMeta = Barrier.getItemMeta();
  	  	BarrierMeta.setDisplayName(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "[" + ChatColor.RED + ChatColor.BOLD + "!" + ChatColor.DARK_GRAY + ChatColor.BOLD + "]" + ChatColor.DARK_RED + ChatColor.ITALIC + " Coming soon!");
  	  	Barrier.setItemMeta(BarrierMeta);
	    MineLog.setItem(14, Barrier);
		    
		ItemStack Back = new ItemStack(Material.ARROW);
		ItemMeta BackMeta = Back.getItemMeta();
		ArrayList<String> Backlore = new ArrayList();
	    Backlore.add(ChatColor.GRAY + "Click to go back!");
	    BackMeta.setLore(Backlore);
	    BackMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Back");
	    Back.setItemMeta(BackMeta);
	    MineLog.setItem(16, Back);
		    
	    ItemStack redGlass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
	    ItemMeta redGlassMeta = redGlass.getItemMeta();
	    ArrayList<String> redGlasslore = new ArrayList();
	    redGlasslore.add(" ");
	    redGlassMeta.setDisplayName(" ");
	    redGlass.setItemMeta(redGlassMeta);
	    MineLog.setItem(6, redGlass);
	    MineLog.setItem(7, redGlass);
	    MineLog.setItem(8, redGlass);
	    MineLog.setItem(15, redGlass);
	    MineLog.setItem(17, redGlass);
	    MineLog.setItem(24, redGlass);
	    MineLog.setItem(25, redGlass);
	    MineLog.setItem(26, redGlass);
	    
	    int x = 0;
	    while (x < 27)
	    {
	      if (((x < 6) || (x >= 9)) && ((x < 10) || (x >= 18)) && ((x < 24) || (x >= 27)))
	      {
	        ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
	        ItemMeta glassMeta = glass.getItemMeta();
	        
	        glassMeta.setDisplayName(" ");
	        glass.setItemMeta(glassMeta);
	        MineLog.setItem(x, glass);
	      }
	      x++;
	    }
	    
	    player.openInventory(MineLog);
	}
}	
