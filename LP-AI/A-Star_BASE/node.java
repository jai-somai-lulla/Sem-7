class node{
	int name;
	int neighbours;
	boolean visit;
	int huristic;
	node parent;
	//int adj[];
	int adj[];
	int g;
	int f;
	node(){
	
	}
	public node(int name,int huristic,int neighbours,int adj[]){
		this.name=name;
		this.visit=false;
		this.parent=null;
		this.g=0;
		this.huristic=huristic;
		this.adj=adj;
		this.neighbours=neighbours;
	}
	public void show(){
		if(parent==null){
		System.out.print("At  ["+name+"] ROOT G----> "+g+" ADJ-->  ");
		}
		else{
		System.out.print("At  ["+name+"] Parent ["+parent.getname()+"] G----> "+g+" ADJ-->  ");
		}
		
		
		for(int i=0;i<neighbours;i++){
			System.out.print(adj[i]+" ");
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
	public int gethuristic(){return huristic;}
	public int[] getadj(){return adj;};
        public void sethuristic(int huristic){this.huristic= huristic;}
        public int get_g(){return g;}
        public void set_g(int g){this.g=g;}
}
