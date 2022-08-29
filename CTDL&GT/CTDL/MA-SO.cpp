#include<bits/stdc++.h>
using namespace std;
int a[20],b[20],c[20],n;
void in(){
    for(int i=1;i<=n;i++){
        cout << (char)(a[i]+64);
    }
    for(int i=1;i<=n;i++){
        cout << b[i];
    }
    cout << endl;
}
void Try1(int i){
    for(int j=1;j<=n;j++){
        b[i]=j;
        if(i==n) in();
        else Try1(i+1);
    }
}
void Try(int i){
    for(int j=1;j<=n;j++){
        if(c[j]==0){
            c[j]=1;
            a[i]=j;
            if(i==n) Try1(1);
            else Try(i+1);
            c[j]=0;
        }
    }
}
main(){
    cin>>n;
    Try(1);
}