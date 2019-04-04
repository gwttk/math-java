package com.github.immueggpain.math;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Launcher {

	public static void main(String[] args) {
		try {
			new Launcher().run();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	private void run() {
		testPrime2();
	}

	public void testPrime() {
		BigInteger n = new BigInteger("20392715357007343829508914402516985321646609865399947718299896446"
				+ "1159035876863462304551609200531779719324839989601442035924412141"
				+ "2270487382081106335126766317182854904708537790348644560687571713765792016861739521"
				+ "004611128777692373346317933122772623569429343855209555475544662153403823722619926191356044887"
				+ "5067442908439339265115028678519992074710405397062876075938908746198767586190932363715"
				+ "79300509729956707816978820133116806572373239409774876253593749153120960003649794557517707"
				+ "669172045114843993645681616106263049964154107627778173807161108414544785255247679218"
				+ "6904497700460799441110183241206247543341229064434151");
		System.out.println(n.isProbablePrime(1));

	}

	public void testPrime2() {
		SecureRandom random = new SecureRandom();
		for (int i = 0;; i++) {
			System.out.println(i);
			BigInteger p = BigInteger.probablePrime(1024, random);
			BigInteger q = BigInteger.probablePrime(1014, random);
			BigInteger n = p.multiply(q);
			if (n.isProbablePrime(1)) {
				break;
			}
		}

	}

	public void findPrime2() {
		BigInteger p = BigInteger.probablePrime(1024, new SecureRandom());
		BigInteger q = BigInteger.probablePrime(1014, new SecureRandom());
		System.out.println(p);
		System.out.println(q);
		System.out.println(p.multiply(q));
	}

	public void findPrime() {
		BigInteger p = BigInteger.probablePrime(64, new SecureRandom());
		System.out.println(p);
		while (true) {
			if (isPrime(p)) {
				System.out.println("is prime");
				break;
			} else {
				System.err.println("not prime");
			}
			p = p.nextProbablePrime();
		}
	}

	private static final BigInteger two = new BigInteger("2");
	private static final BigInteger three = new BigInteger("3");

	public boolean isPrime(BigInteger number) {
		// check if even
		if (!two.equals(number) && BigInteger.ZERO.equals(number.mod(two)))
			return false;

		// find divisor if any from 3 to 'number'
		BigInteger sqrt = sqrt(number);
		for (BigInteger i = three; i.compareTo(sqrt) <= 0; i = i.nextProbablePrime()) {
			// start from 3, 5, etc. the odd number, and look for a divisor if any
			// System.out.println(i);
			if (BigInteger.ZERO.equals(number.mod(i))) // check if 'i' is divisor of 'number'
				return false;
		}
		return true;
	}

	public void fact2() {
		BigInteger n = new BigInteger("11213149235871234567234567890");
		System.out.println(n.bitLength());
		for (;; n = n.add(BigInteger.ONE)) {
			BigInteger p = factorize(n);

			// n is prime
			if (p.equals(BigInteger.valueOf(-1)))
				continue;

			BigInteger q = n.divide(p);

			// q is not prime
			if (!factorize(q).equals(BigInteger.valueOf(-1)))
				continue;

			System.out.println(p + "*" + q + "=" + p.multiply(q));
			break;
		}
	}

	public void fact1() {
		long n = 7140229938787687593L;
		long p = factorize(n);
		long q = n / p;
		System.out.println(p + "*" + q + "=" + p * q);
	}

	public BigInteger factorize(BigInteger n) {
		for (BigInteger i = BigInteger.valueOf(2); i.compareTo(sqrt(n)) <= 0; i = i.add(BigInteger.ONE)) {
			BigInteger r = n.divideAndRemainder(i)[1];
			if (r.equals(BigInteger.ZERO)) {
				return i;
			}
		}
		return BigInteger.valueOf(-1);
	}

	public static BigInteger sqrt(BigInteger x) {
		BigInteger div = BigInteger.ZERO.setBit(x.bitLength() / 2);
		BigInteger div2 = div;
		// Loop until we hit the same value twice in a row, or wind
		// up alternating.
		for (;;) {
			BigInteger y = div.add(x.divide(div)).shiftRight(1);
			if (y.equals(div) || y.equals(div2))
				return y;
			div2 = div;
			div = y;
		}
	}

	public long factorize(long n) {
		for (long i = 2; i < Math.sqrt(n); i++) {
			long r = n % i;
			if (r == 0) {
				return i;
			}
		}
		return -1;
	}

	public void _3x_1() {
		long x = 98134983439834L;
		while (true) {
			if ((x & 1) == 0) {
				// even
				x = x / 2;
			} else {
				// odd
				x = 3 * x + 1;
			}
			System.out.println(x);
			if (x == 1)
				break;
		}
	}

}
