class node{
	int name;
	int neighbours;
	boolean visit;
	double huristic;
	node parent;
	//int adj[];
	int grid[][];
	
	node(){
	
	}
	public node(int name,double huristic,int neighbours,int grid[][]){
		this.name=name;
		this.visit=false;
		this.parent=null;
		this.huristic=huristic;
		//this.adj=adj;
		this.grid=grid;
		this.neighbours=neighbours;
	}
	public void show(){
		/*System.out.print("At  "+name+" Huristic "+huristic+" ADJ-->  ");
		for(int i=0;i<neighbours;i++){
			System.out.print(adj[i]+" ");
		}
		System.out.println("");*/
		 for(int i=0;i<3;i++){
 	    		for(int j=0;j<3;j++){
 	    	  	 System.out.println(" "+gr[i][j]);	
 	    		}
 	    	}
	}
	public void setparent(node parent){this.parent=parent;};
        public void setvisit(boolean visit){this.visit=visit;};
	public node getparent(){return parent;}
	public boolean getvisit(){return visit;}
	public int getname(){return name;}
	public double gethuristic(){return huristic;}
	//public int[] getadj(){return adj;};
	public int[][] getgrid(){return grid;};
        public void sethuristic(double huristic){this.huristic= huristic;}
}
