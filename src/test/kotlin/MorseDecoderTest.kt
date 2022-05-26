import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.fail
import org.junit.jupiter.api.Test

internal class MorseDecoderTest {

	@Test
	fun decode() {
		val morseDecoder = MorseDecoder()
		assertEquals("ea", morseDecoder.decode(". .-"))
		assertEquals("ea", morseDecoder.decode(".   .-"))
		assertEquals("e a", morseDecoder.decode(". / .-"))
		assertEquals("e a", morseDecoder.decode("./.-"))
		assertEquals("e a", morseDecoder.decode(".//.-"))
		try {
			morseDecoder.decode("----------")
			fail()
		} catch (_: IllegalArgumentException) {
		}
		try {
			morseDecoder.decode(".- ......")
			fail()
		} catch (_: IllegalArgumentException) {
		}
		try {
			morseDecoder.decode(".- a")
			fail()
		} catch (_: IllegalArgumentException) {
		}
	}
}