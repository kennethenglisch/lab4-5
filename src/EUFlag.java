public class EUFlag {
	
	private int upperCorner = 0;
	private int lastRow = 3;
	private int plusRow = 3;
	private int plusColumn = 38;
	
	public static void main(String args[]) 
	{
		EUFlag eu = new EUFlag();
		eu.printFlag();
	}

	private void printFlag()
	{
		String outputLine;  
		for (int row = 1; row <= 40; row++){      
		    outputLine = "";      
		    for (int column = 1; column <= 40; column++){
		        outputLine = outputLine + determineCharacter (column, row);
		    }      
		    System.out.println (outputLine);
		}  
	}
	
	public char determineCharacter (int column, int row) 
	{
		char c = '\0';
		char[] arrayOfChar = {'/' , '=', '\0', '?', '-', '|', '+', ')', '('};
		int getChar;

		// everything inside the flag
		if (row >= 3 && row <= 38 && column >= 3 && column <= 38) 
		{
			// upper left corner
			if (row == 17 && column <= 17) c = arrayOfChar[4];
			if (column == 17 && row <= 16) c = arrayOfChar[5];
			
			// the slashes and = in the upper left corner
			// every row has 14 chars. We have 3 options '/' , '=' , '\0'
			if (row <= 16 && column <= 16) 
			{
				// if we go on with the next row we want to decrease upperCorner by 1
				// so we go on with the exact same char as the last in the last row
				if (lastRow != row) upperCorner--;
				
				getChar = upperCorner % 3;
				c = arrayOfChar[getChar];
				upperCorner++;
				lastRow = row;
			} 
			
			// pluses
			if (row == plusRow && column == plusColumn) 
			{
				c = arrayOfChar[6];
				plusRow++;
				plusColumn--;
			}	
			
			// braces
			// from up to down
			// first off we start right site from the banner
			if (row < plusRow && row % 3 == 0 && column - 1 != plusColumn) c = arrayOfChar[7];
			else if (column < plusColumn && column % 5 == 0 && column >= 18 | row >= 18) c = arrayOfChar[8];
		}
		// the border of the flag
		else c = arrayOfChar[3];
		
		return c;
	}
}
