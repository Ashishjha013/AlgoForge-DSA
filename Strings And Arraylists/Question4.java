// Question No. 1
//

// hint: 

public class Question4 {
  public static String toggleCase(String str) {
    String ans = "";

    for(int i=0; i<str.length(); i++) {
      char ch = str.charAt(i);

      if(Character.isUpperCase(ch)) {
        ans = ans + Character.toLowerCase(ch);
      } else{
        ans = ans + Character.toLowerCase(ch);
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    String str = "AbcdEfgh";
    String result = toggleCase(str);
    System.out.println(result);
  }
}
