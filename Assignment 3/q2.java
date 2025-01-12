import java.util.*;

public class q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Point[] points = new Point[n];

        for (int i = 0; i < n; i++) {
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            points[i] = new Point(x, y);
        }

        List<Point> hull = calculateConvexHull(points);

        System.out.println(hull.size());
        for (Point p : hull) {
            System.out.println(p);
        }

        scanner.close();
    }

    static class Point implements Comparable<Point> {
        long x, y;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point other) {
            if (this.x == other.x) {
                return Long.compare(this.y, other.y);
            }
            return Long.compare(this.x, other.x);
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    static long crossProduct(Point p1, Point p2, Point p3) {
        return (p2.x - p1.x) * (p3.y - p2.y) - (p2.y - p1.y) * (p3.x - p2.x);
    }

    static List<Point> calculateConvexHull(Point[] points) {
        Arrays.sort(points);  

        List<Point> lowerHull = new ArrayList<>();
        List<Point> upperHull = new ArrayList<>();

        for (Point p : points) {
            while (lowerHull.size() >= 2 && crossProduct(lowerHull.get(lowerHull.size() - 2), lowerHull.get(lowerHull.size() - 1), p) < 0) {
                lowerHull.remove(lowerHull.size() - 1);
            }
            lowerHull.add(p);
        }

        for (int i = points.length - 1; i >= 0; i--) {
            Point p = points[i];
            while (upperHull.size() >= 2 && crossProduct(upperHull.get(upperHull.size() - 2), upperHull.get(upperHull.size() - 1), p) < 0) {
                upperHull.remove(upperHull.size() - 1);
            }
            upperHull.add(p);
        }

        lowerHull.remove(lowerHull.size() - 1);
        upperHull.remove(upperHull.size() - 1);

        lowerHull.addAll(upperHull);
        return lowerHull;
    }
}
