package cs2s03;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ClassTester {
	Expr test;
	String testS;
	Evaluate eval;
	IntVal ival;
	DblVal dval;

	// Test to see if the different classes (add,mult,sub,div) work properly
	// and some combinations
	@Test
	public void exprTest() throws NotAnInteger {
		// Test the basic versions of these
		// Basic plus
		test = new Plus(new Integer2(2), new Integer2(4));
		assertEquals(test.evalToInt(), 6);
		assertEquals(test.evalToFloat(), 6, 0.001);
		// Basic Minus
		test = new Minus(new Integer2(2), new Integer2(4));
		assertEquals(test.evalToInt(), -2);
		assertEquals(test.evalToFloat(), -2, 0.001);
		// Basic times
		test = new Times(new Integer2(2), new Integer2(4));
		assertEquals(test.evalToInt(), 8);
		assertEquals(test.evalToFloat(), 8, 0.001);
		// Basic divide
		test = new Divide(new Integer2(8), new Integer2(4));
		assertEquals(test.evalToInt(), 2);
		assertEquals(test.evalToFloat(), 2, 0.001);
		// Unary Minus
		test = new UnaryMinus(new Integer2(4));
		assertEquals(test.evalToInt(), -4);
		assertEquals(test.evalToFloat(), -4, 0.001);

		// Embedded testing- this tests all cases of having a certain operator
		// embedded
		// AND having the operator as the root

		// Embedded plus
		test = new Times(new Plus(new Integer2(1), new Integer2(4)),
				new Integer2(4));
		assertEquals(test.evalToInt(), 20);
		assertEquals(test.evalToFloat(), 20, 0.001);
		// Embedded minus
		test = new Divide(new Minus(new Integer2(8), new Integer2(4)),
				new Integer2(4));
		assertEquals(test.evalToInt(), 1);
		assertEquals(test.evalToFloat(), 1, 0.001);
		// Embedded times
		test = new Plus(new Times(new Integer2(1), new Integer2(4)),
				new Integer2(4));
		assertEquals(test.evalToInt(), 8);
		assertEquals(test.evalToFloat(), 8, 0.001);
		// Embedded divide
		test = new Minus(new Divide(new Integer2(8), new Integer2(4)),
				new Integer2(4));
		assertEquals(test.evalToInt(), -2);
		assertEquals(test.evalToFloat(), -2, 0.001);

		// Deep Tests
		// plus
		test = new Plus(new Times(new Integer2(1), new Divide(new Plus(
				new Integer2(2), new Plus(new Integer2(2), new Integer2(4))),
				new Integer2(4))), new Divide(new Integer2(8), new Integer2(4)));
		assertEquals(test.evalToInt(), 4);
		assertEquals(test.evalToFloat(), 4, 0.001);
		// minus
		test = new Minus(new Times(new Integer2(6), new Integer2(4)),
				new Minus(new Integer2(8), new Divide(new Divide(new Integer2(
						16), new Integer2(4)), new Integer2(4))));
		assertEquals(test.evalToInt(), 17);
		assertEquals(test.evalToFloat(), 17, 0.001);
		// Times
		test = new Times(new Plus(new Times(new Integer2(1), new Plus(
				new Times(new Integer2(1), new Integer2(4)), new Integer2(7))),
				new Integer2(3)), new Integer2(4));
		assertEquals(test.evalToInt(), 56);
		assertEquals(test.evalToFloat(), 56, 0.001);
		// Divide
		test = new Divide(new Minus(new Integer2(8), new Minus(new Integer2(8),
				new Integer2(4))), new Minus(new Integer2(8), new Integer2(4)));
		assertEquals(test.evalToInt(), 1);
		assertEquals(test.evalToFloat(), 1, 0.001);

	}

	@Test
	public void evalTest() throws ParseError, NotAnInteger {
		// Times test
		testS = "8*8";
		eval = new Evaluate(testS, Mode.INTEGER);
		ival = (IntVal) eval.eval();
		assertEquals(ival.val, 64);

		eval = new Evaluate(testS, Mode.FLOAT);
		dval = (DblVal) eval.eval();
		assertEquals(dval.val, 64, 0.001);

		// divide test
		testS = "8/8";
		eval = new Evaluate(testS, Mode.INTEGER);
		ival = (IntVal) eval.eval();
		assertEquals(ival.val, 1);

		testS = "8/3";
		eval = new Evaluate(testS, Mode.FLOAT);
		dval = (DblVal) eval.eval();
		assertEquals(dval.val, 2.666, 0.001);
		// assertEquals(,1);

		// subtract test
		testS = "8-8";
		eval = new Evaluate(testS, Mode.INTEGER);
		ival = (IntVal) eval.eval();
		assertEquals(ival.val, 0);

		eval = new Evaluate(testS, Mode.FLOAT);
		dval = (DblVal) eval.eval();
		assertEquals(dval.val, 0, 0.01);

		// Plus Test
		testS = "8+8";
		eval = new Evaluate(testS, Mode.INTEGER);
		ival = (IntVal) eval.eval();
		assertEquals(ival.val, 16);

		eval = new Evaluate(testS, Mode.FLOAT);
		dval = (DblVal) eval.eval();
		assertEquals(dval.val, 16, 0.001);

		// Long Test 1
		testS = "8+8";
		eval = new Evaluate(testS, Mode.INTEGER);
		ival = (IntVal) eval.eval();
		assertEquals(ival.val, 16);

		eval = new Evaluate(testS, Mode.FLOAT);
		dval = (DblVal) eval.eval();
		assertEquals(dval.val, 16, 0.001);

		// LONG Test 2
		testS = "8+8*2+(3/1)-12+2+3+2-1*2*3";
		eval = new Evaluate(testS, Mode.INTEGER);
		ival = (IntVal) eval.eval();
		assertEquals(ival.val, 174);
		
		testS = "8+8*2+(3/1)-12+2+3+2-1*2*3/5";
		eval = new Evaluate(testS, Mode.FLOAT);
		dval = (DblVal) eval.eval();
		assertEquals(dval.val, 34.8, 0.001);
	}

	// initial parse tests

	// Test with non digit
	@Test(expected = ParseError.class)
	public void parseErrorTest1() throws ParseError, NotAnInteger {
		Parser p = new Parser("8*a9");
		p.parse();
	}

	// Test with non digit 2
	@Test(expected = ParseError.class)
	public void parseErrorTest2() throws ParseError, NotAnInteger {
		Parser p = new Parser("(8.8))");
		p.parse();
	}
	//Not an integer test
	@Test(expected = NotAnInteger.class)
	public void notanintTest1()throws NotAnInteger{
		Expr e = new Divide(new Integer2 (3) , new Integer2(4));
		e.evalToInt();
	}
	//Not an integer test long
	@Test(expected = NotAnInteger.class)
	public void notanintTest2()throws NotAnInteger{
		Expr e = new Divide( new Minus(new Divide (new Integer2 (2), new Integer2(3)), new Times(new Integer2 (3),new Integer2(3))), new Plus (new Integer2 (3), new Integer2 (9)));
		e.evalToInt();
	}
}
