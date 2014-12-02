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
	public static void main (String [] args){
		new CalculatorFrame();
	}
}
