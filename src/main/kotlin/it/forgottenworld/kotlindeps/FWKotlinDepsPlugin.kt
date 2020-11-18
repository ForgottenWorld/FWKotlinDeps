package it.forgottenworld.kotlindeps

import org.bukkit.plugin.java.JavaPlugin

class FWKotlinDepsPlugin : JavaPlugin() {

    override fun onEnable() {
        super.onEnable()
        logger.info("KotlinDeps loaded")
    }

}

