class node{
	static int nodecount=0;
	int name;
	int neighbours;
	boolean visit;
	node parent;
	int state[][]=new int[3][3];
	double g;
	int f;
	node(){
	
	}
	public node(int state1[][]){
		this.name=nodecount;
		nodecount++;
		this.visit=false;
		this.parent=null;
		this.g=0;
		for(int i=0;i<3;i++){
            	for(int j=0;j<3;j++){
            	  this.state[i][j]=state1[i][j];	
            	}
            } 
		this.neighbours=neighbours;
	}

	public void show(){
		if(parent==null){
		System.out.print("ID["+name+"] ROOT G:"+g+" F:"+f+"State:\n");
		}
		else{
		System.out.print("ID["+name+"] Parent["+parent.getname()+"] G:"+g+" F:"+f+" State:\n");
		}
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){	
			System.out.print(state[i][j]+" ");
			}	
		System.out.println("");
		}
		System.out.println("");
	}
	public int get_f(){return f;}
        public void set_f(int f){this.f=f;}
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
