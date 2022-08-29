#include<bits/stdc++.h>
using namespace std;
int check[20];
int s,a[20],b[20],c[20];
int n,d;
void Try2(int i,int sum){
    for(int j=c[i-1]+1;j<=n;j++){
        if(sum+a[j]<=s&&check[j]==0){
            sum=sum+a[j];
            c[i]=j;
            check[j]=1;
            if(sum==s) d++;
            else Try2(i+1,sum);
            check[j]=0;
            sum=sum-a[j];
        }
    }
}
void Try(int i, int sum){
    for(int j=b[i-1]+1;j<=n;j++){
        if(sum+a[j]<=s&&check[j]==0){
            sum=sum+a[j];
            b[i]=j;
            check[j]=1;
            if(sum==s){
                Try2(1,0);
            }
            else Try(i+1,sum);
            sum=sum-a[j];
            check[j]=0;
        }
    }
}
main(){
    int t; cin>>t;
    while(t--){
        s=0; d=0; b[0]=0; c[0]=0;
        memset(check,0,sizeof(check));
        cin>>n;
        for(int i=1;i<=n;i++){
            cin>>a[i];
            s=s+a[i];
        }
        if(s%3!=0){
            cout << "0" << endl;
        }
        else {
            s=s/3;
            check[1]=1;
            Try(1,a[1]);
            cout << d*3 << endl;
        }
    }
}