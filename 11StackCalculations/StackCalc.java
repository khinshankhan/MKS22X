public class StackCalc{

    private static String apply(String op, String a, String b){

	double inputA = Double.parseDouble(a);

	double inputB = Double.parseDouble(b);

	String answer="";

	switch (op) {

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




    public static double eval (String s){
	String [] tokens= s.split (" ");
	Stack values = new Stack();
	for (token :token){
	    if (isOp (token)){
		values.push (apply (token, values.pop (),values.pop));
	    }else {
		values.push (token);
	    }
	}
	return Double.parseDouble (values.pop ());
    }
}
