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
void dung_cay(node* &root, int x){
    if(root==NULL){
        root = new node(x);
    }
    else {
        if(x<root->data) dung_cay(root->left,x);
        else dung_cay(root->right,x);
    }
}
void oup(node* &root){
    cout << root->data << " ";
    if(root->left!=NULL) oup(root->left);
    if(root->right!=NULL) oup(root->right);
}
int main(){
    int t; cin>>t;
    while(t--){
        int n; cin>>n;
        int a[n+5];
        for(int i=0;i<n;i++) cin>>a[i];
        node *root=NULL;
        for(int i=0;i<n;i++) dung_cay(root,a[i]);
        oup(root);
        cout << endl;
    }
}