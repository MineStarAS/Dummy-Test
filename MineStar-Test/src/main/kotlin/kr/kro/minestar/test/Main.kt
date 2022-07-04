package kr.kro.minestar.test

import kr.kro.minestar.utility.item.Head
import kr.kro.minestar.utility.main.FunctionalJavaPlugin
import org.bukkit.Bukkit

class Main : FunctionalJavaPlugin() {
    companion object {
        lateinit var plugin: FunctionalJavaPlugin
    }

    override fun onEnable() {
        plugin = this
        prefix = "§cTest"
        getCommand("test")?.setExecutor(Command)
    }

    override fun onDisable() {
        for (player in Bukkit.getOnlinePlayers()) try {
            player.closeInventory()
        } catch (_: Exception) {
        }
    }
}