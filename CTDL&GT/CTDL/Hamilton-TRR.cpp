#include<bits/stdc++.h>
using namespace std;
int a[20][20],b[20],c[20];
int n,x;
int  kiemtra(){
    if(a[c[n]][x]==1) return 1;
    return 0;
}
void in(){
    if(kiemtra()==1){
        for(int i=1;i<=n;i++){
            cout << c[i] << " ";
        }
        cout << endl;
    }
}
void Try(int u, int i, int dem){
    for(int j=1;j<=n;j++){
        if(a[u][j]==1&&b[j]==0){
            b[j]=1;
            c[i]=j;
            if(i==n) in();
            else Try(j,i+1,dem+1);
            b[j]=0;
        }
    }
}
main(){
    cin>>n>>x;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            cin>>a[i][j];
        }
    }
    memset(b,0,sizeof(b));
    c[1]=x;
    b[x]=1;
    Try(x,2,1);
}
