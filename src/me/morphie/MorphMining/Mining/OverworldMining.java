package me.morphie.MorphMining.Mining;

import java.util.Random;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.morphie.MorphMining.Main;
import me.morphie.MorphMining.Files.playerFileMethods;
import me.morphie.MorphMining.Items.Artifacts;
import me.morphie.MorphMining.Items.Pouch;
import me.morphie.MorphMining.Market.ArtifactShop;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ComponentBuilder;

public class OverworldMining implements Listener {
	
	private Main plugin;
	  
	public OverworldMining(Main plugin) {
		this.plugin = plugin;
	}
	
	public void ActionBar (String message, Player player ) {
		player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new ComponentBuilder(ChatColor.translateAlternateColorCodes('&', message)).create());
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
        if (((event.getAction().equals(Action.RIGHT_CLICK_AIR)) || (event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) && (event.getItem().getType().equals(Material.GOLD_NUGGET)) || (event.getItem().getType().equals(Material.FIREWORK_STAR)) && (event.getItem().hasItemMeta())) {
            ItemStack item2 = event.getItem();
            if (item2.getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Mythic Artifact") || item2.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "" + ChatColor.BOLD + "Legendary Artifact") || item2.getItemMeta().getDisplayName().equals(ChatColor.AQUA + "" + ChatColor.BOLD + "Rare Artifact") || item2.getItemMeta().getDisplayName().equals(ChatColor.GRAY + "" + ChatColor.BOLD + "Common Artifact")) {
            	new ArtifactShop(this.plugin).openGUIShop(player);
            } else if (item2.getItemMeta().getLore().contains(ChatColor.translateAlternateColorCodes('&', this.MainColor() + "MorphMining"))) {
            	new ArtifactShop(this.plugin).openGUIShop(player);
            }
        }
    }
    
	@EventHandler (ignoreCancelled = true, priority = EventPriority.HIGH)
	public void onBlockBreakStats(BlockBreakEvent event) {
		Player p = event.getPlayer();
	    UUID uuid = p.getUniqueId();
		Block b = event.getBlock();
		ItemStack i = event.getPlayer().getItemInHand();
		
		if (i.getType() == Material.DIAMOND_PICKAXE || i.getType() == Material.GOLDEN_PICKAXE || i.getType() == Material.IRON_PICKAXE || i.getType() == Material.STONE_PICKAXE || i.getType() == Material.WOODEN_PICKAXE) {
			if (b.getType() == Material.STONE) {
				new playerFileMethods(this.plugin).setData(p, uuid, "Stats.StoneMined", 1);
			} else if (b.getType() == Material.COAL_ORE) {
				new playerFileMethods(this.plugin).setData(p, uuid, "Stats.CoalOreMined", 1);
			} else if (b.getType() == Material.LEGACY_GLOWING_REDSTONE_ORE) {
				new playerFileMethods(this.plugin).setData(p, uuid, "Stats.RedstoneOreMined", 1);
			} else if (b.getType() == Material.IRON_ORE) {
				new playerFileMethods(this.plugin).setData(p, uuid, "Stats.IronOreMined", 1);
			} else if (b.getType() == Material.GOLD_ORE) {
				new playerFileMethods(this.plugin).setData(p, uuid, "Stats.GoldOreMined", 1);
			} else if (b.getType() == Material.LAPIS_ORE) {
				new playerFileMethods(this.plugin).setData(p, uuid, "Stats.LapisOreMined", 1);
			} else if (b.getType() == Material.DIAMOND_ORE) {
				new playerFileMethods(this.plugin).setData(p, uuid, "Stats.DiamondOreMined", 1);
			} else if (b.getType() == Material.EMERALD_ORE) {
				new playerFileMethods(this.plugin).setData(p, uuid, "Stats.EmeraldOreMined", 1);
			} else if (b.getType() == Material.NETHER_QUARTZ_ORE) {
				new playerFileMethods(this.plugin).setData(p, uuid, "Stats.QuartzOreMined", 1);
			}
		}
	}
	
