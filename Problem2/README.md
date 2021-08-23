# Escape Room

I am playing an escape room game with my friends, in which I am locked in a room and to get out of the room I need to 
crack the code of the digital door lock. When I will unlock room 1, I will go to the next room and need to crack the code for 
that room too and so on...till the last room. I am going get a piece of paper in each room on which the digital key is written but encrypted. 

Somehow I manage to understand the following points,
1. All digits of the key are written in words but scrambled.
2. The same digit can have multiple occurrences.
3. Final key will be in ascending order of digits.
4. Key length is not fixed.

So can you find the right key for all rooms one by one and help me to win the game?

## Input

The first line gives the number of rooms, say '**R**'. '**R**' rooms to follow.

For each room, I have the paper with '**EK**', the encrypted key.

## Output

For each room, the output should be like '**Room-RN: DK**',

Where '**RN**' is the room number, and '**DK**' is decrypted key to escape that room.

### Sample Input
```
4
NOOEORWETZ
XTTIROWISGOFEUH
OUORENONFE
HTEER
```

### Sample Output

```
Room-1: 012
Room-2: 2468
Room-3: 114
Room-4: 3
```

## Important Note

We need **Problem2_output.txt** generated based on provided **Problem2_input.txt**.