import org.apache.commons.cli.CommandLine
import org.apache.commons.cli.DefaultParser
import org.apache.commons.cli.Options

class Input(args: Array<String>) {
	private var flags: Options = Options()
	private var parser: DefaultParser = DefaultParser()
	private var cli: CommandLine

	init {
		setupOptions()
		cli = parser.parse(flags, args, true)
	}

	/** Determine the flags allowed */
	private fun setupOptions() {
		flags.addOption("e", "encode", false, "Encode message")
		flags.addOption("d", "decode", false, "Decode message")
	}

	/** @return All args concatenated in one String and trim trailing whitespaces */
	fun getMessageFromArgs(): String {
		var message = ""

		for (arg in cli.args) {
			message += "$arg "
		}

		return message.trim()
	}

	/** @return Not null String with the message. */
	fun cliInput(): String {
		print("Type your message -> ")
		return readLine() ?: return cliInput()
	}

	/** @return The action that the flag should trigger. */
	fun checkFlags(): String? {
		if (cli.hasOption("e")) {
			return "encode"
		}
		if (cli.hasOption("d")) {
			return "decode"
		}
		return null
	}

	/**
	 * Searches for alphabetic or numbers in the message.
	 *
	 * @param message Input message.
	 * @return If the message is in morse code.
	 * @throws IllegalArgumentException If the message is blank.
	 */
	fun isMorseMessage(message: String): Boolean {
		if (message.isBlank()) throw IllegalArgumentException("Empty message")
		return !message.contains("[a-zA-Z\\d]".toRegex())
	}
}