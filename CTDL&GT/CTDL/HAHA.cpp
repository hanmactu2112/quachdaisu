#include<bits/stdc++.h>
using namespace std;
char s[2]={'A','H'};
int t, b[20], n;
int check(int A[], int m){
    if(A[1]!=1 || A[m]!=0) return 0;
    else return 1;
}
int check1(int A[],int m){
    for(int i=1;i<m;i++){
        if(A[i]==1 && A[i+1]==1) return 0;
    }
    return 1;
}
void xuat(){
    if(check(b,n)==1&& check1(b,n)==1){
        for(int i=1;i<=n;i++){
            cout << s[b[i]] ;
        }
        cout << endl;
    }
}
void Try(int i){
    for(int j=0;j<=1;j++){
        b[i]=j;
        if(i==n) xuat();
        else Try(i+1);
    }
}
main(){
    cin >> t;
    while(t--){
        cin >> n;
        Try(1);
    }
}
