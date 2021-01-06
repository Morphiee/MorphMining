package me.morphie.morphmining.Mining;

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

import me.morphie.morphmining.Files.playerFileMethods;
import me.morphie.morphmining.Items.Artifacts;
import me.morphie.morphmining.menus.ArtifactShopMenu;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ComponentBuilder;
import me.morphie.morphmining.MorphMining;

public class OverworldMining implements Listener {
	
	private MorphMining plugin;
	  
	public OverworldMining(MorphMining plugin) {
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
        if (((event.getAction().equals(Action.RIGHT_CLICK_AIR)) || (event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) && (event.getItem().getType().equals(Material.matchMaterial(this.plugin.getConfig().getString("Settings.ArtifactItem")))) || (event.getItem().getType().equals(Material.matchMaterial(this.plugin.getConfig().getString("Settings.HellstoneItem")))) && (event.getItem().hasItemMeta())) {
            ItemStack item2 = event.getItem();
            if (item2.getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Mythic Artifact") || item2.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "" + ChatColor.BOLD + "Legendary Artifact") || item2.getItemMeta().getDisplayName().equals(ChatColor.AQUA + "" + ChatColor.BOLD + "Rare Artifact") || item2.getItemMeta().getDisplayName().equals(ChatColor.GRAY + "" + ChatColor.BOLD + "Common Artifact")) {
            	new ArtifactShopMenu(this.plugin).openGUIShop(player);
            } else if (item2.hasItemMeta() && ChatColor.stripColor(item2.getItemMeta().getLore().get(6)).equals("MorphMining")) {
            	new ArtifactShopMenu(this.plugin).openGUIShop(player);
            	event.setCancelled(true);
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
			} else if (b.getType() == Material.REDSTONE_ORE) {
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
		Random random = new Random();
		
		if (!i.containsEnchantment(Enchantment.SILK_TOUCH)) {
			if(i.getType().toString().toLowerCase().contains("pickaxe")) {
	            if (event.isCancelled() == false) {
					if (b.getType().equals(Material.DIAMOND_ORE) || b.getType().equals(Material.EMERALD_ORE)) {
						int chance = random.nextInt(100);
						int mythicChance = plugin.getConfig().getInt("Settings.ArtifactChances.Mythic");
						if (chance <= mythicChance) {
							if (new playerFileMethods(this.plugin).getBoolean(uuid, "Pouch.Enabled") == true && checkPouch(p) == true) {
								Boolean mUp = new playerFileMethods(this.plugin).getBoolean(uuid, "Pouch.MythicUpgrade");
								if (mUp == true) {
									if (new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Mythic") < this.plugin.getConfig().getInt("Pouches.Mythic.UpgradedCapacity")) {
										new playerFileMethods(this.plugin).setData(p, uuid, "Pouch.Mythic", 1);
										new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
										new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedMythic", 1);
										ActionBar(this.plugin.getMessage("Pouch.ActionMessage").replace("ARTIFACT", "Mythic Artifact!"), p);
									} else {
										new Artifacts(this.plugin).getArts("MythicArt", 1, p);
										new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
										new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedMythic", 1);
										ActionBar(this.plugin.getMessage("Pouch.ActionFullMessage").replace("ARTIFACT", "Mythic Artifact!"), p);
									}
								} else if (new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Mythic") < this.plugin.getConfig().getInt("Pouches.Mythic.StartCapacity")) {
										new playerFileMethods(this.plugin).setData(p, uuid, "Pouch.Mythic", 1);
										new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
										new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedMythic", 1);
										ActionBar(this.plugin.getMessage("Pouch.ActionMessage").replace("ARTIFACT", "Mythic Artifact!"), p);
								} else {
									new Artifacts(this.plugin).getArts("MythicArt", 1, p);
									new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
									new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedMythic", 1);
									ActionBar(this.plugin.getMessage("Pouch.ActionFullMessage").replace("ARTIFACT", "Mythic Artifact!"), p);
								}
							} else {
								new Artifacts(this.plugin).getArts("MythicArt", 1, p);
								new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
								new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedMythic", 1);
								ActionBar(this.plugin.getMessage("ArtifactActionMessage").replace("ARTIFACT", "Mythic Artifact!"), p);
							}
						}
					}
					else if (b.getType() == Material.LAPIS_ORE) {
						int chance = random.nextInt(100);
						int legendaryChance = plugin.getConfig().getInt("Settings.ArtifactChances.Legendary");
						if (chance <= legendaryChance) {
							if (new playerFileMethods(this.plugin).getBoolean(uuid, "Pouch.Enabled") == true && checkPouch(p) == true) {
								Boolean lUp = new playerFileMethods(this.plugin).getBoolean(uuid, "Pouch.LegendaryUpgrade");
								if (lUp == true) {
									if (new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Legendary") < this.plugin.getConfig().getInt("Pouches.Legendary.UpgradedCapacity")) {
										new playerFileMethods(this.plugin).setData(p, uuid, "Pouch.Legendary", 1);
										new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
										new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedLegendary", 1);
										ActionBar(this.plugin.getMessage("Pouch.ActionMessage").replace("ARTIFACT", "Legendary Artifact!"), p);
									} else {
										new Artifacts(this.plugin).getArts("LegendaryArt", 1, p);
										new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
										new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedLegendary", 1);
										ActionBar(this.plugin.getMessage("ArtifactActionMessage").replace("ARTIFACT", "Legendary Artifact!"), p);
									}
								} else if (new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Legendary") < this.plugin.getConfig().getInt("Pouches.Legendary.StartCapacity")) {
									new playerFileMethods(this.plugin).setData(p, uuid, "Pouch.Legendary", 1);
									new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
									new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedLegendary", 1);
									ActionBar(this.plugin.getMessage("Pouch.ActionMessage").replace("ARTIFACT", "Legendary Artifact!"), p);
								} else {
									new Artifacts(this.plugin).getArts("LegendaryArt", 1, p);
									new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
									new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedLegendary", 1);
									ActionBar(this.plugin.getMessage("Pouch.ActionFullMessage").replace("ARTIFACT", "Legendary Artifact!"), p);
								}
							} else {
								new Artifacts(this.plugin).getArts("LegendaryArt", 1, p);
								new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
								new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedLegendary", 1);
							    ActionBar(this.plugin.getMessage("ArtifactActionMessage").replace("ARTIFACT", "Legendary Artifact!"), p);
							}
						}
					}
					else if (b.getType() == Material.REDSTONE_ORE || b.getType() == Material.LEGACY_GLOWING_REDSTONE_ORE) {
						int chance = random.nextInt(100);
						int rareChance = plugin.getConfig().getInt("Settings.ArtifactChances.Rare");
						if (chance <= rareChance) {
							if (new playerFileMethods(this.plugin).getBoolean(uuid, "Pouch.Enabled") == true && checkPouch(p) == true) {
								Boolean rUp = new playerFileMethods(this.plugin).getBoolean(uuid, "Pouch.RareUpgrade");
								if (rUp == true) {
									if (new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Rare") < this.plugin.getConfig().getInt("Pouches.Rare.UpgradedCapacity")) {
										new playerFileMethods(this.plugin).setData(p, uuid, "Pouch.Rare", 1);
										new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
										new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedRare", 1);
										ActionBar(this.plugin.getMessage("Pouch.ActionMessage").replace("ARTIFACT", "Rare Artifact!"), p);
									} else {
										new Artifacts(this.plugin).getArts("RareArt", 1, p);
										new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
										new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedRare", 1);
										ActionBar(this.plugin.getMessage("ArtifactActionMessage").replace("ARTIFACT", "Rare Artifact!"), p);
									}
								} else if (new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Rare") < this.plugin.getConfig().getInt("Pouches.Rare.StartCapacity")) {
									new playerFileMethods(this.plugin).setData(p, uuid, "Pouch.Rare", 1);
									new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
									new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedRare", 1);
									ActionBar(this.plugin.getMessage("Pouch.ActionMessage").replace("ARTIFACT", "Rare Artifact!"), p);
								} else {
									new Artifacts(this.plugin).getArts("RareArt", 1, p);
									new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
									new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedRare", 1);
									ActionBar(this.plugin.getMessage("Pouch.ActionFullMessage").replace("ARTIFACT", "Rare Artifact!"), p);
								}
							} else {
								new Artifacts(this.plugin).getArts("RareArt", 1, p);
								new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
								new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedRare", 1);
							    ActionBar(this.plugin.getMessage("ArtifactActionMessage").replace("ARTIFACT", "Rare Artifact!"), p);
							}
						}
					}
					else if (b.getType() == Material.COAL_ORE) {
						int chance = random.nextInt(100);
						int commonChance = plugin.getConfig().getInt("Settings.ArtifactChances.Common");
						if (chance <= commonChance) {
							if (new playerFileMethods(this.plugin).getBoolean(uuid, "Pouch.Enabled") == true && checkPouch(p) == true) {
								Boolean cUp = new playerFileMethods(this.plugin).getBoolean(uuid, "Pouch.CommonUpgrade");
								if (cUp == true) {
									if (new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Common") < this.plugin.getConfig().getInt("Pouches.Common.UpgradedCapacity")) {
										new playerFileMethods(this.plugin).setData(p, uuid, "Pouch.Common", 1);
										new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
										new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedCommon", 1);
										ActionBar(this.plugin.getMessage("Pouch.ActionMessage").replace("ARTIFACT", "Common Artifact!"), p);
									} else {
										new Artifacts(this.plugin).getArts("CommonArt", 1, p);
										new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
										new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedCommon", 1);
										ActionBar(this.plugin.getMessage("ArtifactActionMessage").replace("ARTIFACT", "Common Artifact!"), p);
									}
								} else if (new playerFileMethods(this.plugin).getStat(uuid, "Pouch.Common") < this.plugin.getConfig().getInt("Pouches.Common.StartCapacity")) {
									new playerFileMethods(this.plugin).setData(p, uuid, "Pouch.Common", 1);
									new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
									new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedCommon", 1);
									ActionBar(this.plugin.getMessage("Pouch.ActionMessage").replace("ARTIFACT", "Common Artifact!"), p);
								} else {
									new Artifacts(this.plugin).getArts("CommonArt", 1, p);
									new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
									new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedCommon", 1);
									ActionBar(this.plugin.getMessage("Pouch.ActionFullMessage").replace("ARTIFACT", "Common Artifact!"), p);
								}
							} else {
								new Artifacts(this.plugin).getArts("CommonArt", 1, p);
								new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedAll", 1);
								new playerFileMethods(this.plugin).setData(p, uuid, "Stats.ArtifactsMinedCommon", 1);
							    ActionBar(this.plugin.getMessage("ArtifactActionMessage").replace("ARTIFACT", "Common Artifact!"), p);
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
	            	if(itm.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Miner's Pouch"))) {
	            		return true;
	            	}
	            }
	        }
	    }
		return false;
	}
}
