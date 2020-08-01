'''
@author: Ashutosh Srivastava
@version: 1.0.0
@email: ashutosh65000@outlook.com
@copyright = Copyright 2020, The Algorithm Project
Python3 solution
'''

def calculateZ(str):
    #initialize the Z[0]=0
    #because first character is always the prefix and suffix
    Z=[0]*1
    #initilize the left and right index for the box
    left,right=0,0
    #length of the concat string
    length=len(str)
    #start the Z array calculation
    for k in range(1,length):
        if(k>right):
            left=right=k
            while(right<length and str[right]==str[right-left]):
                right+=1
            Z.append(right-left)
            right-=1
        else:
            #inside the box
            k1=k-left
            #if the value is less than the right bound of box(inclusive)
            #just append it
            if(Z[k1]<right-k+1):
                Z.append(Z[k1])
            else:
                #if touches the right bound or greater than it then
                #find any other matches
                left=k
                while(right<length and str[right]==str[right-left]):
                    right+=1
                Z.append(right-left)
                right-=1
    return Z

str="baabaa"
pattern="aab"
#concatenate the patter and string with a special character that is not present in either.
concat=pattern+"$"+str
#call the function to calculate the Z array
result=calculateZ(concat)
length_pattern=len(pattern)
print(result,"<- Z array")
for i,j in enumerate(result):
    if(j==length_pattern):
        print("Found at index",i-length_pattern-1)

            
