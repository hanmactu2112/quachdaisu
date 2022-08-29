#include<bits/stdc++.h>
using namespace std;
char s[2]={'0','2'};
vector<vector<int>> op;
int a[20];
// 00/00/2000
int check(){
    if(a[0]==0&&a[1]==0) return 0;
    else if(a[2]==1) return 0;
    else if(a[2]==0&&a[3]==0) return 0;
    else if(a[4]==0) return 0;
    return 1;
}
void in(){
    if(check()==1){
        vector<int> op1;
        for(int i=0;i<8;i++){
            op1.push_back(a[i]);
        }
        op.push_back(op1);
    }
}
void Try(int i){
    for(int j=0;j<=1;j++){
        a[i]=j;
        if(i==7) in();
        else Try(i+1);
    }
}
main(){
    Try(0);
    sort(op.begin(),op.end());
    for(int i=0;i<op.size();i++){
        for(int j=0;j<=1;j++){
            cout << s[op[i][j]];
        }
        cout << "/";
        for(int j=2;j<=3;j++){
            cout << s[op[i][j]];
        }
        cout << "/";
        for(int j=4;j<8;j++){
            cout << s[op[i][j]];
        }
        cout << endl;
    }
}
