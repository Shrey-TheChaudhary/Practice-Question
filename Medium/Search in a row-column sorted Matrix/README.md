<h2><a href="https://practice.geeksforgeeks.org/problems/search-in-a-matrix-1587115621/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article">Search in a row-column sorted Matrix</a></h2><h3>Difficulty Level : Medium</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given a matrix of size&nbsp;n x m, where every row and column is<strong> sorted in increasing order</strong>, and a number <strong>x.</strong>&nbsp;Find whether&nbsp;element x&nbsp;is present in the matrix or not.</span><br>
<br>
<span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input</strong>:
n = 3, m = 3, x = 62
matrix[][] = {{ 3, 30, 38},
&nbsp;             {36, 43, 60},
&nbsp;             {40, 51, 69}}
<strong>Output</strong>: 0
<strong>Explanation</strong>:
62 is not present in the matrix, 
so output is 0.
</span></pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input</strong>:
n = 1, m = 6, x = 55
matrix[][] = {{18, 21, 27, 38, 55, 67}}
<strong>Output</strong>: 1
<strong>Explanation</strong>: 55 is present in the matrix.</span>
</pre>

<p><br>
<span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read input or print anything. Complete the function <strong>search()</strong> that takes <strong>n, m, x, </strong>and <strong>matrix[][]</strong>&nbsp;as input parameters and <strong>returns a boolean value.</strong> True&nbsp;if x is present in the matrix and false&nbsp;if it is not present.<br>
<br>
<strong>Expected Time Complexity:</strong>&nbsp;O(N + M)<br>
<strong>Expected Auxiliary Space:</strong>&nbsp;O(1)<br>
<br>
<strong>Constraints:</strong><br>
1 &lt;= N, M &lt;= 1000<br>
1 &lt;= mat[][] &lt;= 10<sup>5</sup><br>
1 &lt;= X &lt;= 1000</span></p>
</div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Paytm</code>&nbsp;<code>Accolite</code>&nbsp;<code>MakeMyTrip</code>&nbsp;<code>Ola Cabs</code>&nbsp;<code>Oracle</code>&nbsp;<code>Visa</code>&nbsp;<code>Goldman Sachs</code>&nbsp;<code>Directi</code>&nbsp;<code>Groupon</code>&nbsp;<code>InMobi</code>&nbsp;<code>One97</code>&nbsp;<code>Polycom</code>&nbsp;<code>TinyOwl</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Searching</code>&nbsp;<code>Matrix</code>&nbsp;<code>Data Structures</code>&nbsp;<code>Algorithms</code>&nbsp;