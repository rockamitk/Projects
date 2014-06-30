#include<stdio.h>
#include<stdlib.h>

struct BinaryTree{
	struct BinaryTree *left,*right;
	int data;
	};
	typedef struct BinaryTree tree;
	
struct arrQueue {
		int capacity;
		int front,rear;
		tree **array;
		};
typedef struct arrQueue queue;
	

struct StackArray
	{
		int capacity,top;
		tree **array;
	};
	typedef struct StackArray stack;

	tree *createTree()
	{
	tree *root;
	root=NULL;
	return root;
	}

/*          Queue Operation         */

	queue *create()
	{
		queue *Q=malloc(sizeof(queue));
			if(!Q) return NULL;
			
		Q->capacity=30;
		Q->front=Q->rear= -1;
		Q->array=malloc(Q->capacity*sizeof(tree));

			if(!Q->array) return NULL;
			
		return Q;
	}
	
	int IsEmptyQueue(queue *Q)
	{
	return ((Q->front == -1) || (Q->front == Q->rear+1));
	}
	
	void Enqueue(queue *Q,tree *root){
			Q->rear = (Q->rear + 1) % Q->capacity;
			
			Q->array[Q->rear]=root;
			if(Q->front == -1)
				Q->front = Q->rear;
		
	}
	
	tree *Dequeue(queue *Q){
			tree *t;
			t=Q->array[Q->front];
			if(Q->front == Q->rear)
				Q->front = Q->rear=-1;
			else
			Q->front = (Q->front + 1) % Q->capacity;
		return t;
	}
	
	void deleteQueue(queue *Q) {
		if(Q){
			if((Q)->array)
			free((Q)->array);
			free(Q);
		     }    
		} 


/*        Queue Operation Closed		*/


	int IsEmptyTree(tree *root)
	{
		return (root == NULL);
				
	}
	
	void Insert(tree **root,int data)
	{
		queue *Q;	
		tree *temp,*Tnode;
		Tnode=(tree*)malloc(sizeof(tree));
		Tnode->data=data;
		Tnode->left=Tnode->right=NULL;
		
		
		if(!(*root)){
		*root=Tnode;
		return;}
	
	   	Q=create();
	   	Enqueue(Q,*root);
	   	while(!(IsEmptyQueue(Q)))
	   	{
	   		temp=Dequeue(Q);
	   		if(temp->left)
	   		{
	   			Enqueue(Q,temp->left);
	   		}
	   		else {
	   		temp->left=Tnode;
	   		deleteQueue(Q);
	   		return ;
	   		}
	   		
	   		if(temp->right){
	   			Enqueue(Q,temp->right);
	   			}
	   		else{
	   		temp->right=Tnode;
	   		deleteQueue(Q);
	   		return;
	   		}
	   	}
	   	deleteQueue(Q);
	 return;  	
	}

	int DeleteTree(tree *root)
	{
		if(root == NULL)
		return 1;
		
		DeleteTree(root->left);
		DeleteTree(root->right);
		free(root);
		
	}
	
/* Stack Operation */

	stack *createStack()
	 {
			stack *S=malloc(sizeof(stack));
			if(!S)
				return NULL;
			S->capacity=10;
			S->top=-1;
			S->array=malloc(S->capacity * sizeof(tree));
			
			if(!S->array) return NULL;
		return S;
	}
	
	int IsEmptyStack(stack *S) {
	return (S->top == -1); 
	}

	tree *Top(stack *S) {
		if(IsEmptyStack(S))
			return NULL;
		return S->array[S->top];
		}

		
	void Push(stack *S,tree *root)
	 {
		S->array[++S -> top]=root;
	 }
	
	tree *Pop(stack *S) 
	{
		return S->array[S->top--];
	}
	
	void deleteStack(stack *S) {
		if(S){
			if(S->array) 
			free(S->array);
			free(S);
		     }
	}


