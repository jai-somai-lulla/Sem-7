import java.util.*;
class EightPuzzle{
	static ArrayList<node> node_list = new ArrayList<node>();
	static ArrayList<node> open = new ArrayList<node>();
	static ArrayList<node> closed = new ArrayList<node>();
	//static int start_state[][]={{1,2,4},{3,0,6},{5,7,8}};
	static int start_state[][]={{4,5,6},{1,2,3},{7,0,8}};
	static int final_state[][]={{4,5,6},{1,2,3},{7,8,0}};
	
	public static void gen8puzzle(node state){
	System.out.println("In 8*");		
	    int position[]= get_blank(state);
	    int i=position[0];
            int j=position[1];		 
	    if(i==0&&j==0){
	    	makeright(i,j,state);
	    	makedown(i,j,state);
	    }
	    else if(i==0&&j==1){
	    	makeleft(i,j,state);
	    	makeright(i,j,state);
	    	makedown(i,j,state);
	    }
	    else if(i==0&&j==2){
	    	makeleft(i,j,state);
	    	makedown(i,j,state);
	    }
	    else if(i==1&&j==0){
	    	makeright(i,j,state);
	    	makeup(i,j,state);
	    	makedown(i,j,state);
	    }
	    else if(i==1&&j==1){
	    	makeleft(i,j,state);
	    	makeright(i,j,state);
	    	makedown(i,j,state);
	    	makeup(i,j,state);
	    }
	    else if(i==1&&j==2){
	    	makeleft(i,j,state);
	    	makedown(i,j,state);
	    	makeup(i,j,state);
	    }
	    else if(i==2&&j==0){
	    	makeright(i,j,state);
	    	makeup(i,j,state);
	    }
	    else if(i==2&&j==1){
	    
	    //System.out.println("In 21");
	    	makeleft(i,j,state);
	    	makeright(i,j,state);
	    	makeup(i,j,state);
	    }
	    else if(i==2&&j==2){
	    
	    System.out.println("In 22");
	    	makeleft(i,j,state);
	    	makeup(i,j,state);
	    }
	}
	
	public static node getopt(){
		node opt=null;
		if(!open.isEmpty())opt=open.get(0);
		else return null;
		for(node cur:open){
			if(calculate_huristic(opt)>calculate_huristic(cur)){
				opt=cur;
			}
		}
		return opt;
	}
	
	public static void closenode(node current){
	  //for(node temp:open){
		//  if(temp.getname()==current.getname()){
		     closed.add(current);
		     open.remove(current);	
		  //}	
		//}
	}
	
