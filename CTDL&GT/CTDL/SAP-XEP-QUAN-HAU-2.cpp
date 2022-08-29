#include<bits/stdc++.h>
using namespace std;
int A[15], n=8; bool B[15], Xuoi[25], Nguoc[25];
int C[15][15], maxx;
void in(){
    int sum=0;
    for(int i=1;i<=8;i++){
        sum = sum + C[i][A[i]];
    }
    if(maxx<sum) maxx = sum;
}
void Try(int i){
    for(int j=1;j<=n;j++){
        if(!B[j] && !Xuoi[i-j+n] && !Nguoc[i+j-1]){
            A[i] = j ;
            B[j]=true; Xuoi[i-j+n]=true; Nguoc[i+j-1]=true;
            if(i==n) in();
            else Try(i+1);
            B[j]=false; Xuoi[i-j+n]=false; Nguoc[i+j-1]=false;
        }
    }
}
main(){
    int t; cin>>t;
    //while(t--){
    for(int k=1;k<=t;k++){
       
        for(int i=1;i<=15;i++) B[i]=false;
        for(int i=1;i<=20;i++){
             Xuoi[i]=false; Nguoc[i]=false;
        }
        maxx=0;
        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){
                cin>>C[i][j];
            }
        }
        Try(1);
        cout << "Test " << k << ": "; 
        cout << maxx << endl;
    }
}
