package sortingcars;

import java.util.Random;
import java.util.Objects;
import java.util.HashSet;


public class UniqueVinGen {

	public static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String digits = "0123456789";
	public static final String alphanum = digits;// + upper;

	private final Random random;
	private final char[] symbols;
	private final char[] buf;

	private final HashSet<String> unique;

	/**
	 * Generate a random 12-digit alphanumeric VIN.
	 * Check if the VIN exists in the unique HashSet. Use a while
	 * loop to check if it exists in the HashSet. If it does,
	 * invoke getString() again to generate a new VIN.
	 * @return String: VIN
	 */
	public String nextString() {
		String localVin = getString();
		if (unique.contains(localVin)) {
			System.out.println("Duplicate found");
			localVin = getString();
		}
		unique.add(localVin);
		return localVin;
	}

	public String getString() {
		for (int i = 0; i < buf.length; i += 1){
			buf[i] = symbols[random.nextInt(symbols.length)];
		}
		return new String(buf);
	}

	/**
	 * Constructor for the Unique VIN Generator. Pass in the desired
	 * length of the string, a Random generator, and a String of symbols
	 * from which to build the randomly generated VIN.
	 * @param length
	 * @param random
	 * @param symbols
	 */
	public UniqueVinGen(int length, Random random, String symbols) {
		if (length < 1) throw new IllegalArgumentException();
		if (symbols.length() < 2) throw new IllegalArgumentException();
		this.random = Objects.requireNonNull(random);
		this.symbols = symbols.toCharArray();
		this.buf = new char[length];
		this.unique = new HashSet<String>();
	}

	/**
	 * Create an alphanumeric string generator.
	 */
	public UniqueVinGen(int length, Random random) {
		this(length, random, alphanum);
	}
}
