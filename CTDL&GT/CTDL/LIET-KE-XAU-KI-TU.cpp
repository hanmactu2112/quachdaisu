#include<bits/stdc++.h>
using namespace std;
int n, k, a[20];
char c;
char s[11]={'A','B','C','D','E','F','G','H','I','J','K'};
void in(){
    for(int i=1;i<=k;i++){
        cout << s[a[i]];
    }
    cout << endl;
}
void Try(int i){
    for(int j=a[i-1];j<=n;j++){
        a[i]=j;
        if(i==k) in();
        else Try(i+1);
    }
}
main(){
        a[0]=0;
        cin >> c >> k;
        n=c-'A';
        Try(1);
}
