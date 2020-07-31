'''
@author: Ashutosh Srivastava
@version: 1.0.0
@email: ashutosh65000@outlook.com
@copyright = Copyright 2020, The Algorithm Project
Python3 solution
'''

from collections import deque
nil=object()
class TrieNode(object):
    def __init__(self,c):
        self.char=c
        self.output=nil
        self.fail=nil
        self.children={}

class Trie(object):    
    def __init__(self):
        self.root=TrieNode("")
    def insert(self,word):
        if not word:
            return
        else:
            current=self.root
            for i in word:
                if i not in current.children:
                    current.children[i]=TrieNode(i)
                current=current.children[i]
            current.output=word
    def aho_automaton(self):
        queue=deque()       
        for i in range(256):
            if(chr(i) in self.root.children):
                current=self.root.children[chr(i)]
                current.fail=self.root
                queue.append(current)
            else:
                self.root.children[chr(i)]=self.root
        while queue:
            r=queue.popleft()
            for current in r.children.values():
                queue.append(current)
                state=r.fail
                while current.char not in state.children:
                    state=state.fail
                current.fail=state.children.get(current.char,self.root)
    def pattern_search(self, string):
        state = self.root
        output={}
        for index, c in enumerate(string):
            while c not in state.children:
                state = state.fail
            state = state.children.get(c, self.root)
            tmp = state
            while tmp is not nil:
                if tmp.output is not nil:
                    if tmp.output in output:
                        output[tmp.output].append(index)
                    else:
                        output[tmp.output]=[index]
                tmp = tmp.fail
        return output
        
if __name__ == '__main__':
    words = "a ab aab aac bc ".split()
    obj = Trie();
    for i in words:
        obj.insert(i)
    text = "ababaababcaac"
    obj.aho_automaton()
    ans=obj.pattern_search(text)
    print(text)
    for i in ans.items():
        if len(i[1]) == 1:
            tmp=i[1]
            print(i[0],"\t occurs at",tmp[0]-len(i[0])+2)
        else:
            for j in i[1]:
                print(i[0],"\t occurs at",j-len(i[0])+2)
