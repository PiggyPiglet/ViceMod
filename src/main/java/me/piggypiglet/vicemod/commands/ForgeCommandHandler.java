package me.piggypiglet.vicemod.commands;

import com.google.inject.Inject;
import me.piggypiglet.framework.Framework;
import me.piggypiglet.framework.commands.CommandHandlers;
import me.piggypiglet.vicemod.user.ForgeUser;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

// ------------------------------
// Copyright (c) PiggyPiglet 2019
// https://www.piggypiglet.me
// ------------------------------
public final class ForgeCommandHandler extends CommandBase {
    @Inject private Framework framework;
    @Inject private CommandHandlers commandHandlers;

    @NotNull
    @Override
    public String getName() {
        return framework.getCommandPrefix();
    }

    @Override
    public String getUsage(@NotNull ICommandSender sender) {
        return "";
    }

    @Override
    public void execute(@NotNull MinecraftServer server, @NotNull ICommandSender sender, @NotNull String[] args) {
        commandHandlers.process("forge", new ForgeUser(sender), framework.getCommandPrefix() + " " + String.join(" ", args));
    }
}
