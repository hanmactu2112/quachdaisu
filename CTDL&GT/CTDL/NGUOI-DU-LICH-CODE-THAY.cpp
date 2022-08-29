#include<bits/stdc++.h>
using namespace std;
int n,C[20][20],c_min,sum_min;
int A[20],B[20];
void DuLich(int i,int sum){
    if(i==n+1){
        sum=sum+C[B[i-1]][1];
        sum_min=min(sum,sum_min);
        return;
    }
    for(int j=2;j<=n;j++){
        if(A[j]==1){
            A[j]=0;
            B[i]=j;
            sum=sum+C[B[i-1]][B[i]];
            if(sum+c_min*(n-i+1)<sum_min) DuLich(i+1,sum);
            sum=sum-C[B[i-1]][B[i]];
            A[j]=1;
        }
    }
}
main(){
    cin>>n;
    c_min=1e9;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            cin>>C[i][j];
            if(C[i][j]!=0){
                c_min=min(c_min,C[i][j]);
            }
        }
    }
    //memset(A,1,sizeof(A));
    for(int i=1;i<=20;i++) A[i]=1;
    B[1]=1;
    sum_min=1e9;
    DuLich(2,0);
    cout << sum_min << endl;
}
