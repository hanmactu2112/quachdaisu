#include<bits/stdc++.h>
using namespace std;
main(){
    int t; cin>>t;
    while(t--){
        int n,x,y,z; 
        cin>>n>>x>>y>>z;
        long long F[105]={0};
        F[1]=x;
        for(int i=2;i<=n;i++){
            if(i%2==0){
                F[i]=min(F[i-1]+x,F[i/2]+z);
            } else {
                F[i]=min(F[i-1]+x,F[i/2+1]+z+y);
            }
        }
        cout << F[n] << endl;
    }
}