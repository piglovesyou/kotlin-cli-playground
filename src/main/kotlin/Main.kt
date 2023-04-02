
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.subcommands

class Hello : CliktCommand() {
    override fun run() {
        echo("Hello!")
    }
}

class Blaa : CliktCommand() {
    override fun run() {
        echo("Blaa!")
    }
}

class Main : CliktCommand() {
    override fun run() {
        echo("Hello, world!")
    }
}

fun main(args: Array<String>) = Main()
    .subcommands(
        Hello(),
        Blaa(),
    )
    .main(args)
