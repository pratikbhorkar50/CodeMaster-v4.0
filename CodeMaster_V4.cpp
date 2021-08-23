//============================================================================
// Name        : CodeMaster_V4.cpp
// Author      : Ankita
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <fstream>
#include <string>
#include <iterator>
#include <map>
#include <algorithm>
#include<bits/stdc++.h>


using namespace std;

int main () {
      fstream ob;
      ofstream outfile;
      string::size_type pos;
      int flag;
      string final_key;
      int RN = 1;


      ob.open("C:\\projects\\workspace\\CodeMaster_V4\\src\\input_file.txt", ios:: in);   //again opening the file but in reading mode
      outfile.open("C:\\projects\\workspace\\CodeMaster_V4\\src\\output.txt", ios:: out);

      int loop_number = 1;
      while (!ob.eof())
      {
         final_key="";
         string str; // T W O T H R E E
         ob >> str;  //reading word by word from file and storing in str
         if (loop_number == 1)
         {
            loop_number++;
            continue;
         }
         map<string,int> comp_map;
         comp_map.insert(pair<string,int>("ZERO",0));
         comp_map.insert(pair<string,int>("ONE",1));
         comp_map.insert(pair<string,int>("TWO",2));
         comp_map.insert(pair<string,int>("THREE",3));
         comp_map.insert(pair<string,int>("FOUR",4));
         comp_map.insert(pair<string,int>("FIVE",5));
         comp_map.insert(pair<string,int>("SIX",6));
         comp_map.insert(pair<string,int>("SEVEN",7));
         comp_map.insert(pair<string,int>("EIGHT",8));
         comp_map.insert(pair<string,int>("NINE",9));

         for (auto itr = comp_map.begin(); itr != comp_map.end(); ++itr)
         {
            int i;
            flag = 1;
            while (flag == 1)
            {
               flag = 0;
               for (i = 0; i<=itr->first.length() -1 && str.find(itr->first.at(i)) != string::npos; ++i)
               {
               }
               if (i == itr->first.length())
               {
                  std::string chars = itr->first;
                      for (char c: chars)
                      {
                          str.erase(str.find(c),1);
                      }
                  final_key = final_key + to_string(itr->second);

                  flag = 1;
               }
            }
         }
         sort(final_key.begin(), final_key.end());
         outfile << "Room-"<<RN<<": "<<final_key<<"\n";
         RN++;
         cout<<"\n";
      }

      ob.close(); //closing the file after use
      outfile.close();

      return 0;
}