/*       print   Horizontal tree Structure    */	

	void padding ( char ch, int n )
	{
	int i;
	for ( i = 0; i < n; i++ )
	putchar ( ch );
	}

	void structure ( tree *root, int level )
	{
		int i;
		if ( root == NULL ) {
		padding ( '\t', level );
		puts ( "NULL" );
	}
	else {
		structure ( root->right, level + 1 );
		padding ( '\t', level );
		printf ( "%d\n", root->data );
		structure ( root->left, level + 1 );
		}
	}

	int Search(int inOrder[],int inStrt,int inEnd,int data)
	{
		int i;
		for(i=inStrt;i<=inEnd;i++)
		{ if(inOrder[i] == data)
		  return i;
		}	
	}
	
	tree *BBT(int inOrder[],int preOrder[],int inStrt,int inEnd)
	{
		static int preIndex=0;
		tree *newNode;
		
		if(inStrt > inEnd) return NULL;
		
		newNode=malloc(sizeof(tree));
		
		newNode->data=preOrder[preIndex];
		preIndex++;
		
		if(inStrt == inEnd) //if node dnt hv any children
		return newNode;
		
		int inIndex=Search(inOrder,inStrt,inEnd,newNode->data);
		
		newNode->left=BBT(inOrder,preOrder,inStrt,inIndex-1);
		newNode->right=BBT(inOrder,preOrder,inIndex+1,inEnd);
		
		return newNode;
	}
		

	tree *BinaryPostBT(int inOrder[],int postOrder[],int inStrt,int inEnd)
	{
		static int postIndex=5;
		tree *newNode;
		
		if(inStrt > inEnd) return NULL;
		
		newNode=malloc(sizeof(tree));
		
		newNode->data=postOrder[postIndex];
		postIndex--;
		
		if(inStrt == inEnd) //if node dnt hv any children
		return newNode;
		
		int inIndex=Search(inOrder,inStrt,inEnd,newNode->data);
		
	newNode->right=BinaryPostBT(inOrder,postOrder,inIndex+1,inEnd);
	newNode->left=BinaryPostBT(inOrder,postOrder,inStrt,inIndex-1);
		
		return newNode;
	}

/*     Node Search */

	tree *searchNode(tree *root,int data)
	{
		if(root->data == data)
		return root;
		else 
		return NULL;
		searchNode(root->left,data);
		searchNode(root->right,data);
	}
		
		
/*		Ancestor Node */	
	int ancestor(tree *root,int data)
	{
		if(root == NULL)
		return 0;
		
	if(((root->left)->data == data) || ((root->right)->data == data)  || ancestor(root->left,data) || ancestor(root->right,data)){
		printf("   %d  ",root->data);
		return 1;
		}
		return 0;
	}

/*	Least Common  Ancestor  */	
	tree *LCA(tree *root,tree *a,tree *b)
	{	tree *left,*right;
	  
		if(root == NULL)
		return root;
		
	if(root == a || root == b)
	return root;

	left=LCA(root->left,a,b);
	right=LCA(root->right,a,b);
	if(left && right)
		return root;
	else return(left ? left :right);
	
	}
	
			

int main()
{
	int ch,f,data,i;
	tree *root;
	root=createTree();
	
	int inOrder[6],preOrder[6],postOrder[6];
	
		    while(1){
	
	               printf("\n<1> Insert,  ");
	               printf("<2>Contrcut tree (IO+Pre), ");
         	       printf("<3> Travese");
         	       printf("<4> Delete Tree, \n");
	               printf("<5>Contrcut tree (IO+Post), ");
	               printf("<6>Ancestor tree, \n");
	               printf("<7>Least Common Ancestor , ");
         	       printf("<0>Exit, Choice: ");
         	       scanf("%d",&ch);

		switch(ch){
			case 1:
				printf("\tNode Value :");
				scanf("%d",&data);
				
				Insert(&root,data);
				break;
			case 2:
				printf("Enter Inorder Series :");
				for(i=0;i<6;i++)
				scanf("%d",&inOrder[i]);
				
				printf("Enter PreOrder Series :");
				for(i=0;i<6;i++)
				scanf("%d",&preOrder[i]);

				root=BBT(inOrder,preOrder,0,5);
				break;		
			case 3:
				structure(root,0);
				break;
			case 4:
				f=DeleteTree(root);
				if(f) printf("\tTree Deleted\n");
				root=createTree();
				break;
				
			case 5:
				printf("Enter Inorder Series :");
				for(i=0;i<6;i++)
				scanf("%d",&inOrder[i]);
				
				printf("Enter PostOrder Series :");
				for(i=0;i<6;i++)
				scanf("%d",&postOrder[i]);

			root=BinaryPostBT(inOrder,postOrder,0,5);
			break;
			case 6:
				printf("\tEntre node :");
				scanf("%d",&data);
				
				printf("Ancestor of node %d :",data);
				//tree *node=searchNode(root,data);
				ancestor(root,data);
				break;
			case 7:
				printf("\tEntre node :");
				scanf("%d %d",&data,&f);
				
				tree *a=searchNode(root,data);
				tree *b=searchNode(root,f);
				a=LCA(root,a,b);
				if(a)
				printf("\nLCA : %d",a->data);
				break;
			case 0:
				 DeleteTree(root);
				 exit(0);
				 break;
			default :
			printf("\tInvalid Choice\n");
			}
		}
	}

