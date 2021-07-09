package sortingcars;

import java.util.Random;
import java.util.Objects;

public class UniqueVinGen {
	/**
	 * Generate a random string.
	 */
	public String nextString() {
		for (int idx = 0; idx < buf.length; ++idx)
			buf[idx] = symbols[random.nextInt(symbols.length)];
		return new String(buf);
	}

	public static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static final String digits = "0123456789";

	public static final String alphanum = upper + digits;

	private final Random random;

	private final char[] symbols;

	private final char[] buf;

	public UniqueVinGen(int length, Random random, String symbols) {
		if (length < 1) throw new IllegalArgumentException();
		if (symbols.length() < 2) throw new IllegalArgumentException();
		this.random = Objects.requireNonNull(random);
		this.symbols = symbols.toCharArray();
		this.buf = new char[length];
	}

	/**
	 * Create an alphanumeric string generator.
	 */
	public UniqueVinGen(int length, Random random) {
		this(length, random, alphanum);
	}
}
