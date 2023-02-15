package org.example;

public class Lock {
    private final int[] combination = new int[4];
    public Lock(int n0, int n1, int n2, int n3) {
        if (!(isDigitLegal(n0)
                && isDigitLegal(n1)
                && isDigitLegal(n2)
                && isDigitLegal(n3)))
            throw new IllegalArgumentException("Digit must be from 0 to 9");

        combination[0] = n0;
        combination[1] = n1;
        combination[2] = n2;
        combination[3] = n3;
    }
    private boolean isDigitLegal(int n){
        return n >= 0 && n <= 9;
    }
    public int findMinRollsToEquality(){
        int minRollsToEquality = 0;

        if (isAllElementsEqual()) return minRollsToEquality;
        else {
            minRollsToEquality = countMinRolls();
        }
        return minRollsToEquality;
    }

    private boolean isAllElementsEqual(){
        int checkElement = combination[0];

        for (int digit: combination) {
            if (digit != checkElement) return false;
        }

        return true;
    }

    private int countMinRolls(){
        int minRolls = countRollsToCombination(0);
        for(int i = 0; i<10; i++){
            int rolls = countRollsToCombination(i);
            if (rolls < minRolls) minRolls = rolls;
        }
        return minRolls;
    }

    private int countRollsToCombination(int targetCombination){
        int rollsToCombination = 0;
        for (int i = 0; i<4; i++){
            rollsToCombination += rollsToDigit(combination[i], targetCombination);
        }
        return rollsToCombination;
    }

    private int rollsToDigit(int givenDigit, int targetDigit){
        int rollsForward, rollsBack;

        if (givenDigit == targetDigit) return 0;
        else if (givenDigit < targetDigit) {
            rollsForward = targetDigit - givenDigit;
            rollsBack = 10 - rollsForward;
        }
        else {
            rollsBack = givenDigit - targetDigit;
            rollsForward = 10 - rollsBack;
        }

        return Math.min(rollsForward, rollsBack);
    }
}
