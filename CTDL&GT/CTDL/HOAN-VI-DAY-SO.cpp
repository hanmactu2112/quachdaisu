#include<bits/stdc++.h>
using namespace std;
int a[20], n, c[20], b[20]={0};
void in(){
    for(int i=1;i<=n;i++){
        cout << a[c[i]] << " ";
    }
    cout << endl;
}
void Try(int i){
    for(int j=1;j<=n;j++){
        if(b[j]==0){
            c[i]=j;
            b[j]=1;
            if(i==n) in();
            else Try(i+1);
            b[j]=0;
        }

    }
}
main(){
    cin>>n;
    for(int i=1;i<=n;i++){
        cin>>a[i];
    }
    sort(a,a+n+1);
    Try(1);
}
