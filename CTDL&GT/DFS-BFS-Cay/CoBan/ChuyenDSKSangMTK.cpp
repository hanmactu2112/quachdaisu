#include <bits/stdc++.h>
#include <iostream>
using namespace std;

int a[1005][1005];

main(){
	memset(a,0,sizeof(a));
	int t; cin>>t;
    cin.ignore();
	cin.ignore();
	string s;
	for(int i=1;i<=t;i++){
		getline(cin,s);
		stringstream ss(s);
        string y;
        while(ss>>y){
        	int x = stoi(y);
        	a[i][x]=1;
        	a[x][i]=1;
		}	
	}
	for(int i=1;i<=t;i++){
		for(int j=1;j<=t;j++){
			cout<<a[i][j]<<" ";
		}
		cout<<endl;
	}	
}
