package org.beeee.xreply.events;

import org.beeee.xreply.XReply;
import org.beeee.xreply.utils.MainUtil;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ReplyEvent implements Listener {

    @EventHandler
    public static void onChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();

        if (message.contains("@")) {
            Player player = event.getPlayer();
            String[] parts = message.split("@");
            String player_name = parts[1].split(" ")[0];

            Player mentionedPlayer = Bukkit.getPlayer(player_name);
            if (mentionedPlayer != null) {
                String mentioned_message = message.replace("@" + player_name, "");
                mentionedPlayer.sendMessage(MainUtil.MessageColor(XReply.getInstance().getConfig().getString("messages.response_message").replaceAll("%player_sender%", event.getPlayer().getName()).replaceAll("%response_message%", mentioned_message)));
                if(XReply.getInstance().getConfig().getBoolean("use_sound") != false) {
                    MainUtil.playsoundPLayer(player, Sound.valueOf(XReply.getInstance().getConfig().getString("sound")), 5, 5);
                }
            }
        }
    }
}
