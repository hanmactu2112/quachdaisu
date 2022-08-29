#include<bits/stdc++.h>
using namespace std;
int main(){
    int t; cin>>t;
    while(t--){
        int a[26]={0};
        string s; cin>>s;
        for(int i=0;i<s.size();i++){
            a[s[i]-'a']++;
        }
        int m=s.size();
        if(m%2==0) m=m/2;
        else m=m/2+1;
        sort(a,a+26);
        if(a[25]<=m) cout << "1" << endl;
        else cout << "-1" << endl;
    }
}