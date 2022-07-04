package kr.kro.minestar.test

import java.awt.Component
import java.awt.MouseInfo
import java.awt.Robot
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import java.util.*
import kotlin.concurrent.timer

fun main() {
    Test1.addKeyListener(Test)
}

object Test1 : Component() {

}

object Test : KeyListener {
    private val robot = Robot()
    private var timer: Timer? = null

    init {
        println("Test - Start")
        timer?.cancel()
        timer = timer(period = 1) {
        }
    }


    fun test1() {
    }

    fun test2() {
        val pointerInfo = MouseInfo.getPointerInfo()
        val x = pointerInfo.location.x
        val y = pointerInfo.location.y

        robot.mouseMove(x, y + 10)
    }

    override fun keyTyped(e: KeyEvent?) {
    }

    override fun keyPressed(e: KeyEvent?) {
    }

    override fun keyReleased(e: KeyEvent?) {
    }
}

