package com.github.immueggpain.math;

public class Launcher {

	public static void main(String[] args) {
		try {
			new Launcher().run();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	private void run() {
		int n = 1000000000;
		double p = 0;
		int i = 3;
		for (; i < n; i++) {
			p += Math.log(i) / Math.log(2);
		}
		System.out.println(i + ": " + p);
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
