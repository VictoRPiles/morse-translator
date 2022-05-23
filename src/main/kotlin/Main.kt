fun main(args: Array<String>) {
	val input = Input(args)
	val encoder = MorseEncoder()
	val decoder = MorseDecoder()

	val message: String
	val newMessage: String?

	println("====================== MORSE TRANSLATOR ======================")
	println("==== -- --- .-. ... . / - .-. .- -. ... .-.. .- - --- .-. ====")

	if (args.isNotEmpty()) {
		message = input.getMessageFromArgs()
		newMessage = when (input.checkFlags()) {
			"encode" -> "Encoded message -> " + encoder.encode(message)
			"decode" -> "Decoded message -> " + decoder.decode(message)
			else -> "Unknown option flag"
		}
	} else {
		message = input.cliInput()
		newMessage = when (input.menu()) {
			"encode" -> "Encoded message -> " + encoder.encode(message)
			"decode" -> "Decoded message -> " + decoder.decode(message)
			else -> "Unknown option"
		}
	}
	println(newMessage)
}