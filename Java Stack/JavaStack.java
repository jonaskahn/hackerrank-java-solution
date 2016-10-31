import java.util.*;
class JavaStack{

    public static void main(String[] args) {
        try {


            Scanner scan = new Scanner(System.in);
            while (scan.hasNext()){
                String s =  scan.next();
                s = s.replaceAll("\\{","(").replaceAll("\\[","(").replaceAll("\\}",")").replaceAll("\\]",")");
                char[] chars = s.toCharArray();
                System.out.println(changeStack(chars) ? "true" :"false");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static boolean changeStack(char[] chars){
        if(chars.length %2 == 1) return false;
        Stack<Character> stack = new Stack<Character>();
        for (char c : chars) {
            if(c == '('){
                stack.push(c);
            }else {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();


    }
}
