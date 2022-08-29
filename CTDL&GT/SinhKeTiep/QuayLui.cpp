#include <iostream>
using namespace std;

int ok,n,a[25];
void in(){
	for(int i=1;i<=n;i++){
		cout<<a[i]<<" ";
	}
	cout << endl;
}
void Try(int i){
	int j;
	for(j=0;j<=n;j++){
		a[i]=j;
		if(i==n) in();
		else Try(i+1);
	}
}
main(){
	cin>>n;
	Try(1);
}
