# Z Algorithm
This is a pattern searching algorithm that finds the pattern in linear amount of time i.e. `O(m+n)`, where n is the length of 
the text and m is the length of the pattern. 
I will try my best to explain [code](code.py)

###### What is Z array?
>For a string S[0..n-1], Z array is of same length as string. 
>An element Z[i] of Z array stores length of the longest sub-string starting from S[i] which is also a prefix of S[0..n-1]. 
>The first entry of Z array is 0 as complete string is always prefix of itself.

The first step is to concatenate text and pattern, and create a string “A$B” where A is pattern, $ is a special character not 
present in pattern and text both, and B is text.

We build the Z array for concatenated string and wherever in the Z array if the value is equal to the length of the pattern
then print pattern found at the index in Z where it matched subtracted the length of the pattern and the special character itself.
```python
for i,j in enumerate(result):
    if(j==length_pattern):
        print("Found at index",i-length_pattern-1)
```

###### Why use Z Algorithm though the space and time complexity is same as KMP?
>The simple answer is that it is more simpler and easy to understand.

## Calculate the Z array efficiently
We use 4 variable(left,right,k and k1) here and start the iteration from 1......(N+M).
```python
    #initialize the Z[0]=0
    #because first character is always the prefix and suffix 
    Z=[0]*1
    #initilize the left and right index for the box
    left,right=0,0
    #length of the concat string
    length=len(str)
```
The idea is to maintain an interval [left, right] with maximum value of right such that [left, right] is prefix substring.

The part of code below explains that there is no prefix substring that starts before k and ends after k, so we reset value of left 
and right and compute new [left, right] by comparing S[0..] to S[i..] and get `Z[i]= right-left+1`.
```python
if(k>right):
    left=right=k
    while(right<length and str[right]==str[right-left]):
        right+=1
    Z.append(right-left)
    right-=1
```

If the value of k<=right then there arises two cases i.e. we already have calulated the value of that box window prior but we have to check:-
If the value of Z[k-left+1] should be less than the right bound of the boxed window i.e. right if YES than just append it to Z array else.
Else the value of left becomes equal to k and we start by checking for matches again like we did before(as explained above).
