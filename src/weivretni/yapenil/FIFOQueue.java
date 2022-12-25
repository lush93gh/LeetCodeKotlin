package weivretni.yapenil;

import java.util.LinkedList;
import java.util.Queue;

public class FIFOQueue {
    int count = 0;
    int head = 0;

    int tail = 0;
    String[] queue = new String[10];

    public void FIFO(String commend, int capacity) {
        Queue<String> q = new LinkedList<>();

        if (commend.startsWith("OFFER")) {
            if (count >= capacity) System.out.println(false);
            else {
                queue[tail] = commend.split(" ")[1];
                tail = (tail + 1) % capacity;
                count++;
                System.out.println(true);
            }
        } else if (commend.startsWith("TAKE")) {
            if (count > 0) {
                System.out.println(queue[head]);
                head = (head + 1) % capacity;
                count--;
            }
        } else if (commend.startsWith("SIZE")) {
            System.out.println(count);
        }
    }
}
