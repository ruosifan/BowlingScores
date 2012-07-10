import java.util.ArrayList;

public class CalculateScore {
	
	public ArrayList<Frame> game = new ArrayList<Frame>();
	private static int PERFECT_FRAME_SCORE = 10;
	public int numberOfFrames;

	public CalculateScore(ArrayList<Frame> game){
		this.game = game;
		this.numberOfFrames = game.size();
	}
	
	public int evaluate(){
		
		int totalScore = 0;
		int counter = game.size();
		
		if(numberOfFrames>10){
			counter = 10;
		} 
		
		for (int i=0; i<counter; i++){
			String frameType = game.get(i).getType();
			System.out.println(i + " " + game.get(i).getFirst() + " " + game.get(i).getSecond() + " " + game.get(i).getType());
			if(frameType.equals("regular")){
				totalScore += game.get(i).addFirstAndSecond();
			} else if (frameType.equals("spare")) {
				totalScore += PERFECT_FRAME_SCORE + game.get(i+1).getFirst();
			} else {
				String nextFrameType = game.get(i + 1).getType();
				if(nextFrameType.equals("strike")){
					totalScore += PERFECT_FRAME_SCORE*2 + game.get(i + 2).getFirst();
				} else {
					totalScore += PERFECT_FRAME_SCORE + game.get(i + 1).addFirstAndSecond();
				}
			}
		}
		
		System.out.println("Your total score is " + totalScore + ".");
		return totalScore;
	}


	
}
