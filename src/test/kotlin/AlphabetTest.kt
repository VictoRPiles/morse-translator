import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class AlphabetTest {

	@Test
	fun isUnknownLetter() {
		assertTrue(Alphabet.isUnknownLetter("@"))
		assertFalse(Alphabet.isUnknownLetter("-----"))
		assertTrue(Alphabet.isUnknownLetter("------"))
		assertFalse(Alphabet.isUnknownLetter("a"))
		assertTrue(Alphabet.isUnknownLetter("ab"))
		assertTrue(Alphabet.isUnknownLetter("A"))
		assertTrue(Alphabet.isUnknownLetter(".- .-"))
	}
}