	@EventHandler (ignoreCancelled = true, priority = EventPriority.HIGHEST)
	public void onBlockBreak(BlockBreakEvent event) {
		Player p = event.getPlayer();
	    UUID uuid = p.getUniqueId();
		Block b = event.getBlock();
		ItemStack i = event.getPlayer().getItemInHand();
		
		if (!i.containsEnchantment(Enchantment.SILK_TOUCH)) {
			if(i.getType() == Material.DIAMOND_PICKAXE || i.getType() == Material.GOLDEN_PICKAXE || i.getType() == Material.IRON_PICKAXE || i.getType() == Material.STONE_PICKAXE || i.getType() == Material.WOODEN_PICKAXE) {
	            if (event.isCancelled() == false) {
					if (b.getType().equals(Material.DIAMOND_ORE) || b.getType().equals(Material.EMERALD_ORE)) {
						Random randMythic = new Random();
						int m = randMythic.nextInt(100);
						Boolean mUp = new playerFileMethods(this.plugin).getBoolean(uuid, "Pouch.MythicUpgrade");
						if (m > 95) {
							if (new playerFileMethods(this.plugin).getBoolean(uuid, "Pouch.Enabled") == true && checkPouch(p) == true) {
								if (mUp == true) {
									if (new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Mythic") < this.plugin.getConfig().getInt("Pouches.Mythic.UpgradedCapacity")) {
										new playerFileMethods(this.plugin).setData(p, uuid, "Pouch.Mythic", 1);
										new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
										new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedMythic", 1);
										ActionBar(HighlightColor() + "(Pouch) +1 " + MainColor() + "Mythic Artifact!", p);
									} else {
										new Artifacts(this.plugin).getArts("MythicArt", 1, p);
										new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
										new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedMythic", 1);
										ActionBar(HighlightColor() + "(Pouch Full!) +1 " + MainColor() + "Mythic Artifact!", p);
									}
								} else if (new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Mythic") < this.plugin.getConfig().getInt("Pouches.Mythic.StartCapacity")) {
										new playerFileMethods(this.plugin).setData(p, uuid, "Pouch.Mythic", 1);
										new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
										new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedMythic", 1);
										ActionBar(HighlightColor() + "(Pouch) +1 " + MainColor() + "Mythic Artifact!", p);
								} else {
									new Artifacts(this.plugin).getArts("MythicArt", 1, p);
									new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
									new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedMythic", 1);
									ActionBar(HighlightColor() + "(Pouch Full!) +1 " + MainColor() + "Mythic Artifact!", p);
								}
							} else {
								new Artifacts(this.plugin).getArts("MythicArt", 1, p);
								new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
								new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedMythic", 1);
								ActionBar(HighlightColor() + "+1 " + MainColor() + "Mythic Artifact!", p);
							}
						}
					}
					else if (b.getType() == Material.LAPIS_ORE) {
						Random randLegend = new Random();
						int l = randLegend.nextInt(100);
						Boolean lUp = new playerFileMethods(this.plugin).getBoolean(uuid, "Pouch.LegendaryUpgrade");
						if (l > 87) {
							if (new playerFileMethods(this.plugin).getBoolean(uuid, "Pouch.Enabled") == true && checkPouch(p) == true) {
								if (lUp == true) {
									if (new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Legendary") < this.plugin.getConfig().getInt("Pouches.Legendary.UpgradedCapacity")) {
										new playerFileMethods(this.plugin).setData(p, uuid, "Pouch.Legendary", 1);
										new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
										new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedLegendary", 1);
										ActionBar(HighlightColor() + "(Pouch) +1 " + MainColor() + "Legendary Artifact!", p);
									} else {
										new Artifacts(this.plugin).getArts("LegendaryArt", 1, p);
										new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
										new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedLegendary", 1);
										ActionBar(HighlightColor() + "+1 " + MainColor() + "Legendary Artifact!", p);
									}
								} else if (new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Legendary") < this.plugin.getConfig().getInt("Pouches.Legendary.StartCapacity")) {
									new playerFileMethods(this.plugin).setData(p, uuid, "Pouch.Legendary", 1);
									new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
									new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedLegendary", 1);
									ActionBar(HighlightColor() + "(Pouch) +1 " + MainColor() + "Legendary Artifact!", p);
								} else {
									new Artifacts(this.plugin).getArts("LegendaryArt", 1, p);
									new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
									new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedLegendary", 1);
									ActionBar(HighlightColor() + "(Pouch Full!) +1 " + MainColor() + "Legendary Artifact!", p);
								}
							} else {
								new Artifacts(this.plugin).getArts("LegendaryArt", 1, p);
								new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
								new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedLegendary", 1);
							    ActionBar(HighlightColor() + "+1 " + MainColor() + "Legendary Artifact!", p);
							}
						}
					}
					else if (b.getType() == Material.REDSTONE_ORE || b.getType() == Material.LEGACY_GLOWING_REDSTONE_ORE) {
						Random randRare = new Random();
						int r = randRare.nextInt(100);
						Boolean rUp = new playerFileMethods(this.plugin).getBoolean(uuid, "Pouch.RareUpgrade");
						if (r > 93) {
							if (new playerFileMethods(this.plugin).getBoolean(uuid, "Pouch.Enabled") == true && checkPouch(p) == true) {
								if (rUp == true) {
									if (new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Rare") < this.plugin.getConfig().getInt("Pouches.Rare.UpgradedCapacity")) {
										new playerFileMethods(this.plugin).setData(p, uuid, "Pouch.Rare", 1);
										new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
										new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedRare", 1);
										ActionBar(HighlightColor() + "(Pouch) +1 " + MainColor() + "Rare Artifact!", p);
									} else {
										new Artifacts(this.plugin).getArts("RareArt", 1, p);
										new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
										new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedRare", 1);
										ActionBar(HighlightColor() + "+1 " + MainColor() + "Rare Artifact!", p);
									}
								} else if (new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Rare") < this.plugin.getConfig().getInt("Pouches.Rare.StartCapacity")) {
									new playerFileMethods(this.plugin).setData(p, uuid, "Pouch.Rare", 1);
									new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
									new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedRare", 1);
									ActionBar(HighlightColor() + "(Pouch) +1 " + MainColor() + "Rare Artifact!", p);
								} else {
									new Artifacts(this.plugin).getArts("RareArt", 1, p);
									new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
									new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedRare", 1);
									ActionBar(HighlightColor() + "(Pouch Full!) +1 " + MainColor() + "Rare Artifact!", p);
								}
							} else {
								new Artifacts(this.plugin).getArts("RareArt", 1, p);
								new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
								new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedRare", 1);
							    ActionBar(HighlightColor() + "+1 " + MainColor() + "Rare Artifact!", p);
							}
						}
					}
					else if (b.getType() == Material.COAL_ORE) {
						Random randCommon = new Random();
						int c = randCommon.nextInt(100);
						Boolean cUp = new playerFileMethods(this.plugin).getBoolean(uuid, "Pouch.CommonUpgrade");
						if (c > 90) {
							if (new playerFileMethods(this.plugin).getBoolean(uuid, "Pouch.Enabled") == true && checkPouch(p) == true) {
								if (cUp == true) {
									if (new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Common") < this.plugin.getConfig().getInt("Pouches.Common.UpgradedCapacity")) {
										new playerFileMethods(this.plugin).setData(p, uuid, "Pouch.Common", 1);
										new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
										new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedCommon", 1);
										ActionBar(HighlightColor() + "(Pouch) +1 " + MainColor() + "Common Artifact!", p);
									} else {
										new Artifacts(this.plugin).getArts("CommonArt", 1, p);
										new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
										new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedCommon", 1);
										ActionBar(HighlightColor() + "+1 " + MainColor() + "Common Artifact!", p);
									}
								} else if (new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Common") < this.plugin.getConfig().getInt("Pouches.Common.StartCapacity")) {
									new playerFileMethods(this.plugin).setData(p, uuid, "Pouch.Common", 1);
									new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
									new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedCommon", 1);
									ActionBar(HighlightColor() + "(Pouch) +1 " + MainColor() + "Common Artifact!", p);
								} else {
									new Artifacts(this.plugin).getArts("CommonArt", 1, p);
									new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
									new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedCommon", 1);
									ActionBar(HighlightColor() + "(Pouch Full!) +1 " + MainColor() + "Common Artifact!", p);
								}
							} else {
								new Artifacts(this.plugin).getArts("CommonArt", 1, p);
								new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
								new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedCommon", 1);
							    ActionBar(HighlightColor() + "+1 " + MainColor() + "Common Artifact!", p);
							}
						}
					}
				}
			}
		}
	}
	
	public Boolean checkPouch(Player p) {
		Inventory inv = p.getInventory();
	    for(int n = 0; n < inv.getSize(); n++){
	        ItemStack itm = inv.getItem(n);
	        if(itm != null){
	            if(itm.getType().equals(Material.FLOWER_POT)){
	            	if(itm.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "Miner's Pouch"))) {
	            		return true;
	            	}
	            }
	        }
	    }
		return false;
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
