package day08;

import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

class DisplayProcessorTest {

    @Test
    void testDisplay1() {
        List<String> inputList = new ArrayList<>();
        inputList.add("be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | fdgacbe cefdb cefbgd gcbe");
        inputList.add("edbfga begcd cbg gc gcadebf fbgde acbgfd abcde gfcbed gfec | fcgedb cgb dgebacf gc");
        inputList.add("fgaebd cg bdaec gdafb agbcfd gdcbef bgcad gfac gcb cdgabef | cg cg fdcagb cbg");
        inputList.add("fbegcd cbd adcefb dageb afcb bc aefdc ecdab fgdeca fcdbega | efabcd cedba gadfec cb");
        inputList.add("aecbfdg fbg gf bafeg dbefa fcge gcbea fcaegb dgceab fcbdga | gecf egdcabf bgf bfgea");
        inputList.add("fgeab ca afcebg bdacfeg cfaedg gcfdb baec bfadeg bafgc acf | gebdcfa ecba ca fadegcb");
        inputList.add("dbcfg fgd bdegcaf fgec aegbdf ecdfab fbedc dacgb gdcebf gf | cefg dcbef fcge gbcadfe");
        inputList.add("bdfegc cbegaf gecbf dfcage bdacg ed bedf ced adcbefg gebcd | ed bcgafe cdgba cbgef");
        inputList.add("egadfb cdbfeg cegd fecab cgb gbdefca cg fgcdab egfdb bfceg | gbdfcae bgc cg cgb");
        inputList.add("gcafb gcf dcaebfg ecagb gf abcdeg gaef cafbge fdbac fegbdc | fgae cfgab fg bagce");

        DisplayProcessor processor = new DisplayProcessor(inputList);

        int totalOutput = 0;

        int[] output = processor.decode();
        int totalCount = 0;
        for(int i=0; i < output.length; i++) {
            totalCount += output[i];
        }

        assertEquals(26, totalCount);
    }

    @Test
    void testDisplay2() {
        List<String> inputList = new ArrayList<>();
        inputList.add("be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | fdgacbe cefdb cefbgd gcbe");
        inputList.add("edbfga begcd cbg gc gcadebf fbgde acbgfd abcde gfcbed gfec | fcgedb cgb dgebacf gc");
        inputList.add("fgaebd cg bdaec gdafb agbcfd gdcbef bgcad gfac gcb cdgabef | cg cg fdcagb cbg");
        inputList.add("fbegcd cbd adcefb dageb afcb bc aefdc ecdab fgdeca fcdbega | efabcd cedba gadfec cb");
        inputList.add("aecbfdg fbg gf bafeg dbefa fcge gcbea fcaegb dgceab fcbdga | gecf egdcabf bgf bfgea");
        inputList.add("fgeab ca afcebg bdacfeg cfaedg gcfdb baec bfadeg bafgc acf | gebdcfa ecba ca fadegcb");
        inputList.add("dbcfg fgd bdegcaf fgec aegbdf ecdfab fbedc dacgb gdcebf gf | cefg dcbef fcge gbcadfe");
        inputList.add("bdfegc cbegaf gecbf dfcage bdacg ed bedf ced adcbefg gebcd | ed bcgafe cdgba cbgef");
        inputList.add("egadfb cdbfeg cegd fecab cgb gbdefca cg fgcdab egfdb bfceg | gbdfcae bgc cg cgb");
        inputList.add("gcafb gcf dcaebfg ecagb gf abcdeg gaef cafbge fdbac fegbdc | fgae cfgab fg bagce");

        DisplayProcessor processor = new DisplayProcessor(inputList);

        assertEquals(61229, processor.getSumTotalParsedOutput());
    }
}