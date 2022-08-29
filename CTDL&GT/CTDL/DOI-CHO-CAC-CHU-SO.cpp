#include<bits/stdc++.h>
using namespace std;
void xuLy(int n, string s){
    int dem=0;
    for(int i=0;i<s.size();i++){
        int k=i; if(dem==n) break;
        for(int j=s.size()-1;j>=i;j--){
            if(s[k]<s[j]){
                k=j;
            }
        }
        if(k!=i){
            swap(s[i],s[k]);
            dem++;
        }
    }
    cout << s << endl;
}
int main(){
    int t; cin >> t;
    while(t--){
        int n; string s;
        cin >> n >> s;
        xuLy(n,s);
    }
}
