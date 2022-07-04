package kr.kro.minestar.test

import com.comphenix.protocol.ProtocolManager
import com.comphenix.protocol.ProtocolLibrary
import com.comphenix.protocol.events.PacketAdapter
import com.comphenix.protocol.events.ListenerPriority
import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketEvent

class T {
    fun test() {
        val manager = ProtocolLibrary.getProtocolManager()
        manager.addPacketListener(object : PacketAdapter(Main.plugin, ListenerPriority.NORMAL, PacketType.Play.Client.ARM_ANIMATION) {
            override fun onPacketReceiving(event: PacketEvent) {
                event.isCancelled = true
            }
        })
    }
}