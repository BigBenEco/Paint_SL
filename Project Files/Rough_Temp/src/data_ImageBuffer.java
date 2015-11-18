import java.awt.image.BufferedImage;
/*
 * This class is a stack class that uses an array.
 * It holds a list of Buffered images of the canvas in the past.
 */

public class data_ImageBuffer {
	
	public int length;
	
	private int last, first; // pointers to the ends of the arrays.
	
	private BufferedImage data[];
	
	public boolean isEmpty = true;
	
	data_ImageBuffer( int size)
	{
		length = size;
		data = new BufferedImage[length];
		last = 0;
		first = 0;
	}
	
	public void push(BufferedImage top)
	{
		//System.out.println("Push activated; last = "+last+", first = "+first+", length = "+length+".");
		if(isEmpty)
		{
			data[last] = top; // fills last, which is also first, but does not move last yet.
			isEmpty = false;
			//System.out.println("Was Empty.");
		}
		else
		{
			last = (last+1)%length; // advances the pointer last
			//System.out.println("Advanced last to "+last+".");
			if(last == first)
			{
				first = (first+1)%length; // if first is in the way, we need to advance it as well.
				//System.out.println("last caught up with first, first now advanced to "+first+".");
			}
			data[last] = top; // adds the data;
		}
	}

	public BufferedImage pop() throws CanNotUndoException
	{
		//System.out.println("Pop activated; last = "+last+", first = "+first+", length = "+length+".");
		if(isEmpty)
		{
			//System.out.println("Is Empty.");
			throw new CanNotUndoException();
		}
		else
		{
			//System.out.println("Is Not Empty.");
			if( last == first)
			{
				isEmpty = true;
				//System.out.println("Now Empty.");
			    return data[last];
			}
			else
			{
				//System.out.println("Not Empty yet. Last at "+last+".");
				BufferedImage temp = data[last]; // going to save the data to be sent.
				last = ( last == 0 ) ? length-1 : last - 1; // now we retreat the pointer last backwards
				//System.out.println("Retreated last to "+last+".");
				return temp;
			}
		}
	}
}
