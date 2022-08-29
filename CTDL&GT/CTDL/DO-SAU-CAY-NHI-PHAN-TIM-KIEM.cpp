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
vector<int> a;
void do_cao(node *&root, int docao){
    if(root->left==NULL&&root->right==NULL) a.push_back(docao);
    else {
        if(root->left!=NULL) do_cao(root->left,docao+1);
        if(root->right!=NULL) do_cao(root->right,docao+1);
    }
}
main(){
    int t; cin>>t;
    while(t--){
        a.clear();
        int n; cin>>n;
        int b[n+5];
        for(int i=0;i<n;i++) cin>>b[i];
        node *root=NULL;
        for(int i=0;i<n;i++){
            dung_cay(root,b[i]);
        }
        do_cao(root,0);
        sort(a.begin(),a.end());
        cout << a[a.size()-1] << endl;
    }
}