package com.example.Baekjoon;

/**
 * 잃어버린 괄호
 * 그리디 알고리즘으로 풀이
 * String formula -> 수식 문자열
 */
public class LostParenthesis {
    public int getMinByFormula(String formula) {

        int answer = 0;
        // 1. 제일 큰 값을 빼줄 수 있도록 - 기준으로 split
        String[] splitedFormulas = formula.split("-");

        for (int i = 0; i < splitedFormulas.length; i++) {
            int intFormula = splitSum(splitedFormulas[i]);

            // 처음 값이면 더하기(0번째 인덱스 값은 앞에 기호가 없는 값이므로)
            if (i == 0) {
                answer += intFormula;
            } else {
                answer -= intFormula;
            }
        }
        return answer;
    }

    private int splitSum(String formula) {
        // 2. + 수식으로 묶여있는 문자열을 형변환 후 더하기
        int sum = 0;
        String[] splitedFormulas = formula.split("\\+");

        for (String strFormula : splitedFormulas) {
            sum += Integer.parseInt(strFormula);
        }

        return sum;
    }
}
