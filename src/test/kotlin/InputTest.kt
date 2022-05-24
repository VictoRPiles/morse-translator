import org.junit.jupiter.api.Test
import kotlin.test.*

internal class InputTest {

	@Test
	fun getMessageFromArgs() {
		var args: Array<String>
		var input: Input

		/* Encode flag */
		args = arrayOf("-e", "hola", "morse   ")
		input = Input(args)
		assertEquals("hola morse", input.getMessageFromArgs())

		/* Decode flag */
		args = arrayOf("-d", ".- .", ".- --   ")
		input = Input(args)
		assertEquals(".- . .- --", input.getMessageFromArgs())

		/* Wrong flag */
		args = arrayOf("-z", "abc", "def")
		input = Input(args)
		assertEquals("-z abc def", input.getMessageFromArgs())
	}

	@Test
	fun checkFlags() {
		var args: Array<String>
		var input: Input

		/* Encode flag */
		args = arrayOf("-e", "hola", "morse")
		input = Input(args)
		assertEquals("encode", input.checkFlags())

		/* Decode flag */
		args = arrayOf("-d", ".- .", ".- --   ")
		input = Input(args)
		assertEquals("decode", input.checkFlags())

		/* Wrong flag */
		args = arrayOf("-z", "abc", "def")
		input = Input(args)
		assertNull(input.checkFlags())
	}

	@Test
	fun isMorseMessage() {
		val input = Input(arrayOf("args"))
		assertTrue(input.isMorseMessage(".- .. .- ---"))
		assertTrue(input.isMorseMessage(".- @ .. .- ---"))
		assertTrue(input.isMorseMessage(".- @ .. .- ------"))
		assertFalse(input.isMorseMessage(".- a .. .- ---"))
		assertFalse(input.isMorseMessage(".- 1 .. .- ---"))
		/* Empty message */
		try {
			input.isMorseMessage(" ")
			fail()
		} catch (_: IllegalArgumentException) {
		}
	}
}