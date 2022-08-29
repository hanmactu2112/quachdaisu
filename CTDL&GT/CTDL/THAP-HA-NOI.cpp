#include<bits/stdc++.h>
using namespace std;
void THN(int n, char a, char b, char c){
    if(n==1) cout << a << " -> " << c << endl;
    else {
        THN(n-1,a,c,b);
        cout << a << " -> " << c << endl;
        THN(n-1,b,a,c);
    }
}
main(){
    int n; cin >> n ;
    char a='A', b='B', c='C';
    THN(n,a,b,c);
}
