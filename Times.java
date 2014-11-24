class Times extends BinaryOp {
	Times(Expr x, Expr y) {
		left = x;
		right = y;
	}

	public String toString() {
		// we are the context
		return super.toString(this, " * ");
	}

	public boolean isSame(Expr e) {
		return e instanceof Times;
	}

	@Override
	public int evalToInt() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double evalToFloat() {
		// TODO Auto-generated method stub
		return 0;
	}
}
