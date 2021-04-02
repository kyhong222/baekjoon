import sys

def distance(pos1, pos2):
    return abs(pos1[0] - pos2[0])+ abs(pos1[1]-pos2[1])

def closePos(pos):
    return [[pos[0], pos[1]], 
            [pos[0]-1, pos[1]],
            [pos[0]+1, pos[1]],
            [pos[0], pos[1]-1],
            [pos[0], pos[1]+1],
            ]

N = int(sys.stdin.readline().rstrip())
i=0
position = []
while i < N+1:
    i += 1
    x,y = map(int, sys.stdin.readline().rstrip().split())
    position.append([x, y])

#print("position", position)

dp = []
lastPositions = []
dp.append(0)
lastPositions.append(position[0])
#print("lastPositions", lastPositions)

i=0
while i < N:
    i += 1
    ClosePos = closePos(position[i])
    distances = []
    min = 99999
    closers = []
    for p in ClosePos:
        for l in lastPositions:
            d = distance(l, p)
            #print("p, l",p, l)
            #print("distance",d)
            if d < min:
                closers.clear()
                closers.append(p)
                min = d
                #print("min changed", min)
            elif d == min:
                if p not in closers:
                    closers.append(p)
    
    lastPositions.clear()
    lastPositions = closers
    #print("lastPositions", lastPositions)
    dp.append(min)
    #print('\n')

total = 0
for d in dp:
    total += d

print(total)
    
