package me.morphie.morphmining.events;

import me.morphie.morphmining.Files.playerFileMethods;
import me.morphie.morphmining.MorphMining;
import me.morphie.morphmining.util.ItemUtils;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Random;
import java.util.UUID;

public class InventoryCloseEvent implements Listener {

    private MorphMining plugin;

    public InventoryCloseEvent(MorphMining plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onShopClose(org.bukkit.event.inventory.InventoryCloseEvent event) {
        if (ChatColor.stripColor(event.getView().getTitle()).equalsIgnoreCase("Artifact Shop")) {
            Inventory inv = event.getInventory();
            Player player = (Player)event.getPlayer();
            UUID uuid = player.getUniqueId();

            int Artifacts = 0;
            int Money = 0;

            double CommonPrice = this.plugin.getConfig().getDouble("ArtifactPrice.Common");
            double RarePrice = this.plugin.getConfig().getDouble("ArtifactPrice.Rare");
            double LegendaryPrice = this.plugin.getConfig().getDouble("ArtifactPrice.Legendary");
            double MythicPrice = this.plugin.getConfig().getDouble("ArtifactPrice.Mythic");
            double HellStonePrice = this.plugin.getConfig().getDouble("ArtifactPrice.HellStone");
            for (int i = 8; i <= 41; i++) {
                ItemStack item = inv.getItem(i);
                if (item != null) {
                    if (item.hasItemMeta()) {
                        if (item.getType() == Material.matchMaterial(this.plugin.getConfig().getString("Settings.ArtifactItem")) || item.getType() == Material.matchMaterial(this.plugin.getConfig().getString("Settings.HellstoneItem"))) {
                            int x = item.getAmount();
                            while (x > 0) {
                                x--;
                                if (ChatColor.stripColor(item.getItemMeta().getLore().get(4)).equals("Tier » Common") && ChatColor.stripColor(item.getItemMeta().getLore().get(6)).equals("MorphMining")) {
                                    MorphMining.econ.depositPlayer(player, CommonPrice);
                                    new playerFileMethods(this.plugin).addMoney(player, uuid, "Stats.MoneyEarned", CommonPrice);
                                    Artifacts++;
                                    Money = (int)(Money + CommonPrice);
                                }
                                else if (ChatColor.stripColor(item.getItemMeta().getLore().get(4)).equals("Tier » Rare") && ChatColor.stripColor(item.getItemMeta().getLore().get(6)).equals("MorphMining")) {
                                    MorphMining.econ.depositPlayer(player, RarePrice);
                                    new playerFileMethods(this.plugin).addMoney(player, uuid, "Stats.MoneyEarned", RarePrice);
                                    Artifacts++;
                                    Money = (int)(Money + RarePrice);
                                }
                                else if (ChatColor.stripColor(item.getItemMeta().getLore().get(4)).equals("Tier » Legendary") && ChatColor.stripColor(item.getItemMeta().getLore().get(6)).equals("MorphMining")) {
                                    MorphMining.econ.depositPlayer(player, LegendaryPrice);
                                    new playerFileMethods(this.plugin).addMoney(player, uuid, "Stats.MoneyEarned", LegendaryPrice);
                                    Artifacts++;
                                    Money = (int)(Money + LegendaryPrice);
                                }
                                else if (ChatColor.stripColor(item.getItemMeta().getLore().get(4)).equals("Tier » Mythic") && ChatColor.stripColor(item.getItemMeta().getLore().get(6)).equals("MorphMining")) {
                                    MorphMining.econ.depositPlayer(player, MythicPrice);
                                    new playerFileMethods(this.plugin).addMoney(player, uuid, "Stats.MoneyEarned", MythicPrice);
                                    Artifacts++;
                                    Money = (int)(Money + MythicPrice);
                                }
                                else if (ChatColor.stripColor(item.getItemMeta().getLore().get(4)).equals("Tier » HellStone") && ChatColor.stripColor(item.getItemMeta().getLore().get(6)).equals("MorphMining")) {
                                    MorphMining.econ.depositPlayer(player, HellStonePrice);
                                    new playerFileMethods(this.plugin).addMoney(player, uuid, "Stats.MoneyEarned", HellStonePrice);
                                    Artifacts++;
                                    Money = (int)(Money + HellStonePrice);
                                }
                            }
                        }
                    }
                    else if ((!item.hasItemMeta()) || (!item.getItemMeta().hasDisplayName()) || (!item.getItemMeta().getDisplayName().equals(ChatColor.RED + "" + ChatColor.BOLD + "Information"))) {
                        player.getInventory().addItem(new ItemStack[] { item });
                    }
                }
            }
            if ((Money != 0) && (Artifacts != 0)) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Prefix") + this.plugin.getMessage("ArtifactSellMessage").replace("MONEY", "" + Money).replace("ARTIFACT", "" + Artifacts)));
            }
        } else if (ChatColor.stripColor(event.getView().getTitle()).equalsIgnoreCase("Ore Grinder")) {
            Inventory inv = event.getInventory();
            Player player = (Player)event.getPlayer();
            UUID uuid = player.getUniqueId();

            int Ores = 0;
            int Gems = 0;
            int Min = 0;

            for (int i = 8; i <= 21; i++) {
                ItemStack item = inv.getItem(i);
                if (item != null) {
                    if (item.getType() == Material.COAL_ORE || item.getType() == Material.IRON_ORE || item.getType() == Material.GOLD_ORE || item.getType() == Material.REDSTONE_ORE || item.getType() == Material.LAPIS_ORE || item.getType() == Material.DIAMOND_ORE || item.getType() == Material.EMERALD_ORE) {
                        int x = item.getAmount();
                        while (x > 0) {
                            x--;
                            if (item.getType() == Material.COAL_ORE) {
                                Ores++;
                                Random random = new Random();
                                int chance = random.nextInt(100);
                                int coalChance = plugin.getConfig().getInt("OreGrinder.CoalGemChance");
                                if (chance <= coalChance) {
                                    new playerFileMethods(this.plugin).setData(player, uuid, "Stats.Gems", 1);
                                    Gems++;
                                } else if (chance >= coalChance) {
                                    ItemStack Coal = new ItemStack(Material.COAL, 1);
                                    new ItemUtils().dropItem(player.getWorld(), player.getLocation(), Coal);
                                    Min++;
                                }
                            }
                            else if (item.getType() == Material.IRON_ORE) {
                                Ores++;
                                Random random = new Random();
                                int chance = random.nextInt(100);
                                int ironChance = plugin.getConfig().getInt("OreGrinder.IronGemChance");
                                if (chance <= ironChance) {
                                    new playerFileMethods(this.plugin).setData(player, uuid, "Stats.Gems", 1);
                                    Gems++;
                                } else if (chance >= ironChance) {
                                    ItemStack Iron = new ItemStack(Material.IRON_INGOT, 1);
                                    new ItemUtils().dropItem(player.getWorld(), player.getLocation(), Iron);
                                    Min++;
                                }
                            }
                            else if (item.getType() == Material.GOLD_ORE) {
                                Ores++;
                                Random random = new Random();
                                int chance = random.nextInt(100);
                                int goldChance = plugin.getConfig().getInt("OreGrinder.GoldGemChance");
                                if (chance <= goldChance) {
                                    new playerFileMethods(this.plugin).setData(player, uuid, "Stats.Gems", 1);
                                    Gems++;
                                } else if (chance >= goldChance) {
                                    ItemStack Gold = new ItemStack(Material.GOLD_INGOT, 1);
                                    new ItemUtils().dropItem(player.getWorld(), player.getLocation(), Gold);
                                    Min++;
                                }
                            }
                            else if (item.getType() == Material.REDSTONE_ORE) {
                                Ores++;
                                Random random = new Random();
                                int chance = random.nextInt(100);
                                int redstoneChance = plugin.getConfig().getInt("OreGrinder.RedstoneGemChance");
                                if (chance <= redstoneChance) {
                                    new playerFileMethods(this.plugin).setData(player, uuid, "Stats.Gems", 1);
                                    Gems++;
                                } else if (chance >= redstoneChance) {
                                    ItemStack Red = new ItemStack(Material.REDSTONE, 1);
                                    new ItemUtils().dropItem(player.getWorld(), player.getLocation(), Red);
                                    Min++;
                                }
                            }
                            else if (item.getType() == Material.LAPIS_ORE) {
                                Ores++;
                                Random random = new Random();
                                int chance = random.nextInt(100);
                                int lapisChance = plugin.getConfig().getInt("OreGrinder.LapisGemChance");
                                if (chance <= lapisChance) {
                                    new playerFileMethods(this.plugin).setData(player, uuid, "Stats.Gems", 1);
                                    Gems++;
                                } else if (chance >= lapisChance) {
                                    ItemStack Lapis = new ItemStack(Material.LAPIS_LAZULI, 1);
                                    new ItemUtils().dropItem(player.getWorld(), player.getLocation(), Lapis);
                                    Min++;
                                }
                            }
                            else if (item.getType() == Material.DIAMOND_ORE) {
                                Ores++;
                                Random random = new Random();
                                int chance = random.nextInt(100);
                                int diamondChance = plugin.getConfig().getInt("OreGrinder.DiamondGemChance");
                                if (chance <= diamondChance) {
                                    new playerFileMethods(this.plugin).setData(player, uuid, "Stats.Gems", 1);
                                    Gems++;
                                } else if (chance >= diamondChance) {
                                    ItemStack Dia = new ItemStack(Material.DIAMOND, 1);
                                    new ItemUtils().dropItem(player.getWorld(), player.getLocation(), Dia);
                                    Min++;
                                }
                            }
                            else if (item.getType() == Material.EMERALD_ORE) {
                                Ores++;
                                Random random = new Random();
                                int chance = random.nextInt(100);
                                int emeraldChance = plugin.getConfig().getInt("OreGrinder.EmeraldGemChance");
                                if (chance <= emeraldChance) {
                                    new playerFileMethods(this.plugin).setData(player, uuid, "Stats.Gems", 1);
                                    Gems++;
                                } else if (chance >= emeraldChance) {
                                    ItemStack Em = new ItemStack(Material.EMERALD, 1);
                                    new ItemUtils().dropItem(player.getWorld(), player.getLocation(), Em);
                                    Min++;
                                }
                            }
                        }
                    }
                    else if (!item.getItemMeta().getDisplayName().equals(" ") || !item.hasItemMeta() || !item.getItemMeta().hasDisplayName()) {
                        player.getInventory().addItem(new ItemStack[] { item });
                    }
                }
            }
            if ((Gems != 0) && (Ores != 0)) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Prefix") + this.plugin.getMessage("OreGrinder.GemMessage").replace("GEMS", "" + Gems).replace("ORES", "" + Ores)));
            }
            if ((Gems == 0) && (Ores > 0)) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("Prefix") + this.plugin.getMessage("OreGrinder.NoGemMessage").replace("ORES", "" + Ores)));
            }
        }
    }
}
