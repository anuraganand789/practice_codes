#include<compare>
#include<cstdio>
class BinaryTree{
    struct TreeNode{
        int data;
	struct TreeNode * left;
	struct TreeNode * right;
	TreeNode(int const data){
	    this->data = data;
	    this->left = nullptr;
	    this->right = nullptr;
	}

	~TreeNode() { delete left; delete right; }
    };

    private: struct TreeNode * root;

    public: ~BinaryTree() { delete root; }
    public: BinaryTree(){}

    private:
    struct TreeNode * maxValueInTree(struct TreeNode * rootNode){
	struct TreeNode * iter = rootNode;
        while(iter && iter->right) iter = iter->right;
	return iter;
    }

    private:
    struct TreeNode * minValueInTree(struct TreeNode * rootNode){
        struct TreeNode * iter = rootNode;
	while(iter && iter->left) iter = iter->left;
	return iter;
    }

    private: 
    struct TreeNode * deleteANode(struct TreeNode * rootNode, int const data){
	if(rootNode){
	    struct TreeNode * nodeToBeDeleted = rootNode;
	    struct TreeNode * prevNode = nullptr;
	    while(nodeToBeDeleted && nodeToBeDeleted->data != data) {
		prevNode = nodeToBeDeleted;
	        nodeToBeDeleted = (nodeToBeDeleted->data > data) ? nodeToBeDeleted->left : nodeToBeDeleted->right;
	    }
	    if(nodeToBeDeleted){
	        //If Leaf node
	        if(!nodeToBeDeleted->left && !nodeToBeDeleted->right){
                    if(prevNode->left == nodeToBeDeleted){
                        prevNode->left = nullptr;
                    }else{
                        prevNode->right = nullptr;
                    }

         	    delete nodeToBeDeleted;
		    return nullptr;
	    	} 
		
	        struct TreeNode * replacer =  nullptr;
	        if(nodeToBeDeleted->left){
	            replacer = maxValueInTree(nodeToBeDeleted->left);
	            nodeToBeDeleted->data = replacer->data;
	    	    nodeToBeDeleted->left = deleteANode(nodeToBeDeleted->left, replacer->data);
	        }else {
	       	    replacer = minValueInTree(nodeToBeDeleted->right);
	            nodeToBeDeleted->data = replacer->data;
	       	    nodeToBeDeleted->right= deleteANode(nodeToBeDeleted->right, replacer->data);
	    	}
	    	
	    }
	}
        return rootNode;
    }
     
    public:
    bool remove(int const data){
        if(this->root){
	    this->root = deleteANode(this->root, data);
	    return true;
	}

	return false;
    }

    private:
    void inorder(struct TreeNode * const rootNode){
       if(rootNode){
           inorder(rootNode->left);
           printf("%d ", rootNode->data);
	   inorder(rootNode->right);
       }
    }

    public:
    void printInIncreasingOrder(){
        inorder(this->root);
    }

    private:
    void postorder(struct TreeNode * const rootNode){
        if(rootNode){
	    postorder(rootNode->right);
	    printf("%d ", rootNode->data);
	    postorder(rootNode->left);
	}
    }

    public:
    void printInDecreasingOrder(){
        postorder(this->root);
    }
    
    public: 
    void add(int const data){
        struct TreeNode * newNode = new TreeNode(data);
	if(root){
	    struct TreeNode * nodeIter = this->root;
            struct TreeNode * prevTreeNode = nullptr;

	    while(nodeIter){
	        prevTreeNode = nodeIter;
		nodeIter = nodeIter->data > data ? nodeIter->left : nodeIter->right;
	    }

	    if(prevTreeNode->data < data) 
	        prevTreeNode->right = newNode;
	    else 
	        prevTreeNode->left = newNode;
	    
	}

	this->root = newNode; 
    }


};
