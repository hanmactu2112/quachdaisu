#include<bits/stdc++.h>
using namespace std;
void xuly(long long n, long long s){
    long long n1=n;
    long long sum=0,cnt=0;
    while(n1>0){
        sum=sum+n1%10;
        ++cnt; 
        n1=n1/10;
    }
    if(sum<=s){
        cout << "0" << endl;
    }
    else {
        for(long long i=1;i<=cnt;i++){
            long long n2 = ((long long)(n/pow(10,i))+1)*pow(10,i);
            long long n3=n2;
            long long sum2=0;
            while(n2>0){
                sum2=sum2+n2%10;
                n2=n2/10;
            }
            if(sum2<=s){
                cout << n3 - n << endl;
                break;
            }
        }
    }
}
main(){
    int t; cin>>t;
    while(t--){
        long long n,s; cin>>n>>s;
        xuly(n,s);
    }
}