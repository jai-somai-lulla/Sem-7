class node{
	static int nodecount=0;
	int name;
	int neighbours;
	boolean visit;
	//double huristic;
	node parent;
	//int adj[];
	//int adj[];
	int state[][];	
	int goal[][];
	double g;
	node(){
	
	}
	public node(int state[][]){
		this.name=nodecount;
		nodecount++;
		this.visit=false;
		this.parent=null;
		this.g=0;
		//this.goal=goal;
		//this.huristic=calculate_huristic();
		this.state=state;
		this.neighbours=neighbours;
	}

	public int calculate_huristic(){
		      int h=0;
		      for(int i=0;i<3;i++){
			  for(int j=0;j<3;j++){
				if(goal[i][j]!=state[i][j]){
				  h++;	
				}		
			  }
			}
			return h;
		}
	public void show(){
		if(parent==null){
		System.out.print("At  ["+name+"] ROOT G----> "+g+" ADJ-->  ");
		}
		else{
		System.out.print("At  ["+name+"] Parent ["+parent.getname()+"] G----> "+g+" State-->  ");
		}
		
		
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){	
			System.out.print(state[i][j]+" ");
			}	
		System.out.println("");
		}
		System.out.println("");
	}
	public void setparent(node parent){this.parent=parent;};
        public void setvisit(boolean visit){this.visit=visit;};
	public node getparent(){return parent;}
	public boolean getvisit(){return visit;}
	public int getname(){return name;}
	//public double gethuristic(){return huristic;}
	public int[][] getstate(){return state;};
        //public void sethuristic(double huristic){this.huristic= huristic;}
        public double get_g(){return g;}
        public void set_g(double g){this.g=g;}
}
