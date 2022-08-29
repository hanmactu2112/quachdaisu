#include<bits/stdc++.h>
using namespace std;
main(){
    int n; cin>>n;
    vector<int> a(n);
    for(int i=0;i<n;i++){
        cin>>a[i];
    }
    sort(a.begin(),a.end());
    long long max1,max2,max3,max4;
    max1=a[0]*a[1];
    max2=a[n-1]*a[n-2];
    max3=max2*a[n-3];
    max4=a[n-1]*max1;
    long long m1=max(max1,max2);
    long long m2=max(m1,max3);
    long long m3=max(m2,max4);
    cout << m3 << endl;
}