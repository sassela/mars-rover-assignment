public class Plateau {

	int[] size;

	public Plateau() {
	 size = new int[2];
	}

	public int[] getSize() {
		return size;
	}

	public void setSize(int[] size) {
		// returns 0 if either coordinate is negative
		for(int i = 0; i < size.length; i++){
			if(size[i] < 0){
				size[i] = 0;
			}
		}
		this.size = size;
	}
}