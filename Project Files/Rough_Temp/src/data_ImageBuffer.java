import java.awt.image.BufferedImage;
/*
 * This class is a stack class that uses an array.
 * It holds a list of Buffered images of the canvas in the past.
 */

public class data_ImageBuffer {
	
	public int length;
	
	private int last, opening; // pointers to the ends of the arrays.
	
	private BufferedImage data[];
	
	public boolean isEmpty = true;
	
	data_ImageBuffer( int size)
	{
		length = size;
		data = new BufferedImage[length];
		last = 0;
		opening = 0;
	}
	
	public void push(BufferedImage top)
	{
		if( (opening == last) && (isEmpty == false) ) // the other constraint prevents it from moving the last since it is holding nothing, else it moves it to hold the last buffer.
		{
			last += ( last == (length-1) ) ? (1-length) : 1; //moves the pointer last up one so that it can keep up with the open end.
		}
		data[opening] = top;
		opening += ( opening == (length-1) ) ? (1-length) : 1;  //moves the opening now that we added data, catching up with last if possible.
		isEmpty = false;
	}

	public BufferedImage pop() throws CanNotUndoException
	{
		if(isEmpty)
		{
			throw new CanNotUndoException();
		}
		else
		{
			opening += ( opening == 0) ? length-1 : (0-1); 
			isEmpty = (opening == last) ? true : false;  //checks to see if empty now. We know if it is because we just took one thing off the stack, and if moving the pointer to the new spot is the same spot as the last pointer, than we know we cleared the last of the data.
			return data[opening];
		}
	}
}
