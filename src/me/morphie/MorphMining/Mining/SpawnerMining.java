package me.morphie.MorphMining.Mining;

import org.bukkit.event.Listener;

import me.morphie.MorphMining.Main;

public class SpawnerMining implements Listener {
	
	private Main plugin;
	  
	public SpawnerMining(Main plugin) {
		this.plugin = plugin;
	}
	
//    private void dropSpawner(World world, Location loc, ItemStack item) {
//	    world.dropItem(loc, item);
//    }
//
//    @EventHandler
//    public void onSpawnerClick(PlayerInteractEvent event) {
//        final Player player = event.getPlayer();
//        if (event.getAction() == null) {
//          return;
//        }
//        if (event.getItem() == null) {
//          return;
//        }
//        if (((event.getAction().equals(Action.RIGHT_CLICK_AIR)) || (event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) && (event.getItem().getType().equals(Material.SPAWNER)) && (event.getItem().hasItemMeta())) {
//        	ItemStack item = event.getItem();
//        	if(item.hasItemMeta()) {
//                ItemMeta itemMeta = item.getItemMeta();
//                if (itemMeta.getLore().contains(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "State &8» " + "&cDamaged"))) {
//                	event.setCancelled(true);
//                } else if (itemMeta.getLore().contains(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "State &8» " + "&aRepaired"))) {
//                	event.setCancelled(true);
//                }	
//            }
//        }
//    }
//	
//	@EventHandler
//	public void onSpawnerMine(BlockBreakEvent event) {
//		if (plugin.getConfig().getBoolean("SilkSpawners.Enabled") == true) {
//			Player p = event.getPlayer();
//			Block b = event.getBlock();
//			ItemStack i = p.getInventory().getItemInMainHand();
//			if (p.hasPermission("MorphMining.SilkSpawners")) {
//			    Random random = new Random();
//			    int chance = random.nextInt(100) + 1;
//			    int spawnerChance = plugin.getConfig().getInt("SilkSpawners.Percentage");
//			    if (chance <= spawnerChance) {
//					if (event.getBlock().getType() == Material.SPAWNER) {
//				        CreatureSpawner type = (CreatureSpawner) b.getState();
//				        EntityType mobtype = type.getSpawnedType();
//				        World world = b.getWorld();
//				        Location loc = b.getLocation();
//						if (i.getType() == Material.DIAMOND_PICKAXE || i.getType() == Material.GOLDEN_PICKAXE || i.getType() == Material.IRON_PICKAXE) {
//							if (i.containsEnchantment(Enchantment.SILK_TOUCH)) {
//								ItemStack spawner = new ItemStack(Material.SPAWNER);
//								ItemMeta spawnerMeta = spawner.getItemMeta();
//								ArrayList<String> spawnerLore = new ArrayList();
//								spawnerLore.add("");
//								spawnerLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.LoreColor") +  "Right-Click this spawner to open its menu."));
//								spawnerLore.add("");
//								spawnerLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") +  "State &8» " + "&cDamaged"));
//								spawnerLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") +  "Reinforced &8» " + "&cFalse"));
//								spawnerLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.HighlightColor") + "Type &8» &e" + mobtype.toString()));
//								spawnerLore.add("");
//								spawnerLore.add(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "MorphMining"));
//								spawnerMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Menus.ItemColor") + "Mob Spawner"));
//								spawnerMeta.setLore(spawnerLore);
//								spawner.setItemMeta(spawnerMeta);
//								dropSpawner(world, loc, spawner);
//								p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Prefix") + this.plugin.getMessage("Menus.LoreColor") + " You feel a touch of magic when you mine this!"));
//							}
//						}
//					}		
//			    }
//			}
//		}
//	}
}
