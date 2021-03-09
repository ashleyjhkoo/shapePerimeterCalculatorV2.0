import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }    
        

    public int getNumPoints (Shape s) {
        // Start with totalNumPoint = 0
        int totalNumPoint = 0;
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
         
            totalNumPoint = totalNumPoint + 1;
        }
        
        return totalNumPoint;
    }

    public double getAverageLength(Shape s) {
        // Start with aveLength = 0.0;
        double aveLength = 0.0;
        // Calculate the average perimeter length of the shape
        aveLength = aveLength + getPerimeter(s)/getNumPoints(s);
        
        return aveLength;
    }

    public double getLargestSide(Shape s) {
        // Start with largestSide = 0.0;
        double largestSide = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
            // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Check which distance is bigger
            if (currDist > largestSide) {
               largestSide = currDist;  
            } 
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        return largestSide;
    }

    public double getLargestX(Shape s) {
        // Start with largestX = 0.0;
        double largestX = 0.0;
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {             
            // Get the X coordinate of the current point
            double xPoint = currPt.getX();
            // Check which X point is bigger
            if (xPoint > largestX) {
            largestX = xPoint;
            }
        }
        
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Create a DirectoryResource
        DirectoryResource dr = new DirectoryResource();
        // Start with largestPerimeter = 0.0;
        double largestPerimeter = 0.0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double eachShapePerimeter = getPerimeter(s);
            if (eachShapePerimeter>largestPerimeter){
               largestPerimeter = eachShapePerimeter;
            }    
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Create a DirectoryResource
        DirectoryResource dr = new DirectoryResource();
        // Start with largestPerimeter = 0.0;
        double largestPerimeter = 0.0;
        // Start with fileWithLargestPerimeter = null;
        File fileWithLargestPerimeter = null;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double eachShapePerimeter = getPerimeter(s);
            if (eachShapePerimeter>largestPerimeter){
               largestPerimeter = eachShapePerimeter;
               fileWithLargestPerimeter = f;
            }    
        }
        File temp = fileWithLargestPerimeter;    // get the file with largest perimeter;
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        
        // Print out total perimeters(total side length of the shape)
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        
        // Print out the total number of points of the shape
        int numPoints = getNumPoints(s);
        System.out.println("Number of Points = " + numPoints);
        
        // Print out the average perimeter length of the shape
        double aveLength = getAverageLength(s);
        System.out.println("Average perimeter length = " + aveLength);
        
        // Print out the largest side of the shape
        double largestSide = getLargestSide(s);
        System.out.println("Largest side length = " + largestSide);
        
        // Print out the largest X coorninate of the shape
        double largestX = getLargestX(s);
        System.out.println("Largest X coordinate point = " + largestX);
                
        // Print out the horizontal line indicator
        System.out.println("-------------------");        
        
    }
    
    public void testPerimeterMultipleFiles() {
        // Print out the largest perimeter among shapes
        double largestPerimeter = getLargestPerimeterMultipleFiles();
        System.out.println("Largest perimeter = " + largestPerimeter);
        
    }

    public void testFileWithLargestPerimeter() {
        // Print out the name of the file that has the largest perimeter
        String fileWithLargestPerimeter = getFileWithLargestPerimeter();
        System.out.println("File with largest perimeter = " + fileWithLargestPerimeter);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
