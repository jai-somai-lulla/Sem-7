import java.util.*;

class huristic{
	//static int graph[][] =new int [10][10];
	static int graph[][] ={{0,1,1,1,0,0,0},{1,0,1,0,1,0,0},{1,1,0,1,0,0,0},{1,0,1,0,0,1,0},{0,1,0,0,0,0,0},{0,0,0,1,0,0,1},{0,0,0,0,0,1,0}};
	static double huristic[] ={9,2,5,3,6,2,0};
	static double cost[][] ={{1,1,1,1,1,1,1},{1,1,1,1,1,1,1},{1,1,1,1,1,1,1},{1,1,1,1,1,1,1},{1,1,1,1,1,1,1},{1,1,1,1,1,1,1},{1,1,1,1,1,1,1}};
	//static double huristic[] =new double [10];
	//static int goal_grid[][] =new int [10][10];;
	//static int goal_grid[][]={{1,2,3},{8,0,4},{7,6,5}};
	static int goal;
	static int v;	
	//static node node_list[]=new node[10];
	//static node open[]=new node[10];
	//static node closed[]=new node[10];
	static ArrayList<node> node_list = new ArrayList<node>();
	static ArrayList<node> open = new ArrayList<node>();
	static ArrayList<node> closed = new ArrayList<node>();
	static int start;
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.println("Huristic");
		//System.out.println("Enter number of nodes");
		//v=scan.nextInt();
		v=7;	
		start=0;
		goal=6;
		
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
		for(int i=0;i<v;i++){
			node_list.add(new node(i,huristic[i],v,graph[i]));
			//if(v==goal){
			//node_list.get(goal).sethuristic(100);
			//}
			node_list.get(i).show();
		}
		
	  	node_list.get(goal).sethuristic(0);
		best_first();
		//display(); 
		//huristic_display();
	}
	
	public static node getopt(){
		node opt=null;
		if(!open.isEmpty())opt=open.get(0);
		else return null;
		for(node cur:open){
			if(opt.gethuristic()>cur.gethuristic()){
				opt=cur;
			}
		}
		return opt;
	}
	
	public static void make_children(node current){
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

		public static int get_huristic(node current){
			int h=0;
				
			return h;
		}
		public static void best_first(){		
		//for(int i=0;i<v;i++){}
		//open.
		double f=0;
		double gp=0;
		double g=0;
		double h=0;
		node temp;
		node current=node_list.get(start);
		current.setvisit(true);
		System.out.println("Init");
		open.add(current);
		current.set_g(0);
		//list_display();
		while(current.gethuristic()!=0&&!open.isEmpty()){
			System.out.println("---------------=---------------");
			System.out.print("Current ");
			current.show();	
			System.out.println();
			//node current=node_list.get(start);
                        temp=current;
                       
                        list_display();
			make_children(current);
			closenode(current);
			if(getopt()==null){break;}
			current=getopt();	
			 
			gp=current.getparent().get_g();
			//System.out.println("Parent name= "+current.getparent().getname()+" GP-->"+gp);
			
			g=cost[current.getparent().getname()][current.getname()];
			current.set_g(g+gp);
			System.out.println("G-->"+g);
			h=current.gethuristic();
			System.out.println("H-->"+h);
			f=h+g+gp;
			System.out.println("F-->"+f);
			//HILL Climbing LOC
			//if(current.gethuristic()>temp.gethuristic()){System.out.println("Stopped Climbing no better huristic ");break;}	
			//current.setparent(temp);	
		}
		
		 System.out.println("------OUT OF LOOP-----------");		
			list_display();	
		if(get_huristic(current)==0){
				System.out.println("Found Goal node!!!");
				current.show();
				traverse_parents(current);
			}
		else{
		System.out.println("Search Stopped Not found");
	        current.show();
		}	
	
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
            for (int i=1;i<=v;i++)
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
