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
	return ((Q->front == -1) || (Q->front == (Q->rear+1)));
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
	void Traverse(queue *Q){
		int i;
		printf("\tQueue :");
		for(i=Q->front;i <= Q->rear;i++ )
		{
			if(Q->array[i])
			printf(" %d ",(Q->array[i])->data);
			else 
			printf(" NULL  ");
		}
		printf("\n");
		
		return;
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
	
/* Method of Traversal Tree    */

	void Preorder(tree *root)
	{
		
		if(root)
		{
		printf("  %d  ",root->data);
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
		printf("  %d  ",root->data);
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
		printf("  %d  ",root->data);
		
		}
	return;
	}
	int LevelOrderTraverse(tree *root)
	{ int count=0;
		queue *Q;	
		tree *temp;

		if(!root){
		return 0;}
	
	   	Q=create();
	   	Enqueue(Q,root);
		Enqueue(Q,NULL);

	   	while(!(IsEmptyQueue(Q)))
	   	{
	   		temp=Dequeue(Q);
			if(temp){
			printf("%d\t",temp->data);
			count++;
			}
			
	   		//completion of current Level
	   		if(temp == NULL)
	   		{
	   			if(!IsEmptyQueue(Q)){
	   			Enqueue(Q,NULL);
	   			printf("\n");
	   			}
	   		}
	   		else
	   		{
	   		if(temp->left)
	   			Enqueue(Q,temp->left);

	   		if(temp->right)
	   			Enqueue(Q,temp->right);
	   		}
	   	}
	   deleteQueue(Q);
	 return count;  	
	}

/* Method of Traversal Tree closed    */

/* Differents Operations */

	int findMaxValue(tree *root)
	{
	int root_val,left,right,max;
	if(root != NULL){
	root_val=root->data;
	
	left=findMaxValue(root->left);
	right=findMaxValue(root->right);
	
	if(left > right)
	max=left;
	else
	max=right;
	
	if(root_val > max)
	max=root_val;
	return max;
	}
	}
	
	int sizeOfBinary(tree *root)
	{
		if(root == NULL)
		return 0;
	return (sizeOfBinary(root->left) + 1 + sizeOfBinary(root->right));
	}
	

	int heightOfBinary(tree *root)
	{ 	
		int level=1;
		queue *Q;	
		
		if(!root){
		return 0;}
	
	   	Q=create();
	   	Enqueue(Q,root);
	   	//End Of first Level
	   	Enqueue(Q,NULL);
	   	
	   	while(!(IsEmptyQueue(Q)))
	   	{
	   		root=Dequeue(Q);
			
	   		//completion of current Level
	   		if(root == NULL)
	   		{
	   			if(!IsEmptyQueue(Q)){
	   			Enqueue(Q,NULL);
	   			level++;
	   			}
	   		}
	   		else
	   		{
	   		if(root->left)
	   			Enqueue(Q,root->left);
			
	   		if(root->right){
	   			Enqueue(Q,root->right);
		   		}
	   		}
	   	}
	   	deleteQueue(Q);
	 return level;  	
	}
	
/* Height ? depth Of tree Using Recursive Function */	

	int depthOfBinary(tree *root)
	{
		 int l,r;
		if(root = NULL)
		return 0;
		
		else
		{
			l=depthOfBinary(root->left);
			r=depthOfBinary(root->right);
		
		if(l > r)
		return(l +1);
		else
		return(r +1);
		}

	}	
/*		Main Function of Binary tree		*/
int main()
{
	int ch,f,data;
	tree *root;
	root=createTree();
	
	queue *Q;
	Q=create();
	
		    while(1){
	
	               printf("\n<1> Insert,  ");
	               printf("<2> Delete , ");
         	       printf("<3> PreOrder,  ");
	 	       printf("<4> InOrder, \n");
	 	       printf("<5> PostOrder,");
         	       printf("<6> Delete Tree");
         	       printf("<7> Height/Depth of tree, \n ");
         	       printf("<8> Maximum Node, ");
         	       printf("<9> Total Nodes Of Tree, ");
         	       printf("<10>LevelOrder traversal\n");
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
				Preorder(root);
				break;
			case 4:
				Inorder(root);
				break;
			case 5:
				Postorder(root);
				break;
			case 6:
				DeleteTree(root);
				root=createTree();
				break;
			case 7:
				f=heightOfBinary(root);
			printf("\n(Non-recursive)Height/Depth OfBinary : %d\n",f);
		//		f=depthOfBinary(root);
		//	printf("(Recursive)Height/Depth OfBinary : %d\n",f);
				break;
				
			case 8:
				f=findMaxValue(root);
				printf("Maximum Value OfBinary : %d\n",f);
				break;
			case 9:
				f=sizeOfBinary(root);
				printf("Number of Nodes: %d\n",f);
				break;
			case 10:
				printf("\n");
				f=LevelOrderTraverse(root);
			printf("\n\nNumber of Nodes : %d\n",f);
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

