package me.piggypiglet.vicemod.listeners;

import com.google.inject.Inject;
import me.piggypiglet.framework.file.framework.FileConfiguration;
import me.piggypiglet.framework.utils.annotations.files.Config;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.minecraft.client.Minecraft;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import org.jetbrains.annotations.NotNull;

// ------------------------------
// Copyright (c) PiggyPiglet 2019
// https://www.piggypiglet.me
// ------------------------------
public final class MessageListener extends ListenerAdapter {
    @Inject @Config private FileConfiguration config;

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent e) {
        if (e.getChannel().getId().equals(config.getString("channel_id"))) {
            MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
            server.getCommandManager().executeCommand(server, "whitelist add " + e.getMessage().getContentRaw());
        }
    }
}
