//NMEC: 92968
//NOME: Sofia Teixeira Vaz
//
// Joaquim Madeira, AlgC, May 2020
// João Manuel Rodrigues, AlgC, May 2020
//
// Adapted from an old example (ca. 2003)
//
// Binary Search Tree storing pointers to items --- Simple Version
//

//// PROCURE ... E COMPLETE ////

#include "BSTree.h"

#include <assert.h>
#include <stdio.h>
#include <stdlib.h>

struct _BSTreeNode {
    void *item;
    struct _BSTreeNode *left;
    struct _BSTreeNode *right;
};

struct _BSTreeHeader {
    unsigned int numNodes;
    struct _BSTreeNode *root;
    compFunc compare;
    printFunc print;
};

BSTree *BSTreeCreate(compFunc compF, printFunc printF) {
    BSTree *t = (BSTree *) malloc(sizeof(struct _BSTreeHeader));
    assert(t != NULL);

    t->numNodes = 0;
    t->root = NULL;
    t->compare = compF;
    t->print = printF;
    return t;
}

static void _treeDestroy(struct _BSTreeNode **pRoot) {
    struct _BSTreeNode *root = *pRoot;

    if (root == NULL) return;

    _treeDestroy(&(root->left));
    _treeDestroy(&(root->right));
    free(root);

    *pRoot = NULL;
}
// Q: What kind of tree traversal is this function doing?
// Breadth-first or Depth-first?        A: Depth-first, uma vez que é eliminado, recursivamente,os nós da esquerda e os da direita, em vez de eliminar todos os que estão à mesma distância
// Pre-order, In-order or Post-order?   A: Post-order, uma vez que é eliminada a árvore esquerda, a árvore direita e a raíz
// Is this the best order here? Why?
// A: Esta seria a melhor ordem uma vez que todos os nós são apagados sem exigir a criação de variáveis temporárias e não haverá memory-leaks significativos
// (por exemplo, se se apagasse primeiro a raíz, depois a árvore esquerda e a direita, seria necessário guardar a árvore esquerda e direita em variáveis temporárias, uma vez
//que ficariam inacessíveis após free(root))

void BSTreeDestroy(BSTree **pHeader) {
    BSTree *header = *pHeader;
    if (header == NULL) return;

    _treeDestroy(&(header->root));

    free(header);

    *pHeader = NULL;
}

// FUNÇÕES DE CONSULTA

int BSTreeIsEmpty(const BSTree *header) {
    assert(header != NULL);
    return header->root == NULL;
}

unsigned int BSTreeGetNumberOfNodes(const BSTree *header) {
    assert(header != NULL);
    return header->numNodes;
}

// Determina a altura da (sub)árvore que nasce no nó root.
// (Função interna, que é usada por BSTreeGetHeight.)
static int _treeGetHeight(const struct _BSTreeNode *root) {
    // Complete a função
    if (root == NULL) return -1;
    int heightLeft = _treeGetHeight(root->left);
    int heightRight = _treeGetHeight(root->right);
    if (heightLeft > heightRight)
        return 1 + heightLeft;

    return 1 + heightRight;
}

// Devolve a altura da árvore.
// Segundo a convenção usada, uma árvore vazia tem altura=-1
// e uma árvore de um nó tem altura=0.
int BSTreeGetHeight(const BSTree *header) {
    assert(header != NULL);
    return _treeGetHeight(header->root);
}

// Acha e devolve o menor item da árvore.
// Requer que a árvore não esteja vazia!
void *BSTreeGetMin(const BSTree *header) {
    assert(header != NULL);
    assert(!BSTreeIsEmpty(header));

    // Complete a função com uma solução ITERATIVA.
    auto currentNode = header->root;
    while (currentNode->left !=
           NULL)    //while we have left elements, AKA smaller elements, we'll continue to the left part
        currentNode = currentNode->left;
    return currentNode->item;
}

// Acha e devolve o maior item da (sub)árvore que nasce no nó root.
// (Função interna invocada em BSTreeGetMax.)
static void *_treeGetMax(const struct _BSTreeNode *root) {
    assert(root != NULL);

    // Complete a função com uma solução RECURSIVA.
    if (root->right == NULL)  //if we don't have a right sub-tree then we know that this is the biggest element
        return root->item;
    return _treeGetMax(root->right);

}

// Acha e devolve o maior item da árvore.
// Requer que a árvore não esteja vazia!
void *BSTreeGetMax(const BSTree *header) {
    assert(header != NULL);
    assert(!BSTreeIsEmpty(header));

    return _treeGetMax(header->root);  // chama a função interna recursiva
}

// Does the tree contain an element that compares==0 with this item?
int BSTreeContains(const BSTree *header, const void *item) {
    assert(header != NULL);

    struct _BSTreeNode *root = header->root;
    while (root != NULL) {
        if (header->compare(root->item, item) == 0)
            return 1;
        if (header->compare(root->item, item) > 0)
            root = root->left;
        else
            root = root->right;
    }
    return 0;
}

