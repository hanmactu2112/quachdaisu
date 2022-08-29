#include<bits/stdc++.h>
using namespace std;
string a[20];
set<string> c;
int n, k, b[20], m=1;
void in(){
    for(int i=1;i<=k;i++){
        cout << a[b[i]] << " ";
    }
    cout << endl;

}
void Try(int i){
    for(int j=b[i-1]+1;j<m;j++){
        b[i]=j;
        if(i==k) in();
        else Try(i+1);
    }
}
int main(){
    cin >> n >> k;
    string s;
    for(int i=1;i<=n;i++){
        cin>>s;
        c.insert(s);
    }
    for(auto x:c){
        a[m++]=x;
    }
    Try(1);
    return 0;
}
