package me.morphie.morphmining.util;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;

public class ItemUtils {

    public void dropItem(World world, Location loc, ItemStack artifact) {
        loc.setY(loc.getY() + 1.0D);
        world.dropItem(loc, artifact);
    }
}
