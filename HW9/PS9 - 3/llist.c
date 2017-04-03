/*
 * A demo linked list implemenation
 */

#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

/*** Struct/typedef's below are usually in a .h file ***/

/* Internal node struct */
struct LNode {
    int element;
    struct LNode *next;
};
typedef struct LNode Node_t;

/* Public linked list struct */
typedef struct LinkedListC {
    Node_t *root;
    int size;
} LinkedList_t;

/*** Struct/typedef's above are usually in a .h file ***/

/*
 * Internal function to allocate memory for a node
 * (static functions are only visible in the file they are defined in)
 *
 * Returns a pointer to an initialized node
 */
static Node_t* newNode(int el) {
    Node_t *pNewNode = (Node_t *)malloc(sizeof(Node_t));
    assert(pNewNode != NULL);
    pNewNode->element = el;
    pNewNode->next = NULL;
    return pNewNode;
}

/*
 * Create a new linked list structure (with a dummy element)
 *
 * Returns a pointer to the linked list struct
 */
LinkedList_t* newLinkedList() {
    LinkedList_t *newLL = (LinkedList_t *)malloc(sizeof(LinkedList_t));
    assert(newLL != NULL);
    newLL->root = newNode(0);  // Dummy element
    newLL->size = 0;
    return newLL;
}

/*
 * Add to the head of the given linked list
 */
void addToHead(LinkedList_t *pLList, int el) {
    assert(pLList != NULL);
    assert(el != 0);      // Do not allow 0 (somewhat arbitrary)
    
    Node_t* pNewNode = newNode(el);
    pNewNode->next = pLList->root->next;  // Point to old head node
    pLList->root->next = pNewNode;        // Point to new head node
    pLList->size++;
}

/*
 * Add to the tail of the given linked list
 */
void addToTail(LinkedList_t *pLList, int el) {
    assert(pLList != NULL);
    assert(el != 0);      // Do not allow 0 (somewhat arbitrary)
    
    Node_t* currNode = pLList->root->next;
    Node_t* pNewNode = newNode(el);
    
    if(currNode!=NULL) {
    while(currNode->next!=NULL) {
        
        currNode = currNode->next;
        }
        currNode->next=pNewNode;
    }
    
    else {
        pLList->root->next=pNewNode;
    }
    pLList->size++;
}

/*
 * Get the size of the given linked list
 */
int getSize(LinkedList_t *pLList) {
    assert(pLList != NULL);
    return pLList->size;
}

/*
 * Find the size of the given linked list by traversing the list
 */
int findSize(LinkedList_t *pLList) {
    assert(pLList != NULL);
    int count=0;
    Node_t* currNode = pLList->root->next;
    
    if(currNode!=NULL) {
        count++;
    while(currNode->next!=NULL) {
        count++;
        currNode = currNode->next;
    }
    }
    return count;
    }
    


/*
 * Internal function to advance to given index n
 *
 * Returns a pointer to the node at index n
 */

static Node_t* nodeAtIndex(LinkedList_t *pLList, int n) {
    
    /* TODO:  your code here */
    Node_t* currNode = pLList->root->next;
    for(int i=0; i<=n; i++) {
        if(i==n) {
            return currNode;
        }
        else if(currNode->next==NULL) {
            return NULL;
        }
        else {
            currNode = currNode->next;
        }
    }
    return NULL;
}

/*
 * Get element at a given index n
 *
 * Returns 0 if error
 */
int getIndex(LinkedList_t *pLList, int n) {
    assert(pLList != NULL);
    
    /* Check for valid index */
    if (n > pLList->size || n < 0) return 0;
    
    Node_t *pCurrent = nodeAtIndex(pLList, n);
    return pCurrent->element;
}

/*
 * Remove element at given index n
 *
 * Returns 0 if error
 */
int removeIndex(LinkedList_t *pLList, int n) {
    assert(pLList != NULL);
    
    /* Check for valid index */
    if (n > pLList->size || n < 0) return 0;
    
    /* TODO:  your code here */
    Node_t* currNode = pLList->root->next;
    

    if(n==0 && pLList->size==1) {
        pLList->root->next=NULL;
        pLList->size--;
        return currNode->element;
        
    }
    else if(n==0) {
        pLList->root->next=pLList->root->next->next;
        pLList->size--;
        return currNode->element;
    }
    else {
        for(int i=0; i<=n; i++) {
            if(i==n-1 && currNode->next->next==NULL) {
                int x=currNode->next->element;
                currNode->next=NULL;
                pLList->size--;
                return x;
            }
            else if(i==n-1) {
                int x=currNode->next->element;
                currNode->next=currNode->next->next;
                pLList->size--;
                return x;
            }
         
                        else {
                currNode = currNode->next;
            }
            
    }
    }
    return -1;
}

/*
 * Clear the linked list of all nodes freeing node memory as it goes.
 * Linked list must still be useable after it's cleared.
 */
void clearList(LinkedList_t *pLList) {
    assert(pLList != NULL);
    
    /* TODO:  your code here */
        while(pLList->size!=0) {
        removeIndex(pLList, 0);
    }
}

/*
 * Print the contents of the list
 */
void printList(LinkedList_t *pLList) {
    Node_t* pCurrent = pLList->root->next;
    printf("List elements: ");
    while (pCurrent) {
        printf("%d, ", pCurrent->element);
        pCurrent = pCurrent->next;
    }
    printf("\n");
}

/*
 * Test the implementation
 */

int main() {
    
    LinkedList_t *pList;
    pList = newLinkedList();
    
    setbuf(stdout,0);  // Turn off buffering of stdout for Eclipse
    
    /* Get the size */
    printf("size should be 0\n");
    printf("get size: %d,  find size = %d\n", getSize(pList), findSize(pList));
    
    printf("Adding to the list...\n");
    int i;
    for (i = 1; i < 10; i++) {
        addToTail(pList, i);
    }
    addToHead(pList,99);
    printList(pList);
    
    printf("size should be 10\n");
    printf("get size: %d,  find size = %d\n", getSize(pList), findSize(pList));
    
    printList(pList);
    
    /* Test get */
    int val = getIndex(pList, 0);
    printf("getting index 0, should get 99, got: %d\n", val);
    val = getIndex(pList, 5);
    printf("getting index 5, should get 5, got: %d\n", val);
    val = getIndex(pList, 9);
    printf("getting index 9, should get 9, got: %d\n", val);
    
    /* Test remove */
    val = removeIndex(pList,0);
    printf("removing index 0, should get 99, got: %d\n", val);
    printf("  99 should not be in the list below\n");
    printList(pList);
    
    val = removeIndex(pList,3);
    printf("removing index 3, should get 4, got: %d\n", val);
    printf("  4 should not be in the list below\n");
    printList(pList);
    
    val = removeIndex(pList,7);
    printf("removing index 7, should get 9, got: %d\n", val);
    printf("  9 should not be in the list below\n");
    printList(pList);
    
    printf("size should be 7\n");
    printf("get size: %d,  find size = %d\n", getSize(pList), findSize(pList));
    
    /* Test clear */
    clearList(pList);
    
    printf("size should be 0\n");
    printf("get size: %d,  find size = %d\n", getSize(pList), findSize(pList));
    
    /* Finally add 3 more */
    printf("Adding 3 more elements...\n");
    addToHead(pList, 10);
    addToHead(pList, 20);
    addToHead(pList, 30);
    
    printf("size should be 3\n");
    printf("get size: %d,  find size = %d\n", getSize(pList), findSize(pList));
    
    printf("list should contain:  30, 20, 10\n");
    printList(pList);
    
    return 0;
}