// Aplica a função function a cada item da árvore.
// (Função interna usada em BSTreeTraverseINOrder.)
static void
_treeTraverseINOrder(struct _BSTreeNode *root, void (*function)(void *p)) {
    if (root == NULL) return;
    _treeTraverseINOrder(root->left, function);  //process leftmost (smaller) items
    function(root->item);   //process current items
    _treeTraverseINOrder(root->right, function);  //process rightmost (bigger) items

}

// Aplica a função function a cada item da árvore.
void BSTreeTraverseINOrder(BSTree *header, void (*function)(void *p)) {
    assert(header != NULL);
    _treeTraverseINOrder(header->root, function);
}

// Operations with items

// Acrescenta um item à árvore, se for válido.
// Devolve 1 (sucesso) se conseguir acrescentar o item 
// ou 0 (falha) se o item colide com algum que já esteja na árvore.
int BSTreeAdd(BSTree *header, void *item) {
    assert(header != NULL);

    struct _BSTreeNode *root = header->root;

    int cmp;  // to store comparison results
    struct _BSTreeNode *prev = NULL;
    struct _BSTreeNode *current = root;
    while (current != NULL) {
        cmp = header->compare(item, current->item);
        prev = current;
        if (cmp < 0) {
            current = current->left;
        } else if (cmp > 0) {
            current = current->right;
        } else {   // (cmp == 0)
            return 0;  // items that compare==0 are not allowed in this tree
        }
    }

    struct _BSTreeNode *newNode = (struct _BSTreeNode *) malloc(sizeof(*newNode));
    if (newNode == NULL) abort();
    newNode->item = item;
    newNode->left = newNode->right = NULL;

    // Complete a função fazendo a ancoragem do novo nó no ramo adequado.
    //current is the root of the new item, so, we'll add left if it's smaller or
    //add to right if it's larger

    if (header->root == NULL) {
        header->root = newNode;
        header->numNodes++;
        return 1;
    }//tree is empty

    if (header->compare(prev->item, item) > 0)
        prev->left = newNode;
    else
        prev->right = newNode;
    header->numNodes++;
    return 1;
}


static void _deleteNextNode(struct _BSTreeNode **pRoot, void **pItem) {
    if ((*pRoot)->left == NULL) {
        // FOUND IT
        struct _BSTreeNode *auxPointer = *pRoot;
        *pItem = auxPointer->item;
        *pRoot = auxPointer->right;
        free(auxPointer);
    } else {
        _deleteNextNode(&((*pRoot)->left), pItem);
    }
}

// This internal function removes the node pointed to by *pPointer.
// Note that pPointer is the address of a variable that points to the node
// to be removed. When it removes the node, it also sets that variable to NULL.
// That variable is either the root field of the _BSTreeHeader struct
// or the left or the right field of the parent _BSTreeNode struct.
// (Pointing to fields inside a struct is something you cannot do in Java.)
static void _removeNode(struct _BSTreeNode **pPointer) {
    struct _BSTreeNode *nodePointer = *pPointer;

    if ((nodePointer->left == NULL) && (nodePointer->right == NULL)) {
        /* A LEAF node */
        free(nodePointer); // FREE it and
        *pPointer = NULL;  // SET field in parent node (or header) to NULL
    } else if (nodePointer->left == NULL) {
        /* It has only a RIGHT sub-tree */
        *pPointer = nodePointer->right;
        free(nodePointer);
    } else if (nodePointer->right == NULL) {
        /* It has only a LEFT sub-tree */
        *pPointer = nodePointer->left;
        free(nodePointer);
    } else {
        /* Node has TWO CHILDREN */
        /* Replace its item with the item of the next node in-order */
        /* And remove that node */
        _deleteNextNode(&(nodePointer->right), &(nodePointer->item));
    }
}

static int _treeRemoveItem(struct _BSTreeNode **pRoot, const void *item,
                           compFunc compare) {
    struct _BSTreeNode *root = *pRoot;

    if (root == NULL) {
        return 0;
    }
    int cmp = compare(item, root->item);
    if (cmp < 0) {
        return _treeRemoveItem(&(root->left), item, compare);
    } else if (cmp > 0) {
        return _treeRemoveItem(&(root->right), item, compare);
    } else {  // (cmp == 0)
        _removeNode(pRoot);
        return 1;
    }
}

int BSTreeRemove(BSTree *header, const void *item) {
    assert(header != NULL);

    if (_treeRemoveItem(&(header->root), item, header->compare) == 1) {
        header->numNodes--;
        return 1;
    }
    return 0;
}

// Funções internas necessárias para as funções
// BSTreeGetKthItem e BSTreeRemoveKthItem.  Leia essas primeiro.

