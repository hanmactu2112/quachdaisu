#include<bits/stdc++.h>
using namespace std;
void xuly(string a){
    int n=a.size()-1;
    for(int i=1;i<=n;i++){
        if(a[i]=='1' && a[i-1]=='0'){
            a[i]='1';
        }
        else if(a[i]=='1' && a[i-1]=='1'){
            a[i]='0';
        }
        else if(a[i]=='0'){
            a[i]=a[i-1];
        }
    }
    cout << a << endl; 
}
main(){
    int t; cin>>t;
    while (t--){
        string a; cin>>a;
        xuly(a);
    }
    
}