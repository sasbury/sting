package com.sasbury.sting;

import com.sasbury.sting.operations.impl.*;
import com.sasbury.sting.types.*;
import com.sasbury.util.*;
import com.sasbury.util.collections.*;

public class StingCompiler implements StingConstants
{
    private static StingCompiler shared;

    public static StingCompiler shared()
    {
        if(shared == null) shared = new StingCompiler();

        return shared;
    }

    public IntArray compile(StingProgram program) throws SyntaxException
    {
        IntArray retVal = new IntArray();

        String code = program.getCode();
        String[] lines = StringUtilities.splitLines(code);
        int curDepth = 0;
        boolean inString=false;
        StringBuffer curElement=new StringBuffer();
        int opIndex = -1;
        boolean gotSlash,gotEscape;

        for(int i=0,max=lines.length;i<max;i++)
        {
            String line = lines[i];

            if(line.startsWith(COMMENT) || line.length()==0) continue;

            inString = false;
            gotSlash = false;
            gotEscape = false;

            for(int j=0,chars = line.length();j<chars;j++)
            {
                char c = line.charAt(j);
                opIndex = -1;

                if(gotSlash)
                {
                    if(c=='/')
                    {
                        break;
                    }
                    else
                    {
                        curElement.setLength(0);
                        curElement.append('/');
                        checkCurElement(curElement,program,curDepth,retVal);
                        gotSlash = false;
                    }
                }

                if(inString)
                {
                    if(c=='\"' && !gotEscape)
                    {
                        inString = false;
                        String string = curElement.toString();
                        opIndex = program.getIndexFor(string);

                        if(opIndex<0)
                        {
                            StingString str = new StingString(string);
                            StingOperation op = new PushString(str);
                            opIndex = program.addOperation(string,op);
                        }

                        opIndex = StingUtilities.setDepth(opIndex,curDepth);
                        retVal.add(opIndex);

                        curElement.setLength(0);
                    }
                    else if(c=='\\')
                    {
                        if(gotEscape)
                        {
                            gotEscape = false;
                            curElement.append("\\");
                        }
                        else
                        {
                            gotEscape = true;
                        }
                    }
                    else if(gotEscape)
                    {
                        curElement.append(StringUtilities.unescape("\\"+c));
                        gotEscape = false;
                    }
                    else
                    {
                        curElement.append(c);
                    }
                }
                else if(c == '\"')
                {
                    inString = true;
                }
                else if(c=='/')
                {
                    gotSlash = true;
                }
                else if(c == START_PROCEDURE_C)
                {
                    curDepth++;
                    opIndex = program.getIndexFor(START_PROCEDURE);
                    opIndex = StingUtilities.setDepth(opIndex,curDepth);
                    retVal.add(opIndex);
                }
                else if(c == START_ARRAY_C)
                {
                    curDepth++;
                    opIndex = program.getIndexFor(START_ARRAY);
                    opIndex = StingUtilities.setDepth(opIndex,curDepth);
                    retVal.add(opIndex);
                }
                else if(c==END_PROCEDURE_C)
                {
                    checkCurElement(curElement,program,curDepth,retVal);
                    opIndex = program.getIndexFor(END_PROCEDURE);
                    opIndex = StingUtilities.setDepth(opIndex,curDepth);
                    retVal.add(opIndex);
                    curDepth--;
                }
                else if(c==END_ARRAY_C)
                {
                    checkCurElement(curElement,program,curDepth,retVal);
                    opIndex = program.getIndexFor(END_ARRAY);
                    opIndex = StingUtilities.setDepth(opIndex,curDepth);
                    retVal.add(opIndex);
                    curDepth--;
                }
                else if(Character.isWhitespace(c))
                {
                    checkCurElement(curElement,program,curDepth,retVal);
                }
                else
                {
                    curElement.append(c);
                }
            }

            checkCurElement(curElement,program,curDepth,retVal);
        }

        return retVal;
    }

    protected void checkCurElement(StringBuffer curElement,StingProgram program
                                   ,int curDepth,IntArray code)
    {
        if(curElement.length()>0)
        {
            String elem = curElement.toString().toLowerCase();
            int opIndex = program.getIndexFor(elem);

            if(opIndex<0)
            {
                try
                {
                    double d = Double.parseDouble(elem);
                    String string;
                    
                    if(d == (int)d) string = String.valueOf((int)d);
                    else string = String.valueOf(d);
                    
                    opIndex = program.getIndexFor(string);

                    if(opIndex<0)
                    {
                        StingOperation op = new PushNumber(d);
                        opIndex = program.addOperation(string,op);
                    }
                }
                catch(Exception exp)
                {
                    String string = curElement.toString();
                    opIndex = program.getIndexFor(string);

                    if(opIndex<0)
                    {
                        StingString str = new StingString(string);
                        StingOperation op = new PushString(str);
                        opIndex = program.addOperation(string,op);
                    }
                }
            }

            if(opIndex>=0)
            {
                opIndex = StingUtilities.setDepth(opIndex,curDepth);
                code.add(opIndex);
            }

            curElement.setLength(0);
        }
    }

    public String decompile(StingProgram sProgram,boolean pretty)
    {
        StringBuffer buff = new StringBuffer();
        int code;
        StingOperation op;
        int depth=0;
        int opIndex;
        IntArray program = (IntArray)sProgram.getByteCode().clone();

        for(int i=0,max=program.size();i<max;i++)
        {
            if(i!=0) buff.append(' ');

            code = program.get(i);
            opIndex = StingUtilities.getOperationIndex(code);

            op = sProgram.getOperation(opIndex);

            if(op == null)
            {
                System.err.println("GOT NULL OP");
                continue;
            }

            if(StingBuiltinOperations.isEnd(opIndex))
            {
                depth--;
            }

            if(op!=null) buff.append(op.toString());

            if(StingBuiltinOperations.isStart(opIndex))
            {
                depth++;
            }
        }

        return buff.toString();
    }
}
