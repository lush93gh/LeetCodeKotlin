package hackerrank;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueuesAndStacks {
    Queue<String> queue = new LinkedList<>();
    Stack<String> stack = new Stack<>();
    void pushCharacter(char ch) {
        stack.push(String.valueOf(ch));
    }

    char popCharacter() {
        return stack.pop().toCharArray()[0];
    }

    void enqueueCharacter(char ch) {
        queue.offer(String.valueOf(ch));
    }

    char dequeueCharacter() {
        return queue.poll().toCharArray()[0];
    }
}
