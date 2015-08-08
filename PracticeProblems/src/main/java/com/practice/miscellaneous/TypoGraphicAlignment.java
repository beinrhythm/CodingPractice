package com.practice.miscellaneous;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by abhi.pandey on 11/19/14.
 */
public class TypoGraphicAlignment {

    private final static Logger LOGGER = Logger.getLogger(TypoGraphicAlignment.class.getName());

    /**
     * Implement the "justify" (flush to the left AND right margins) form of typographical alignment. Go here for what that means: http://en.wikipedia.org/wiki/Typographic_alignment
     * <p/>
     * Assumptions:
     * 1) All characters are monospaces
     * 2) The language is left-to-right
     */
    public static List<String> justify(String text, int marginWidth) {

        try {
            if (text == null || text.isEmpty() || text.trim().isEmpty()) {
                throw new NullPointerException("The text passed is empty or null");
            }

            if (marginWidth <= 0) {
                throw new IllegalArgumentException("Number of words has to be greater than zero");
            }

            String[] words = text.trim().split(" ");
            List<String> justifiedString = new ArrayList<String>();

            int remainingSpace = marginWidth;
            String line;
            List<String> wordsInOneLine = new ArrayList<String>();
            for (String w : words) {
                //Adding the words in the line
                if (remainingSpace > w.length()) {

                    wordsInOneLine.add(w);
                    remainingSpace = remainingSpace - w.length() - 1;

                } else {
                    // Added enough words now adjust the space
                    line = getFormattedString(remainingSpace, wordsInOneLine);

                    justifiedString.add(line);
                    remainingSpace = marginWidth;
                    wordsInOneLine = new ArrayList<String>();

                    // adding the word in the next line that didn't got added last
                    if (remainingSpace > w.length()) {
                        wordsInOneLine.add(w);
                        remainingSpace = remainingSpace - w.length() - 1;
                    }
                }


            }
            //processing the last line
            if (wordsInOneLine.size() > 0) {
                line = getFormattedString(remainingSpace, wordsInOneLine);
                justifiedString.add(line);
            }

            return justifiedString;
        } catch (NullPointerException e) {
            LOGGER.severe(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        throw new IllegalArgumentException("The arguments passed are not valid");
    }

    //space processing within a line
    private static String getFormattedString(int remainingSpace, List<String> wordsInOneLine) {
        StringBuilder sb;
        String line;
        int totalWordsInLine = wordsInOneLine.size();
        remainingSpace += totalWordsInLine;
        if (totalWordsInLine > 1) {
            totalWordsInLine--;
        }
        int space = remainingSpace / (totalWordsInLine);
        int extraSpace = remainingSpace % (totalWordsInLine);
        sb = new StringBuilder();
        for (String wo : wordsInOneLine) {
            sb.append(wo);

            int tempSpace = space;
            while (tempSpace > 0) {
                sb.append(" ");
                tempSpace--;
            }

            if (extraSpace > 0) {
                sb.append(" ");
                extraSpace--;
            }


        }

        line = sb.toString().trim();
        return line;
    }

    public static void main(String[] args)  {

        String content = "Thy father was delighted and cried out to the servant, ‘Give him a hundred and three gold pieces with a robe of honour!’ The man obeyed his orders, and I awaited an auspicious moment, when I blooded him; and he did not baulk me; nay he thanked me and I was also thanked and praised by all present. When the blood-letting was over I had no power to keep silence and asked him, ‘By God, O my lord, what made thee say to the servant, Give him an hundred and three dinars?’; and he answered, ‘One dinar was for the astrological observation, another for thy pleasant conversation, the third for the phlebotomisation, and the remaining hundred and the dress were for thy verses in my commendation.’” “May God show small mercy to my father,” exclaimed I, “for knowing the like of thee.";
        TypoGraphicAlignment.justify(content, 80);
    }

}
