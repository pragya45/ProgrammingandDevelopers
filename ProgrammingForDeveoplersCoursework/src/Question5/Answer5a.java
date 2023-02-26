package Question5;//package Question5;
//
//
//import java.util.*;
//
//public class Answer5a {
//
////    public int[][] getKeyCoordinates(int[][] height) {
////        // Store the start and end points of each rectangle in a TreeMap
////        TreeMap<Integer, Integer> map = new TreeMap<>();
////        for (int[] rect : height) {
////            map.put(rect[0], Math.max(map.getOrDefault(rect[0], 0), rect[2]));
////            map.put(rect[1], 0);
////        }
////
////        // Keep track of the current height while iterating through the map
////        int currHeight = 0;
////        int[][] res = new int[map.size()][2];
////        int i = 0;
////        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
////            int x = entry.getKey();
////            int h = entry.getValue();
////            if (h != currHeight) {
////                res[i][0] = x;
////                res[i][1] = currHeight = h;
////                i++;
////            }
////        }
////
////        // Return the key coordinates
////        return Arrays.copyOfRange(res, 0, i);
////    }
//
//    public static void main(String[] args) {
//        Answer5a obj = new Answer5a() ;
//        int[][] height = {{1,4,10},{2,5,15},{5,8,12},{9,11,1},{11,13,15}};
//        int[][] res = obj.getKeyCoordinates(height);
//        System.out.println(Arrays.deepToString(res));
//    }
//}

import java.util.*;

public class Answer5a {
    public List<Integer> getBorder(int[][] height) {
        List<Integer> result = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = height.length;
        int maxHeight = 0;
        for (int i = 0; i < n; i++) {
            map.put(height[i][0], 0);
            map.put(height[i][1], 0);
            maxHeight = Math.max(maxHeight, height[i][2]);
        }
        int currentHeight = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            for (int i = 0; i < n; i++) {
                if (height[i][0] <= key && key <= height[i][1]) {
                    entry.setValue(Math.max(entry.getValue(), height[i][2]));
                }
            }
            if (entry.getValue() > currentHeight) {
                result.add(key);
                currentHeight = entry.getValue();
            } else if (entry.getValue() < currentHeight) {
                result.add(key);
                currentHeight = entry.getValue();
            }
        }
        return result;
    }
//    public static void main(String[] args) {
//        Answer5a obj = new Answer5a() ;
//        int[][] height = {{1,4,10},{2,5,15},{5,8,12},{9,11,1},{11,13,15}};
//        List<Integer> res = obj.getBorder(height);
//        System.out.println(Arrays.deepToString(Arrays.deepToString(res)
//        ));
//    }
public static void main(String[] args) {
    int[][] height = {{1,4,10},{2,5,15},{5,8,12},{9,11,1},{11,13,15}};
    Answer5a q = new Answer5a();
    List<Integer> border = q.getBorder(height);
    System.out.println(border);
}

}
