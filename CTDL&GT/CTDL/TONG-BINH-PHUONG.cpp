#include<bits/stdc++.h>
using namespace std;
int F[10000];
void qhd(){
    for(int i=1;i<=10000;i++){
        F[i]=i;
        for(int j=1;j<=sqrt(i);j++){
            F[i]=min(F[i],F[i-j*j]+1);
        }
    }
}
main(){
    int t,n; cin>>t;
    qhd();
    while(t--){
        cin>>n;
        cout << F[n] << endl;
    }
}