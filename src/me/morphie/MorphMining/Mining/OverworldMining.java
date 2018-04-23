package me.morphie.MorphMining.Mining;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.morphie.MorphMining.Main;
import me.morphie.MorphMining.Items.Artifacts;
import me.morphie.MorphMining.Items.Crates;
import me.morphie.MorphMining.Shop.Shop;
import net.md_5.bungee.api.ChatColor;

public class OverworldMining implements Listener {
	
	private Main plugin;
	  
	public OverworldMining(Main plugin) {
		this.plugin = plugin;
	}

    private void dropArt(World world, Location loc, ItemStack artifact) {
	    loc.setY(loc.getY());
	    world.dropItem(loc, artifact);
	}
    
    @EventHandler
    public void onArtClick(PlayerInteractEvent event) {
        final Player player = event.getPlayer();
        if (event.getAction() == null) {
          return;
        }
        if (event.getItem() == null) {
          return;
        }
        if (((event.getAction().equals(Action.RIGHT_CLICK_AIR)) || (event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) && (event.getItem().getType().equals(Material.GOLD_NUGGET)) && (event.getItem().hasItemMeta())) {
            ItemStack item2 = event.getItem();
            if (item2.getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Mythic Artifact") || item2.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "" + ChatColor.BOLD + "Legendary Artifact") || item2.getItemMeta().getDisplayName().equals(ChatColor.AQUA + "" + ChatColor.BOLD + "Rare Artifact") || item2.getItemMeta().getDisplayName().equals(ChatColor.GRAY + "" + ChatColor.BOLD + "Common Artifact")) {
            	new Shop(this.plugin).openGUIShop(player);
            }
        }
    }
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Player p = event.getPlayer();
		Block b = event.getBlock();
		ItemStack i = event.getPlayer().getItemInHand();
		
		if(this.plugin.getServer().getPluginManager().getPlugin("WorldGuard") != null) {
			if (Main.worldguardPlugin.canBuild(p, b.getRelative(0, -1, 0)) == true) {
				if (!i.containsEnchantment(Enchantment.SILK_TOUCH)) {
					if(i.getType() == Material.DIAMOND_PICKAXE || i.getType() == Material.GOLD_PICKAXE || i.getType() == Material.IRON_PICKAXE || i.getType() == Material.STONE_PICKAXE || i.getType() == Material.WOOD_PICKAXE) {
						if (b.getType().equals(Material.DIAMOND_ORE) || b.getType().equals(Material.EMERALD_ORE)) {
							Random randMythic = new Random();
							int m = randMythic.nextInt(100);		      
							Random randDream = new Random();
							int md = randDream.nextInt(100);  
							if (m > 95) {
								new Artifacts(this.plugin).getArts("MythicArt", 1, p);
								if (md > 93) {
									dropArt(p.getWorld(), b.getLocation(), Crates.Crate("DreamCrate", 1));
									p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Mining" + ChatColor.DARK_GRAY + ChatColor.BOLD + " >> " + ChatColor.GRAY + "You got a " + ChatColor.DARK_RED + "Miner's Dream Crate " + ChatColor.GRAY + "with your" + ChatColor.DARK_PURPLE + " Mythic " + ChatColor.GRAY + "Artifact!");
								}
								else {
									p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Mining" + ChatColor.DARK_GRAY + ChatColor.BOLD + " >> " + ChatColor.GRAY + "You got a" + ChatColor.DARK_PURPLE + " Mythic " + ChatColor.GRAY + "Artifact!");
								}
							}
						}
						else if (b.getType() == Material.LAPIS_ORE) {
							Random randLegend = new Random();
							int l = randLegend.nextInt(100);					      
							Random randIron = new Random();
							int io = randIron.nextInt(100);								
							if (l > 85) {						    	  
								new Artifacts(this.plugin).getArts("LegendaryArt", 1, p);						          
								if (io > 90) {						        	  
									dropArt(p.getWorld(), b.getLocation(), Crates.Crate("IronCrate", 1));				
									p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Mining" + ChatColor.DARK_GRAY + ChatColor.BOLD + " >> " + ChatColor.GRAY + "You got a " + ChatColor.YELLOW + "Ironed Crate " + ChatColor.GRAY + "with your" + ChatColor.GOLD + " Legendary " + ChatColor.GRAY + "Artifact!");											
								}
								else {
									p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Mining" + ChatColor.DARK_GRAY + ChatColor.BOLD + " >> " + ChatColor.GRAY + "You got a" + ChatColor.GOLD + " Legendary " + ChatColor.GRAY + "Artifact!");
								}
							}
						}
						else if (b.getType() == Material.REDSTONE_ORE || b.getType() == Material.GLOWING_REDSTONE_ORE) {
							Random randRare = new Random();
							int r = randRare.nextInt(100);						      
							Random randRock = new Random();
							int por = randRock.nextInt(100);						      
							if (r > 78) {						    	  
								new Artifacts(this.plugin).getArts("RareArt", 1, p);						          
								if (por > 80) {					        	  
									dropArt(p.getWorld(), b.getLocation(), Crates.Crate("RockCrate", 1));			
									p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Mining" + ChatColor.DARK_GRAY + ChatColor.BOLD + " >> " + ChatColor.GRAY + "You got a Rock Crate with your" + ChatColor.AQUA + " Rare " + ChatColor.GRAY + "Artifact!");							          
								}
								else {
									p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Mining" + ChatColor.DARK_GRAY + ChatColor.BOLD + " >> " + ChatColor.GRAY + "You got a" + ChatColor.AQUA + " Rare " + ChatColor.GRAY + "Artifact!");
								}
							}
						}
						else if (b.getType() == Material.COAL_ORE) {
							Random randCommon = new Random();
							int c = randCommon.nextInt(100);					      
							Random randRock = new Random();
							int por = randRock.nextInt(100);						      
							if (c > 80) {							      
								new Artifacts(this.plugin).getArts("CommonArt", 1, p);					          
								if (por > 90) {						        	  
									dropArt(p.getWorld(), b.getLocation(), Crates.Crate("RockCrate", 1));			
									p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Mining" + ChatColor.DARK_GRAY + ChatColor.BOLD + " >> " + ChatColor.GRAY + "You got a Rocks Crate with your Common Artifact!");							          
								}
								else {
									p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Mining" + ChatColor.DARK_GRAY + ChatColor.BOLD + " >> " + ChatColor.GRAY + "You got a Common Artifact!");
								}
							}
						}
					}
				}
			}
		}
		else if (this.plugin.getServer().getPluginManager().getPlugin("GriefPrevention") != null ) {
			if (Main.griefpreventionPlugin.allowBreak(p, b, b.getLocation()) == null) {
				if (!i.containsEnchantment(Enchantment.SILK_TOUCH)) {
					if(i.getType() == Material.DIAMOND_PICKAXE || i.getType() == Material.GOLD_PICKAXE || i.getType() == Material.IRON_PICKAXE || i.getType() == Material.STONE_PICKAXE || i.getType() == Material.WOOD_PICKAXE) {
						if (b.getType().equals(Material.DIAMOND_ORE) || b.getType().equals(Material.EMERALD_ORE)) {
							Random randMythic = new Random();
							int m = randMythic.nextInt(100);		      
							Random randDream = new Random();
							int md = randDream.nextInt(100);  
							if (m > 95) {
								new Artifacts(this.plugin).getArts("MythicArt", 1, p);
								if (md > 93) {
									dropArt(p.getWorld(), b.getLocation(), Crates.Crate("DreamCrate", 1));
									p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Mining" + ChatColor.DARK_GRAY + ChatColor.BOLD + " >> " + ChatColor.GRAY + "You got a " + ChatColor.DARK_RED + "Miner's Dream Crate " + ChatColor.GRAY + "with your" + ChatColor.DARK_PURPLE + " Mythic " + ChatColor.GRAY + "Artifact!");
								}
								else {
									p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Mining" + ChatColor.DARK_GRAY + ChatColor.BOLD + " >> " + ChatColor.GRAY + "You got a" + ChatColor.DARK_PURPLE + " Mythic " + ChatColor.GRAY + "Artifact!");
								}
							}
						}
						else if (b.getType() == Material.LAPIS_ORE) {
							Random randLegend = new Random();
							int l = randLegend.nextInt(100);					      
							Random randIron = new Random();
							int io = randIron.nextInt(100);								
							if (l > 85) {						    	  
								new Artifacts(this.plugin).getArts("LegendaryArt", 1, p);					          
								if (io > 90) {						        	  
									dropArt(p.getWorld(), b.getLocation(), Crates.Crate("IronCrate", 1));				
									p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Mining" + ChatColor.DARK_GRAY + ChatColor.BOLD + " >> " + ChatColor.GRAY + "You got a " + ChatColor.YELLOW + "Ironed Crate " + ChatColor.GRAY + "with your" + ChatColor.GOLD + " Legendary " + ChatColor.GRAY + "Artifact!");											
								}
								else {
									p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Mining" + ChatColor.DARK_GRAY + ChatColor.BOLD + " >> " + ChatColor.GRAY + "You got a" + ChatColor.GOLD + " Legendary " + ChatColor.GRAY + "Artifact!");
								}
							}
						}
						else if (b.getType() == Material.REDSTONE_ORE || b.getType() == Material.GLOWING_REDSTONE_ORE) {
							Random randRare = new Random();
							int r = randRare.nextInt(100);						      
							Random randRock = new Random();
							int por = randRock.nextInt(100);						      
							if (r > 78) {						    	  
								new Artifacts(this.plugin).getArts("RareArt", 1, p);						          
								if (por > 80) {					        	  
									dropArt(p.getWorld(), b.getLocation(), Crates.Crate("RockCrate", 1));			
									p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Mining" + ChatColor.DARK_GRAY + ChatColor.BOLD + " >> " + ChatColor.GRAY + "You got a Rock Crate with your" + ChatColor.AQUA + " Rare " + ChatColor.GRAY + "Artifact!");							          
								}
								else {
									p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Mining" + ChatColor.DARK_GRAY + ChatColor.BOLD + " >> " + ChatColor.GRAY + "You got a" + ChatColor.AQUA + " Rare " + ChatColor.GRAY + "Artifact!");
								}
							}
						}
						else if (b.getType() == Material.COAL_ORE) {
							Random randCommon = new Random();
							int c = randCommon.nextInt(100);					      
							Random randRock = new Random();
							int por = randRock.nextInt(100);						      
							if (c > 80) {							      
								new Artifacts(this.plugin).getArts("CommonArt", 1, p);				          
								if (por > 90) {						        	  
									dropArt(p.getWorld(), b.getLocation(), Crates.Crate("RockCrate", 1));			
									p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Mining" + ChatColor.DARK_GRAY + ChatColor.BOLD + " >> " + ChatColor.GRAY + "You got a Rocks Crate with your Common Artifact!");							          
								}
								else {
									p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Mining" + ChatColor.DARK_GRAY + ChatColor.BOLD + " >> " + ChatColor.GRAY + "You got a Common Artifact!");
								}
							}
						}
					}
				}
			}
		}
		else {
			if (!i.containsEnchantment(Enchantment.SILK_TOUCH)) {
				if(i.getType() == Material.DIAMOND_PICKAXE || i.getType() == Material.GOLD_PICKAXE || i.getType() == Material.IRON_PICKAXE || i.getType() == Material.STONE_PICKAXE || i.getType() == Material.WOOD_PICKAXE) {
					if (b.getType().equals(Material.DIAMOND_ORE) || b.getType().equals(Material.EMERALD_ORE)) {
						Random randMythic = new Random();
						int m = randMythic.nextInt(100);		      
						Random randDream = new Random();
						int md = randDream.nextInt(100);  
						if (m > 95) {
							new Artifacts(this.plugin).getArts("MythicArt", 1, p);
							if (md > 93) {
								dropArt(p.getWorld(), b.getLocation(), Crates.Crate("DreamCrate", 1));
								p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Mining" + ChatColor.DARK_GRAY + ChatColor.BOLD + " >> " + ChatColor.GRAY + "You got a " + ChatColor.DARK_RED + "Miner's Dream Crate " + ChatColor.GRAY + "with your" + ChatColor.DARK_PURPLE + " Mythic " + ChatColor.GRAY + "Artifact!");
							}
							else {
								p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Mining" + ChatColor.DARK_GRAY + ChatColor.BOLD + " >> " + ChatColor.GRAY + "You got a" + ChatColor.DARK_PURPLE + " Mythic " + ChatColor.GRAY + "Artifact!");
							}
						}
					}
					else if (b.getType() == Material.LAPIS_ORE) {
						Random randLegend = new Random();
						int l = randLegend.nextInt(100);					      
						Random randIron = new Random();
						int io = randIron.nextInt(100);								
						if (l > 85) {						    	  
							new Artifacts(this.plugin).getArts("LegendaryArt", 1, p);						          
							if (io > 90) {						        	  
								dropArt(p.getWorld(), b.getLocation(), Crates.Crate("IronCrate", 1));				
								p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Mining" + ChatColor.DARK_GRAY + ChatColor.BOLD + " >> " + ChatColor.GRAY + "You got a " + ChatColor.YELLOW + "Ironed Crate " + ChatColor.GRAY + "with your" + ChatColor.GOLD + " Legendary " + ChatColor.GRAY + "Artifact!");											
							}
							else {
								p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Mining" + ChatColor.DARK_GRAY + ChatColor.BOLD + " >> " + ChatColor.GRAY + "You got a" + ChatColor.GOLD + " Legendary " + ChatColor.GRAY + "Artifact!");
							}
						}
					}
					else if (b.getType() == Material.REDSTONE_ORE || b.getType() == Material.GLOWING_REDSTONE_ORE) {
						Random randRare = new Random();
						int r = randRare.nextInt(100);						      
						Random randRock = new Random();
						int por = randRock.nextInt(100);						      
						if (r > 78) {						    	  
							new Artifacts(this.plugin).getArts("RareArt", 1, p);						          
							if (por > 80) {					        	  
								dropArt(p.getWorld(), b.getLocation(), Crates.Crate("RockCrate", 1));			
								p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Mining" + ChatColor.DARK_GRAY + ChatColor.BOLD + " >> " + ChatColor.GRAY + "You got a Rock Crate with your" + ChatColor.AQUA + " Rare " + ChatColor.GRAY + "Artifact!");							          
							}
							else {
								p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Mining" + ChatColor.DARK_GRAY + ChatColor.BOLD + " >> " + ChatColor.GRAY + "You got a" + ChatColor.AQUA + " Rare " + ChatColor.GRAY + "Artifact!");
							}
						}
					}
					else if (b.getType() == Material.COAL_ORE) {
						Random randCommon = new Random();
						int c = randCommon.nextInt(100);					      
						Random randRock = new Random();
						int por = randRock.nextInt(100);						      
						if (c > 80) {							      
							new Artifacts(this.plugin).getArts("CommonArt", 1, p);					          
							if (por > 90) {						        	  
								dropArt(p.getWorld(), b.getLocation(), Crates.Crate("RockCrate", 1));			
								p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Mining" + ChatColor.DARK_GRAY + ChatColor.BOLD + " >> " + ChatColor.GRAY + "You got a Rocks Crate with your Common Artifact!");							          
							}
							else {
								p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Mining" + ChatColor.DARK_GRAY + ChatColor.BOLD + " >> " + ChatColor.GRAY + "You got a Common Artifact!");
							}
						}
					}
				}
			}
		}
	}
}
