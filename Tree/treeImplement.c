#include<stdio.h>
#include<stdlib.h>

struct BinaryTree{
	struct BinaryTree *left,*right;
	int data;
	};
typedef struct BinaryTree tree;

struct Node {
	tree *root;
	struct Node *next;
	};
typedef struct Node node;

struct Queue {
	node *front;
	node *rear;
	};
typedef struct Queue queue;


tree *createTree(){
	tree *root;
	root=NULL;
	return root;
	}
/*Queue Operation Start*/	
	queue *create()
	{
		queue *Q;
		Q=malloc(sizeof(queue));
		
		if(!Q) return NULL;
		
		Q->front=Q->rear=NULL;
		
		return Q;
	}
	
	int IsEmptyQueue(queue *Q)
	{
		return (Q->front == NULL);
	}
	
	void Enqueue(queue *Q,tree *root)
	{
		node *newNode;
		newNode=(node*)malloc(sizeof(node));
		if(!newNode)
			return;
			
		newNode->root=root;
		newNode->next=NULL;
		
		if(Q->rear == NULL){
		Q->front=Q->rear=newNode;
		return;
		}
		
		Q->rear->next=newNode;
		Q->rear=newNode;
		printf(" inserted: %d",newNode->root->data);
		return;
		
	}
	
	tree *Dequeue(queue *Q)
	{
		node *temp;
		tree *T;
		
		/*if(IsEmptyQueue(Q)){
		printf("\tEmpty Queue\n");
		return NULL;
		}*/
		
		//else {
			temp=Q->front;
			T=Q->front->root;
			Q->front = Q->front->next;
			free(temp);
		  //   }
		  return T;
	}
	
	void deleteQueue(queue *Q){
	node *temp=Q->front,*p;
	
	while(temp != NULL){
		p=temp;
		temp=temp->next;
		free(p);
		}
	Q->front=Q->rear=NULL;
	return;
	}

	void Traverse(queue *Q){
		int i;
		node *temp=Q->front;
		
		if(IsEmptyQueue(Q))
		{
			printf("\tEmpty Queue  \n");
			return;
		}
		printf("\tQueue :");
		while(temp!= NULL) 
		{
			printf(" %d ",temp->root->data);
			temp=temp->next;
		}
		printf("\n");
		
		return;
	}


/*        Queue Operation Closed		*/
	
	int IsEmptyTree(tree *root)
	{	if(root->left==NULL && root->right==NULL)
		return 1;
		return 0;
				
	}
	tree *Insert(tree *root,int data)
	{
		queue *Q;	
		tree *temp,*Tnode,*ptr=root;
		Tnode=(tree*)malloc(sizeof(tree));
		Tnode->data=data;
		Tnode->left=Tnode->right=NULL;
		
		
		if(!root){
		root=Tnode;
		return root;
		}
	//temp=root;
	   Q=create();
	   Enqueue(Q,root);
	   Traverse(Q);
	   	while(!(IsEmptyQueue(Q)))
	   	{
	   		Traverse(Q);
	   		temp=Dequeue(Q);
	   		
	   		
	   		if(temp->left)
	   		{//printf(" left child %d",(temp->left)->data);
	   			temp=temp->left;	
	   			Enqueue(Q,temp);
	   			
	   		}
	   		else {
	   		temp->left=Tnode;
	   		deleteQueue(Q);
	   		return ptr;
	   		}
	   		
	   		if(temp->right){
	   		//printf(" right child %d",(temp->right)->data);				
	   			temp=temp->right;
	   			Enqueue(Q,temp);
	   			}
	   		else{
	   		temp->right=Tnode;
	   		deleteQueue(Q);
	   		return ptr;
	   		}
	   	}
	   	deleteQueue(Q);
	 return ptr;  	
	}

	int Delete(tree **root)
	{
	
	return 1;
	}

/* Method of Traversal Tree    */
	void Preorder(tree *root)
	{
		
		if(root)
		{
		printf("%d ",root->data);
		Preorder(root->left);
		Preorder(root->right);
		}
	return;
	}


	void Inorder(tree *root)
	{
		if(root)
		{
		Inorder(root->left);
		printf("%d ",root->data);
		Inorder(root->right);
		
		}
	return;
	}

	void Postorder(tree *root)
	{
		if(root)
		{
		Postorder(root->left);
		Postorder(root->right);
		printf("%d ",root->data);
		
		}
	return;
	}
/* Method of Traversal Tree    */


int main()
{
	int ch,f,data;
	tree *root;
	root=createTree();
	
		    while(1){
	
	               printf("\n<1> Insert,  ");
	               printf("<2> Delete , ");
         	       printf("<3> PreOrder\n");
	 	       printf("<4> InOrder,  ");
	 	       printf("<5> PostOrder,  ");
         	       //printf("<6> Delete Tree");
         	       printf("<7> Exit\n Choice: ");
         	       scanf("%d",&ch);

		switch(ch){
			case 1:
				printf("\tNode Value :");
				scanf("%d",&data);
				
				root=Insert(root,data);
				break;
			case 2:
				f=Delete(&root);
				if(f)
				printf("Deleted tree:%d\n",f);
				break;		
			case 3:
				Preorder(root);
				break;
			case 4:
				Inorder(root);
				break;
			case 5:
				Postorder(root);
				break;
		/*	case 6:
				Deletetree(root);
				break;
		*/		
			case 7:
				 exit(0);
				 break;
			default :
			printf("\tInvalid Choice\n");
			}
		}
	}

