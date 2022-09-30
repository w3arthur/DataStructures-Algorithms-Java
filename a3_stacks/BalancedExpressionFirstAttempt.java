package a3_stacks;

import java.util.Stack;

public class BalancedExpressionFirstAttempt {

	private boolean isLeftBracket(char ch) {
		switch(ch) {
		  case '(' , '<' , '{' , '[': return true;
		  default: return false;
		}
	}
	
	private boolean isRightBracket(char ch) {
		switch(ch) {
		  case ')' , '>' , '}' , ']': return true;
		  default: return false;
		}
	}
	
	boolean isEqual(char chLeft, char chRight) {
		return chLeft == chRight;
	}
	private boolean bracketsMatch(char chLeft, char chRight ) {
		char oposite;
		switch(chLeft) {
		  case ')': oposite = '('; break;
		  case '>': oposite = '>'; break;
		  case ']': oposite = ']'; break;
		  case '}': oposite = '}'; break;
		  default: return false;
		}
		return chRight == oposite;
	}
	
	
	public boolean isBalanced(String input) {
		Stack<Character> stack = new Stack<>();
		for(char ch: input.toCharArray()) {
			//if (ch == '(') stack.push(')');
			if( isLeftBracket(ch)  ) stack.push(')');
//			if (ch == ')') {
//				if(stack.empty()) return false;	//Edge case
//				stack.pop();
//			}
			if ( isRightBracket(ch) ) {
				if(stack.empty()) return false;	//Edge case
				char oposite = stack.pop();
				if( bracketsMatch(ch, oposite) ) return true;
			}
			
		}
		return stack.empty(); //boolean
	}
	
}
