# Edit-Distance-Problem-Solution-in-Java
Problem

Given two strings word1 and word2, return the minimum number of operations required to convert word1 into word2.

You can perform three operations:

Insert a character

Delete a character

Replace a character



---

Example

Input:  word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse → rorse (replace 'h' with 'r')
rorse → rose  (remove 'r')
rose  → ros   (remove 'e')


---

🔹 Intuition

This is a dynamic programming problem (classic edit distance).

Let dp[i][j] = minimum operations to convert first i chars of word1 into first j chars of word2.

Transitions:

1. If word1[i-1] == word2[j-1]:

dp[i][j] = dp[i-1][j-1]


2. Otherwise, choose one of:

Insert:  dp[i][j-1] + 1

Delete:  dp[i-1][j] + 1

Replace: dp[i-1][j-1] + 1



