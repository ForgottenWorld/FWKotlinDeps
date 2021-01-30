package it.forgottenworld.kotlindeps

import org.bukkit.plugin.java.JavaPlugin
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.context.KoinContext
import org.koin.core.context.startKoin
import org.koin.core.error.KoinAppAlreadyStartedException
import org.koin.core.module.Module

class FWKotlinDepsPlugin : JavaPlugin(), KoinContext {

    private var _koin: Koin? = null

    override fun onEnable() {
        super.onEnable()
        startKoin(this) {}
        logger.info("KotlinDeps loaded")
    }

    fun loadKoinModules(modules: List<Module>) {
        _koin?.loadModules(modules)
    }

    override fun get() = _koin ?: error("Application non initialized")

    override fun getOrNull() = _koin

    override fun register(koinApplication: KoinApplication) {
        if (_koin != null) throw KoinAppAlreadyStartedException("Application already started")
        _koin = koinApplication.koin
    }

    override fun stop() {
        _koin?.close()
        _koin = null
    }

    companion object {

        fun loadKoinModules(vararg modules: Module) {
            getPlugin(FWKotlinDepsPlugin::class.java).loadKoinModules(modules.toList())
        }
    }

}

