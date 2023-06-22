<h2><a href="https://practice.geeksforgeeks.org/problems/d857113143f69fab217cf5dab978535542f3cbb1/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article">Word Break (Trie)</a></h2><h3>Difficulty Level : Hard</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given a string <strong>A </strong>and a dictionary of n words <strong>B</strong>, find out if A&nbsp;can be segmented into a space-separated sequence of dictionary words.&nbsp;</span></p>

<p><br>
<span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
n = 12
B = { "i", "like", "sam", "sung", "samsung",
"mobile","ice","cream", "icecream", "man",
"go", "mango" }, A = "ilike"
<strong>Output:</strong> 1
<strong>Explanation: </strong>The string can be segmented as
"i like".</span></pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input</strong>: </span>
<span style="font-size:18px">n = 12 </span>
<span style="font-size:18px">B = { "i", "like", "sam", "sung", "samsung",
"mobile","ice","cream", "icecream", "man", 
"go", "mango" }, A = "ilikesamsung" </span>
<span style="font-size:18px"><strong>Output:</strong> 1</span>
<span style="font-size:18px"><strong>Explanation</strong>: The string can be segmented as 
"i like samsung" or "i like sam sung".</span>

</pre>

<p><span style="font-size:18px"><strong>Your Task:</strong><br>
Complete&nbsp;<strong>wordBreak()</strong>&nbsp;function which takes a string and list of strings as a parameter&nbsp;and returns 1 if it is possible to break words, else return&nbsp;0. You don't need to read any input or print any output, it is done by driver code.</span></p>

<p><br>
<span style="font-size:18px"><strong>Expected time complexity:&nbsp;</strong>O(n*l+|A|<sup>2</sup>) where l is the leght of longest string present in the dictionary and |A| is the length of&nbsp;string A</span><br>
<span style="font-size:18px"><strong>Expected auxiliary space:</strong>&nbsp;O(|A| + k) , where k = sum of length of all strings present in B</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Constraints</strong>:<br>
1 &lt;= N &lt;= 12<br>
1 &lt;= s &lt;=1000 , where s =&nbsp;length of string A<br>
&nbsp;The length of each word is less than 15.</span></p>

<p>&nbsp;</p>
</div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Zoho</code>&nbsp;<code>Amazon</code>&nbsp;<code>Microsoft</code>&nbsp;<code>Hike</code>&nbsp;<code>Walmart</code>&nbsp;<code>MAQ Software</code>&nbsp;<code>Google</code>&nbsp;<code>IBM</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Trie</code>&nbsp;<code>Advanced Data Structure</code>&nbsp;