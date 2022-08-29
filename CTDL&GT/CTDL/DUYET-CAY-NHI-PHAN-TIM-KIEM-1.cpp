#include<bits/stdc++.h>
using namespace std;
struct node{
    int data;
    node *left,*right;
    node (int x){
        data=x;
        left=right=NULL;
    }
};
void xay_dung(node* &root, int x){
    if(root==NULL){
        root = new node(x);
    }
    else {
        if(x<root->data) xay_dung(root->left,x);
        else xay_dung(root->right,x);
    }
}
void oup(node* &root){
    if(root!=NULL){
        if(root->left!=NULL) oup(root->left);
        if(root->right!=NULL) oup(root->right);
        cout << root->data << " ";
    }
}
main(){
    int t; cin>>t;
    while(t--){
        int n; cin>>n;
        int a[n+5];
        for(int i=1;i<=n;i++){
            cin>>a[i];
        }
        node *root = NULL;
        for(int i=1;i<=n;i++){
            xay_dung(root,a[i]);
        }
        oup(root);
        cout << endl;
    }
}