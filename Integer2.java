class Integer2 extends Expr {
	int i;

	Integer2(int x) {
		i = x;
	}

	public String toString() {
		return Integer.toString(i);
	}

	public boolean isGround() {
		return true;
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
