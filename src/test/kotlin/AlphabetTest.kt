import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

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

	@Test
	fun normalize() {
		assertEquals("aeiou", Alphabet.normalize("áéíóú"))
		assertEquals("aeiou", Alphabet.normalize("àèìòù"))
		assertEquals("aeiou", Alphabet.normalize("äëïöü"))
		assertEquals("a e i o u", Alphabet.normalize("a  e  i  o  u"))
		assertEquals("n", Alphabet.normalize("ñ"))
	}
}