import sys

A, B, C = map(int,sys.stdin.readline().split())

if (A == B):
    if (B == C):
        print (10000+A*1000)
    else:
        print (1000+A*100)
else:
    if (A == C):
        print (1000+A*100)
    elif (B == C):
        print (1000+B*100)
    else: print (100*max(A, B, C))