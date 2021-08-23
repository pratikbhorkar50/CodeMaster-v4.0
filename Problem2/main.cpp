#include <bits/stdc++.h>

using namespace std;

char cArr[] = {'Z', 'X', 'G', 'W', 'U', 'H', 'V', 'N'};

int iMs[] = {0,6,8,2,4,3,5,7,1,9};

char cErArr[] = {'Z', 'E', 'R', 'O', // 0
                 'S', 'I', 'X',     //4
                 'E', 'I', 'G', 'H', 'T',//7
                 'T', 'W', 'O',//12
                 'F', 'O', 'U', 'R',//15
                 'T', 'H', 'R', 'E', 'E',//19
                 'F', 'I', 'V', 'E',//24
                 'S', 'E', 'V', 'E', 'N',//28
                 'O', 'N', 'E',//33
                 'N', 'I', 'N', 'E' };//36

int iErArr[] = {4,3,5,3,4,5,4,5,3,4};

void eraseString(string& str, int cntr, multiset<int>& tims)
{
   int index = 0;
   int valToInsert = 0;

   for(int i = 0; i < cntr; i++)
   {
      index += iErArr[i];
   }

   if(cntr < 6)
   {
      for(int i = 0; i < iErArr[cntr]; i++)
      {
         size_t found = str.find(cErArr[index + i]);
         if(found != string::npos)
         {
            str.erase(found, 1);
         }
      }
      valToInsert = iMs[cntr];

   }
   else if(cntr == 6)
   {
      size_t f1 = str.find('F');
      size_t f2 = str.find('V');

      int val = 0;

      if(f1 != string::npos && f2 !=string::npos)
      {
         index = 24;
         val = 4;
         valToInsert = iMs[6];
      }
      else
      {
         index = 28;
         val = 5;
         valToInsert = iMs[7];
      }
         for(int i = 0; i < val; i++)
         {
            size_t found = str.find(cErArr[index + i]);
            if(found != string::npos)
            {
               str.erase(found, 1);
            }
         }

   }
   else if(cntr == 7)
   {
      size_t f1 = str.find('O');

      int val = 0;

      if(f1 != string::npos)
      {
         index = 33;
         val = 3;
         valToInsert = iMs[8];
      }
      else
      {
         index = 36;
         val = 4;
         valToInsert = iMs[9];
      }
         for(int i = 0; i < val; i++)
         {
            size_t found = str.find(cErArr[index + i]);
            if(found != string::npos)
            {
               str.erase(found, 1);
            }
         }
   }

   tims.insert(valToInsert);

}

int main()
{
   freopen("input.txt", "r", stdin);
   freopen("output.txt", "w", stdout);

   int R = 0;
   cin>>R;
   multiset<int> ims;

   for(int r = 0; r < R; r++)
   {
      string EK;
      cin>>EK;

      int tempCntr = 0;

      while(true)
      {
         if(EK.find(cArr[tempCntr]) != string::npos)
         {
            eraseString(EK, tempCntr, ims);
         }
         else
         {
            tempCntr++;
         }

         if(tempCntr > 7)
            break;
      }
      cout<<"Room-"<<(r+1)<<":";
      for(auto v : ims)
         cout<<v;

      cout<<endl;
      ims.clear();


   }



   return 0;
}


