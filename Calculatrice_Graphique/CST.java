public class CST extends EXPR{
	double value;
	CST(double v){
		this.value = v;
	}
	
	double eval() 
	{
		return value;
	}
}
