package math;

public class MissingDigit {
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static int MissingDigits(String str) {
        String[] splits = str.split(" ");
        String xValue = null;
        String firstValue;
        String operator;
        String secondValue;
        String finalAnswer;
        int answer = 0;
        for (int i = 0; i < splits.length; i++) {
            if (splits[i].indexOf('x') != -1) {
                xValue = splits[i];
            }

            firstValue = splits[0];
            operator = splits[1];
            secondValue = splits[2];
            finalAnswer = splits[4];
            if (!isNumeric(firstValue) && operator.equals("+")) {
                answer = Integer.parseInt(finalAnswer) - Integer.parseInt(secondValue);
            } else if (!isNumeric(firstValue) && operator.equals("-")) {
                answer = Integer.parseInt(finalAnswer) + Integer.parseInt(secondValue);
            } else if (!isNumeric(firstValue) && operator.equals("*")) {
                answer = Integer.parseInt(finalAnswer) / Integer.parseInt(secondValue);
            } else if (!isNumeric(firstValue) && operator.equals("/")) {
                answer = Integer.parseInt(finalAnswer) * Integer.parseInt(secondValue);
            } else if (!isNumeric(secondValue) && operator.equals("+")) {
                answer = Integer.parseInt(finalAnswer) - Integer.parseInt(firstValue);
            } else if (!isNumeric(secondValue) && operator.equals("-")) {
                answer = Integer.parseInt(firstValue) - Integer.parseInt(finalAnswer);
            } else if (!isNumeric(secondValue) && operator.equals("*")) {
                answer = Integer.parseInt(finalAnswer) / Integer.parseInt(firstValue);
            } else if (!isNumeric(secondValue) && operator.equals("/")) {
                answer = Integer.parseInt(firstValue) / Integer.parseInt(finalAnswer);
            } else if (!isNumeric(finalAnswer) && operator.equals("+")) {
                answer = Integer.parseInt(firstValue) + Integer.parseInt(secondValue);
            } else if (!isNumeric(finalAnswer) && operator.equals("-")) {
                answer = Integer.parseInt(firstValue) - Integer.parseInt(secondValue);
            } else if (!isNumeric(finalAnswer) && operator.equals("*")) {
                answer = Integer.parseInt(firstValue) * Integer.parseInt(secondValue);
            } else {
                answer = Integer.parseInt(firstValue) / Integer.parseInt(secondValue);
            }
        }
        String[] xValueArray = xValue.split("");
        String[] answerArr = String.valueOf(answer).split("");
        int xPosition = 0;
        int ansPos;
        for (int i = 0; i < xValueArray.length; i++) {
            if (xValueArray[i].indexOf('x') != -1) {
                xPosition = i;
            }
        }
        return Integer.parseInt(answerArr[xPosition]);

    }

    public static void main(String[] args) {
        System.out.println(MissingDigits("3x + 12 = 46"));
    }
}
