#include<bits/stdc++.h>
using namespace std;
main(){
    int a[100000];
    a[1]=0;a[2]=1;a[3]=1;
    for(int i=4;i<=100000;i++){
        int x,y,z; x=y=z=1e6;
        if(i%3==0){
            x=a[i/3];
        }
        if(i%2==0){
            y=a[i/2];
        }
        z=a[i-1];
        int m1=min(x,y);
        int m2=min(m1,z);
        a[i]=m2+1;
    }
    int t; cin>>t;
    while(t--){
        int n; cin>>n;
        cout << a[n] << endl;
    }
}
