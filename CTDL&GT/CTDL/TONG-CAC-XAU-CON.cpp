#include<bits/stdc++.h>
using namespace std;
int chuyen(char c){
    return c-'0';
}
void tinh(string s){
    long long n=s.size(),i;
    long long F[15];
    F[0]=chuyen(s[0]);
    long long kq=F[0];
    for(i=1;i<n;i++){
        long long t = chuyen(s[i]);
        F[i]=F[i-1]*10+(i+1)*t;
        kq=kq+F[i];
    }
    cout << kq << endl;
}
main(){
    int t; string s;
    cin>>t;
    while(t--){
        cin>>s;
        tinh(s);
    }
}