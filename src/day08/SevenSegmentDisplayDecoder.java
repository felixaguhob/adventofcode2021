package day08;

public class SevenSegmentDisplayDecoder {
    public class CountHolder {
        public int number;
        public int count;
    }

    String[] inputCodes;
    String[] outputCodes;
    String[] parsedCode = new String[10];
    public SevenSegmentDisplayDecoder(String input) {
        String[] codes = input.trim().split("\\|");
        inputCodes = codes[0].split(" ");
        outputCodes = codes[1].split(" ");

        for(int i=0; i < inputCodes.length; i++) {
            inputCodes[i] = sortStringContent(inputCodes[i]);
        }

        for(int i=0; i < outputCodes.length; i++) {
            outputCodes[i] = sortStringContent(outputCodes[i]);
        }
        parsedCode[0] = "";
        parsedCode[1] = "";
        parsedCode[2] = "";
        parsedCode[3] = "";
        parsedCode[4] = "";
        parsedCode[5] = "";
        parsedCode[6] = "";
        parsedCode[7] = "";
        parsedCode[8] = "";
        parsedCode[9] = "";

    }

    private void fillUpParsedCode1478() {
        for(int i=0; i < inputCodes.length; i++) {
            String curCode = inputCodes[i];
            if (curCode.length() == 2) {
                parsedCode[1] = curCode;
            } else if (curCode.length() == 3) {
                parsedCode[7] = curCode;
            } else if (curCode.length() == 4) {
                parsedCode[4] = curCode;
            } else if (curCode.length() == 7) {
                parsedCode[8] = curCode;
            }
        }
    }

    private void fillUpParsedCode235() {
        for(int i=0; i < inputCodes.length; i++) {
            String curCode = inputCodes[i];
            if (curCode.length() == 5) {
                if (contains(curCode, parsedCode[7])) {
                    parsedCode[3] = curCode;
                } else {
                    if (countCommon(curCode, parsedCode[4]) == 3) {
                        parsedCode[5] = curCode;
                    } else {
                        parsedCode[2] = curCode;
                    }
                }
            }
        }
    }

    private void fillUpParsedCode069() {
        for(int i=0; i < inputCodes.length; i++) {
            String curCode = inputCodes[i];
            if (curCode.length() == 6) {
                if(contains(curCode, parsedCode[4])) {
                    parsedCode[9] = curCode;
                } else {
                    if(contains(curCode, parsedCode[7])) {
                        parsedCode[0] = curCode;
                    } else {
                        parsedCode[6] = curCode;
                    }
                }
            }
        }
    }

    public int[] decode() {
        int[] result = new int[10];
        fillUpParsedCode1478();

        for(int i=0; i < outputCodes.length; i++) {
            if (outputCodes[i].length() == 0)
                continue;

            for(int j=0; j < parsedCode.length; j++) {
                if (outputCodes[i].equals(parsedCode[j])) {
                      result[j] += 1;
                    break;
                }
            }
        }

        return result;
    }

    public int getDecodedOutput() {
        fillUpParsedCode1478();
        fillUpParsedCode235();
        fillUpParsedCode069();

        String output = "";
        for(int i=0; i < outputCodes.length; i++) {
            if (outputCodes[i].length() == 0)
                continue;

            for(int j=0; j < parsedCode.length; j++) {
                if (outputCodes[i].equals(parsedCode[j])) {
                    output += String.valueOf(j);
                }
            }
        }
        return Integer.parseInt(output);
    }

    private boolean contains(String haystack, String needle) {
        for(int i=0; i < needle.length(); i++) {
            char toSearch = needle.charAt(i);
            if (!haystack.contains(String.valueOf(toSearch))) {
                return false;
            }
        }

        return true;
    }

    private int countCommon(String group1, String group2) {
        int count = 0;
        for(int i=0; i < group2.length(); i++) {
            char toSearch = group2.charAt(i);
            if (group1.contains(String.valueOf(toSearch))) {
                count++;
            }
        }

        return count;
    }

    private String sortStringContent(String input) {
        char[] charArray = input.toCharArray();
        int size = charArray.length;
        int temp;
        for(int i = 0; i < size; i++ ) {
            for(int j = i+1; j < size; j++) {
                if(charArray[i]>charArray[j]) {
                    temp = charArray[i];
                    charArray[i] = charArray[j];
                    charArray[j] = (char) temp;
                }
            }
        }
        return String.copyValueOf(charArray);
    }
}
