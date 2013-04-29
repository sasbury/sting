package com.sasbury.sting;

/**
 * The toString method for a StackOperation should return the correct syntax for this operation.
 * So a "pushArray" operation might return "[0 1 2]", while the add operation returns "add".
 *
 * StackOperation should implement hashCode and equals correctly.
 */
public interface StingOperation extends StingConstants
{
    public StingOperation copy();

    /**
     * Execute the operation, returning true if successfull, false otherwise
     * @param context
     * @return
     */
    public boolean execute(ExecutionContext context);
}
