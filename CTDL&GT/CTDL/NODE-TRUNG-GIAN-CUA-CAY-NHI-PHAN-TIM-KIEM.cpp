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
void makenode(node* &root, int x){
    if(root==NULL){
        root = new node(x);
    }
    else {
        if(x<root->data) makenode(root->left,x);
        else makenode(root->right,x);
    }
}
int dem;
void dem_node(node* &root){
    if(root->left!=NULL || root->right!=NULL) {
        dem++;
    }
    if(root->left!=NULL) dem_node(root->left);
    if(root->right!=NULL) dem_node(root->right);
}
main(){
    int t; cin>>t;
    while(t--){
        dem=0;
        int n; cin>>n;
        int a[n+5];
        for(int i=0;i<n;i++) cin>>a[i];
        node *root=NULL;
        for(int i=0;i<n;i++){
            makenode(root,a[i]);
        }
        dem_node(root);
        cout << dem << endl;
    }
}