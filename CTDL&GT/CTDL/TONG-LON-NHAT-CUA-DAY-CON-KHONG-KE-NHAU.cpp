#include<bits/stdc++.h>
using namespace std;
main(){
    int t; cin>>t;
    while(t--){
        long long n,i; cin>>n;
        long long A[n],F[n]={0};
        for(i=0;i<n;i++) cin>>A[i];
        F[0]=A[0];
        F[1]=max(A[0],A[1]);
        for(i=2;i<n;i++){
            F[i]=max(F[i-1],F[i-2]+A[i]);
        }
        cout << F[n-1] << endl;
    }
}