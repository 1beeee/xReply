package org.beeee.xreply;

import org.beeee.xreply.commands.ReloadConfig;
import org.beeee.xreply.events.ReplyEvent;
import org.beeee.xreply.utils.MainUtil;
import org.bukkit.plugin.java.JavaPlugin;

public final class XReply extends JavaPlugin {
    public static XReply instance;
    public static String prefix;

    @Override
    public void onEnable() {
        prefix = getConfig().getString("prefix");
        instance = this;

        getCommand("xReply").setExecutor(new ReloadConfig());
        getCommand("xReply").setTabCompleter(new ReloadConfig());
        getServer().getPluginManager().registerEvents(new ReplyEvent(), this);

        saveDefaultConfig();

    }

    public static XReply getInstance() {
        return instance;
    }

    public static String getPrefix() {
        return MainUtil.MessageColor(prefix);
    }
}
