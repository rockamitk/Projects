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

struct StackArray{
			int capacity,top;
			tree **array;
			};
typedef struct StackArray stack;

tree *createTree(){
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
/*		Find a Node in Binary Tree		*/

	tree *findNode(tree **root,int data)
	{
		queue *Q;	
		tree *temp;

		if(!(*root)){
		return NULL;}
	
	   	Q=create();
	   	Enqueue(Q,*root);
	   	while(!(IsEmptyQueue(Q)))
	   	{
	   		temp=Dequeue(Q);
	   		if(temp->data == data)
	   		{deleteQueue(Q);
	   		return temp;
	   		}
	   		
	   		if(temp->left)
	   			Enqueue(Q,temp->left);

	   		if(temp->right)
	   			Enqueue(Q,temp->right);
	   	}
	   deleteQueue(Q);
	 return NULL;  	
	}

/*		Deepest Node in Binary Tree		*/
	tree *depthOfTree(tree **root)
	{
		queue *Q;	
		tree *temp,*temp1;

		if(!(*root)){
		return NULL;}
	
	   	Q=create();
	   	Enqueue(Q,*root);
	   	while(!(IsEmptyQueue(Q)))
	   	{
	   		temp=Dequeue(Q);
	   		if(temp->left)
	   			Enqueue(Q,temp->left);

	   		if(temp->right)
	   			Enqueue(Q,temp->right);
	   	}
	   deleteQueue(Q);
	 return temp;  	
	}
	
/*   Node Deletion Of Binary Tree        */
	int Delete(tree **root,int data)
	{
		tree *t1,*t2;
		
		if(IsEmptyTree(*root)){
			printf("Tree Empty !\n");
			return 0;
			}
			
		t1=findNode(root,data);
		t2=depthOfTree(root);
		
		if(t1 == NULL){
			printf("Not Exist Node : %d\n",data);
			return 0;
			}
			
		t1->data=t2->data;
		t1=t2;
		free(t2);
		return data;
	}


/*   Delete Entire Binary Tree        */
	void DeleteTree(tree *root)
	{
		if(root == NULL)
		return;
		
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
	


/* Method of traversal without recursion */

   void Preorder(tree *root)
   {
	stack *S=createStack();
	
	if(root)
	printf("\nPreOreder Traversal :");
	else
	printf("Tree Empty");

	while(1)
	{
	  while(root)
	  {
	  	printf("  %d ",root->data);
	  	Push(S,root);
	  	
	  	root=root->left;//if Left node exist
	  }
	  
	  if(IsEmptyStack(S))
	  break;
	  
	  root=Pop(S); //move
	  root=root->right;//if right node exist
	}
	deleteStack(S);
    }
    
    
   void Inorder(tree *root)
   {
	stack *S=createStack();
	if(root)
	printf("\nInOreder Traversal :");
	else
	printf("Tree Empty");
	
	while(1)
	{
	  while(root)
	  {
	  	Push(S,root);
	  	root=root->left;//if Left node exist
	  }
	  
	  if(IsEmptyStack(S))
	  break;
	  
	  root=Pop(S); //move
	  printf("  %d ",root->data);
	  root=root->right;//if right node exist
	}
	deleteStack(S);
    }


    void Postorder(tree *root)
    {
    	stack *S=createStack();

	if(root)
	printf("\nPostOreder Traversal :");
	else
	printf("Tree Empty");

    	while(1)
    	{
    		if(root != NULL)
    		{
    			Push(S,root);
    			root=root->left;
    		}
    		else
    		{
    		   if(IsEmptyStack(S)){
    		   return;
    		   }
    		   
    		   else
    		   if(Top(S) -> right == NULL){
    		   	root=Pop(S);
    		   	printf("   %d  ",root->data);
    		   	
    		   	if(root == Top(S) -> right){
    		   		printf("   %d  ",Top(S)->data);
    		   		Pop(S);
    		   	}
    		   }
    		   if(!IsEmptyStack(S))
    		   	root=Top(S)->right;
    		   	else
    		   	root=NULL;
    		   }
    	}
    	deleteStack(S);
    }

/*Level order data in reverse order*/

   void levelOrderReverse(tree *root)
   {
   	tree *temp;
	stack *S=createStack();
	if(!root)
	return;
	
	queue *Q=create();
	Enqueue(Q,root);
	while(!IsEmptyQueue(Q))
	{
	temp=Dequeue(Q);
		if(temp->right)
		Enqueue(Q,temp->right);
		
		if(temp->left)
		Enqueue(Q,temp->left);
		Push(S,temp);
	}
	printf("\nLevel Order Data in Reverse Order :");
	while(!IsEmptyStack(S))
	printf("  %d ",Pop(S)->data);
	
	deleteQueue(Q);
	deleteStack(S);
	return;
    }

/*	Mirror of tree		*/
	tree *mirrorOfTree(tree *root)
	{
		tree *temp;
		if(root)
		{
		mirrorOfTree(root->left);
		mirrorOfTree(root->right);
		temp=root->left;
		root->left=root->right;
		root->right=temp;
		
		}
	return root;	
	}

/*		Main Function of Binary tree		*/

int main()
{
	int ch,f,data;
	tree *root;
	root=createTree();
	
		    while(1){
	
	               printf("\n<1> Insert,  ");
	               printf("<2> Delete , ");
         	       printf("<3> Travese");
         	       printf("<4> Delete Tree, \n");
         	       printf("<5> Level ord in reverse, ");
         	       printf("<6> Mirrors Of Tree, ");
//         	       printf("<10>LevelOrder traversal\n");
         	       printf("<0>Exit, Choice: ");
         	       scanf("%d",&ch);

		switch(ch){
			case 1:
				printf("\tNode Value :");
				scanf("%d",&data);
				
				Insert(&root,data);
				break;
			case 2:
				printf("\tNode To Delete :");
				scanf("%d",&data);
				f=Delete(&root,data);
				if(f)
				printf("Deleted Node:%d\n",f);
				break;		
		case 3:
			
         	       printf("1. PreOrder, 2.InOrder,  3. PostOrder,  4. Print Tree Format,Choice:");
         	       scanf("%d",&ch);
			switch(ch)
			{
			case 1:
				Preorder(root);
				break;
			case 2:
				Inorder(root);
				break;
			case 3:
				Postorder(root);
				break;
			case 4:
				structure(root,0);
				break;
			default : printf("Wrong\n");
			}
			break;
			
			case 4:
				DeleteTree(root);
				root=createTree();
				break;
				
			case 5:
				levelOrderReverse(root);
				break;
			case 6:
				root=mirrorOfTree(root);
				break;
			case 7:
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

