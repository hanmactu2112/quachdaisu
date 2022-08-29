#include<bits/stdc++.h>
using namespace std;
int a[10], b[10]={0};
string s;
void in(){
    for(int i=0;i<s.size();i++){
        cout << s[a[i]];
    }
    cout << " ";
}
void Try(int i){
    int m = s.size();
    for(int j=0;j<m;j++){
        if(b[j]==0){
            a[i]=j;
            b[j]=1;
            if(i==m-1) in();
            else Try(i+1);
            b[j]=0;
        }
    }
}
main(){
    int t; cin >> t;
    while(t--){
        cin >> s;
        Try(0);
        cout << endl;
    }
}
