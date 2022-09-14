from math import sqrt
import sys

T = int(sys.stdin.readline())

detect = [list(map(int,sys.stdin.readline().split())) for _ in range(T)]

for i in detect:
    dist = sqrt(pow(i[0]-i[3],2)+pow(i[1]-i[4],2))
    
    if (dist == 0 and i[2] == i[5]):
        if (i[2] == 0):
            print ('1')
        else:
            print ('-1')
    elif (dist == 0 and i[2] != i[5]):
        print ('0')
    elif (min(i[2],i[5])>=dist>0):
        if (dist + min(i[2],i[5]) == max(i[2],i[5])):
            print ('1')
        elif (dist + min(i[2],i[5]) > max(i[2],i[5])):
            print ('2')
        else:
            print ('0')
    elif (max(i[2],i[5])>=dist>=min(i[2],i[5])):
        if (dist + min(i[2],i[5]) == max(i[2],i[5])):
            print ('1')
        elif (dist + min(i[2],i[5]) > max(i[2],i[5])):
            print ('2')
        else:
            print ('0')
    elif (dist>=max(i[2],i[5])):
        if (dist == max(i[2],i[5])+min(i[2],i[5])):
            print ('1')
        elif (dist < max(i[2],i[5])+min(i[2],i[5])):
            print ('2')
        else:
            print ('0')