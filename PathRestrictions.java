package Ibm;

import java.util.ArrayList;
import java.util.Arrays;

public class PathRestrictions {
    public static void main(String[] args){
        ArrayList<String> dr=downRight("",3,3);
        ArrayList<String> vdh=withDiagonals("",1,1);
        boolean[][] maze={
                {true,true,true},
                {true,false,true},
                {true,true,true}

        };
        withObstacle("",maze,0,0);

        //System.out.println(dr);
       // System.out.println(vdh);
    }
    public static ArrayList<String> downRight(String ans,int r,int c){
        ArrayList<String> list=new ArrayList<>();
        if( r==1 && c==1 ){
            ArrayList<String> res= new ArrayList<>();
            res.add(ans);
            return res;
        }

        if(r>1){
            list.addAll(downRight(ans+"V",r-1,c));
        }
        if(c>1){
            list.addAll(downRight(ans+"H",r,c-1));
        }

        return list;
    }

    public static  ArrayList<String> withDiagonals(String ans,int r,int c){
        ArrayList<String> list = new ArrayList<>();

        if (r == 3 && c == 3) {
            list.add(ans);
            return list;
        }

        if (r < 3 && c < 3) {
            list.addAll(withDiagonals(ans + "D", r + 1, c + 1));
        }

        if (r < 3) {
            list.addAll(withDiagonals(ans + "V", r + 1, c));
        }

        if (c < 3) {
            list.addAll(withDiagonals(ans + "H", r, c + 1));
        }

        return list;
    }
    public static void withObstacle(String ans,boolean maze[][],int r,int c){

        if(r== maze.length-1 && c== maze[0].length-1){
            System.out.println(ans);
            return;
        }
        if(!maze[r][c]){
            return;
        }

        if(maze.length-1>r){
            withObstacle(ans+"V",maze,r+1,c);
        }

        if(maze[0].length-1>c){
            withObstacle(ans+"H",maze,r,c+1);
        }
    }
}
