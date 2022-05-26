import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MorseEncoderTest {

	@Test
	fun encode() {
		val morseEncoder = MorseEncoder()
		assertEquals(". .-", morseEncoder.encode("ea"))
		assertEquals(". .-", morseEncoder.encode("ea"))
		assertEquals(". / .-", morseEncoder.encode("e a"))
		assertEquals(". / .-", morseEncoder.encode("e a"))
		assertEquals(". / .-", morseEncoder.encode("e a"))
		assertEquals(". / .- <.>", morseEncoder.encode("e a."))
		assertEquals(". / .- <->", morseEncoder.encode("e a-"))
		assertEquals(". / .- <.><->", morseEncoder.encode("e a.-"))
	}
}