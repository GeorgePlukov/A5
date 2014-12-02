package cs2s03;

public enum Mode {
	INTEGER, FLOAT
}

abstract class Value{
	Mode m;
}

class IntVal extends Value{
	int val;
	IntVal (int val){
		m = Mode.INTEGER;
		this.val = val;
	}

}

class DblVal extends Value{
	double val;
	DblVal (double val){
		m = Mode.FLOAT;
		this.val = val;
	}
}