class MorseEncoder {
	/**
	 * Splits the message in words (space character).
	 * For each letter calls [replaceWithMorseLetter] and appends the result to the new message.
	 *
	 * @see [replaceWithMorseLetter].
	 * @param message Message in natural alphabet.
	 * @return Message in [morse code][Alphabet.morseAlphabet].
	 */
	fun encode(message: String): String {
		var callDashDotLetterWarning = false
		var newMessage = ""
		/* lookahead Regex, allows to keep the delimiter */
		val delimiter = Regex("(?<=\\s)|(?=\\s)")

		val words = message.split(delimiter)
		for (word in words) {
			for (letter in word) {
				if (letter == '-' || letter == '.') {
					callDashDotLetterWarning = true
				}

				newMessage += replaceWithMorseLetter(letter.lowercaseChar().toString())
			}
		}

		if (callDashDotLetterWarning) {
			println("WARNING: The message you entered contained dots (.) or dashes (-), these have been highlighted with < >")
		}

		return newMessage.trim()
	}

	/**
	 * @param letter Natural letter
	 * @return Equivalent [morse code][Alphabet.morseAlphabet] letter.
	 */
	private fun replaceWithMorseLetter(letter: String): String {
		val alphabet = Alphabet()

		/* So there is no confusion with the characters of the morse code */
		if (letter == "-" || letter == ".") return "<$letter>"

		if (!alphabet.naturalAlphabet.contains(letter)) return "$letter "

		return alphabet.morseAlphabet[alphabet.naturalAlphabet.indexOf(letter)] + " "
	}
}