package java102;

public class Square {
	public final Point corner;
	public final double sideLength;

	/**
	* @param corner 
	* @param sideLength
	*/
	public Square(Point corner, double sideLength) {
		this.corner = corner;
		this.sideLength = sideLength;
	}

	public double area() {
		return Math.pow(sideLength, 2);
	}
	
	public double perimeter() {
		return (sideLength * 4);
	}
	
	/** 
	* @return Whether point p is inside of the square.
	*/
	public boolean isInside(Point p) {
		double xDist = p.x - corner.x;
		double yDist = p.y - corner.y;
		return 0 < xDist && xDist < sideLength &&
			   0 < yDist && yDist < sideLength;
	}

	/** 
	* @return Whether point p part of/on the border of the square.
	*/
	public boolean isOn(Point p) {
		double xDist = p.x - corner.x;
        double yDist = p.y - corner.y;
        return (xDist == 0 || xDist == sideLength) && (yDist >= 0 && yDist <= sideLength) || 
        (yDist == 0 || yDist == sideLength) && (xDist >= 0 && xDist <= sideLength);
}

	
	
	/** 
	* @param x How much to translate the sqaure by in the + x direction.
	* @param y How much to translate the squarer by in the + y direction.
	* @return The sqaure that results from the translation.
	*/
	public Square translate(double x, double y) {
        Point newCorner = new Point(corner.x + x, corner.y + y);
        return new Square(newCorner, sideLength);
	}

	/** 
	* @return The sqaure that results from scaling the side length and maintaining the bottom left corner
	*/
	public Square scale(double k) {
		return new Square(corner, sideLength * k);
	}

	public Point[] corners() {
        Point topRight = new Point(corner.x + sideLength, corner.y); 
        Point topLeft = new Point(corner.x, corner.y + sideLength);    
        Point bottomRight = new Point(corner.x + sideLength, corner.y + sideLength);
        return new Point[]{corner, topLeft, topRight, bottomRight};
	}

	@Override
	public String toString() {
		return "(corner: " + corner + "; side length: " + sideLength + ")";
	}
}
