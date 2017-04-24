import java.util.Stack;

public class StackCalc{

    private static boolean isOp(String op){
	switch (op) {
	case "+": return true;
	case "-": return true;
	case "*": return true;
	case "/": return true;
	case "%": return true;
	default: return false;
	}
    }
    
    private static String apply(String op, String b, String a){
	double inputA = Double.parseDouble(a);
	double inputB = Double.parseDouble(b);
	String answer="";
	switch (op){
	case "+": answer += inputA+inputB;
	    break;
	case "-": answer += inputA-inputB;
	    break;
	case "*": answer += inputA*inputB;
	    break;
	case "/": answer += inputA/inputB;
	    break;
	case "%": answer += inputA%inputB;
	    break;
	default: System.out.println( "INVALID. CURRENTLY THERE ARE ONLY:\n * + - / %");
	}
	return answer;
    }
    
    public static double eval(String s){
	String [] tokens= s.split (" ");
	Stack<String> values = new Stack<String>();
	for (String a :tokens){
	    if (isOp(a)){
		values.push (apply (a, ""+values.pop(),""+values.pop()));
	    }else {
		values.push(a);
	    }
	}
	return Double.parseDouble (""+values.pop ());
    }
}
