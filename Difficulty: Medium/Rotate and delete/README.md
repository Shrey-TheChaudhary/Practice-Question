<h2><a href="https://www.geeksforgeeks.org/problems/rotate-and-delete-1587115621/1">Rotate and delete</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 18px;">Given an array <strong>arr</strong> integers. Do the following operation until a single element left. For every <strong>k<sup>th</sup></strong> operation:</span></p>
<ul>
<li><span style="font-size: 18px;">Right, rotate the vector clockwise by <strong>1</strong>.</span></li>
<li><span style="font-size: 18px;">Delete the <strong>k</strong><strong><sup>th</sup></strong> element from the last.</span></li>
</ul>
<p><span style="font-size: 18px;">Now, find the element which is left at last.</span></p>
<p><span style="font-size: 18px;"><strong>Example:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input: </strong>arr<strong> = </strong>[1, 2, 3, 4, 5, 6]</span>
<span style="font-size: 18px;"><strong>Output: </strong>3</span>
<span style="font-size: 18px;"><strong>Explanation:</strong></span><span style="font-size: 18px;"> Rotate the vector clockwise i.e. after rotation the vector arr = [6, 1, 2, 3, 4, 5] and delete the last element that is 5 that will be arr = [6, 1, 2, 3, 4]. </span><span style="font-size: 14pt;">Similarly, the output will be 3.</span></pre>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>arr<strong> = </strong>[1, 2, 3, 4]
<strong>Output: </strong>2
<strong>Explanation:</strong> Rotate the vector clockwise i.e. after rotation the vector arr = [4, 1, 2, 3] and delete the last element that is 3 that will be arr = [4, 1, 2]. Similarly, the output will be 2.</span></pre>
<p><span style="font-size: 18px;"><strong>Expected Time Complexity:</strong> O(n)<br><strong>Expected Auxiliary Space:</strong>&nbsp;O(1)</span></p>
<p><span style="font-size: 18px;"><strong>Constraints:</strong><br>1 &lt;= arr.size() &lt;= 10<sup>5</sup><br>1 &lt;= arr[i] &lt;= 10<sup>6</sup></span></p></div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Arrays</code>&nbsp;<code>Data Structures</code>&nbsp;