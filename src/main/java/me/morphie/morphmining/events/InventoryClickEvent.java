package me.morphie.morphmining.events;

import me.morphie.morphmining.menus.ArchivistMenu;
import me.morphie.morphmining.menus.OreGrinderMenu;
import me.morphie.morphmining.DataLog.LogMenu;
import me.morphie.morphmining.menus.ArtifactShopMenu;
import me.morphie.morphmining.menus.MarketMenu;
import me.morphie.morphmining.MineStats;
import me.morphie.morphmining.MorphMining;
import me.morphie.morphmining.menus.MainMenu;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class InventoryClickEvent implements Listener {

    private MorphMining plugin;

    public InventoryClickEvent(MorphMining plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClick(org.bukkit.event.inventory.InventoryClickEvent event) {
        Player player = (Player)event.getWhoClicked();
        if (ChatColor.stripColor(event.getView().getTitle()).equalsIgnoreCase("Mining Station")) {
            if ((event.getCurrentItem() == null) || (!event.getCurrentItem().hasItemMeta())) {
                return;
            }
            switch (event.getCurrentItem().getType()) {
                case END_CRYSTAL:
                    new ArchivistMenu().openGUIArch(player);
                    break;
                case ENDER_CHEST:
                    new MarketMenu(this.plugin).openGUIMarket(player);
                    break;
                case BOOK:
                    new LogMenu(this.plugin).openGUIMineLog(player);
                    break;
                case PAPER:
                    event.setCancelled(true);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getMessage("SpigotLink")));
                    break;
                case PLAYER_HEAD:
                    new MineStats(this.plugin).openGUIStats(player, player.getUniqueId(), player.getName().toString());
                    break;
                case SPAWNER:
                    event.setCancelled(true);
                    break;
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ")) {
                event.setCancelled(true);

            }
        } else if (ChatColor.stripColor(event.getView().getTitle()).equalsIgnoreCase("Miner's Market")) {
            if ((event.getCurrentItem() == null) || (!event.getCurrentItem().hasItemMeta())) {
                return;
            }
            switch (event.getCurrentItem().getType()) {
                case STRUCTURE_VOID:
                    event.setCancelled(true);
                    break;
                case BOOK:
                    event.setCancelled(true);
                    break;
                case EMERALD_BLOCK:
                    event.setCancelled(true);
                    break;
                case LAPIS_BLOCK:
                    event.setCancelled(true);
                    break;
                case PRISMARINE_CRYSTALS:
                    event.setCancelled(true);
                    break;
                case CHEST:
                    new ArtifactShopMenu(this.plugin).openGUIShop(player);
                    break;
                case REDSTONE:
                    new MainMenu(this.plugin).openGUIMining(player);
                    break;
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ")) {
                event.setCancelled(true);

            }
        } else if (ChatColor.stripColor(event.getView().getTitle()).equalsIgnoreCase("Artifact Shop")) {
            if ((event.getCurrentItem() == null) || (!event.getCurrentItem().hasItemMeta())) {
                return;
            }
            switch (event.getCurrentItem().getType()) {
                case MAP:
                    event.setCancelled(true);
                    break;
                case REDSTONE:
                    new MarketMenu(this.plugin).openGUIMarket(player);
                    break;
                case BOOK:
                    event.setCancelled(true);
                    break;
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ")) {
                event.setCancelled(true);

            }
        } else if (ChatColor.stripColor(event.getView().getTitle()).equalsIgnoreCase("Archivist")) {
            if ((event.getCurrentItem() == null) || (!event.getCurrentItem().hasItemMeta())) {
                return;
            }
            switch (event.getCurrentItem().getType()) {
                case END_CRYSTAL:
                    event.setCancelled(true);
                    break;
                case STRUCTURE_VOID:
                    event.setCancelled(true);
                    break;
                case ENDER_EYE:
                    event.setCancelled(true);
                    break;
                case REDSTONE_BLOCK:
                    event.setCancelled(true);
                    break;
                case DIAMOND_BLOCK:
                    event.setCancelled(true);
                    break;
                case BONE:
                    event.setCancelled(true);
                    break;
                case ANVIL:
                    event.setCancelled(true);
                    break;
                case DIAMOND_ORE:
                    new OreGrinderMenu(this.plugin).openGUIOG(player);
                    break;
                case BOOK:
                    break;
                case REDSTONE:
                    new MainMenu(this.plugin).openGUIMining(player);
                    break;
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ")) {
                event.setCancelled(true);
            }
        } else if (ChatColor.stripColor(event.getView().getTitle()).equalsIgnoreCase("Ore Grinder")) {
            if ((event.getCurrentItem() == null) || (!event.getCurrentItem().hasItemMeta())) {
                return;
            }
            switch (event.getCurrentItem().getType()) {
                case MAP:
                    event.setCancelled(true);
                    break;
                case REDSTONE:
                    player.closeInventory();
                    new ArchivistMenu().openGUIArch(player);
                    break;
                case BOOK:
                    event.setCancelled(true);
                    break;
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(" ")) {
                event.setCancelled(true);
            }
        }
    }
}
