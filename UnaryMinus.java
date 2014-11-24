class UnaryMinus extends Expr {
	Expr e;

	UnaryMinus(Expr x) {
		e = x;
	}

	public String toString() {
		return "-" + e.toString();
	}

	public boolean isGround() {
		return false;
	}

	@Override
	public int evalToInt() {
		// TODO Auto-generated method stub
		return -1 * e.evalToInt();
	}

	@Override
	public double evalToFloat() {
		// TODO Auto-generated method stub
		return 0;
	}
}
