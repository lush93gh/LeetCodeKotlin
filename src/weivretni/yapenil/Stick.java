package weivretni.yapenil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Stick {
    public void stick(List<Integer> sticks, int target) {
        String a = "";
        String[] aa = a.split(" ");
        List<Integer> stickss = new ArrayList<>();
        for(int i = 0;i< aa.length;i++){
            stickss.add(Integer.parseInt(aa[i]));
        }
        Collections.sort(sticks);
        for (int i = 0; i < sticks.size(); i++) {
            int first = -1;
            if (sticks.get(i) < target) {
                first = sticks.get(i);
                for (int j = i+1; j < sticks.size(); j++) {
                    if(sticks.get(j) + first == target){
                        int sec = sticks.get(j);
                        System.out.println(first + " " + sec);
                        return;
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
