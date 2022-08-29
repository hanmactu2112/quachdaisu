#include<bits/stdc++.h>
using namespace std;
int main(){
    int t; cin>>t;
    while(t--){
        int a,b,c,d;
        cin>>a>>b>>c>>d;
        int dem=0;
        while(a!=c && b!=d){
                if(a>c) a--;
                else c--;
                if(b>d) b--;
                else d--;
                dem++;
        }
        while(a==c&&b!=d){
            if(b>d)  b--;
            else d--;
            dem++;
        }
        while(a!=c && b==d){
            if(a>c) a--;
            else c--;
            dem++;
        }
        cout << dem << endl;
    }
}