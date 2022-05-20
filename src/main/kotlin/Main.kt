fun main(args: Array<String>) {
	val input = Input(args)
	val encoder = MorseEncoder()
	val decoder = MorseDecoder()

	val message = if (args.isNotEmpty()) input.getMessageFromArgs() else input.cliInput()

	val newMessage = when (input.checkFlags()) {
		"encode" -> "Encoded message -> " + encoder.encode(message)
		"decode" -> "Decoded message -> " + decoder.decode(message)
		else -> "Unknown option flag"
	}

	println(newMessage)
}