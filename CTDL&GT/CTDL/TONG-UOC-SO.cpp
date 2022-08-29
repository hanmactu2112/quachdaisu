#include<bits/stdc++.h>
using namespace std;
long long a[1000005];
void Sang(){
    memset(a,0,sizeof(a));
    for(int i=1;i<=1000005;i++){
        for(int j=2*i;j<=1000005;j=j+i){
            a[j]=a[j]+i;
        }
    }
    long long l,r; cin>>l>>r;
    long long dem=0;
    for(long long i=l;i<=r;i++){
        if(a[i]>i) dem++;
    }
    cout << dem << endl;
}
main(){
    Sang();
}