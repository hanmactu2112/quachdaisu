#include<bits/stdc++.h>
using namespace std;
main(){
    int n; cin>>n;
    int a[n];
    long long sum1=0,sum2=0,sum=0;
    for(int i=0;i<n;i++){
        cin>>a[i];
        sum1=sum1+a[i];
        sum2=sum2+abs(a[i]);
    }
    cout << sum1+sum2 << endl;
}