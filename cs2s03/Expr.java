package cs2s03;
abstract class Expr {
	abstract public String toString();

	abstract public boolean isGround();

	abstract public int evalToInt() throws NotAnInteger;

	abstract public double evalToFloat();

	static void print(Expr e) {
		System.out.println(e.toString());
	}

	static String betweenParens(final Expr e) {
		return (e.isGround()) ? e.toString() : "( " + e.toString() + " )";
	}

	public static void main(String[] args) throws NotAnInteger {
		String s1 = "8+3";
		Parser p = new Parser(s1);
		try {
			Expr e5 = p.parse();
			print(e5);
			System.out.println(e5.evalToInt());
		} catch (ParseError e) {
			System.out.println(e);
		}
	}
}
