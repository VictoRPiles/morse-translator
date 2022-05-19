class MorseDecoder {
	/**
	 * Splits the morse code in words ('/' character).
	 * Splits the morse words in letters (space character).
	 * For each letter calls [replaceWithNaturalLetter] and appends the result to the new message.
	 *
	 * @see [replaceWithNaturalLetter].
	 * @param message Message in morse code.
	 * @return Message in [natural alphabet][Alphabet.naturalAlphabet].
	 */
	fun decode(message: String): String {
		var newMessage = ""
		/* lookahead Regex, allows to keep the delimiter */
		val delimiter = Regex("(?<=/)|(?=/)")

		val words = message.split(delimiter)
		for (word in words) {
			val letters = word.split(" ")

			for (letter in letters) {
				if (letter.isNotBlank()) {
					newMessage += replaceWithNaturalLetter(letter)
				}
			}
		}

		return newMessage
	}

	/**
	 * @param letter Morse letter.
	 * @return Equivalent [natural alphabet][Alphabet.naturalAlphabet] letter.
	 * @throws IllegalArgumentException If morse letter is not in the [morse alphabet][Alphabet.morseAlphabet].
	 */
	private fun replaceWithNaturalLetter(letter: String): String {
		val alphabet = Alphabet()

		if (!alphabet.morseAlphabet.contains(letter)) {
			throw IllegalArgumentException("ERROR: Incorrect morse letter: $letter")
		}

		return alphabet.naturalAlphabet[alphabet.morseAlphabet.indexOf(letter)]
	}
}