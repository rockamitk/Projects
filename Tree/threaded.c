//prog to implement threaded binary tree
#include<stdio.h>
#include<stdlib.h>
struct tree{
	int data;
	struct tree *left;
	struct tree *right;
};
struct queue{
	int front;
	int rear;
	int capacity;
	struct tree **arr;
};
void enqueue(struct queue *q,struct tree *root){
	if(q_not_full(q)){
		if(q->front==-1)
			q->front++;
		q->rear++;
		q->arr[q->rear]=root;
		//printf("q rear=%d and arr[rear]=%d\n",q->rear,q->arr[q->rear]);
	}
	else
		printf("queue is full\n");
}
struct tree *dequeue(struct queue *q){
	struct tree *node;
	if(q_not_empty(q)){
		node=q->arr[q->front];
		if(q->front==q->rear)
			q->front=q->rear=-1;
		else
			q->front++;
	}	
		
			
	else 
		printf("queue is empty\n");
return node;
}
int q_not_full(struct queue *q){
		if(q->rear==q->capacity-1)
			return 0;
		else 
			return 1;
}
int q_not_empty(struct queue *q){
		if(q->rear==-1)
			return 0;
		else
			return 1;
}

struct queue *create_queue(){
	//queue space allocation
	struct queue *q=malloc(sizeof(struct queue));
	q->front=-1;
	q->rear=-1;
	q->capacity=5;
	q->arr=malloc(q->capacity*sizeof(struct tree));
	//queue allocation over.
return q;
}
struct tree *insert(struct tree *root,int data,struct queue *q){
	struct tree *temp=root;
	if(temp)
		printf("temp=%d",temp->data);
	struct tree *newnode=malloc(sizeof(struct tree));
	newnode->left=newnode->right=NULL;
	newnode->data=data;
	if(!root){
		//printf("root is null here\n");
		root=newnode;
		return root;
	}
	
	//printf("after q creation\n");
	enqueue(q,root);
	//printf("value has been enqueued\n");
	while(q_not_empty(q)){
		root=dequeue(q);
		//printf("deq done and val=%d\n",root->data);
		if(root->left){
			//printf("enq\n");
			enqueue(q,root->left);
			}
		else{
			////printf("else part\n");
			root->left=newnode;
			return temp;
		}
		if(root->right){
			enqueue(q,root->right);
			}
		else{
			root->right=newnode;
			return temp;
		}
	}

}


void show(struct tree *root){
	if(root){
		printf("%d\t",root->data);	
		show(root->left);
		show(root->right);
	}
}
main(){
	int choice;
	struct tree *root=NULL;
	 struct queue *q=create_queue();
	root=insert(root,13,q);
	//printf("root is=%u",root);
	//printf("first root returned=%d\n",root->data);
	root=insert(root,20,q);
//printf("first root returned=%d\n",root->data);
	root=insert(root,25,q);
//printf("first root left returned=%d\n",root->left->data);
	root=insert(root,10,q);
//printf("first root returned=%d\n",root->data);
	root=insert(root,22,q);
//printf("first root returned=%d\n",root->data);
	root=insert(root,15,q);
	root=insert(root,17,q);

	//printf("root left=%d and right=%d\n",root->left->data,root->right->data);
	do{
	printf("enter choice \n1.show\t2.delete\t3.quit\n");
	scanf("%d",&choice);
	switch(choice){
		case 1:
		show(root);
		break;
		//case 2:
		//delete(root);
		//break;
		case 3:
		break;
	}
	}while(choice!=3);
}
