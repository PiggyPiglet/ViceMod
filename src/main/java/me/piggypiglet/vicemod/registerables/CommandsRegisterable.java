package me.piggypiglet.vicemod.registerables;

import com.google.inject.Inject;
import me.piggypiglet.framework.commands.CommandHandlers;
import me.piggypiglet.framework.registerables.StartupRegisterable;
import me.piggypiglet.framework.utils.annotations.Main;
import me.piggypiglet.vicemod.ViceMod;
import me.piggypiglet.vicemod.commands.ForgeCommandHandler;

// ------------------------------
// Copyright (c) PiggyPiglet 2019
// https://www.piggypiglet.me
// ------------------------------
public final class CommandsRegisterable extends StartupRegisterable {
    @Inject private CommandHandlers commandHandlers;
    @Inject private ViceMod main;
    @Inject private ForgeCommandHandler commandHandler;

    @Override
    protected void execute() {
        commandHandlers.newHandler("forge", injector);
        main.getStart().registerServerCommand(commandHandler);
    }
}
