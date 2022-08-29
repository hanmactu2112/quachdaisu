#include<bits/stdc++.h>
using namespace std;
long long chuyen(string a){
    long long sum=0;
    int n=a.size()-1;
    for(int i=0;i<=n;i++){
        sum = sum + (a[i]-'0')*pow(2,n-i);
    }
    return sum;
}
main(){
    int t; cin>>t;
    while(t--){
        string a,b;
        cin>>a>>b;
        cout << chuyen(a)*chuyen(b) << endl;
    }
}
