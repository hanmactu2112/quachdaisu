#include<bits/stdc++.h>
using namespace std;
int a[1005][1005];
main(){
    memset(a,0,sizeof(a));
    int t; cin>>t;
    cin.ignore();
    string s;
    for(int i=1;i<=t;i++){
        getline(cin,s); 
        for(int j=0;j<s.size();j++){
            if(s[j]>='0' && s[j] <='9'){
                int n=0;
                while(j<s.size() && s[j]>='0' && s[j] <='9'){
                    n=n*10+(s[j]-'0');
                    j++;
                }
                a[i][n]=1;
            }
        }
    }
    for(int i=1;i<=t;i++){
        for(int j=1;j<=t;j++){
            cout << a[i][j] << " ";
        }
        cout << endl;
    }
}
