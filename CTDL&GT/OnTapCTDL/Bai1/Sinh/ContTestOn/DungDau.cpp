#include<bits/stdc++.h>
using namespace std;
int n,b[20],chuaxet[20];
string a[20],s;
void in(){
	if(a[b[1]]==s){
		for(int i=1;i<=n;i++){
		
			cout<<a[b[i]]<<" ";
		}
		cout<<endl;
	}
}
void Try(int i){
	for(int j=1;j<=n;j++){
		if(!chuaxet[j]){
			chuaxet[j]=1;
			b[i] = j;
			if(i==n) {
				in();
			}
			else Try(i+1);
			chuaxet[j]=0;
		}
	}
}
main(){
	cin>>n;
	for(int i=1;i<=n;i++) cin>>a[i];
	cin>>s;
	sort(a,a+n+1);
	Try(1);
}
