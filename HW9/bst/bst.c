/*                                                      bst.c
 *
 * This example builds a binary search tree of words with their
 * frequencies and displays the tree.
 *
 */

#include "bst.h"
#include "math.h"

tNode *tAdd(tNode *p, char *w) {
    int cond;
    
    if (p == NULL) {
        p = tAlloc();
        p->word = strdup(w);
        p->count    = 1;
        p->left = NULL;
        p->right = NULL;
    }
    else if ((cond = strcmp(p->word, w)) == 0) {
        p->count++;
    }
    else if (cond < 0) {
        p->left = tAdd(p->left, w);
    }
    else {
        p->right = tAdd(p->right, w);
    }
    return p;
}


tNode *tAlloc(void) {
    return (tNode *)malloc(sizeof(tNode));
}


void tDisplay(tNode *p) {
    printf("\nIn display...\n");
    tDisplayAux(p, 0);
}
void tDisplayAux(tNode *p, int level) {
    if (p != NULL) {
        tDisplayAux(p->left, level + 1);
        int i;
        for (i = 0; i <= level; i++) {
            printf("  ");
        }
        printf("%4d %s\n", p->count, p->word);
        tDisplayAux(p->right, level + 1);
    }
}

int height(tNode *p) {
    if(p == NULL) {
        return 0;
    }
    if(height(p->left) > height(p->right)) {
        return 1+height(p->left);
    }
    else
        return 1+height(p->right);
    
}

boolean tBalanced(tNode *p) {

    int leftHeight = height(p->left);
    int rightHeight = height(p->right);
    
    if( abs(leftHeight-rightHeight) <= 1) {
        return 1;
    }
    
    return 0;
}

/* Already defined in string.h
 * I leave it here in case you would like to see.
 
 char *strdup(char *s) {
 char *p;
 
 p = (char *)malloc(strlen(s) + 1);  // +1 for '\0'
 if (p != NULL) {
 strcpy(p, s);
 }
 return p;
 }
 */

int main () {
    
    char *f1 = "apple";
    char *f2 = "pear";
    char *f3 = "orange";
    char *f4 = "kiwi";
    char *f5 = "watermelon";
    char *f6 = "olive";
    char *f7 = "grape";
    
    tNode *root = NULL;
    
    root = tAdd(root, f2);
    root = tAdd(root, f3);
    root = tAdd(root, f3);
    root = tAdd(root, f3);
    root = tAdd(root, f1);
    root = tAdd(root, f1);
    root = tAdd(root, f4);
    root = tAdd(root, f5);
    root = tAdd(root, f5);
    root = tAdd(root, f6);
    root = tAdd(root, f6);
    root = tAdd(root, f7);
    
    tDisplay(root);
    
    if (tBalanced(root)) {
        printf("Yes, the tree is balanced.\n");
    }
    else {
        printf("No, the tree is not balanced.\n");
    }
    
    return 0;
}




