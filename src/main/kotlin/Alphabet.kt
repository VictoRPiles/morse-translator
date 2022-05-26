import java.text.Normalizer

class Alphabet {
	val naturalAlphabet = arrayOf(
			"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
			"k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
			"u", "v", "w", "x", "y", "z",
			"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", " "
	)
	val morseAlphabet = arrayOf(
			".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
			"-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
			"..-", "...-", ".--", "-..-", "-.--", "--..",
			".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----", "/"
	)

	/**
	 * @param letter Letter to be searched.
	 * @return If any alphabet contains the letter.
	 */
	fun isUnknownLetter(letter: String): Boolean {
		return !(naturalAlphabet.contains(letter) || morseAlphabet.contains(letter))
	}

	/**
	 * @param message Input string.
	 * @return Message without multiple spaces, accentuated or diacritics.
	 */
	fun normalize(message: String): String {
		/* remove multiple spaces */
		val newMessage: String = message.replace("\\s+".toRegex(), " ")
		/* remove accentuated and diacritics */
		return Normalizer.normalize(newMessage, Normalizer.Form.NFD)
				.replace("\\p{Mn}+".toRegex(), "")
	}
}