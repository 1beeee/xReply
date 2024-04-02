package org.beeee.xreply.commands;

import org.beeee.xreply.XReply;
import org.beeee.xreply.utils.MainUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ReloadConfig implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(strings.length == 0) {
            commandSender.sendMessage("&fВерсия &dXReply&f: &d1.0&f.");
            return true;
        }
        if(strings[0].equalsIgnoreCase("reload")){
            if(!commandSender.hasPermission("XReply.reload")) {
                commandSender.sendMessage(MainUtil.MessageColor(XReply.getInstance().getConfig().getString("messages.no_permission")));
                return true;
            }
            commandSender.sendMessage(MainUtil.MessageColor(XReply.getInstance().getConfig().getString("messages.reload_config")));
            XReply.getInstance().reloadConfig();
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        List<String> tab = new ArrayList<>();
        tab.add("reload");
        return tab;
    }
}
