import java.util.*;

class huristic{
	//static int graph[][] =new int [10][10];
	//static int graph[][] ={{0,1,1,1,0,0,0},{1,0,1,0,1,0,0},{1,1,0,1,0,0,0},{1,0,1,0,0,1,0},{0,1,0,0,0,0,0},{0,0,0,1,0,0,1},{0,0,0,0,0,1,0}};
	//static double huristic[] ={9,2,5,3,6,2,0};
	//static double cost[][] ={{1,1,1,1,1,1,1},{1,1,1,1,1,1,1},{1,1,1,1,1,1,1},{1,1,1,1,1,1,1},{1,1,1,1,1,1,1},{1,1,1,1,1,1,1},{1,1,1,1,1,1,1}};
	//static double huristic[] =new double [10];
	//static int goal_grid[][] =new int [10][10];;
	//static int goal_grid[][]={{1,2,3},{8,0,4},{7,6,5}};
	static int goal;
	static int v;	
	//static int transit[][]=new int [3][3];
	//static node node_list[]=new node[10];
	//static node open[]=new node[10];
	//static node closed[]=new node[10];
	static ArrayList<node> node_list = new ArrayList<node>();
	static ArrayList<node> open = new ArrayList<node>();
	static ArrayList<node> closed = new ArrayList<node>();
	//static int start;
	static int start_state[][]={{1,2,3},{4,5,6},{7,8,0}};
	static int final_state[][]={{4,5,6},{1,2,3},{7,8,0}};
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.println("Huristic");
		//System.out.println("Enter number of nodes");
		//v=scan.nextInt();
		//v=7;	
		//start=0;
		//goal=6;
		
		//MAKING THE GRAPH
		/*for(int i=0;i<v;i++){
		   huristic[i]=Math.floor((Math.random()*10))+1;		
		  for(int j=0;j<=i;j++)
		  if(Math.random()<0.3&&i!=j){
			graph[i][j]=1;
			graph[j][i]=1;	
			//System.out.println(graph[i][j]);
		  }
		  else{
			graph[i][j]=0;
			graph[j][i]=0;
			//System.out.println(graph[i][j]);
			}		
		//-------------------------------------------
					
		}
		*/
		//for(int i=0;i<v;i++){
			//node_list.add(new node(i,huristic[i],v,graph[i]));
			//if(v==goal){
			//node_list.get(goal).sethuristic(100);
			//}
			//node_list.get(i).show();
		//}
		
	  	//node_list.get(goal).sethuristic(0);
		best_first();
		//display(); 
		//huristic_display();
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
	
	/*public static void make_children(node current){
	        //int arr[]=new int[v];
	        int arr[]=current.getadj();
		for(int i=0;i<v;i++){
		  if(arr[i]==1&&node_list.get(i).getvisit()==false){
		       // System.out.println("OPENED :"+node_list.get(i).getname());           
		     	open.add(node_list.get(i));
		     	node_list.get(i).setvisit(true);
		     	node_list.get(i).setparent(current);
		  }	
		}
	}*/
	
	public static void makeleft(int i,int j,int state[][]){
		//int temp_state[][]=state[][];
		state[i][j]=state[i][j-1];
		state[i][j-1]=0;
		
	    System.out.println("In makeLeft");
		node temp=new node(state);
		if(!visted_before(temp)){
	    System.out.println("add left");
		   open.add(temp);	
		}
	}
	public static void makeright(int i,int j,int state[][]){
		state[i][j]=state[i][j+1];
		state[i][j+1]=0;
		node temp=new node(state);
		if(!visted_before(temp)){
		   open.add(temp);	
		}
	}
	public static void makeup(int i,int j,int state[][]){
		state[i][j]=state[i-1][j];
		state[i-1][j]=0;
		node temp=new node(state);
		
	    System.out.println("In Makup");
		if(!visted_before(temp)){
		   open.add(temp);	
		}
	}
	public static void makedown(int i,int j,int state[][]){
		state[i][j]=state[i+1][j];
		state[i+1][j]=0;
		node temp=new node(state);
		if(!visted_before(temp)){
		   open.add(temp);	
		}
	}

	public static void gen8puzzle(node current){
	System.out.println("In 8*");		
	    int position[]= get_blank(current);
	    int i=position[0];
            int j=position[1];		 
            int state[][]=current.getstate();
            int temp[][];
            
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

	public static boolean visted_before(node current){
	    boolean visit=false;
	    
	    System.out.println("In Visit Before Comapre state ");
	    System.out.println("Current");
	    current.show();
	    System.out.println("From open");
	    open.get(0).show();
	    
	    	for(node temp:open){
		   if(compareState(current,temp)){visit=true;return visit;}
		}
		for(node temp:closed){
		   if(compareState(current,temp)){visit=true;return visit;}
		}
	return visit;
	}
	
	public static void closenode(node current){
	  //for(node temp:open){
		//  if(temp.getname()==current.getname()){
		     closed.add(current);
		     open.remove(current);	
		  //}	
		//}
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
		while(calculate_huristic(current)!=0&&!open.isEmpty()){
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

	public static int calculate_huristic(node current){
		int h=0;
		 int state[][]=current.getstate();
		      for(int i=0;i<3;i++){
			  for(int j=0;j<3;j++){
				if(final_state[i][j]!=state[i][j]){
				  h++;	
				}		
			  }
			}
			return h;
	}
	
	public static void traverse_parents(node cur){
		System.out.println("Parent Traversal :: \n");
		while(cur!=null){
			cur.show();
			cur=cur.getparent();
		}
		
		System.out.println("END Traversal :: \n");
	
	}


	/*public static void display(){
	    System.out.println("The adjacency matrix for the given graph is: ");
            System.out.print("  ");
            for (int i=1;i<=v;i++)x
            System.out.print(i + " ");
            System.out.println();
            for (int i = 1; i <= v; i++) 
            {
		System.out.print(i + " ");
                for (int j = 1; j <= v; j++) 
                System.out.print(graph[i][j] + " ");
                System.out.println();
            }
	}
	public static void huristic_display(){
 	    for (int i=0;i<v;i++)
            System.out.print( huristic[i] + "\n");
	} */

}
