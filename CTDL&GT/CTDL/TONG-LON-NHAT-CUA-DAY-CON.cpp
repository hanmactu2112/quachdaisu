#include<bits/stdc++.h>
using namespace std;
main(){
    int t; cin>>t;
    while(t--){
        int n; cin>>n;
        long long A[n+5],F[n+5]={0};
        long long sum=0;
        for(int i=1;i<=n;i++) cin>>A[i];
        for(int i=1;i<=n;i++){
            F[i]=A[i];
            for(int j=1;j<i;j++){
                if(A[i]>A[j]){
                    F[i]=max(F[i],F[j]+A[i]);
                }
            }
            sum = max(sum,F[i]);
        }
        cout << sum << endl;
    }
}