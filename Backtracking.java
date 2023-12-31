package Ibm;

public class Backtracking {
    public static void main(String[] args){
        boolean[][] maze={
                {true,true,true},
                {true,true,true},
                {true,true,true}

        };
         allPaths("",maze,0,0);
    }
    public static void allPaths(String ans,boolean[][] maze,int r,int c){
        if(r== maze.length-1 && c == maze[0].length-1){
            System.out.println(ans);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        maze[r][c]=false;
        if(r<maze.length-1){
            allPaths(ans+"D",maze,r+1,c);
        }
        if(c<maze[0].length-1){
            allPaths(ans+"R",maze,r,c+1);
        }
        if(r>0){
            allPaths(ans+"U",maze,r-1,c);
        }
        if(c>0){
            allPaths(ans+"L",maze,r,c-1);
        }

// this line is the recursive call will over here  and functon will be removed here and it will return up where it was called;
        maze[r][c]=true;

    }
}
