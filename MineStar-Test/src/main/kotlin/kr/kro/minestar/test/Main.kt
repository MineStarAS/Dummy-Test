package kr.kro.minestar.test

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.ProtocolLibrary
import com.comphenix.protocol.events.ListenerPriority
import com.comphenix.protocol.events.PacketAdapter
import com.comphenix.protocol.events.PacketEvent
import kr.kro.minestar.utility.main.FunctionalJavaPlugin
import kr.kro.minestar.utility.string.toServer
import org.bukkit.Bukkit

class Main : FunctionalJavaPlugin() {
    companion object {
        lateinit var plugin: FunctionalJavaPlugin
    }

    override fun onEnable() {
        plugin = this
        prefix = "§cTest"
        getCommand("test")?.setExecutor(Command)

        Event

        /**
         * Protocol Test
         */
        val manager = ProtocolLibrary.getProtocolManager()

        manager.addPacketListener(object : PacketAdapter(this, ListenerPriority.NORMAL, PacketType.Play.Client.ARM_ANIMATION) {
            override fun onPacketReceiving(event: PacketEvent) {
                val packet = event.packet

                packet.playerActions.values.size.toString().toServer()
            }
        }
        )
    }

    override fun onDisable() {
        for (player in Bukkit.getOnlinePlayers()) try {
            player.closeInventory()
        } catch (_: Exception) {
        }
    }
}