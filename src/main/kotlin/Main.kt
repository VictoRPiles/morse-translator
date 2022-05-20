/** @return All args concatenated in one String */
fun getMessageFromArgs(args: Array<String>): String {
	var message = ""
	for (word in args) {
		message += "$word "
	}
	return message
}

/** @return Not null String with the message. */
fun input(): String {
	print("Type your message -> ")
	return readLine() ?: return input()
}

fun checkFlags(args: Array<String>) {
	if (args[0].startsWith("-")) {
		// TODO: 20/05/2022  numero del arg? recursivo ???
	}
}

fun main(args: Array<String>) {
	val message: String = if (args.isNotEmpty()) {
		checkFlags(args)
		getMessageFromArgs(args)
	} else input()
	println(message)
	// TODO: 20/05/2022 Añadir flag al comando, para saber si args es morse o alfabeto -e (--encode), -d (--decode)
	// TODO: 20/05/2022 Menu encode o decode
}