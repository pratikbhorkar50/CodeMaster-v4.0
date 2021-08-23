#include<iostream>
#include <iomanip>
using namespace std;

int main(int argc, char const *argv[])
{
	freopen("Problem1_input.txt","r",stdin);
	freopen("output.txt","w",stdout);
	int trip;
	cin>>trip;
	for (int i = 0; i < trip; i++)
	{
		float km, num_vc;
		cin>>km>>num_vc;
		double high_hour = 0.00000;
		double mySpeed = 0.00000;
		for(int j=0; j<num_vc;j++)
		{
			double hour;
			double vc_km, vc_speed;
			cin>>vc_km>>vc_speed;
			hour = (km-vc_km)/vc_speed;
			if(hour > high_hour)
				high_hour = hour;
		}
		mySpeed = km/high_hour;
		std::cout << std::fixed;
        std::cout << std::setprecision(6);
		cout<<"Trip-"<<i+1<<": "<<mySpeed<<endl;
	}

	return 0;
}