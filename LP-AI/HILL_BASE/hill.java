import java.util.*;
class hill{
    static int graph[][]={
    {0,1,1,0,0,0,0,0}
    ,{1,0,0,1,1,1,0,0},{1,0,0,1,0,0,0,0}
    ,{0,1,1,0,0,0,0,0},{0,1,0,0,0,0,1,0},{0,1,0,0,0,0,1,0},
    {0,0,0,0,1,1,0,1},{0,0,0,0,0,0,1,0}};    
    static int huristic[]={540,63,50,85,19,4,10,0};
    static ArrayList<Node>open=new ArrayList<Node>();
    static ArrayList<Node>closed=new ArrayList<Node>();
    static Node current=null;
    static Node parent=null;
    static int SIZE=8;
    static int start=0;
    static int goal=7;
    public static void showGraph(){
        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }    
    }
    
    static boolean inList(Node x,ArrayList<Node> list){
        for(Node i:list){
            if(x.getName()==i.getName()) return true;
        }
        return false;
    }
    
    static void movegen(Node current){
        Node child=null;
        for(int i=0;i<SIZE;i++){
                    //System.out.println("GP node"+i);
                        if(graph[current.getName()][i]==1){
                            child=new Node(i,huristic[i]);
                            if(!inList(child,open)&&!inList(child,closed)){
                                child.setG(current.getG()+1);
                                child.setF(child.getG()+child.getH());
                                open.add(child);
                                
                            }
                    }
        }
        }
    
    static Node getBest(){
        Node best=open.get(0);        
        for(Node i:open){
            if(i.getF()<best.getF()){
                best=i;   
            }        
        }
        return best;
    }
    
    public static void main(String args[]){
                showGraph();
                System.out.println("Start");
                //boolean move=true;
                current=new Node(start,huristic[start]);
                current.setG(0);
               current.setF(0+huristic[start]);
                //parent=null;
                //Node child=null;
                while(current.getH()>0){
                    System.out.println("At node:"+current.getName()+" G:"+current.getG()+" H:"+current.getH()+" F:"+current.getF());
                    
                    if(current.getName()==goal){
                        System.out.println("Found goal");
                    }
                    
                    movegen(current);
                    closed.add(current); 
                    open.remove(current);                   
                    current=getBest();
                    
                  }
                  if(current.getName()==goal){
                    
                        System.out.println("Found goal :"+goal);
                  }
                  
               
    
    }
}
