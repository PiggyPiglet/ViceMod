package me.piggypiglet.vicemod.user;

import me.piggypiglet.framework.user.User;
import net.kyori.text.TextComponent;
import net.kyori.text.serializer.gson.GsonComponentSerializer;
import net.kyori.text.serializer.plain.PlainComponentSerializer;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentUtils;
import net.minecraftforge.server.command.TextComponentHelper;

// ------------------------------
// Copyright (c) PiggyPiglet 2019
// https://www.piggypiglet.me
// ------------------------------
public final class ForgeUser extends User {
    private final ICommandSender sender;

    public ForgeUser(ICommandSender sender) {
        super(sender.getName(), sender.getCommandSenderEntity() instanceof EntityPlayer ? sender.getCommandSenderEntity().getUniqueID().toString() : "Console");
        this.sender = sender;
    }

    @Override
    public boolean hasPermission(String s) {
        return true;
    }

    @Override
    protected void sendMessage(String s) {
        sender.sendMessage(ITextComponent.Serializer.jsonToComponent(GsonComponentSerializer.INSTANCE.serialize(PlainComponentSerializer.INSTANCE.deserialize(s))));
    }
}
