#include <bits/stdc++.h>
using namespace std;

int main()
	{
	string a[10];
	a[1] = "DONG";
	a[2]= "TAY";
	a[3]="NAM";
	a[4]="BAC";
	a[5]="TAY";
	a[6]="BAC";
    struct cmp {
    bool operator() (string a, string b) const {
        return a<b;
    	}
	};

	std::set<string, cmp> s;
//	for(int i=1;i<=6;i++){
//		s.insert(a[i]);
//	}
	s.insert(a,a+5);
  	for(auto i:s){
  		cout<<i<<" "<<endl;
	  }
    return 0;
	}
