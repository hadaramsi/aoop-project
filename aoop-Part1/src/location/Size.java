package location;

public class Size {
	
	/**
	 * Ctor of Size class
	 * @param width - width input
	 * @param height - height input
	 */
	public Size(int width , int height )
	{
		m_width = width;
		m_height = height;
	}
	
	/**
	 * copy constructor
	 * @param o - the object we want to copy
	 */
	public Size(Size o)
	{
		m_width = o.m_width;
		m_height = o.m_height;
	}
	
	
	/**
	 * return the size in string form
	 */
	public String toString() 
	{
		return "(" + m_width + ", " + m_height + ")";
	}
	
	/**
	 * return true if the objects have the same values
	 */
	public boolean equals(Object o)
	{
		boolean ans = false;
		if ((o instanceof Size))
			ans = (m_width == ((Size)o).m_width) && (m_height == ((Size)o).m_height);
		return ans;
	}
	
	/**
	 * @return m_width
	 */
	public int getWidth()
	{
		return m_width;
	}
	
	
	/**
	 * @return m_height
	 */
	public int getHeight()
	{
		return m_height;
	}
	
	private int m_width;
	private int m_height;
}