#include<bits/stdc++.h>
using namespace std;
main(){
    int t; cin>>t;
    while(t--){
        string a; cin>>a;
        cout << a[0];
        for(int i=1;i<a.size();i++){
            if(a[i]==a[i-1] && a[i]=='0'){
                cout << "0" ; 
            }
            else if(a[i]==a[i-1] && a[i]=='1'){
                cout << "0";
            }
            else cout << "1";
        }
        cout <<endl;
    }
}