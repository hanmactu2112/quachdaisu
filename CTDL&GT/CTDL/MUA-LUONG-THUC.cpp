#include<bits/stdc++.h>
using namespace std;
int main(){
    int t; cin>>t;
    while(t--){
        int n,s,m;
        cin>>n>>s>>m;
        int sum=0,ok=1;
        int dem=0,sum1=0;
        for(int i=1;i<=s;i++){
            if(sum1<m){
                dem++;
                sum1=sum1+n;
            }
            sum1=sum1-m;
            if(i%7==0){
                sum=sum-m;
            }
            else sum=sum+n-m;
            if(sum<0){
                ok=0;
                break;
            } 
        }
        if(ok==0) cout << "-1" << endl;
        else cout << dem << endl;
    }
}