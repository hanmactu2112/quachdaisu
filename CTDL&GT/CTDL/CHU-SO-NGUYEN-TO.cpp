#include<bits/stdc++.h>
using namespace std;
char s[4]={'2','3','5','7'};
int a[20],b[20],n;
int kt(){
    if(a[n]==0){
        return 0;
    }
    return 1;
}
void in(){
    if(kt()==1){
        for(int i=1;i<=n;i++){
            cout << s[a[i]];
        }
        cout << endl;
    }
}
void Try(int i){
    for(int j=0;j<4;j++){
        if(b[j]==0){
            a[i]=j;
            b[j]=1;
            if(i==n) in();
            else Try(i+1);
            b[j]=0;
        }
    }
}
main(){
    cin>>n;
    memset(b,0,sizeof(b));
    Try(1);
}
