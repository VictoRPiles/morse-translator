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
	 * @throws IllegalArgumentException If is not in the [morse alphabet][Alphabet.morseAlphabet] and only contains morse characters.
	 * @throws IllegalArgumentException If letter is in the natural alphabet [natural alphabet][Alphabet.naturalAlphabet].
	 */
	private fun replaceWithNaturalLetter(letter: String): String {
		val alphabet = Alphabet()

		/* If is not in the morse alphabet and only contains morse characters */
		if (!alphabet.morseAlphabet.contains(letter) && letter.matches("[.-]+".toRegex())) {
			throw IllegalArgumentException("ERROR: Invalid morse letter: $letter")
		}
		/* If is in the natural alphabet */
		if (alphabet.naturalAlphabet.contains(letter)) {
			throw IllegalArgumentException("ERROR: Not a morse letter: $letter")
		}

		/* For special characters */
		if (alphabet.isUnknownLetter(letter)) return letter

		return alphabet.naturalAlphabet[alphabet.morseAlphabet.indexOf(letter)]
	}
}