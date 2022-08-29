#include<bits/stdc++.h>
using namespace std;
void sinhKT(int t,string a){
    int n=a.size();
    int i=n-2;
    while(i>=0 && a[i]>=a[i+1]){
        i--;
    }
    if(i<0){
        cout << t << " " << "BIGGEST";
    }
    else {
        int k=n-1;
        while(a[k] <= a[i]){
            k--;
        }
        swap(a[k],a[i]);
        int l=i+1,r=n-1;
        while(l<r){
            swap(a[l],a[r]);
            l++;r--;
        }
        cout << t << " " << a;
    }
}
main(){
    int t; cin>>t;
    while(t--){
        int a;string b;
        cin>>a>>b;
        sinhKT(a,b);
        cout << endl;
    }
    
}