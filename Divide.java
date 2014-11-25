class Divide extends Expr { // NOT BinaryOp!
	Expr left;
	Expr right;

	Divide(Expr x, Expr y) {
		left = x;
		right = y;
	}

	public String toString() {
		return betweenParens(left) + " / " + betweenParens(right);
	}

	public boolean isGround() {
		return false;
	}

	@Override
	public int evalToInt() throws NotAnInteger {
		int a = left.evalToInt() / right.evalToInt();
		double b = left.evalToFloat() / right.evalToFloat();
		if(!(b == (int)b))
			throw new NotAnInteger(left + " divided by " + right + " is not an integer");
		return a;
	}

	@Override
	public double evalToFloat() {
		return left.evalToFloat() / right.evalToFloat();
	}
}
