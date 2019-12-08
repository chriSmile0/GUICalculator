class SUB extends EXPR_BINARY {
    SUB(EXPR l, EXPR r){
        this.left = l;
        this.right = r;
    }

    double eval()
    {
        return left.eval() - right.eval();
    }
}