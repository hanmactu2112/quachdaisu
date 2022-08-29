#include<bits/stdc++.h>
using namespace std;
struct data{
    int hs,mu;
} P[500],Q[500];
int n,m;
int xuly(string s,struct data P[]){
    int a[10000+5],d=0,d1=0;
    for(int i=0;i<s.size();i++){
        if(s[i]>='0' && s[i] <='9'){
            int dem=0;
            while(s[i]>='0'&&s[i]<='9'&& i<s.size()){
                dem=dem*10+(s[i]-'0');
                i++;
            }
            a[d++]=dem;
        }
    }
    for(int i=0;i<d;i=i+2){
        P[d1].hs=a[i];
        P[d1].mu=a[i+1];
        d1++;
    }
    return d1;
}
void tinh(){
    struct data Tong[100];
    int i=0,j=0,k=0;
    while(i<n&&j<m){
        if(P[i].mu>Q[j].mu){
            Tong[k++]=P[i++];

        } else if(P[i].mu<Q[j].mu){
            Tong[k++]=Q[j++];
        } else {
            Tong[k].hs=P[i].hs+Q[j].hs;
            Tong[k].mu=P[i].mu;
            k++;i++;j++;
        }
    }
    while(i<n){
        Tong[k++]=P[i++];
    }
    while(j<m){
        Tong[k++]=Q[j++];
    }
    for(int i=0;i<k-1;i++){
        cout << Tong[i].hs << "*x^" << Tong[i].mu << " + ";
    }
    cout << Tong[k-1].hs << "*x^" << Tong[k-1].mu;
    cout << endl;
}
main(){
    int t; cin>>t;
    cin.ignore();
    while(t--){
        string s1; getline(cin,s1);
        string s2; getline(cin,s2);
        n=xuly(s1,P);
        m=xuly(s2,Q);
        tinh();
    }
}
