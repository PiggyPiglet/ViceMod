package me.piggypiglet.vicemod;

import me.piggypiglet.framework.Framework;
import me.piggypiglet.framework.bootstrap.BootPriority;
import me.piggypiglet.framework.jda.JDAAddon;
import me.piggypiglet.framework.utils.annotations.files.Config;
import me.piggypiglet.framework.utils.annotations.registerable.RegisterableData;
import me.piggypiglet.framework.utils.map.KeyValueSet;
import me.piggypiglet.vicemod.registerables.CommandsRegisterable;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = "vicemod",
        name = "ViceMod",
        version = "1.0.0"
)
public class ViceMod {
    private Logger logger;
    private FMLServerStartingEvent start;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLServerStartingEvent event) {
        this.start = event;

        Framework.builder()
                .main(ViceMod.class, this)
                .pckg("me.piggypiglet.vicemod")
                .commandPrefix("vicemod")
                .startup(new RegisterableData(CommandsRegisterable.class, BootPriority.AFTER_COMMANDS))
                .file(true, "config", "/config.json", "vicemod/config.json", Config.class)
                .config(JDAAddon.class, "config", KeyValueSet.builder()
                        .key("token").value("token")
                        .key("activity.type").value("activity.type")
                        .key("activity.activity").value("activity.activity")
                        .build().toMap())
                .build()
                .init();
    }

    public Logger getLogger() {
        return logger;
    }

    public FMLServerStartingEvent getStart() {
        return start;
    }
}
