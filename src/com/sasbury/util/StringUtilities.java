
package com.sasbury.util;

import java.util.*;

public class StringUtilities
{
    public static String[] splitLines(String str)
    {
        List dynaArr;
        String[] strings;
        int i, max = 0;

        dynaArr = splitLinesIntoList(str);

        max = dynaArr.size();

        strings = new String[max];

        for(i = 0; i < max; i++)
        {
            strings[i] = (String) dynaArr.get(i);
        }

        return strings;
    }

    /**
     * Splits a string, using the line end characters \r and \n, into a list of sub-strings.
     *
     * @param str The string to split
     * @return A List of strings
     */
    public static List<String> splitLinesIntoList(String str)
    {
        ArrayList<String> retVal = new ArrayList<String>();
        char c;
        int i, max;
        StringBuilder curLine = new StringBuilder();

        if(str == null)
            return retVal;

        max = str.length();

        for(i = 0; i < max; i++)
        {
            c = str.charAt(i);

            if((c == '\n') || (c == '\r'))
            {
                if(curLine.length() > 0) retVal.add(curLine.toString());

                curLine.setLength(0);
            }
            else
            {
                curLine.append(c);
            }
        }

        if(curLine.length() > 0) retVal.add(curLine.toString());

        return retVal;
    }

    final static String octalDigits = "01234567";
    final static String hexDigits = "0123456789abcdefABCDEF";
    final static String escChars = "\n\t\b\r\f\\\'\"\0";
    final static String unescChars = "ntbrf\\'\"0";

    /**
     * Unescapes a string, replacing the \ syntax with a single character, so \n becomes the new line character.
     *
     * @param cstring The string to unescape
     * @return The results
     */
    public static String unescape(String cstring)
    {
        if(cstring == null)
            return cstring;

        int len = cstring.length();
        StringBuilder sb = new StringBuilder();
        int val;
        int unesc;

        for(int i = 0; i < len; i++)
        {
            char ch = cstring.charAt(i);

            if(ch == '\\')
            {
                i++;
                ch = cstring.charAt(i);

                if(ch >= '0' && ch <= '7')
                {
                    val = 0;

                    for(int j = i; j - i < 3 && octalDigits.indexOf(ch =
                                                                    cstring.charAt(j)) != -1; j++)
                    {
                        val = val * 8 + (((int) ch) - '0');
                    }

                    ch = (char) val;
                    i += 3 - 1;
                }
                else if(ch == 'u')
                {
                    i++;
                    val = 0;

                    for(int j = i; j - i < 4; j++)
                    {
                        ch = cstring.charAt(j);

                        if(hexDigits.indexOf(ch) == -1)
                        {
                            //invalid
                        }

                        val *= 16;

                        if(Character.isDigit(ch))
                            val += (((int) ch) - '0');
                        else if(Character.isLowerCase(ch))
                            val += (((int) ch) - 'a');
                        else
                            val += (((int) ch) - 'A');
                    }

                    i += 4 - 1;
                    ch = (char) val;
                }
                else if((unesc = unescChars.indexOf(ch)) != -1)
                {
                    ch = escChars.charAt(unesc);
                }
                else
                {
                    //invalid char
                }
            }

            sb.append(ch); // usually have some translated character to append now
        }

        String retVal = sb.toString();
        return retVal;
    }

    /**
     * Escape the standard charaters in a string using \ notation. For example the new line character becomes \n.
     *
     * @return The resulting escaped string
     */
    public static String escape(String raw)
    {
        if(raw == null)
            return raw;

        StringBuilder sb = new StringBuilder();
        int unesc;
        int len;
        String hex;

        for(int i = 0; i < raw.length(); i++)
        {
            char ch = raw.charAt(i);
            int ich = (int) ch;

            if((unesc = escChars.indexOf(ch)) != -1)
            {
                sb.append('\\');
                sb.append(unescChars.charAt(unesc));
            }
            else if(ch < ' ' || ich >= 0x7f /*|| ich>0xff*/)
            { // not printable or Unicode
                sb.append("\\u");

                hex = Integer.toHexString(ich);
                len = hex.length();

                for(int j = len; j < 4; j++)
                    sb.append('0');

                sb.append(hex);
            }
            else
            {
                sb.append(ch);
            }
        }

        String retVal = sb.toString();
        return retVal;
    }
}




