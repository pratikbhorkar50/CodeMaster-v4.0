#!/bin/bash
#Problem 2

inputFile=Problem2_input.txt
noOfLines=`sed -n 1p $inputFile`
#echo no. of lines is $noOfLines
declare -i count
export count=`expr 0 + 0`
#echo count is $count
while read line; do
    if [ $count -eq 0 ]; then
        count=`expr $count + 1`
        continue
    fi
    #echo $line is line
    #Readind each line in sequence
    echo "$line" > tmp.txt
    export tempLine=line.txt
    > $tempLine
    zero=`grep -o "Z" tmp.txt | wc -l`
    if [ $zero -gt 0 ]; then
        #echo "zeros is $zero"
        while [ $zero -gt 0 ]; do
            echo 0 >> $tempLine
            sed -i s/Z// tmp.txt
            sed -i s/E// tmp.txt
            sed -i s/R// tmp.txt
            sed -i s/O// tmp.txt
            zero=`expr $zero - 1`
        done
        #export key=`sort $tempLine | tr -d '\n'`
    fi
    
    twos=`grep -o "W" tmp.txt | wc -l`
    if [ $twos -gt 0 ]; then
        while [ $twos -gt 0 ]; do
            echo 2 >> $tempLine
            sed -i s/T// tmp.txt
            sed -i s/W// tmp.txt
            sed -i s/O// tmp.txt
            twos=`expr $twos - 1`
        done
    fi
    
    threes=`grep -o "H" tmp.txt | wc -l`
    if [ $threes -gt 0 ]; then
        while [ $threes -gt 0 ]; do
            echo 3 >> $tempLine
            sed -i s/T// tmp.txt
            sed -i s/H// tmp.txt
            sed -i s/R// tmp.txt
            sed -i s/E// tmp.txt
            sed -i s/E// tmp.txt
            threes=`expr $threes - 1`
        done
    fi
    
    fours=`grep -o "U" tmp.txt | wc -l`
    if [ $fours -gt 0 ]; then
        while [ $fours -gt 0 ]; do
            echo 4 >> $tempLine
            sed -i s/F// tmp.txt
            sed -i s/O// tmp.txt
            sed -i s/U// tmp.txt
            sed -i s/R// tmp.txt
            fours=`expr $fours - 1`
        done
    fi
    
    fives=`grep -o "F" tmp.txt | wc -l`
    if [ $fives -gt 0 ]; then
        while [ $fives -gt 0 ]; do
            echo 5 >> $tempLine
            sed -i s/F// tmp.txt
            sed -i s/I// tmp.txt
            sed -i s/V// tmp.txt
            sed -i s/E// tmp.txt
            fives=`expr $fours - 1`
        done
    fi
    
    sixs=`grep -o "X" tmp.txt | wc -l`
    if [ $sixs -gt 0 ]; then
        while [ $sixs -gt 0 ]; do
            echo 6 >> $tempLine
            sed -i s/S// tmp.txt
            sed -i s/I// tmp.txt
            sed -i s/X// tmp.txt
            sixs=`expr $sixs - 1`
        done
    fi
    
    sevens=`grep -o "V" tmp.txt | wc -l`
    if [ $sevens -gt 0 ]; then
        while [ $sevens -gt 0 ]; do
            echo 7 >> $tempLine
            sed -i s/S// tmp.txt
            sed -i s/E// tmp.txt
            sed -i s/V// tmp.txt
            sed -i s/E// tmp.txt
            sed -i s/N// tmp.txt
            sevens=`expr $sevens - 1`
        done
    fi
    
    eights=`grep -o "G" tmp.txt | wc -l`
    if [ $eights -gt 0 ]; then
        while [ $eights -gt 0 ]; do
            echo 8 >> $tempLine
            sed -i s/E// tmp.txt
            sed -i s/I// tmp.txt
            sed -i s/G// tmp.txt
            sed -i s/H// tmp.txt
            sed -i s/T// tmp.txt
            eights=`expr $eights - 1`
        done
    fi
    
    nines=`grep -o "I" tmp.txt | wc -l`
    if [ $nines -gt 0 ]; then
        while [ $nines -gt 0 ]; do
            echo 9 >> $tempLine
            sed -i s/N// tmp.txt
            sed -i s/I// tmp.txt
            sed -i s/N// tmp.txt
            sed -i s/E// tmp.txt
            nines=`expr $nines - 1`
        done
    fi
    
    ones=`grep -o "O" tmp.txt | wc -l`
    if [ $ones -gt 0 ]; then
        while [ $ones -gt 0 ]; do
            echo 1 >> $tempLine
            sed -i s/O// tmp.txt
            sed -i s/N// tmp.txt
            sed -i s/E// tmp.txt
            ones=`expr $ones - 1`
        done
    fi
    
    export key=`sort $tempLine | tr -d '\n'`
    echo "Room-$count: $key" >> Problem2_output.txt
    count=`expr $count + 1`
done <$inputFile

rm -f tmp.txt line.txt sed*