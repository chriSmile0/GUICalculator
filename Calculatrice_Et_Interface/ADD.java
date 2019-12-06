public class ADD extends EXPR_BINARY {
	ADD(EXPR l, EXPR r){
		this.left = l;
		this.right = r;
	}
	
	double eval() 
	{
		return left.eval() + right.eval();
	}
}
