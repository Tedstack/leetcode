package DP;

public class distinctSequence {
    public static int numDistinct(String s, String t) {
        int[][] sum=new int[s.length()+1][t.length()+1];
        for(int i = 0;i<=s.length();i++){
            sum[i][0] = 1;
        }
        print(sum);
        for(int i=0;i<s.length();i++){
            for(int j=0;j<t.length();j++) {
                sum[i + 1][j + 1] = sum[i][j + 1];
                if (s.charAt(i) == t.charAt(j))
                    sum[i + 1][j + 1] += sum[i][j];
            }
        }
        System.out.println(".");
        print(sum);
        return sum[s.length()][t.length()];
    }

    private static void print(int[][] sum){
        for(int i=0;i<sum.length;i++){
            for(int j=0;j<sum[0].length;j++)
                System.out.print(sum[i][j] + " ");
            System.out.println(".");
        }
    }
}
