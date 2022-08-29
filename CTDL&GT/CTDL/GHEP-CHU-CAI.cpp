#include<bits/stdc++.h>
using namespace std;
char s[11]={'A','B','C','D','E','F','G','H','I','J','K'};
char c;
int n, k, a[20], b[20]={0};
int ktra(){
    for(int i=1;i<n-1;i++){
        if((a[i]==0&&a[i-1]!=4) && (a[i]==0&&a[i+1]!=4)) return 0;
        else if((a[i]==4&&a[i-1]!=0)&& (a[i]==4&&a[i+1]!=0)) return 0;
    }
    return 1;
}

void in(){
    if(ktra()){
        for(int i=0;i<n;i++){
            cout << s[a[i]] ;
        }
        cout << endl;
    }
}
void Try(int i){
    for(int j=0;j<n;j++){
        if(b[j]==0){
            a[i]=j;
            b[j]=1;
            if(i==n-1) in();
            else Try(i+1);
            b[j]=0;
        }
    }
}
int main(){
    cin>>c;
    n=c-'A'+1;
    Try(0);

}
