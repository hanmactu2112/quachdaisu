#include<bits/stdc++.h>
using namespace std;
int t, a[20], b[20], n;
char s[2]={'A','B'};
void xuat(){
    for(int i=1;i<=n;i++){
        cout << s[a[i]];
    }
    cout << " ";
}
void Try(int i){
    for(int j=0;j<=1;j++){
        a[i]=j;
        if(i==n) xuat();
        else Try(i+1);
    }
}
main(){
    cin >> t;
    while(t--){
        cin >> n;
        Try(1);
        cout << endl;
    }
}
