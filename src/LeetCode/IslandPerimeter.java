package LeetCode;

public class IslandPerimeter {
    public static int islandPerimeter(int[][] grid) {
        int area = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                //TOP ROW
                if(i == 0){ //restricted from checking up
                    if(j == 0){
                        // restricted from checking left
                    }
                    else if(j == grid[i].length-1){
                        // restricted from checking right
                    }
                    else{
                        // check down, left, and right
                    }
                }
                //BOTTOM ROW
                else if (i == grid.length - 1){ // restricted from checking down
                    if(j == 0){
                        // restricted from checking left
                    }
                    else if(j == grid[i].length-1){
                        // restricted from checking right
                    }
                    else{
                        // check up, left and right
                    }
                }
                //LEFT COLUMN
                else if(j == 0){ // restricted from checking left

                }

                //RIGHT COLUMN
                else if (j == grid[i].length - 1){ // restricted from checking right

                }

                //ANY CELL OTHERWISE
                else{
                    //can perform left, right, up, down scan without index OOB exception!

                }
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


        System.out.println(IslandPerimeter.islandPerimeter2(island1));
        //System.out.println(IslandPerimeter.islandPerimeter(island2));
        //System.out.println(IslandPerimeter.islandPerimeter(island3));
    }
}
