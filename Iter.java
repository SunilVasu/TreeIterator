import java.util.Stack;

public class Iter {
	public static void main(String args[]) {
		Tree tr1, tr2;
		tr1 = new Tree(100);
		tr1.insert(50);
		tr1.insert(150);
		tr1.insert(25);
		tr1.insert(75);
		tr1.insert(60);
		tr1.insert(55);
		tr1.insert(175);
			

		tr2 = new Tree(175);
		tr2.insert(100);
		tr2.insert(50);
		tr2.insert(60);
		tr2.insert(55);
		tr2.insert(25);
		tr2.insert(75);
				
	    System.out.println(tr1.equal(tr2));
	}
}

class Tree {
	public Tree(int n) {
		value = n;
		left = null;
		right = null;
	};

	public void insert(int n) {
		if (value == n)
			return;
		if (value < n)
			if (right == null)
				right = new Tree(n);
			else
 				right.insert(n);
		else if (left == null)
			left = new Tree(n);
		else
			left.insert(n);
	}
	
	public boolean equal(Tree t2) {
		 // fill in the definition of equal
		TreeIterator itr1 = this.createIterator();
		TreeIterator itr2 = t2.createIterator();
		while(!itr1.done() && !itr2.done())
		{
			if(itr1.next()!=itr2.next())
			{
				return false;
			}
				
		}
		if(!itr1.done() || !itr2.done())
			return false;
		return true;
	}

	public TreeIterator createIterator(){
		return new TreeIterator(this);
	}
	protected int value;
	protected Tree left;
	protected Tree right;

}


class TreeIterator {
	 // fill in the definition of TreeIterator
	protected Tree tr;
	protected Stack<Tree> stack;
	public TreeIterator(Tree tree){
		tr = tree;
		stack = new Stack<Tree>();
		appendLeftToStack(tr);
	}
	private void appendLeftToStack(Tree current)
	{
		while(current != null)
		{
			stack.add(current);
			current = current.left;
		}
	}
	public int next()
	{
		Tree current = stack.pop();
		int returnValue = current.value;
		appendLeftToStack(current.right);
		//System.out.println(returnValue);
		return returnValue;
	}
	public boolean done()
	{
		if(stack.empty())
			return true;
		else
			return false;
	}
}
