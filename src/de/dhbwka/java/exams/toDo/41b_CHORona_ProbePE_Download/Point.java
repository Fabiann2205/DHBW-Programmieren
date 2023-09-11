public class Point {

	@Override
	public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + this.x;
      result = prime * result + this.y;
      return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
         return true;
      }
		if (obj == null) {
         return false;
      }
		if (this.getClass() != obj.getClass()) {
         return false;
      }
		Point other = (Point) obj;
		if (this.x != other.x) {
         return false;
      }
		if (this.y != other.y) {
         return false;
      }
		return true;
	}	
}
