class Solution {
public boolean isPalindrome(String s)
{
s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
int start = 0, end = s.length()-1;
while(start < end)
{
if(s.charAt(start++) != s.charAt(end--))
return false;
}
return true;
}
}