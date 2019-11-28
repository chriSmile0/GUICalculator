class NEUTRAL extends EXPR_UNARY {
    NEUTRAL(EXPR v){
        this.value = v;
    }
    int eval()
    {
        return  value.eval();
    }
    
}