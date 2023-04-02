import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.subcommands
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.prompt
import com.github.ajalt.clikt.parameters.types.int

class Hello : CliktCommand() {
    val count: Int by option(help="Number of greetings").int().default(1)
    val name: String by option(help="The person to greet").prompt("Your name")

    override fun run() {
        repeat(count) {
            echo("Hello $name!")
        }
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