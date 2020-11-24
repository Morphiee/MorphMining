package me.morphie.MorphMining.Files;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.morphie.MorphMining.Main;

public class playerFileMethods {
	
	private Main plugin;
	  
	public playerFileMethods(Main plugin) {
		this.plugin = plugin;
	}
	
  public int getStat(UUID uuid, String string) {
    File file = getPlayerFile(uuid);
    FileConfiguration fc = YamlConfiguration.loadConfiguration(file);
    return fc.getInt(string);
  }
  
  public boolean getBoolean(UUID uuid, String string) {
	    File file = getPlayerFile(uuid);
	    FileConfiguration fc = YamlConfiguration.loadConfiguration(file);
	    return fc.getBoolean(string);
   }
  
  public ItemStack getMaterial(UUID uuid, String string) {
	    File file = getPlayerFile(uuid);
	    FileConfiguration fc = YamlConfiguration.loadConfiguration(file);
	    return fc.getItemStack(string);
 }
  
  public File getPlayerFile(UUID uuid) {
    File playerFile = new File(this.plugin.getDataFolder() + File.separator + "PlayerData", uuid + ".yml");
    FileConfiguration playerCFG = YamlConfiguration.loadConfiguration(playerFile);
    if (!playerFile.exists()) {
      try {
        playerCFG.save(playerFile);
      }
      catch (IOException e1) {
        e1.printStackTrace();
      }
    }
    return playerFile;
  }
  
	public void setData(Player player, UUID uuid, String string, int i) {
	    File file = getPlayerFile(player.getUniqueId());
	    FileConfiguration fc = YamlConfiguration.loadConfiguration(file);
	    fc.set(string, Integer.valueOf(fc.getInt(string) + i));
	    try
	    {
	      fc.save(file);
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
	    }
	}
	
	public void setInt(Player player, UUID uuid, String string, int i) {
	    File file = getPlayerFile(player.getUniqueId());
	    FileConfiguration fc = YamlConfiguration.loadConfiguration(file);
	    fc.set(string, Integer.valueOf(i));
	    try
	    {
	      fc.save(file);
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
	    }
	}
	
	public void addMoney(Player player, UUID uuid, String string, double i) {
	    File file = getPlayerFile(player.getUniqueId());
	    FileConfiguration fc = YamlConfiguration.loadConfiguration(file);
	    fc.set(string, Double.valueOf(fc.getDouble(string) + i));
	    try
	    {
	      fc.save(file);
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
	    }
	}
	
	public void addMaterial(Player player, UUID uuid, String string, ItemStack i) {
	    File file = getPlayerFile(player.getUniqueId());
	    FileConfiguration fc = YamlConfiguration.loadConfiguration(file);
	    fc.set(string, i);
	    try
	    {
	      fc.save(file);
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
	    }
	}
	
	public void removeInt(Player player, UUID uuid, String string, int i) {
	    File file = getPlayerFile(player.getUniqueId());
	    FileConfiguration fc = YamlConfiguration.loadConfiguration(file);
	    fc.set(string, Double.valueOf(fc.getDouble(string) - i));
	    try
	    {
	      fc.save(file);
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
	    }
	}
	
	public void setBoolean(Player player, UUID uuid, String string, Boolean b) {
	    File file = getPlayerFile(player.getUniqueId());
	    FileConfiguration fc = YamlConfiguration.loadConfiguration(file);
	    fc.set(string, Boolean.valueOf(b));
	    try
	    {
	      fc.save(file);
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
	    }
	}
}