import java.util.Queue;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

class Parentheses {
    String str;
    int openCount;
    int closeCount;

    Parentheses(String str, int openCount, int closeCount){
        this.str = str;
        this.openCount = openCount;
        this.closeCount = closeCount;
    }
}

class GenerateParentheses {

    public static List<String> generateValidParentheses(int num){
        List<String> result = new ArrayList<>();
        Queue<Parentheses> queue = new LinkedList<>();
        queue.offer(new Parentheses("", 0, 0));

        while(!queue.isEmpty()){
            Parentheses p = queue.poll();
            if(p.openCount == num && p.closeCount == num)
                result.add(p.str);
            else {
                if(p.openCount < num)
                    queue.offer(new Parentheses(p.str + "(", p.openCount + 1, p.closeCount));
                
                if(p.openCount > p.closeCount)
                    queue.offer(new Parentheses(p.str + ")", p.openCount, p.closeCount + 1));
            }
        }

        return result;
    }

    public static void main(String[] args){
        int num = 3;
        System.out.println("Generate " + num + ": " + generateValidParentheses(num));
        
        num = 4;
        System.out.println("Generate " + num + ": " + generateValidParentheses(num));
        
        num = 5;
        System.out.println("Generate " + num + ": " + generateValidParentheses(num));

        // num = 7;
        // System.out.println("Generate 7: " + generateValidParentheses(7));
    }
}