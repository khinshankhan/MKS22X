public class Test02{
 public static void main(String[]args){
  QueenBoard b;
  int[]tests =   {2,4, 5,6, 7, 8,  9,10,11};
  int[]answers = {0,2,10,4,40,92,352,724,2680};
  int score = 0;
  for(int i = 0; i < tests.length; i++){
    int size = tests[i];
    int ans  = answers[i];
    b = new QueenBoard(size);
    b.countSolutions();
    if(b.getSolutionCount()==ans){
      score++;
    }else{
      System.out.println("Failed board size: "+size );
    }
  }
  b = new QueenBoard(5);
  if(b.getSolutionCount() == -1){
    score++;
  }else{
    System.out.println("Failed when solution not yet run");
    System.out.println(b.getSolutionCount());
  }
  System.out.println("Score: "+score+" / "+(tests.length+1));
 }
}
