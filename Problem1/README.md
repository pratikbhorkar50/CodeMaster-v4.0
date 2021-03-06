# Express Way

I want to go to Pune from Mumbai through Express Way. But due to the Covid-19 breakout, only one lane is operational so 
that authorities can check vehicles for norms. But that's not my problem.

As only one lane is allowed, all small and big vehicles (e.g. cars and heavy-duty trucks) are on the same lane with different 
speeds. So when a high-speed car reaches behind a slow-moving truck then the car needs to reduce the speed same as the 
truck and keep moving.

But somehow I know before leaving from Mumbai, the position of each vehicle w.r.t. me and its maximum speed.

As I am not a big fan of shifting gears and pushing breaks, I would like to keep a constant speed to reach my destination 
at '**K**' kilometers. I don't have an upper limit for speed, the only thing is I can't overtake other vehicles.

So what should be my maximum speed which I should be able to keep constant to reach my destination?

## Input

The first line gives the number of trips, say '**T**'. '**T**' trips to follow.

For each trip, I have two numbers '**K**' and '**VC**', the destination kilometers for all, and the total number of vehicles 
on road.

The next line(s) will give each vehicle position (kms from me) and its max. speed (km/hr).

## Output

For each trip, the output should be like '**Trip-TN: CS**',

Where '**TN**' is the trip number, and '**CS**' is max. constant speed which I can take to reach my destination 
without overtaking anybody. '**CS**' should be correct up to the 6th decimal place. (see ref. sample output)

### Sample Input
```
3
2525 1
2400 5
300 2
120 60
60 90
100 2
80 100
70 10
```

### Sample Output

```
Trip-1: 101.000000
Trip-2: 100.000000
Trip-3: 33.333333
```

### Explanation (Sample Input)
3 => Total number of trips

for **Trip 1**

2525 1 => indicate vehicles destination '**2525**' km for all and next '**1**' is number of other vehicle on road.

2400 5 => indicate the position of the only vehicle which is '**2400**' kms from me and max. speed as '**5**' km/hr

for **Trip 2**

300 2 => indicate vehicles destination '**300**' km for all and next '**2**' is number of other vehicles on road.

120 60 => indicate the position vehicle 1 from me which is '**120**' kms and max. speed as '**60**' km/hr.

60 90 => indicate the position vehicle 2 from me which is '**60**' kms and max. speed as '**90**' km/hr.

and so on....

## Important Note

We need **Problem1_output.txt** generated based on provided **Problem1_input.txt**.
