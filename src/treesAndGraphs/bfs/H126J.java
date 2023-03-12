package treesAndGraphs.bfs;

import java.util.*;

//  Word Ladder II
public class H126J {
    Set<String> words = new HashSet<>();
    Map<String,Integer> visited = new HashMap<>();
    String beginWord;
    String endWord;
    List<List<String>> res;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        this.beginWord = beginWord;
        this.endWord = endWord;
        this.res = new ArrayList<>();
        for(String word: wordList){
            words.add(word);
        }
        // Bfs
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        visited.put(beginWord,1);
        while(queue.size() > 0){
            String curr = queue.remove();
            if(curr.equals(endWord)) break;
            char[] charArr = curr.toCharArray();
            for(int i = 0; i < charArr.length; i++){
                char c = charArr[i];
                for(char ch = 'a'; ch <= 'z'; ch++){
                    charArr[i] = (char)ch;
                    String str = new String(charArr);
                    if(words.contains(str) && !visited.containsKey(str)){
                        visited.put(str,visited.get(curr) + 1);
                        queue.add(str);
                    }
                }
                charArr[i] = c;
            }
        }
        List<String> path = new ArrayList<>();
        if(!words.contains(endWord)) return res;
        path.add(endWord);
        dfs(endWord,path); // in treesandgraphs.dfs create all transformations from endWord to beginWord
        return res;

    }
    public void dfs(String word,List<String> path){
        if(word.equals(beginWord)){
            List<String> list = new ArrayList<>(path);
            Collections.reverse(list);
            res.add(list);
            return;
        }
        char[] charArr = word.toCharArray();
        for(int i = 0; i < charArr.length; i++){
            char c = charArr[i];
            for(char ch = 'a'; ch <= 'z'; ch++){
                charArr[i] = ch;
                String str = new String(charArr);
                if(visited.get(str) != null && visited.get(str) + 1 == visited.get(word)){
                    path.add(str);
                    dfs(str,path);
                    path.remove(path.size() - 1);
                }
            }
            charArr[i] = c;
        }
    }
}
