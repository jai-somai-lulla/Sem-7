class Node{
    int name;
    int h;
    int g;
    int f;
    Node parent; 
    
    public Node(int name,int h){
        this.name=name;
        this.h=h;
    }
    
    public Node getParent(){return parent;}
    public void setParent(Node parent){this.parent=parent;}
    
    public int getName(){return name;}
    public int getH(){return h;}
    public int getG(){return g;}
    public void setG(int g){this.g=g;}
    public int getF(){return f;}
    public void setF(int f){this.f=f;}
}


