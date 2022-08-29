#include<bits/stdc++.h>
using namespace std;
struct node{
    int data;
    node *left, *right;
    node (int x){
        data=x;
        left=right=NULL;
    }
};
node* makenode(int n){
    node *root=NULL;
    map<int, node*> mp;
    while(n--){
        int x,y; char c;
        cin>>x>>y>>c;
        if(mp.find(x)==mp.end()){
            node *tmp = new node(x);
            mp[x]=tmp;
            if(root==NULL){
                root=tmp;
            }
        }
        node *tmp = new node(y);
        node *tmp1 = mp[x];
        if(c=='R') tmp1->right=tmp;
        else tmp1->left=tmp;
        mp[y] = tmp;
    }
    return root;
}
int kt;
void bang_nhau(node *root1, node *root2){
    if(root1==NULL && root2==NULL) return;
    if((root1==NULL && root2!=NULL) && (root1!=NULL && root2==NULL)){
        kt=0; return;
    }
    if(root1->data==root2->data){
        bang_nhau(root1->left,root2->left);
        bang_nhau(root1->right,root2->right);
    }
    else {
        kt=0;
        return;
    }
}
main(){
    int t; cin>>t;
    while(t--){
        int n;
        cin>>n;
        node *root1=makenode(n);
        int m;
        cin>>m;
        node *root2=makenode(m);
        kt=1;
        bang_nhau(root1,root2);
        cout << kt << endl;
    }
}