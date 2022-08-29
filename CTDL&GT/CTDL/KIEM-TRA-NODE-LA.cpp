#include<bits/stdc++.h>
using namespace std;
struct node{
    int data;
    node *L,*R;
    node (int x){
        data=x;
        L=R=NULL;
    }
};
void makenode(node *root, int x, int y, char c){
    switch(c){
        case 'L': root->L = new node(y); break;
        case 'R': root->R = new node(y); break;
    }
}
void insert(node *root, int x, int y, char c){
    if(root==NULL) return;
    if(root->data==x){
        makenode(root,x,y,c);
    }
    else {
        insert(root->L,x,y,c);
        insert(root->R,x,y,c);
    }
}
vector<int> a;
void kiem_tra(node *root, int dodai){
    if(root->L==NULL && root->R==NULL) a.push_back(dodai);
    else {
        if(root->L!=NULL) kiem_tra(root->L,dodai+1);
        if(root->R!=NULL) kiem_tra(root->R,dodai+1);
    }
}
main(){
    int t; cin>>t;
    while(t--){
        a.clear();
        int n; cin>>n;
        node *root = NULL;
        while(n--){
            int x,y; char c;
            cin>>x>>y>>c;
            if(root == NULL){
                root = new node(x);
                makenode(root,x,y,c);
            }
            else insert(root,x,y,c);
        }
        kiem_tra(root,1);
        int kt=1;
        for(int i=1;i<a.size();i++){
            cout << a[i] << " ";
            /*if(a[i]!=a[0]){
                kt=0;
                break;
            }*/
        }
        cout << endl;
        /*
        if(kt==1) cout << "1" << endl;
        else cout << "0" << endl;*/
    }
}
