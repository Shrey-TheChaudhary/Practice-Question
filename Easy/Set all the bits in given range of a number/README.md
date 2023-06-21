<h2><a href="https://practice.geeksforgeeks.org/problems/set-all-the-bits-in-given-range-of-a-number4538/1">Set all the bits in given range of a number</a></h2><h3>Difficulty Level : Easy</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given a non-negative number <strong>N</strong> and two values <strong>L</strong> and <strong>R</strong>. The problem is to set all the bits in the range L to R in the binary representation of N.</span></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input :</strong></span>
<span style="font-size:18px"><strong>N =</strong> 17, <strong>L =</strong> 2, <strong>R =</strong> 3 </span>
<span style="font-size:18px"><strong>Output :</strong></span>
<span style="font-size:18px">23</span>
<span style="font-size:18px"><strong>Explanation:</strong></span>
<span style="font-size:18px">(17)<sub>10</sub> = (10001)<sub>2</sub>
(23)<sub>10</sub> = (10111)<sub>2</sub>
The bits in the range 2 to 3 in the binary
representation of 17 are set.</span></pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input :</strong></span>
<span style="font-size:18px"><strong>N =</strong> 8, <strong>L =</strong> 1, <strong>R =</strong> 2 </span>
<span style="font-size:18px"><strong>Output :</strong></span>
<span style="font-size:18px">11</span>
<span style="font-size:18px"><strong>Explanation:</strong></span>
<span style="font-size:18px">(8)<sub>10</sub> = (1000)<sub>2</sub>
(11)<sub>10</sub> = (1011)<sub>2</sub>
The bits in the range 2 to 3 in the binary
representation of 8 are set.</span>
</pre>

<p><span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read input or print anything. Your task is to complete the function <strong>setAllRangeBits()</strong> which takes an Integer N as input and returns the answer.</span></p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:</strong> O(1)<br>
<strong>Expected Auxiliary Space:</strong> O(1)</span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong></span><br>
<span style="font-size:18px">1 &lt;= N &lt;= 10<sup>8</sup></span></p>
</div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Bit Magic</code>&nbsp;<code>Data Structures</code>&nbsp;