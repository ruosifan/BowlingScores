public class Frame {
	
	private int first = 0;
	private int second;
	private String type;
	private int score;
	
	public Frame(int first, int second){
		this.first = first;
		this.second = second;
		
		this.type = typeOfFrame();
	}
	
	public String typeOfFrame(){
		
		if(first == 10){
			type = "strike";
			second = 0;
		} else if (first + second == 10){
			type = "spare";
		} else {
			type = "regular";
		}
		
		return type;
	}
	
	public int addFirstAndSecond(){
		return first + second;
	}
	
	public int getFirst(){
		return first;
	}
	
	public int getSecond(){
		return second;
	}
	
	public String getType(){
		return type;
	}
	
	public int getScore(){
		return score;
	}
	
	public void setScore(int newScore){
		score = newScore;
	}
	
}
