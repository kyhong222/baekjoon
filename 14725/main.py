import sys
# input
N = int(sys.stdin.readline().rstrip())

i=0
infoN = []
info = []

stack = []

while i<N:
    i += 1
    temp = sys.stdin.readline().rstrip().split()
    infoN.append(int(temp[0]))
    info.append(temp[1:])

# logic
info = sorted(info)

def printInfo(information, start):
    for element in information[start:]:
        temptxt = ""
        num = 0
        while num < start:
            num += 1
            temptxt += "--"
        temptxt += element[num]
        print(temptxt)

stack = info
printInfo(stack, 0)

for element in info[1:]:
    count = 0
    while count < len(stack):
        if(stack[count] == element[count]):
            printInfo(element, count)
            stack = element
            break
        count += 1

    printInfo(element, 0)
    stack = element