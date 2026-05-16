package part4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Collection;

import part3.CharCounter;
import part3.CharCounterImpl;

public class CharCounterFileFormatImpl implements CharCounterFileFormat {

	private String escapeChar(final char c) {
		// escape \ and newline
		if (c == '\\') {
			return "\\\\";
		} else if (c == '\n') {
			return "\\n";
		} else {
			return String.valueOf(c);
		}
	}

	private char unescapeChar(final String s, final int[] pos) throws RuntimeException {
		char c = s.charAt(pos[0]);
		if (c == '\\') {
			// char is escaped with slash so use next one
			if (pos[0] == s.length() - 1) {
				throw new IllegalArgumentException("Premature end-of-string");
			}
			c = s.charAt(pos[0] + 1);
			if (c == 'n') {
				c = '\n';
			} else if (c != '\\') {
				throw new IllegalArgumentException("Illegal escaped char: '" + c + "'");
			}
			pos[0]++;
		}
		return c;
	}

	@Override
	public void save(final CharCounter cc, final OutputStream out) {
		final PrintStream ps = new PrintStream(out);
		// first write a line of all countedChars
		final Collection<Character> countedChars = cc.getCountedChars();
		for (final char c : countedChars) {
			ps.print(escapeChar(c));
		}
		ps.println();
		// then write lines with char and corresponding count
		for (final char c : countedChars) {
			ps.print(escapeChar(c));
			ps.println(cc.getCharCount(c));
		}
		ps.flush();
	}

	@Override
	public CharCounterImpl load(final InputStream in) throws IOException {
		final BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		final String acceptedChars = loadAcceptedChars(reader);
		final CharCounterImpl cc = new CharCounterImpl(acceptedChars);
		try {
			loadCounters(cc, reader);
		} catch (final RuntimeException e) {
			throw new IOException("Illegal format", e);
		}
		return cc;
	}

	private String loadAcceptedChars(final BufferedReader reader) throws IOException {
		String acceptedChars = "";
		final String line = reader.readLine();
		if (line == null) {
			throw new IOException("Premature EOF");
		}
		final int[] pos = { 0 };
		while (pos[0] < line.length()) {
			final char c = unescapeChar(line, pos);
			pos[0]++;
			acceptedChars += c;
		}
		return acceptedChars;
	}

	private void loadCounters(final CharCounter cc, final BufferedReader reader) throws IOException, RuntimeException {
		String line = null;
		while ((line = reader.readLine()) != null) {
			if (line.length() == 0) {
				break;
			}
			// assume format is correct, expect caller to catch exceptions
			final int[] pos = { 0 };
			final char c = unescapeChar(line, pos);
			final int counter = Integer.valueOf(line.substring(pos[0] + 1));
			cc.countChar(c, counter);
		}
	}

	@Override
	public void loadInto(final CharCounter cc, final InputStream in) throws IOException {
		final BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		loadAcceptedChars(reader);
		try {
			loadCounters(cc, reader);
		} catch (final RuntimeException e) {
			throw new IOException("Illegal format", e);
		}
	}
}
