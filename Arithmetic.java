import java.util.*;

public class Arithmetic {

		public static void main(String[] args) {
				List<String> argList = new ArrayList<>();
				for (String arg: args[0].split(" ")) argList.add(arg);
				println(evaluate(argList));

		}

	  private static double biExpr(double a, String op, double b) {
				switch (op) {
				case "+": return a + b;
				case "-": return a - b;
				case "*": return a * b;
				case "/": return a / b;
				}
				throw new IllegalArgumentException("Unknown operator");
		}

		private static String biExpr(final List<String> args, int operatorIndex) {
				double leftOperand = Double.parseDouble(args.get(operatorIndex-1));
				String operator = args.get(operatorIndex);
				double rightOperand = Double.parseDouble(args.get(operatorIndex+1));
				double resultValue = biExpr(leftOperand, operator, rightOperand);
				return Double.valueOf(resultValue).toString();
		}

		private static double evaluate(List<String> args) {
				for (int counter = 0; counter < args.size(); counter++) {
						if (isOpenParentheses(args.get(counter))) {
								String arg = args.get(counter);
								List<String> expressionInParentheses = new ArrayList<>();
								
								
								do {
										expressionInParentheses.add(args.remove(counter + 1));
								} while(!args.get(counter + 1).equals(")"));

								String resultValue = Double.valueOf(evaluate(expressionInParentheses)).toString();
								
								args.remove(counter);
								args.set(counter, resultValue);
						}
				}
				for (int counter = 0; counter < args.size(); counter++) {
						if (isFirstPriority(args.get(counter))) {
								String resultValue = biExpr(args, counter);
								
								args.set(counter, resultValue);
								args.remove(counter+1);
								args.remove(counter-1);
								
								counter-=1;
						}
				}
				for (int counter = 0; counter < args.size(); counter++) {
						if (isSecondPriority(args.get(counter))) {
								String resultValue = biExpr(args, counter);
								
								args.set(counter, resultValue);
								args.remove(counter+1);
								args.remove(counter-1);
								
								counter-=1;
						}
				}
				
				return Double.parseDouble(args.get(0));
		}

		private static boolean isOpenParentheses(String arg) {
				return arg.equals("(");
		}

		private static boolean isFirstPriority(String arg) {
				return arg.equals("*") || arg.equals("/");
		}

		private static boolean isSecondPriority(String arg) {
				return arg.equals("+") || arg.equals("-");
		}

		private static boolean isDouble(String arg) {
				try {
						Double.parseDouble(arg);
				} catch (NumberFormatException exc) {
						return false;
				}
				return true;
		}

	  private static <T> void println(T message) {
				System.out.println(message.toString());
		}

		private static <T> void println(T[] messages) {
				for (T message : messages) println(message);
		}

		@SuppressWarnings("unchecked")
		private static <T> T[] subArray(T[] array, int start, int end) {
			  T[] subArray = (T[]) new Object[end - start];
				for (int i = 0; i < subArray.length; i++) {
						subArray[i] = (T) array[i+start];
				}
				return (T[])subArray;
		}

}
