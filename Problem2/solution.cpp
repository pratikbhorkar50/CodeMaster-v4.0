#include <iostream>
#include <vector>
#include <map>
#include <iterator>
//#include <string>
using namespace std;

map<char,int> findOcurrencesOfChar(string input)
{
    map<char, int> myMap;
    map<char, int>::iterator it = myMap.begin();

    for(int i=0; input[i] != '\0'; i++)
    {
        it = myMap.find(input[i]);
        if( it != myMap.end())
        {
            cout<<"found"<<endl;
            it->second++;
        }
        else
        {
            cout<<"not found"<<endl;
            myMap.insert(pair<char,int>(input[i],1));
        }
    }

    return myMap;
}

// works fine.
int getCount(const map<char,int>& characterCount)
{
	int countValue = 0;
	for (auto iter = characterCount.begin(); iter != characterCount.end(); iter++)
		{
			countValue = countValue + (iter->second);
		}
	cout << "count: " << countValue << endl;
	return countValue;
}

int main()
{
//	int numberOfLines = 0;
//
//	cout << "enter number of lines string: ";
//	cin>> numberOfLines;
//
//	vector<string> collectionKey;
//
//	for(int i =0; i<numberOfLines; i++)
//	{
//		string getString;
//		cin>> getString;
//		collectionKey.push_back(getString);
//	}

	map<char, int> characterCount = findOcurrencesOfChar("ZERO");
	int keyGenerated = 0;

	for(auto iter = characterCount.begin(); iter!=characterCount.end();iter++)
	{
		cout << iter->first << '\t';
		cout << iter->second << endl;
	}

	while(getCount(characterCount))
	{
		// zero
		if((characterCount.find('Z'))->second >= 1 &&
			(characterCount.find('E'))->second >= 1 &&
			(characterCount.find('R'))->second >= 1 &&
			(characterCount.find('O'))->second >= 1)
		{
			keyGenerated = (keyGenerated*10) + 0;

			(characterCount.find('Z'))->second -=1;
			(characterCount.find('E'))->second -=1;
			(characterCount.find('R'))->second -=1;
			(characterCount.find('O'))->second -=1;
		}

		// one
		if((characterCount.find('O'))->second >= 1 &&
			(characterCount.find('N'))->second >= 1 &&
			(characterCount.find('E'))->second >= 1)
		{
			keyGenerated = (keyGenerated*10) + 1;

			(characterCount.find('O'))->second -=1;
			(characterCount.find('N'))->second -=1;
			(characterCount.find('E'))->second -=1;;
		}

		// two
		if((characterCount.find('T'))->second >= 1 &&
			(characterCount.find('W'))->second >= 1 &&
			(characterCount.find('0'))->second >= 1)
		{
			keyGenerated = (keyGenerated*10) + 2;

			(characterCount.find('T'))->second -=1;
			(characterCount.find('W'))->second -=1;
			(characterCount.find('O'))->second -=1;
		}

		// three
		if((characterCount.find('T'))->second >= 1 &&
			(characterCount.find('H'))->second >= 1 &&
			(characterCount.find('R'))->second >= 1 &&
			(characterCount.find('E'))->second >= 2)
		{
			keyGenerated = (keyGenerated*10) + 3;

			(characterCount.find('T'))->second -=1;
			(characterCount.find('H'))->second -=1;
			(characterCount.find('R'))->second -=1;
			(characterCount.find('E'))->second -=2;
		}

		// four
		if((characterCount.find('F'))->second >= 1 &&
			(characterCount.find('O'))->second >= 1 &&
			(characterCount.find('U'))->second >= 1 &&
			(characterCount.find('R'))->second >= 1)
		{
			keyGenerated = (keyGenerated*10) + 4;

			(characterCount.find('F'))->second -=1;
			(characterCount.find('O'))->second -=1;
			(characterCount.find('U'))->second -=1;
			(characterCount.find('R'))->second -=1;
		}

		// five
		if((characterCount.find('F'))->second >= 1 &&
			(characterCount.find('I'))->second >= 1 &&
			(characterCount.find('V'))->second >= 1 &&
			(characterCount.find('E'))->second >= 1)
		{
			keyGenerated = (keyGenerated*10) + 5;

			(characterCount.find('F'))->second -=1;
			(characterCount.find('I'))->second -=1;
			(characterCount.find('V'))->second -=1;
			(characterCount.find('E'))->second -=1;
		}

		// six
		if((characterCount.find('S'))->second >= 1 &&
			(characterCount.find('I'))->second >= 1 &&
			(characterCount.find('X'))->second >= 1)
		{
			keyGenerated = (keyGenerated*10) + 6;

			(characterCount.find('S'))->second -=1;
			(characterCount.find('I'))->second -=1;
			(characterCount.find('X'))->second -=1;
		}

		// seven
		if((characterCount.find('S'))->second >= 1 &&
			(characterCount.find('E'))->second >= 2 &&
			(characterCount.find('V'))->second >= 1 &&
			(characterCount.find('N'))->second >= 1)
		{
			keyGenerated = (keyGenerated*10) + 7;

			(characterCount.find('S'))->second -=1;
			(characterCount.find('E'))->second -=2;
			(characterCount.find('V'))->second -=1;
			(characterCount.find('N'))->second -=1;
		}

		// eight
		if((characterCount.find('E'))->second >= 1 &&
			(characterCount.find('I'))->second >= 1 &&
			(characterCount.find('G'))->second >= 1 &&
		    (characterCount.find('H'))->second >= 1 &&
			(characterCount.find('T'))->second >= 1)
		{
			keyGenerated = (keyGenerated*10) + 8;

			(characterCount.find('E'))->second -=1;
			(characterCount.find('I'))->second -=1;
			(characterCount.find('G'))->second -=1;
			(characterCount.find('H'))->second -=1;
			(characterCount.find('T'))->second -=1;
		}

		// nine
		if((characterCount.find('N'))->second >= 2 &&
			(characterCount.find('I'))->second >= 1 &&
			(characterCount.find('E'))->second >= 1)
		{
			keyGenerated = (keyGenerated*10) + 8;

			(characterCount.find('N'))->second -=2;
			(characterCount.find('I'))->second -=1;
			(characterCount.find('E'))->second -=1;
		}

	}

	cout << "keygeneraated: "<< keyGenerated << endl;



	return 0;
}
