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
	public int evalToInt() {
		// TODO Auto-generated method stub
		return left.evalToInt() / right.evalToInt();
	}

	@Override
	public double evalToFloat() {
		// TODO Auto-generated method stub
		return 0;
	}
}
