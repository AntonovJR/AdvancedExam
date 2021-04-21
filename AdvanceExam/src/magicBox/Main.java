package magicBox;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> firstBox = new ArrayDeque<>();//first queue
        ArrayDeque<Integer> secondBox = new ArrayDeque<>();//last stack

        String[] lootAsText = scanner.nextLine().split(" ");
        for (String s : lootAsText) {
            firstBox.offer(Integer.parseInt(s));
// first queue
        }
        lootAsText = scanner.nextLine().split(" ");
        for (String s : lootAsText) {
            secondBox.push(Integer.parseInt(s));
//last stack
        }
        int value = 0;
        while(!firstBox.isEmpty()&&!secondBox.isEmpty()){
            int sum = firstBox.peek()+secondBox.peek();
            if(sum%2==0){
                value+=sum;
                firstBox.pop();
                secondBox.pop();
            }else{
                firstBox.offer(secondBox.pop());
            }
        }
        if(firstBox.isEmpty()){
            System.out.println("First magic box is empty.");
        }else{
            System.out.println("Second magic box is empty.");
        }
        if(value>=90){
            System.out.printf("Wow, your prey was epic! Value: %d",value);
        }else{
            System.out.printf("Poor prey... Value: %d",value);
        }
    }
}
