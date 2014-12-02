package cs2s03;

public class Evaluate {
	private Expr e;
	private Mode m;
	Evaluate (String s, Mode m) throws ParseError{
		this.m = m;
		Parser p = new Parser(s);
		this.e = p.parse();
	}
	public Value eval() throws NotAnInteger{
		if(m == Mode.INTEGER)
			return new IntVal (e.evalToInt());
		return new DblVal(e.evalToFloat());
	}
	
}
