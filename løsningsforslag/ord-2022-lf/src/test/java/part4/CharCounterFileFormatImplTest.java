package part4;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import part3.AbstractCharCounterTest;
import part3.CharCounter;
import part3.CharCounterImpl;

class CharCounterFileFormatImplTest {

	private CharCounterImpl letterCounter;
	private CharCounterImpl whitespaceCounter;

	private CharCounterFileFormat charCounterFileFormat;

	@BeforeEach
	void setUp() throws Exception {
		letterCounter = new CharCounterImpl(Character::isLetter);
		whitespaceCounter = new CharCounterImpl(Character::isWhitespace);

		charCounterFileFormat = new CharCounterFileFormatImpl();
	}

	private final String textSample = """
			Java er gøy,
			ikke sant!
			""";

	void testSaveLoad(final CharCounter cc) throws IOException {
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
		charCounterFileFormat.save(cc, out);
		final byte[] bytes = out.toByteArray();
		final InputStream in = new ByteArrayInputStream(bytes);
		final CharCounter cc2 = charCounterFileFormat.load(in);
		AbstractCharCounterTest.checkCharCounter(cc, cc2);
	}

	@Test
	void testCharCounterFileFormatImpl_saveLoad_letters() throws IOException {
		letterCounter.countChars(textSample);
		testSaveLoad(letterCounter);
	}

	@Test
	void testCharCounterFileFormatImpl_saveLoad_whitespace() throws IOException {
		whitespaceCounter.countChars(textSample);
		testSaveLoad(whitespaceCounter);
	}
}
