#include<bits/stdc++.h>
using namespace std;
void xuly(string s){
    s='9'+s;
    int F[1000]={0};
    F[0]=1;
    for(int i=1;i<s.size();i++){
        int n=0;
        if(s[i]=='0'){
            if(s[i-1]>'2'){
                F[s.size()-1]=0;
                break;
            }
            else F[i]=0;
        } else {
            F[i]=F[i-1];
        }
        n=(s[i-1]-'0')*10+(s[i]-'0');
        if(n>=10&&n<=26){
            F[i]=F[i]+F[i-2];
        }
    }
    cout << F[s.size()-1] << endl;
}
main(){
    int t; cin>>t;
    while(t--){
        string s; cin>>s;
        xuly(s);
    }
}
