#include<bits/stdc++.h>
using namespace std;
main(){
    int a[1000+5]={},dem=0,n;
    string s;
    while(cin>>s){
        if(s=="push"){
            cin>>n;
            a[++dem]=n;
        }
        else if(s=="show"){
            if(dem>0){
                for(int i=1;i<=dem;i++) cout << a[i] << " ";
                cout << endl;
            }
            else {
                cout << "empty" << endl;
            }
        }
        else if(s=="pop"){
            if(dem>0) dem--;
        }
    }
}