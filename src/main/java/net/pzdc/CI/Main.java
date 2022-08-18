package net.pzdc.CI;

import georegression.struct.point.Point2D_F64;
import georegression.struct.trig.Circle2D_F64;

public class Main {
	public static void main(String... args) {
		Circle2D_F64 C1 = new Circle2D_F64(50, 1,1);
		Circle2D_F64 C2 = new Circle2D_F64(50, 28.5,9);
		
		proc(C1,C2);
	}
	
	public static void proc(Circle2D_F64 C1, Circle2D_F64 C2) {
		double r1 = C1.radius;
		double r2 = C2.radius;
		double x1 = C1.center.x;
		double x2 = C2.center.x;
		double y1 = C1.center.y;
		double y2 = C2.center.y;
		
		double d = Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2, 2));
		double a = (Math.pow(r1, 2)-Math.pow(r2, 2)+Math.pow(d, 2))/(2*d);
		double h = Math.sqrt(Math.pow(r1, 2)-Math.pow(a, 2));
		
		Point2D_F64 temp = new Point2D_F64(x2-x1,y2-y1);
		Point2D_F64 P3 = temp.times(a/d).plus(C1.center);
		
		double xp1=P3.x+(h/d)*(y2-y1);
		double yp1=P3.y-(h/d)*(x2-x1);
		double xp2=P3.x-(h/d)*(y2-y1);  
		double yp2=P3.y+(h/d)*(x2-x1);
		
		System.out.println("point1( x:"+xp1+" y:"+yp1+") \npoint2( x:"+xp2+" y:"+yp2+")");
	}
}

