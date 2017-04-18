public class IteratorDriver{
  public static void main(String[] args) {
    MyLinkedList data = new MyLinkedList();
    int i = 0;
    while(i < 20){
      data.add(i);
      i++;
    }

    System.out.println(data);
    System.out.println("Standard loop:");

    for(int n = 0; n < data.size(); n++){
      System.out.print(data.get(n)+" ");
    }
    System.out.println();
    System.out.println("for-each loop:");
    for(Integer s : data){
      System.out.print(s+" ");
    }
  }
}
