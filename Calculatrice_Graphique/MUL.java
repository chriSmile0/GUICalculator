public class MUL extends EXPR_BINARY{
	MUL(EXPR l, EXPR r){
		this.left = l;
		this.right = r;
	}
	
	double eval() 
	{
		return left.eval() * right.eval();
	}
}
