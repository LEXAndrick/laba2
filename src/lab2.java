import java.text.DecimalFormat;
import java.util.Scanner;

public class lab2 extends Point3d {
    public static void main(String[] args)
    {
        int check = 0;


        Scanner in = new Scanner(System.in);

        System.out.print("enter coordinates for the first point: " + "\n");
        double a = in.nextInt();
        double b = in.nextInt();
        double c = in.nextInt();
        System.out.print("enter coordinates for the second point: " + "\n");
        double a1 = in.nextInt();
        double b1 = in.nextInt();
        double c1 = in.nextInt();
        System.out.print("enter coordinates for the third point: " + "\n");
        double a2 = in.nextInt();
        double b2 = in.nextInt();
        double c2 = in.nextInt();

        Point3d Point = new Point3d(a,b,c);
        Point3d Point1 = new Point3d(a1,b1,c1);
        Point3d Point2 = new Point3d(a2,b2,c2);
        in.close();

        Point.setX(a);
        Point1.setX(a1);
        Point2.setX(a2);

        Point.setY(b);
        Point1.setY(b1);
        Point2.setY(b2);

        Point.setZ(c);
        Point1.setZ(c1);
        Point2.setZ(c2);

        if (Area(Point, Point1, Point2) == 0 || Point3d.compare(Point, Point2)|| Point3d.compare(Point2, Point1)|| Point3d.compare(Point, Point1)||!Exist(Point, Point1, Point2))	// Проверка координат точек
        {
            if (Area(Point, Point1, Point2) == 0){
                System.out.println("All points lie on one straight line.");
            }
            System.out.println("The triangle does not exist.");
            check ++;
        }

        if (check == 0)
        {
            DecimalFormat df = new DecimalFormat("###.##");
            System.out.println("Area of a triangle: ");
            System.out.print(df.format(Area(Point, Point1, Point2)));
        }
    }

    public static double Area(Point3d a, Point3d b, Point3d c)				// Нахождение площади
    {
        double Side1 = Point3d.distanceTo(a, b), Side2 = Point3d.distanceTo(a, c), Side3 = Point3d.distanceTo(c, b);
        double per = (Side1 + Side2 + Side3) / 2;
        return Math.sqrt(per * (per - Side1) * (per - Side2) * (per - Side3));
    }

    public static boolean Exist(Point3d a, Point3d b, Point3d c){
        if (Point3d.distanceTo(a, b)> Point3d.distanceTo(a, c)+ Point3d.distanceTo(b, c) ){
            return false;
        }
        else if (Point3d.distanceTo(a, c)> Point3d.distanceTo(a, b)+ Point3d.distanceTo(b, c)){
            return false;
        }
        else return !(Point3d.distanceTo(b, c) > Point3d.distanceTo(a, c) + Point3d.distanceTo(a, b));
    }
}