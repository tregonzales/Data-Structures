/*                                                      bst.h
 *
 * This example builds a binary search tree of words with their
 * frequencies and displays the tree.
 *
 */

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define  true      1    // These three are not used in this program,
#define  false     0    // but maybe useful to keep around in case
#define  boolean   int  // we need them.

typedef struct tnode tNode;  // Note this way of defining a type.
// We saw another way before.
struct tnode {
    char *word;
    int count;
    tNode *left;
    tNode *right;
};

tNode *tAdd(tNode *, char *);
tNode *tAlloc(void);
void tDisplay(tNode *);
void tDisplayAux(tNode *, int);
boolean tBalanced(tNode *);