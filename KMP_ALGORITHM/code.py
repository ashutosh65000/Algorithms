string="AABAACAADAABAABA"
pattern="AABA"
length_string=len(string)
length_pattern=len(pattern)
#Compute the LPS array
lps=[0]*length_pattern
i,j=1,0

#Calulate the LPS(longest prefix which is also a suffix)
while i<length_pattern:
    #if char at i and j match
    if pattern[i]==pattern[j]:
        lps[i]=j+1
        i+=1
        j+=1
    #if char at i and j do not match check two things
    #1. if the value of j =0, assign lps[i]=0 and increment i
    #2. if not then assign j the value of previous characters value in lps and continue
    else:
        if(j!=0):
            j=lps[j-1]
        else:
            lps[i]=j
            i+=1
            
#KMP Searching 
i,j=0,0
while i<length_string:
    if string[i]==pattern[j]:
        i+=1
        j+=1
    if j==length_pattern:
        print("Matched at index",i-j)
        j=lps[j-1]
    elif i<length_string and string[i]!=pattern[j]:
        if j!=0:
            j=lps[j-1]
        else:
            i+=1
