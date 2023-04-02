
import com.example.tutorial.protos.AddressBook
import com.example.tutorial.protos.Person
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

        val book = AddressBook.newBuilder().apply {
            addPeople(
                Person.newBuilder().apply {
                    id = 123
                    name = "John Doe"
                    email = "johndoe@example.com"
                }.build()
            )
        }

        println(book)
    }
}

class Main : CliktCommand() {
    override fun run() {}
}

fun main(args: Array<String>) = Main()
    .subcommands(
        Hello(),
        Blaa(),
    )
    .main(args)
