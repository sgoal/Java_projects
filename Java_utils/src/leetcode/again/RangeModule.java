package leetcode.again;

class IntervalNode{
	int left, right;
	int max,min;
}
//A[1,N],left->[1,(1+N)/2]
class IntervalTree{
	IntervalNode nodes[];
	int data[];
	IntervalTree(int[] datas){
		nodes = new IntervalNode[4*datas.length];
		data = datas;
	}
	//[l,r]
	void build(int root,int l,int r) {
		nodes[root].left=l;
		nodes[root].right=r;
		if(l==r) {
			nodes[root].max=nodes[root].min=data[l];
		}
		
	}
	
	
}

// TODO
//https://leetcode.com/problems/range-module/
public class RangeModule {
    public RangeModule() {
        
    }
    
    public void addRange(int left, int right) {
        
    }
    
    public boolean queryRange(int left, int right) {
        
    }
    
    public void removeRange(int left, int right) {
        
    }
}
