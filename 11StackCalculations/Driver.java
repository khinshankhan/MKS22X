public class Driver {
    public static void main(String[] args)

    {

	System.out.println(StackCalc.eval("10 2 +"));//12.0

	System.out.println(StackCalc.eval("10 2 -"));//8.0

	System.out.println(StackCalc.eval("10 2.0 +"));//12.0

	System.out.println(StackCalc.eval("11 3 - 4 + 2.5 *"));//30.0

	System.out.println(StackCalc.eval("8 2 + 99 9 - * 2 + 9 -"));//839.0

	System.out.println(StackCalc.eval("10 2 + 10 * 1 + 1 1 1 + + + 10 10 + -"));//104.0

    }

}

