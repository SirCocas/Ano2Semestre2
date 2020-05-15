//
// Joaquim Madeira, AlgC, April 2020
//
// Adapted from an old example (ca. 2003)
//
// Integers Binary Tree --- FIRST VERSION --- INCOMPLETE
//

#include "IntegersBinTree.h"

#include <assert.h>
#include <stdlib.h>

struct _TreeNode {
    ItemType item;
    struct _TreeNode *left;
    struct _TreeNode *right;
};

Tree *TreeCreate(void) {
    Tree *created = (Tree *) malloc(sizeof(ItemType) + sizeof(struct _TreeNode) * 2);
    return created;
}

void TreeDestroy(Tree **pRoot) {
    Tree *root = *pRoot;
    if (root == NULL) return;
    TreeDestroy(&(root->left));
    TreeDestroy(&(root->right));
    free(root);
    *pRoot = NULL;
}

int TreeIsEmpty(const Tree *root) {
    return root == NULL;
}

int TreeEquals(const Tree *root1, const Tree *root2) {
    if (root1 == NULL && root2 == NULL)
        return 1;
    if (root1 == NULL || root2 == NULL)
        return 0;
    if (root1->item != root2->item)
        return 0;
    return TreeEquals(root1->left, root2->left) && TreeEquals(root1->right, root2->right);
}

int TreeMirrors(const Tree *root1, const Tree *root2) {
    if (root1 == NULL && root2 == NULL)
        return 1;
    if (root1 == NULL || root2 == NULL) {
        return 0;
    }
    if (root1->item == root2->item) {
        return TreeMirrors(root1->left, root2->right) && TreeMirrors(root1->right, root2->left);
    }
    return 0;
}

int TreeGetNumberOfNodes(const Tree *root) {
    if (root == NULL)
        return 0;
    return 1 + TreeGetNumberOfNodes(root->left) + TreeGetNumberOfNodes(root->right);
}

int TreeGetHeight(const Tree *root) {
    if (root == NULL) return -1;
    int heightLeftSubTree = TreeGetHeight(root->left);
    int heightRightSubTree = TreeGetHeight(root->right);
    if (heightLeftSubTree > heightRightSubTree) {
        return 1 + heightLeftSubTree;
    }
    return 1 + heightRightSubTree;
}

void TreeTraverseInPREOrder(Tree *root, void (*function)(ItemType *p)) {
    if (root == NULL) return;
    function(&(root->item));
    TreeTraverseInPREOrder(root->left, function);
    TreeTraverseInPREOrder(root->right, function);
}

void TreeTraverseINOrder(Tree *root, void (*function)(ItemType *p)) {
    if (root == NULL) return;
    TreeTraverseINOrder(root->left, function);
    function(&(root->item));
    TreeTraverseINOrder(root->right, function);
}

void TreeTraverseInPOSTOrder(Tree *root, void (*function)(ItemType *p)) {
    // need a stack!
}

// ...

int TreeContains(const Tree *root, const ItemType item) {
    if (root == NULL) return 0;
    if (root->item == item)
        return 1;
    return (TreeContains(root->left, item) || TreeContains(root->right, item));
}

int TreeAdd(Tree **pRoot, const ItemType item) {
    if (TreeIsEmpty(pRoot)) {
        (*pRoot)->item = item;
        return 1;
    }
    if ((*pRoot)->left == NULL) {
        (*pRoot)->left->item = item;
        return 1;
    }
    if ((*pRoot)->right == NULL) {
        (*pRoot)->right->item = item;
        return 1;
    }
    return TreeAdd((*pRoot)->left, item);
}

int TreeRemove(Tree **pRoot, const ItemType item) {
    // ...
    return 0;
}

// ...

// JUST FOR RUNNING EXAMPLES - REMOVE FROM THE INTERFACE

Tree *createExampleTree(void) {
    // SHOULD NEVER BE DONE LIKE THIS !!!???!!!

    int numNodes = 8;

    Tree *nodes[numNodes];

    for (int i = 0; i < numNodes; i++) {
        nodes[i] = (Tree *) malloc(sizeof(Tree));
        nodes[i]->item = i + 1;
        nodes[i]->left = nodes[i]->right = NULL;
    }

    nodes[3]->left = nodes[7];

    nodes[1]->left = nodes[3];
    nodes[1]->right = nodes[4];

    nodes[2]->left = nodes[5];
    nodes[2]->right = nodes[6];

    nodes[0]->left = nodes[1];
    nodes[0]->right = nodes[2];

    return nodes[0];
}