	public static boolean visted_before(node current){
	    boolean visit=false;  
	    	for(node temp:open){
		   if(compareState(current,temp)){visit=true;return visit;}
		}
		for(node temp:closed){
		   if(compareState(current,temp)){visit=true;return visit;}
		}
	return visit;
	}
	public static void makeleft(int i,int j,node parent){
		int state[][]=parent.getstate();
		int child[][]=new int[3][3];
		for(int k=0;k<3;k++){
		   for(int l=0;l<3;l++){
		   	child[k][l]=state[k][l];
		   }	 		
		}
		child[i][j]=child[i][j-1];
		child[i][j-1]=0;
		node temp=new node(child);
		if(!visted_before(temp)){
		System.out.println("Add left");
		//temp.show();
		temp.setparent(parent);
		open.add(temp);	
		}
	}
	public static void makeright(int i,int j,node parent){
		int state[][]=parent.getstate();
		int child[][]=new int[3][3];
		for(int k=0;k<3;k++){
		   for(int l=0;l<3;l++){
		   	child[k][l]=state[k][l];
		   }	 		
		}
		child[i][j]=child[i][j+1];
		child[i][j+1]=0;
		node temp=new node(child);
		if(!visted_before(temp)){
		//temp.show();
		 temp.setparent(parent);
		 open.add(temp);	
		}
	}
	public static void makeup(int i,int j,node parent){
		int state[][]=parent.getstate();
		int child[][]=new int[3][3];
		for(int k=0;k<3;k++){
		   for(int l=0;l<3;l++){
		   	child[k][l]=state[k][l];
		   }	 		
		}
		child[i][j]=child[i-1][j];
		child[i-1][j]=0;
		
	  	node temp=new node(child);
		if(!visted_before(temp)){
		//temp.show();
	   	 temp.setparent(parent);
	   	 open.add(temp);	
		}
	}
	public static void makedown(int i,int j,node parent){
		int state[][]=parent.getstate();
		int child[][]=new int[3][3];
		for(int k=0;k<3;k++){
		   for(int l=0;l<3;l++){
		   	child[k][l]=state[k][l];
		   }	 		
		}
		
		child[i][j]=child[i+1][j];
		child[i+1][j]=0;
		
	  	node temp=new node(child);
		if(!visted_before(temp)){
		//temp.show();
		temp.setparent(parent);
		open.add(temp);	
		}
	}
	
	
	public static boolean compareState(node an,node bn){
		boolean flag=true;
		int a[][]=an.getstate();
		int b[][]=bn.getstate();			

		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
			   if(a[i][j]!=b[i][j]){
				flag=false;
				break;
			  }	
			}	
		}
	return flag;
	}
	public static int calculate_huristic(node current){
		int h=0,f=0,g=0;
		 int state[][]=current.getstate();
		      for(int i=0;i<3;i++){
			  for(int j=0;j<3;j++){
				if(final_state[i][j]!=state[i][j]){
				  h++;	
				}		
			  }
			}
		g=(int)current.get_g();
		f=(int)g+h;	
			return f;
	}
	public static boolean isGoal(node current){
		int h=0;
		 int state[][]=current.getstate();
		      for(int i=0;i<3;i++){
			  for(int j=0;j<3;j++){
				if(final_state[i][j]!=state[i][j]){
				  h++;	
				}		
			  }
			}
		if(h==0)return true;
		else return false;
	}
	
	public static int[] get_blank(node an){
	int a[][]=an.getstate();
	 int position[]=new int [2];
	  for(int i=0;i<3;i++){
	   for(int j=0;j<3;j++){
			if(a[i][j]==0){
			position[0]=i;
			position[1]=j;			
	 		}
		}	
	   }
	   return position;	
	}
	
	public static void list_display(){
 			    System.out.println("Open List");
 			    for (node temp:open){
        		    System.out.print(temp.getname()+"->");
        		    }
        		    System.out.println();
        		    System.out.println("Closed List");
 			    for (node temp:closed){
        		    System.out.print(temp.getname()+"->");
        		    }
        		    System.out.println();
		} 

public static void traverse_parents(node cur){
		System.out.println("Parent Traversal :: \n");
		while(cur!=null){
			cur.show();
			cur=cur.getparent();
		}
		
		System.out.println("END Traversal :: \n");
	
	}



public static void best_first(){		
		//for(int i=0;i<v;i++){}
		//open.
		double f=0;
		double gp=0;
		double g=0;
		double h=0;
		node temp;
		node current=new node(start_state);  //node_list.get(start);
		//current.setvisit(true);
		System.out.println("Init");
		open.add(current);
		current.set_g(0);
		//list_display();
		while(!isGoal(current)&&!open.isEmpty()){
			System.out.println("---------------=---------------");
			System.out.print("Current ");
			current.show();	
			System.out.println();
			//node current=node_list.get(start);
                        temp=current;
                       
                        list_display();
			//make_children(current);
			gen8puzzle(current);	
			closenode(current);
			if(getopt()==null){break;}
			current=getopt();// move down the treee	 
			gp=current.getparent().get_g();
			//System.out.println("Parent name= "+current.getparent().getname()+" GP-->"+gp);
			
			//g=cost[current.getparent().getname()][current.getname()];
			g=1;

			current.set_g(g+gp);
			System.out.println("G-->"+g);
			h=calculate_huristic(current);//current.gethuristic();
			System.out.println("H-->"+h);
			f=h+g+gp;
			System.out.println("F-->"+f);
			//HILL Climbing LOC
			//if(current.gethuristic()>temp.gethuristic()){System.out.println("Stopped Climbing no better huristic ");break;}	
			//current.setparent(temp);	
		}
		
		 System.out.println("------OUT OF LOOP-----------");		
			list_display();	
		if(calculate_huristic(current)==0){
				System.out.println("Found Goal node!!!");
				current.show();
				traverse_parents(current);
			}
		else{
		System.out.println("Search Stopped Not found");
	        current.show();
		}	
	
	}
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		node temp=new node(start_state);
		//open.add(temp);
		//temp.show();
		//int pos []=get_blank(temp);
		//makeleft(pos[0],pos[1],temp);
		//makeright(pos[0],pos[1],temp);
		//makeup(pos[0],pos[1],temp);
		//makedown(pos[0],pos[1],temp);	
		//temp.show();
		
		//System.out.println(calculate_huristic(new node(final_state)));
		//System.out.println(compareState(new node(start_state),new node(start_state)));
		//System.out.println("Huristic");
		best_first();
	}
	
	

}
