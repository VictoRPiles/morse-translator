import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class AlphabetTest {

	@Test
	fun isUnknownLetter() {
		val alphabet = Alphabet()

		assertTrue(alphabet.isUnknownLetter("@"))
		assertFalse(alphabet.isUnknownLetter("-----"))
		assertTrue(alphabet.isUnknownLetter("------"))
		assertFalse(alphabet.isUnknownLetter("a"))
		assertTrue(alphabet.isUnknownLetter("ab"))
		assertTrue(alphabet.isUnknownLetter("A"))
		assertTrue(alphabet.isUnknownLetter(".- .-"))
	}
}