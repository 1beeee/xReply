package org.beeee.xreply.utils;

import org.bukkit.*;
import org.bukkit.entity.Player;

public class MainUtil {
    public static String MessageColor(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static void teleportPlayer(Player player, String world, double x, double y, double z) {
        Location location = new Location(Bukkit.getWorld(world), x, y, z);
        player.teleport(location);
    }

    public static void playsoundPLayer(Player player, Sound sound, float volume, float pitch) {
        Location location = player.getLocation();
        player.playSound(location, sound, volume, pitch);
    }

    public static void playparticlePlayer(Particle particle, Player player, int count) {
        Location location = player.getLocation();
        player.spawnParticle(particle, location, count);
    }
}
