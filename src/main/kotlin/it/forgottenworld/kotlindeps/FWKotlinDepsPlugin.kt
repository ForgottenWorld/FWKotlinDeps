package it.forgottenworld.kotlindeps

import org.bukkit.plugin.java.JavaPlugin

class CrossbowCTFPlugin : JavaPlugin() {

    override fun onEnable() {
        super.onEnable()
        logger.info("KotlinDeps loaded")
    }

    override fun onDisable() {
        super.onDisable()
    }
}