// Count and return the number of nodes of the (sub)tree at the given root.
static unsigned int _getNumNodes(const struct _BSTreeNode *root) {
    if (root == NULL) {
        return 0;
    }
    return 1 + _getNumNodes(root->left) + _getNumNodes(root->right);
}

// Procura e devolve o K-ésimo nó da árvore contado em-ordem.
static struct _BSTreeNode *
_getPointerToKthNode(struct _BSTreeNode *root, unsigned int k) {
    // Esta função está INCORRETA!
    // Teste o programa, encontre o erro e corrija-o.
    unsigned int numNodesLeftTree = _getNumNodes(root->left);

    if (k < numNodesLeftTree) {
        return _getPointerToKthNode(root->left, k);
    } else if (k > numNodesLeftTree) {  //<-- error was here!
        return _getPointerToKthNode(root->right, k - numNodesLeftTree - 1);
    } else {  // (k == numNodesLeftTree)
        return root;
    }
}
// Q: Admitindo que a árvore tem n nós e está equilibrada (balanced),
// qual é a complexidade computacional da função getPointerToKthNode?
// Justifique resumidamente como chegou ao resultado.
// R: A função getPointerToKthNode irá ser percorrida, no pior caso, tantas vezes
// quanta a altura da árvore. Uma árvore equilibrada tem altura log(n), logo, a
// complexidade computacional será logarítmica, isto é, o grau de complexidade da
// função pertence a O(log(n)).
//
// 
// Explique como poderia evitar a chamada a _getNumNodes nesta função.
// Q: O que seria preciso mudar na estrutura de dados?
// R: Se cada nó tivesse ao seu dispôr o número de itens abaixo dele, não seria
// necessário invocar a função. Para isso
//
// Q: E que funções teriam de ser modificadas?
// R: Seria necessário modificar duas funções, a de inserção e a de remoção.
//  Na de inserção seria necessário incrementar o número de nós abaixo dele
//  (NNA) sempre que se desce de nó (indo para a esquerda
// ou direita). Para a remoção, bastaria decrementar NNA sempre que se desce
// de nó.
//


// Devolve o K-ésimo item da árvore.
// Índice K=0 corresponde ao menor item, K=1 corresponde ao segundo menor,
// K=2 ao terceiro menor, etc.
// Exige que 0 <= k < Number of Nodes.
void *BSTreeGetKthItem(const BSTree *header, unsigned int k) {
    assert(header != NULL);
    assert(0 <= k && k < header->numNodes);

    struct _BSTreeNode *p = _getPointerToKthNode(header->root, k);
    return p->item;
}

// Remove e devolve o K-ésimo item da árvore.
// Índice K=0 corresponde ao menor item, K=1 corresponde ao segundo menor,
// K=2 ao terceiro menor, etc.
// Exige que 0 <= k < Number of Nodes.
void *BSTreeRemoveKthItem(BSTree *header, int k) {
    assert(header != NULL);
    assert(0 <= k && k < header->numNodes);

    struct _BSTreeNode *pNode = _getPointerToKthNode(header->root, k);
    void *pItem = pNode->item;
    BSTreeRemove(header, pItem);
    return pItem;
}
// A função BSTreeRemoveKthItem percorre os nós duas vezes:
// uma quando faz _getPointerToKthNode e outra quando chama BSTreeRemove.
// Q: Será que se poderia fazer de modo mais eficiente?
// Sugira resumidamente uma solução e explique os seus aspetos essenciais.
// R: Poder-se-ia percorrer a árvore até encontrar o elemento e, ao encontrar,
// eliminar esse elemento específico, não invocanto BSTTreeRemove. Ao
// eliminar o elemento também seria necessário diminuir a altura da árvore
//
// Em alternativa, pode implementar essa solução na função abaixo.

//void* BSTreeRemoveKthItem2(BSTree* header, int k) {
//   unsigned int numNodesLeftTree = _getNumNodes(root->left);
//
//    if (k < numNodesLeftTree) {
//        return  BSTreeRemoveKthItem2(root->left, k);
//    } else if (k > numNodesLeftTree) {  //<-- error was here!
//        return  BSTreeRemoveKthItem2(root->right, k - numNodesLeftTree - 1);
//    } else {  // (k == numNodesLeftTree)
//        _removeNode(pRoot);
//       header->numNodes--;
//       return 1;
//    }
//}


// Tree Visualization

static void _treeView(struct _BSTreeNode *root, int level,
                      const char *edge, printFunc print) {
    if (root == NULL) {
        printf("%*s%s\n", 4 * level, edge, "#");  // # represents NULL pointer
    } else {
        _treeView(root->left, level + 1, "/", print);
        printf("%*s", 4 * level, edge);
        print(root->item);
        printf("\n");
        _treeView(root->right, level + 1, "\\", print);
    }
}

void BSTreeView(BSTree *header) {
    _treeView(header->root, 0, ":", header->print);  // : marks the root
    printf("numNodes: %d\n", header->numNodes);
}
