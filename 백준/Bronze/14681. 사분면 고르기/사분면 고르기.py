Coordi = [0, 0]

Coordi[0] = int(input())
Coordi[1] = int(input())

if (Coordi[0] > 0):
    if (Coordi[1] > 0):
        print ('1')
    else:
        print ('4')
else:
    if (Coordi[1] > 0):
        print ('2')
    else:
        print ('3')