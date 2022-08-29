#include<bits/stdc++.h>
using namespace std;
int a[1000],n;
vector<string> op;
bool cmp(string a, string b){
    if(a.size()==b.size()) return a<b;
    else return a.size()<b.size();
}
int check(int m){
    if(a[1]==0) return 0;
    else {
        int dem2=0;
        for(int i=1;i<=m;i++){
            if(a[i]==2) dem2++;
        }
        if(dem2>m-dem2) return 1;
        return 0;
    }
}
void in(int m){
    if(check(m)==1){
        string x="";
        for(int i=1;i<=m;i++){
            x=x+to_string(a[i]);
        }
        op.push_back(x);
    }
}
void Try(int i){
    for(int j=0;j<=2;j++){
        a[i]=j;
        if(i<=10){
            in(i);
            Try(i+1);
        }
    }
}
main(){
    Try(1);
    sort(op.begin(),op.end(),cmp);
    int t; cin>>t;
    while(t--){
        cin>>n;
        for(int i=0;i<n;i++) cout << op[i] << " ";
        cout << endl;
    }
}
