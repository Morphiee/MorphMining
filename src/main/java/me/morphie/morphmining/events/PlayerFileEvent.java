package me.morphie.morphmining.events;

import me.morphie.morphmining.MorphMining;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Level;

public class PlayerFileEvent implements Listener {

    private MorphMining plugin;

    public PlayerFileEvent(MorphMining plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        UUID uuid = player.getUniqueId();

        new BukkitRunnable() {
            public void run() {
                File file = getData(uuid);
                FileConfiguration pd = YamlConfiguration.loadConfiguration(file);
                if (!pd.contains("Stats.Gems")) {
                    pd.set("Stats.Gems", Integer.valueOf(0));
                    pd.set("Stats.ArtifactsMinedAll", Integer.valueOf(0));
                    pd.set("Stats.ArtifactsMinedCommon", Integer.valueOf(0));
                    pd.set("Stats.ArtifactsMinedRare", Integer.valueOf(0));
                    pd.set("Stats.ArtifactsMinedLegendary", Integer.valueOf(0));
                    pd.set("Stats.ArtifactsMinedMythic", Integer.valueOf(0));
                    pd.set("Stats.ArtifactsMinedHellstone", Integer.valueOf(0));
                    pd.set("Stats.StoneMined", Integer.valueOf(0));
                    pd.set("Stats.CoalOreMined", Integer.valueOf(0));
                    pd.set("Stats.RedstoneOreMined", Integer.valueOf(0));
                    pd.set("Stats.IronOreMined", Integer.valueOf(0));
                    pd.set("Stats.GoldOreMined", Integer.valueOf(0));
                    pd.set("Stats.LapisOreMined", Integer.valueOf(0));
                    pd.set("Stats.DiamondOreMined", Integer.valueOf(0));
                    pd.set("Stats.EmeraldOreMined", Integer.valueOf(0));
                    pd.set("Stats.QuartzOreMined", Integer.valueOf(0));
                    pd.set("Stats.MoneyEarned", Integer.valueOf(0));
                    pd.set("Pouch.Enabled", Boolean.valueOf(false));
                    pd.set("Pouch.CommonUpgrade", Boolean.valueOf(false));
                    pd.set("Pouch.RareUpgrade", Boolean.valueOf(false));
                    pd.set("Pouch.LegendaryUpgrade", Boolean.valueOf(false));
                    pd.set("Pouch.MythicUpgrade", Boolean.valueOf(false));
                    pd.set("Pouch.Common", Integer.valueOf(0));
                    pd.set("Pouch.Rare", Integer.valueOf(0));
                    pd.set("Pouch.Legendary", Integer.valueOf(0));
                    pd.set("Pouch.Mythic", Integer.valueOf(0));
                    try {
                        pd.save(file);
                    }
                    catch (IOException e) {
                        Bukkit.getServer().getLogger().log(Level.SEVERE, "Could not save " + uuid + "'s player file!");
                        e.printStackTrace();
                    }
                }
            }
        }.runTaskLater(plugin, 60L);
    }

    public File getData(UUID uuid) {
        File data = new File(plugin.getDataFolder() + File.separator + "PlayerData", uuid + ".yml");
        FileConfiguration dataFile = YamlConfiguration.loadConfiguration(data);
        if (!data.exists()) {
            try {
                dataFile.save(data);
            }
            catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return data;
    }
}