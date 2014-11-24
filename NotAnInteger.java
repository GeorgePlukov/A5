@SuppressWarnings("serial")
public class NotAnInteger extends Exception {
	String type;
	public NotAnInteger(String string) {
		type = string;
	}
	public String toString(){
		return type;
	}
}
