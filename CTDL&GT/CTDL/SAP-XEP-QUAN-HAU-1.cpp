#include<bits/stdc++.h>
using namespace std;
int hang[20], cot[20], xuoi[20], nguoc[20],ans,n;
void Try(int i){
    for(int j=1;j<=n;j++){
        if(hang[i]==0&&cot[j]==0&&xuoi[i-j+n]==0&&nguoc[i+j-1]==0){
            hang[i] = 1 ; cot[j] = 1 ; xuoi[i-j+n]=1 ; nguoc[i+j-1]=1;
            if(i==n){
                ans++;
            }
            else Try(i+1);
            hang[i]=0 ; cot[j]= 0;xuoi[i-j+n]=0;nguoc[i+j-1]=0;
        }
    }
}
main(){
    int t; cin>>t;
    while(t--){
        memset(hang,0,sizeof(hang));
        memset(cot,0,sizeof(cot));
        memset(xuoi,0,sizeof(xuoi));
        memset(nguoc,0,sizeof(nguoc));
        ans=0;
        cin>>n;
        Try(1);
        cout << ans << endl;
    }
}
