package kr.kro.minestar.test


import kr.kro.minestar.utility.command.*
import kr.kro.minestar.utility.string.toPlayer

object Command : FunctionalCommand {
    enum class Arg : Argument {
        test1("", ArgumentPermission()),
        test2("", ArgumentPermission()),
        test3("", ArgumentPermission()),
        test4("", ArgumentPermission()),
        ;

        override val howToUse: String
        override val permission: ArgumentPermission
        override val aliases: List<String>?

        constructor(howToUse: String, permission: ArgumentPermission) {
            this.howToUse = howToUse
            this.permission = permission
            this.aliases = null
        }

        constructor(aliases: List<String>, howToUse: String, permission: ArgumentPermission) {
            this.howToUse = howToUse
            this.permission = permission
            this.aliases = aliases
        }
    }

    override val plugin = Main.plugin
    override val arguments = Arg.values()

    override fun commanding(data: CommandData, args: Array<out String>) {
        if (!data.valid) return
        val player = data.player ?: return "플레이어가 아닙니다.".warningScript(data.sender)

        when (data.argument) {
            null -> plugin.name.toPlayer(player)

            Arg.test1 -> {
            }
            Arg.test2 -> {}
            Arg.test3 -> {}
            Arg.test4 -> {}
        }
        return
    }

    override fun tabComplete(data: TabCompleteData, args: Array<out String>): MutableList<String> {
        val list = mutableListOf<String>()

        val last = data.last
        val lastIndex = data.lastIndex

        if (!data.valid) return list

        when (val argument = data.argument) {
            /** First argument */
            null -> when (lastIndex) {
                0 -> Arg.values().add(data.sender, list, last, this)
            }
            /** Other argument */

            Arg.test1 -> {}
            Arg.test2 -> {}
            Arg.test3 -> {}
            Arg.test4 -> {}

        }

        return list
    }
}