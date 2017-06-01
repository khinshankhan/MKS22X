public class Test11{

    public static void main(final String[] args) {
      int count=0;
      if(StackCalc.eval("0")==0.0){
        count++;
      }
      if(StackCalc.eval("-5")==-5.0){count++;}
      if(StackCalc.eval("20 3 +")==23.0){count++;}
      if(StackCalc.eval("108 212 + 525 -")==-205.0){count++;}
      if(StackCalc.eval("47 969 / 0 - 769 -")==-768.9514963880289){count++;}
      if(StackCalc.eval("15 443 * 336 * 939 / 600 -")==1777.7635782747602){count++;}
      if(StackCalc.eval("67 128 - 297 469 * + 354 + 66 - 345 - 732 -")
          == 138443.0){
            count++;
      }
      if(StackCalc.eval("670 150 511 / + 836 717 * 261 / + 60 - 851 +")==3757.8912432237894){
          count++;
      }
      System.out.println("SCORE out of 8 : " + count);
    }

}
