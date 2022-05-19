class MorseEncoder {
	/**
	 * Splits the message in words (space character).
	 * For each letter calls [replaceWithMorseLetter] and appends the result to the new message plus space.
	 *
	 * @see [replaceWithMorseLetter].
	 * @param message Message in natural alphabet.
	 * @return Message in [morse code][Alphabet.morseAlphabet].
	 */
	fun encode(message: String): String {
		var newMessage = "";
		/* lookahead Regex, allows to keep the delimiter */
		val delimiter = Regex("(?<=\\s)|(?=\\s)")

		val words = message.split(delimiter)
		for (word in words) {
			for (letter in word) {
				newMessage += replaceWithMorseLetter(letter.lowercaseChar().toString()) + " "
			}
		}

		return newMessage
	}

	/**
	 * @param letter Natural letter
	 * @return Equivalent [morse code][Alphabet.morseAlphabet] letter.
	 * @throws IllegalArgumentException If letter is not in the [alphabet][Alphabet.naturalAlphabet].
	 */
	private fun replaceWithMorseLetter(letter: String): String {
		val alphabet = Alphabet()

		if (!alphabet.naturalAlphabet.contains(letter)) {
			throw IllegalArgumentException("ERROR: Incorrect alphabet letter: $letter")
		}

		return alphabet.morseAlphabet[alphabet.naturalAlphabet.indexOf(letter)]
	}
}