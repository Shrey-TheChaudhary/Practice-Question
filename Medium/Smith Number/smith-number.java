//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.smithNum(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int smithNum(int n) {
        if (n <=2)
            return 0;

        int sum = digitSum(n);
     
        int sumprime=prime(n);
        if(sum==sumprime)
        return 1;
        return 0;
    }

    // Helper function to calculate the sum of digits
    private static int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
  public static int prime(int n)
    {

int sum=0;
int temp=n;
if(n%2==0)
{
   int count=0;
    while(n>0&&n%2==0)
    {
        n=n/2;
    count=count+2;
    }
    sum+=count;
}
int tempn=n;
int i=3;
while(n>0&&i<=(tempn/2))
{
    if(n%i==0)
    {
        int a=0;
        while(n>0&&n%i==0)
        {
            n=n/i;
            a++; //power of prime fcator
        }
        int call=digitSum(i);//finding the sum of digits of prime factors
        
        sum=sum+(call*a);
    }
    //System.out.print(a);
    i=i+2;
}
int j=0;
//System.out.print(n);
if(n!=1&&n!=temp)
{
j=digitSum(n);
}
//System.out.print(j);
sum+=j;
        
        return sum;
    }
    
    }