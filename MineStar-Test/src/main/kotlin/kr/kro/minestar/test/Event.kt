package kr.kro.minestar.test

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.ProtocolLibrary
import com.comphenix.protocol.events.PacketContainer
import kr.kro.minestar.utility.event.enable
import kr.kro.minestar.utility.string.toServer
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerJoinEvent

object Event : Listener {
    init {
        enable(Main.plugin)
    }

    private val manager = ProtocolLibrary.getProtocolManager()

    @EventHandler
    fun join(e: PlayerJoinEvent) {
    }

    @EventHandler
    fun interact(e: PlayerInteractEvent) {
        if (e.action != Action.RIGHT_CLICK_AIR) return
        val packetContainer = PacketContainer(PacketType.Play.Client.ARM_ANIMATION)
        packetContainer.bytes.write(0, 3.toByte())
        manager.sendServerPacket(e.player, packetContainer)
    }
}