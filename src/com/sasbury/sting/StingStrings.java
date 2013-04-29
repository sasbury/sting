package com.sasbury.sting;

import java.util.*;

public class StingStrings extends ListResourceBundle
{
    private final static String[][] contents =
    {
        {"stack.cmdlinehelp","usage: stack [-verbose] -i program"}
        ,{"stack.badargs.summary","usage: stack [-verbose] -i program"}
        ,{"stack.badargs.description","Can't start, input is required and must be valid."}

        ,{"stackrun.cmdlinehelp","usage: stack [-verbose] -i program"}
        ,{"stackrun.badargs.summary","usage: stack [-verbose] -i program"}
        ,{"stackrun.badargs.description","Can't start, input is required and must be valid."}
    };

    /**
     * Overrides {@link java.util.ListResourceBundle#getContents()}.
     */
    public Object[][] getContents()
    {
        return contents;
    }
}
