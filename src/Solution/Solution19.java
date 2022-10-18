package Solution;

public class Solution19 {
    public static void main(String[] args) {
        String s = "aa";
        String p = "a*";
        Solution19 solution19 = new Solution19();
        System.out.println(solution19.isMatch(s, p));
    }

    public boolean isMatch(String s, String p) {
        //使用动态规划算法
        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n + 1][m + 1];
        //初始边界，s为0个字符，p也为0个字符
        dp[0][0] = true;
        //dp[0][1]=false，s为空，p为一个字符，此时p必不可能为*，必然匹配失败，
        //由于boolean数组默认为false，所以不写。
        //s为空字符串，p不为空时
        for (int j = 2; j <= m; j++) {
            if (p.charAt(j - 1) == '*')
                //s为空，p[j-1]为‘*’，匹配0个，相当于删掉'*'和前面的字符，
                //状态转换为匹配往前两个字符
                dp[0][j] = dp[0][j - 2];
        }

        //
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                //不为'*'
                if (p.charAt(j - 1) != '*') {
                    //如果为‘.’或者j与i匹配
                    if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {// 为'*'但第j-2个不匹配
                    if(p.charAt(j-2) != s.charAt(i-1) && p.charAt(j-2) != '.'){
                        dp[i][j] = dp[i][j-2];
                    }else {
                        //匹配0次,匹配1次,匹配多次
                        dp[i][j] = dp[i][j - 2] ||  dp[i - 1][j];
                    }
                }

            }
        }

        return dp[n][m];
    }


}
