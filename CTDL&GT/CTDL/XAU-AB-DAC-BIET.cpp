#include<bits/stdc++.h>
using namespace std;
int a[20], n, k;
char s[2]={'A','B'};
vector<vector<int>> op;
int check(){
    int dem0=0;
    for(int i=0;i<n;i++){
        if(a[i]==0){
            int dem=0;
            while(a[i]==0&&i<n){
                dem++;
                i++;
            }
            if(dem==k) dem0++;
            else if(dem>k) return 0;
        }
    }
    if(dem0==1) return 1;
    else return 0;
}
void in(){
    if(check()){
        vector<int> op1;
        for(int i=0;i<n;i++){
            op1.push_back(a[i]);
        }
        op.push_back(op1);
    }
}
void Try(int i){
    for(int j=0;j<=1;j++){
        a[i]=j;
        if(i==n-1) in();
        else Try(i+1);
    }
}
int main(){
    cin >> n >> k;
    Try(0);
    cout << op.size() << endl;
    for(int i=0;i<op.size();i++){
        for(int j=0;j<op[i].size();j++){
            cout << s[op[i][j]];
        }
        cout << endl;
    }
}
