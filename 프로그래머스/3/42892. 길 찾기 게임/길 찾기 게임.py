import sys
sys.setrecursionlimit(10**6)

answer = [[],[]]

class Node:
    def __init__(self, index, value):
        self.index = index
        self.value = value
        self.left = None
        self.right = None
        
    def setleft(self, node):
        self.left = node
    
    def setright(self, node):
        self.right = node
        
class BinaryTree:
    def __init__(self):
        self.head=None
        
    def insert(self, node):
        if self.head==None:
            self.head=node
        else:
            parent = self.head
            while True:
                if parent.value > node.value:
                    if parent.left == None:
                        parent.setleft(node)
                        break
                    else:
                        parent = parent.left
                else:
                    if parent.right == None:
                        parent.setright(node)
                        break
                    else:
                        parent = parent.right
                        
    def show(self, node, option):
        if node is None:
            return
        if option==1:
            answer[0].append(node.index)
            self.show(node.left, 1)
            self.show(node.right, 1)
        if option==3:
            self.show(node.left, 3)
            self.show(node.right, 3)
            answer[1].append(node.index)
        
    def option(self, option):
        if option == 1:
            self.show(self.head, 1)
        if option == 3:
            self.show(self.head, 3)
        
def solution(nodeinfo):
    for i in range(len(nodeinfo)):
        nodeinfo[i].append(i+1)
        
    nodeinfo.sort(key=lambda x:x[1], reverse=True)
    bt = BinaryTree()
    
    for place in nodeinfo:
        value, y, index = place
        bt.insert(Node(index, value))
        
    bt.option(1)
    bt.option(3)
    return answer