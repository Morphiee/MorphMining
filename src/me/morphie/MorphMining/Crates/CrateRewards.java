package me.morphie.MorphMining.Crates;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

import me.morphie.MorphMining.Main;
import me.morphie.MorphMining.Items.Artifacts;

public class CrateRewards implements Listener  {
	
	private Main plugin;
	  
	public CrateRewards(Main plugin) {
		this.plugin = plugin;
	}
	
	private void dropReward(World world, Location loc, ItemStack reward) {
		loc.setY(loc.getY() + 2.0D);
	    world.dropItem(loc, reward);
	}
	
	public void giveCrateReward(Player p, String s) {
		if (s.equals("Rocks")) {
		      Random randRocks = new Random();
		      int r = randRocks.nextInt(6);
		      if (r == 1) {		          
		    	  new Artifacts(this.plugin).getArts("CommonArt", 3, p);
		      }
		      else if (r == 2) {
		    	  new Artifacts(this.plugin).getArts("RareArt", 3, p);
		      }
		      else if (r == 3) {
		    	  ItemStack Coal = new ItemStack(Material.COAL_BLOCK, 4);
		          
		          dropReward(p.getWorld(), p.getLocation(), Coal);
		      }
		      else if (r == 4) {
		    	  ItemStack Redstone = new ItemStack(Material.REDSTONE_BLOCK, 4);
		          
		          dropReward(p.getWorld(), p.getLocation(), Redstone);
		      }
		      else if (r == 5) {
		    	  ItemStack Lapis = new ItemStack(Material.LAPIS_BLOCK, 2);
		          
		          dropReward(p.getWorld(), p.getLocation(), Lapis);
		      }
		      else {
		    	  ItemStack Andesite = new ItemStack(Material.STONE, 16, (short)5);
		          
		          dropReward(p.getWorld(), p.getLocation(), Andesite);
		      }
		}
		else if (s.equals("Iron")) {
		      Random randIron = new Random();
		      int i = randIron.nextInt(7);
		      
		      if (i == 1) {
		    	  new Artifacts(this.plugin).getArts("RareArt", 3, p);
		      }
		      else if (i == 2) {
		    	  new Artifacts(this.plugin).getArts("LegendaryArt", 1, p);
		      }
		      else if (i == 3) {
		    	  ItemStack unBook = new ItemStack(Material.ENCHANTED_BOOK);
		    	  EnchantmentStorageMeta unBookMeta = (EnchantmentStorageMeta)unBook.getItemMeta();
		    	  unBookMeta.addStoredEnchant(Enchantment.DURABILITY, 3, true);
		    	  unBook.setItemMeta(unBookMeta);
		    	  dropReward(p.getWorld(), p.getLocation(), unBook);
		      }
		      else if (i == 4) {
		    	  ItemStack Iron = new ItemStack(Material.IRON_BLOCK, 2);
		          
		          dropReward(p.getWorld(), p.getLocation(), Iron);
		      }
		      else if (i == 5) {
		    	  ItemStack Gold = new ItemStack(Material.GOLD_BLOCK, 2);
		          
		          dropReward(p.getWorld(), p.getLocation(), Gold);
		      }
		      else if (i == 6) {
		    	  ItemStack Quartz = new ItemStack(Material.QUARTZ_ORE, 6);
		          
		          dropReward(p.getWorld(), p.getLocation(), Quartz);
		      }
		      else {
		    	  ItemStack Shulker = new ItemStack(Material.RED_SHULKER_BOX);
		          
		          dropReward(p.getWorld(), p.getLocation(), Shulker);
		      }
		}
		else if (s.equals("Dream")) {
		      Random randIron = new Random();
		      int i = randIron.nextInt(7);
		      
		      if (i == 1) {
		    	  new Artifacts(this.plugin).getArts("LegendaryArt", 3, p);
		      }
		      else if (i == 2) {
		    	  new Artifacts(this.plugin).getArts("MythicArt", 1, p);
		      }
		      else if (i == 3) {
		    	  ItemStack mendBook = new ItemStack(Material.ENCHANTED_BOOK);
		    	  EnchantmentStorageMeta mendMeta = (EnchantmentStorageMeta)mendBook.getItemMeta();
		    	  mendMeta.addStoredEnchant(Enchantment.MENDING, 1, true);
		    	  mendBook.setItemMeta(mendMeta);
		    	  dropReward(p.getWorld(), p.getLocation(), mendBook);
		      }
		      else if (i == 4) {
		    	  ItemStack effBook = new ItemStack(Material.ENCHANTED_BOOK);
		    	  EnchantmentStorageMeta effMeta = (EnchantmentStorageMeta)effBook.getItemMeta();
		    	  effMeta.addStoredEnchant(Enchantment.DIG_SPEED, 5, true);
		    	  effBook.setItemMeta(effMeta);
		    	  
		    	  dropReward(p.getWorld(), p.getLocation(), effBook);
		      }
		      else if (i == 5) {
		    	  ItemStack Diamond = new ItemStack(Material.DIAMOND_BLOCK, 1);
		          
		          dropReward(p.getWorld(), p.getLocation(), Diamond);
		      }
		      else if (i == 6) {
		    	  ItemStack Emerald = new ItemStack(Material.EMERALD_BLOCK, 2);
		          
		          dropReward(p.getWorld(), p.getLocation(), Emerald);
		      }
		      else {
		    	  ItemStack Beacon = new ItemStack(Material.BEACON, 1);
		          
		          dropReward(p.getWorld(), p.getLocation(), Beacon);
		      }
		}
	}
}
