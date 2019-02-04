package me.morphie.MorphMining.Items;

import java.util.ArrayList;
import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import me.morphie.MorphMining.Main;
import me.morphie.MorphMining.Station;
import net.md_5.bungee.api.ChatColor;

public class CrafterItems implements Listener {
	
	private Main plugin;
	  
	public CrafterItems(Main plugin) {
		this.plugin = plugin;
	}
	
	public ItemStack recipeItems(String string) {
		if (string == "trashcan") {
			ItemStack item = new ItemStack(Material.CAULDRON, 1);
			ItemMeta im = item.getItemMeta();
			ArrayList<String> itemlore = new ArrayList();
			itemlore.add(" ");
			itemlore.add(ChatColor.translateAlternateColorCodes('&', HighlightColor() + TextColor() + "Dump all unwanted things here!"));
			itemlore.add(" ");
			itemlore.add(ChatColor.translateAlternateColorCodes('&', this.MainColor() + "Information&8:"));
			itemlore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "➛ " + this.TextColor() + "Level&8: [" + this.HighlightColor() + "●" + this.TextColor() + "●●&8]"));
			itemlore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "➛ " + this.TextColor() + "Nullifier&8: " + this.HighlightColor() + "Disabled"));
			itemlore.add(ChatColor.translateAlternateColorCodes('&', HighlightColor() + "➛ " + this.TextColor() + "Right-Click to use."));
			itemlore.add(" ");
			itemlore.add(ChatColor.translateAlternateColorCodes('&', this.MainColor() + "MorphMining"));
			im.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.ItemColor() + "TrashCan"));
			im.setLore(itemlore);
			item.setItemMeta(im);
			return item;
		} else if (string == "pouch") {
			ItemStack item = new ItemStack(Material.FLOWER_POT, 1);
			ItemMeta im = item.getItemMeta();
			ArrayList<String> itemlore = new ArrayList();
			itemlore.add(" ");
			itemlore.add(ChatColor.translateAlternateColorCodes('&', HighlightColor() + TextColor() + "Automatically stores your artifacts!"));
			itemlore.add(" ");
			itemlore.add(ChatColor.translateAlternateColorCodes('&', this.MainColor() + "Information&8:"));
			itemlore.add(ChatColor.translateAlternateColorCodes('&', this.HighlightColor() + "➛ " + this.TextColor() + "Right-Click to use."));
			itemlore.add(" ");
			itemlore.add(ChatColor.translateAlternateColorCodes('&', this.MainColor() + "MorphMining"));
			im.setDisplayName(ChatColor.translateAlternateColorCodes('&', ItemColor() + "Miner's Pouch"));
			im.setLore(itemlore);
			item.setItemMeta(im);
			return item;
		} else if (string == "datalog") {
			ItemStack DataLog = new ItemStack(Material.BOOK, 1);
			ItemMeta DataMeta = DataLog.getItemMeta();
			ArrayList<String> Datalore = new ArrayList();
			Datalore.add(" ");
			Datalore.add(ChatColor.translateAlternateColorCodes('&', HighlightColor() + TextColor() + "The infinite wisdom of MorphMining"));
			Datalore.add(" ");
			Datalore.add(ChatColor.translateAlternateColorCodes('&', this.MainColor() + "Information&8:"));
			Datalore.add(ChatColor.translateAlternateColorCodes('&', HighlightColor() + "➛ " + this.TextColor() + "Version&8: " + TextColor() + new Station(plugin).Version));
			Datalore.add(ChatColor.translateAlternateColorCodes('&', HighlightColor() + "➛ " + this.TextColor() + "Author&8:" + TextColor() + " Morphie"));
			Datalore.add(ChatColor.translateAlternateColorCodes('&', HighlightColor() + "➛ " + this.TextColor() + "Right-Click to use."));
			Datalore.add(" ");
			Datalore.add(ChatColor.translateAlternateColorCodes('&', MainColor() + "MorphMining"));
			DataMeta.setLore(Datalore);
			DataMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', ItemColor() + "MorphMining DataLog"));
			DataLog.setItemMeta(DataMeta);
			return DataLog;
		}
		return null;
	}
	
	public void removeRecipes(ItemStack item){
        Iterator<Recipe> it = Bukkit.getServer().recipeIterator();
    
        while(it.hasNext()){
            ItemStack result = it.next().getResult();
            if(result.isSimilar(item)){
                it.remove();
            }
        }
    }
	
	public void createRecipeTrashcan() {
		ItemStack item = recipeItems("trashcan");
		NamespacedKey key = new NamespacedKey(this.plugin, "trashcan");
		ShapedRecipe craftItem = new ShapedRecipe(key, item);
		craftItem.shape("%$%","%*%","%%%");
		craftItem.setIngredient('%', Material.IRON_INGOT);
		craftItem.setIngredient('$', Material.CAULDRON);
		craftItem.setIngredient('*', Material.LAVA_BUCKET);
		this.plugin.getServer().addRecipe(craftItem);
	}
	
	public void createRecipePouch() {
		ItemStack item = recipeItems("pouch");
		NamespacedKey key = new NamespacedKey(this.plugin, "pouch");
		ShapedRecipe craftItem = new ShapedRecipe(key, item);
		craftItem.shape("%$%","%*%","%%%");
		craftItem.setIngredient('%', Material.LEATHER);
		craftItem.setIngredient('$', Material.ENDER_EYE);
		craftItem.setIngredient('*', Material.ENDER_CHEST);
		this.plugin.getServer().addRecipe(craftItem);
	}
	
	public void createRecipeDatalog() {
		ItemStack item = recipeItems("datalog");
		NamespacedKey key = new NamespacedKey(this.plugin, "datalog");
		ShapedRecipe craftItem = new ShapedRecipe(key, item);
		craftItem.shape("%%%","%$%","%%%");
		craftItem.setIngredient('%', Material.LEATHER);
		craftItem.setIngredient('$', Material.BOOK);
		this.plugin.getServer().addRecipe(craftItem);
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
