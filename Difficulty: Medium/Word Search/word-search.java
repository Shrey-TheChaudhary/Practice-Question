class Solution {
    static public boolean isWordExist(char[][] mat, String word) {
        char first = word.charAt(0);
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] visited = new boolean[n][m];
        int row = 0;
        int col = 0;
        boolean found = false;
        for(int i = 0;i< mat.length;i++){
            for (int j = 0;j<mat[i].length;j++){
                if(mat[i][j] == first){
                    row = i;
                    col = j;
                    visited[i][j] = true;
                    found= checkNearby(mat,row,col,word,1,"huu",visited);
                    if(found){
                        return found;
                    }
                }
                visited[i][j] = false;
            }
        }

        return found;
        
    }
    
      public static boolean checkNearby(char[][] mat, int i,int j, String word, int wordIndex, String notCheck, boolean[][] visited) {
        if(wordIndex>=word.length()){
            return true;
        }

        boolean right = false;
        boolean left = false;
        boolean up = false;
        boolean down = false;


        if(!Objects.equals(notCheck,"right") && j+1<mat[i].length && mat[i][j+1]==word.charAt(wordIndex) && !visited[i][j+1]) {
            visited[i][j+1] = true;
            right =  checkNearby(mat,i,j+1,word,wordIndex+1,"left",visited);
            if(!right)
                visited[i][j+1] = false;
        } if(!Objects.equals(notCheck,"left") && j-1>=0 &&  mat[i][j-1]== word.charAt(wordIndex) && !visited[i][j-1]) {
            visited[i][j-1] = true;
            left =  checkNearby(mat,i,j-1,word,wordIndex+1,"right",visited);
            if(!left)
                visited[i][j-1] = false;
        } if(!Objects.equals(notCheck,"down") && i+1<mat.length &&  mat[i+1][j] ==  word.charAt(wordIndex) && !visited[i+1][j]) {
            visited[i+1][j] = true;
            up =  checkNearby(mat,i+1,j,word,wordIndex+1,"up",visited);
            if(!up)
                visited[i+1][j] = false;
        }
        if(!Objects.equals(notCheck,"up") && i-1>=0 && mat[i-1][j] == word.charAt(wordIndex) && !visited[i-1][j]) {
            visited[i-1][j] = true;
            down =  checkNearby(mat,i-1,j,word,wordIndex+1,"down",visited);
            if(!down)
                visited[i-1][j] = false;
        }
        return right || left || up || down;
    }
}

