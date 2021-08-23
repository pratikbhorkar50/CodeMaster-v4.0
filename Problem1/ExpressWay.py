def check(arr,max):
    for i in arr:
        if i['distance'] < max:
            return False
    return True

def solve(max,v,arr):
    t = 0
    while check(arr,max) != True:
        for i in arr:
            if i['distance'] >= max:
                pass
            else:
                i['distance'] += i['speed']
        t += 1
    return max/(t)

f = open('Problem1_input.txt','r')
f2 = open('Problem1_output.txt','w')

x = f.readline()
for i in range(int(x)):
    t = f.readline()
    max = int(t.split(' ')[0])
    v = int(t.split(' ')[1])
    arr = []
    for j in range(v):
        x = f.readline()
        d = int(x.split(' ')[0])
        s = int(x.split(' ')[1])
        arr.append({'distance':d,'speed':s})
    s=solve(max,v,arr)
    # print('Trip-',i+1,': ','{:6f}'.format(s))
    f2.write('Trip-'+str(i+1)+': '+'{:6f}'.format(s)+'\n')
f2.close()

