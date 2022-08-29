#include<bits/stdc++.h>
using namespace std;
void xuly(int k, string a, string b){
    int n=a.size()-1;
    int m=b.size()-1;
    while(n<m){
        a="0"+a;
        n++;
    }
    while(m<n){
        b="0"+b;
        m++;
    }
    int nho=0;
    string tmp="";
    for(int i=m;i>=0;i--){
        int ans = (a[i]-'0')+(b[i]-'0')+nho;
        tmp = char(ans%k+'0')+tmp;
        nho=ans/k;
    }
    if(nho>0) tmp=char(nho+'0')+tmp;
    for(int i=0;i<tmp.size();i++){
        cout << tmp[i];
    }
}
int main(){
    int t; cin>>t;
    while(t--){
        int k;
        string a,b;
        cin>>k>>a>>b;
        xuly(k,a,b);
        cout << endl;
    }
}