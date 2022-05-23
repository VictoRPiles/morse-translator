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
	 * Allows to choose between encode or decode.
	 *
	 * @return "encode" or "decode"
	 */
	fun menu(): String {
		println("Choose action")
		println("1) Encode")
		println("2) Decode")
		print("> ")

		return when (readLine()) {
			"1", "encode" -> "encode"
			"2", "decode" -> "decode"
			else -> {
				println("Unknown option")
				menu()
			}
		}
	}
}