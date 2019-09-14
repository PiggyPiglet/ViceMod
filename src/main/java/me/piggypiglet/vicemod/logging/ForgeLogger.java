package me.piggypiglet.vicemod.logging;

import com.google.inject.Inject;
import me.piggypiglet.framework.logging.Logger;
import me.piggypiglet.framework.utils.annotations.Main;
import me.piggypiglet.vicemod.ViceMod;

// ------------------------------
// Copyright (c) PiggyPiglet 2019
// https://www.piggypiglet.me
// ------------------------------
public final class ForgeLogger extends Logger<org.apache.logging.log4j.Logger> {
    @Inject private ViceMod main;

    @Override
    protected org.apache.logging.log4j.Logger init(String s) {
        return main.getLogger();
    }

    @Override
    protected void info(String s) {
        logger.info(s);
    }

    @Override
    protected void warning(String s) {
        logger.warn(s);
    }

    @Override
    protected void error(String s) {
        logger.error(s);
    }
}
