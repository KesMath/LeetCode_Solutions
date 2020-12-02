package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IslandPerimeter {

    public static int islandPerimeter(int[][] grid) {
        int area = 0;
        HashMap<ArrayList<Integer>, Integer> landMap = new HashMap<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    landMap.put(new ArrayList<>(Arrays.asList(i, j)), -1);
                }
            }
        }
        for (Map.Entry<ArrayList<Integer>, Integer> entry : landMap.entrySet()){
            /**per entry, this checks if there exists a set of corresponding
             ArrayList containing L/R/U/D coordinates with map
             **/
            area+=4;
            if(landMap.containsKey(new ArrayList<>(Arrays.asList(entry.getKey().get(0),
                    entry.getKey().get(1)-1)))){ //check left
                area--;
            }
            if(landMap.containsKey(new ArrayList<>(Arrays.asList(entry.getKey().get(0),
                    entry.getKey().get(1)+1)))){ //check right
                area--;
            }

            if(landMap.containsKey(new ArrayList<>(Arrays.asList(entry.getKey().get(0)-1,
                    entry.getKey().get(1))))){ //check up
                area--;
            }

            if(landMap.containsKey(new ArrayList<>(Arrays.asList(entry.getKey().get(0)+1,
                    entry.getKey().get(1))))){ //check down
                area--;
            }
        }
        return area;
    }

    public static int islandPerimeter2(int[][] grid) {
        int area = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1){
                    area+=4;
                    try {
                        if(grid[i][j - 1] == 1) {// check left
                            area--;
                        }
                    }
                    catch(IndexOutOfBoundsException e){}

                    try{
                        if(grid[i][j+1] == 1){// check right
                            area--;
                        }
                    }
                    catch(IndexOutOfBoundsException e){}

                    try{
                        if(grid[i-1][j] == 1){// check up
                            area--;
                        }
                    }
                    catch(IndexOutOfBoundsException e){}

                    try{
                        if(grid[i+1][j] == 1){// check down
                            area--;
                        }
                    }
                    catch(IndexOutOfBoundsException e){}
                    }
                }
            }
        return area;
        }

    public static void main(String[] args) {
        int [][] island1 = {{0,1,0,0},
                            {1,1,1,0},
                            {0,1,0,0},
                            {1,1,0,0}};
        int [][] island2 = {{1}};
        int [][] island3 = {{1,0}};


        System.out.println(IslandPerimeter.islandPerimeter(island1));
        System.out.println(IslandPerimeter.islandPerimeter(island2));
        System.out.println(IslandPerimeter.islandPerimeter(island3));
        }
    }

