import sys
# 테스트 케이스 개수
case = int(sys.stdin.readline().rstrip())

resultList = []
for i in range(case):
    # 암호화된 문장(crypted) 개수
    c = int(sys.stdin.readline().rstrip())
    cList = []
    for j in range (c):
        # 암호화된 문장 리스트
        text = sys.stdin.readline().rstrip()
        cList.append(text)

    # 복호화된 문장(decrypted)
    d = sys.stdin.readline().rstrip()
    # 복호화할 문장
    toD = sys.stdin.readline().rstrip()

    '''
    1. 문장의 길이 체크
    2. 같은 문자에 대한 유효성 검사
    3. cList가 하나 남으면 -> 바로 복호화
    4. 2개 이상이면 -> 일치하는 부분만 복호화
    5. cList가 0개면 -> IMPOSSIBLE 출력
    '''

    dictList = []
    for crypted in cList[:]:
        #print("cList:", cList)
        #print(crypted)
        #print(i)
        if len(d) != len(crypted):
            cList.remove(crypted)
            continue
        
        else:
            dic = {} # 딕셔너리 선언 
            index = 0
            values = []
            for character in d:
               # print("values", values)

                # 해당값이 없다면
                if character not in dic:
                    # 여기서 value가 중복되면 안됨
                    if crypted[index] in values:
                        cList.remove(crypted)
                        break
                    else:
                        dic[character] = crypted[index]
                        values.append(crypted[index])
                        index += 1
                
                # 해당 값이 있다면(같은 문자열)
                else:
                    # 값이 같은 경우(정상 진행)
                    if(dic[character] == crypted[index]):
                        index += 1
                    
                    # 값이 다른 경우(탈락)
                    else:
                        #print("remove: ", crypted)
                        cList.remove(crypted)
                        break
            if crypted in cList:
                inv_dic = {v: k for k, v in dic.items()}
                dictList.append(inv_dic)
                

    #print("cList:", cList)
    if len(cList) == 0:
        resultList.append("IMPOSSIBLE")
    elif len(cList) == 1:
        result = ""
        for character in toD:
            if character in dictList[0]:
                result += (dictList[0][character])
            else:
                result += ("?")

        resultList.append(result)
    else:
        result = ""
        for char in toD: 
            # 키가 없음 -> ?
            if char not in dictList[0]:
                result += "?"
            else:
                # 키가 있으나, 다른 dic과 일치하지 않음 -> ?
                flg = True
                for dic in dictList:
                    if char not in dic:
                        result += "?"
                        flg = False
                        break

                    if dictList[0][char] != dic[char]:
                        result += "?"
                        flg = False
                        break
                    # else -> 번역
                if flg:
                    result += dictList[0][char]
        resultList.append(result)
            

for r in resultList:
    print(r)



                
        




