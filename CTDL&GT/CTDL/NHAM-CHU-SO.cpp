#include<bits/stdc++.h>
using namespace std;
long long maxx(string a){
    long long sum=0;
    for(int i=0;i<a.size();i++){
        if(a[i]=='5'){
            sum = sum*10+6;
        }
        else sum = sum*10+(a[i]-'0');
    }
    return sum;
}
long long minn(string a){
    long long sum=0;
    for(int i=0;i<a.size();i++){
        if(a[i]=='6'){
            sum=sum*10+5;
        }
        else sum=sum*10+(a[i]-'0');
    }
    return sum;
}
main(){
    string a,b;
    cin>>a>>b;
    cout << minn(a)+minn(b) << " " << maxx(a)+maxx(b) << endl; 
}