fun main(args: Array<String>) {
	val input = Input(args)
	val encoder = MorseEncoder()
	val decoder = MorseDecoder()

	val message: String
	val newMessage: String?

	if (args.isNotEmpty()) {
		message = input.getMessageFromArgs()
		newMessage = when (input.checkFlags()) {
			"encode" -> "Encoded message -> " + encoder.encode(message)
			"decode" -> "Decoded message -> " + decoder.decode(message)
			else -> "Unknown option flag"
		}
	} else {
		println("====================== MORSE TRANSLATOR ======================")
		println("==== -- --- .-. ... . / - .-. .- -. ... .-.. .- - --- .-. ====")

		message = input.cliInput()
		newMessage = if (input.isMorseMessage(message)) {
			"Decoded message -> " + decoder.decode(message)
		} else {
			"Encoded message -> " + encoder.encode(message)
		}
	}
	println(newMessage)
}