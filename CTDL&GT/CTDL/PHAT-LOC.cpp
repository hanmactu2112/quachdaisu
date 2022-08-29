#include<bits/stdc++.h>
using namespace std;
char s[2]={'6','8'};
int a[20], n;
int check1(){
    if(a[1]!=1 || a[n]!=0) return 0;
    return 1;
}
int check2(){
    for(int i=1;i<n;i++){
        if(a[i]==1 && a[i+1]==1) return 0;
    }
    return 1;
}
int check3(){
    for(int i=1;i<=n;i++){
        if(a[i]==0){
            int dem=0;
            while(i<=n&&a[i]==0){
                dem++;
                i++;
            }
            if(dem>3) return 0;
        }
    }
    return 1;
}
void in(){
    if(check1()==1&&check2()==1&&check3()==1){
        for(int i=1;i<=n;i++){
            cout << s[a[i]];
        }
        cout << endl;
    }
}
void Try(int i){
    for(int j=0;j<=1;j++){
        a[i]=j;
        if(i==n) in();
        else Try(i+1);
    }
}
main(){
    cin>>n;Try(1);
}
