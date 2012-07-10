import java.util.ArrayList;

public class CalculateScore {
	
	public ArrayList<Frame> game = new ArrayList<Frame>();
	private static int PERFECT_FRAME_SCORE = 10;
	private static int MAX_NUM_OF_FRAMES = 10;
	public int numberOfFrames;

	public CalculateScore(ArrayList<Frame> game){
		this.game = game;
		this.numberOfFrames = game.size();
	}
	
	public int evaluate(){
		
		int totalScore = 0;
		int counter = setCounter();
		
		for (int i=0; i<counter; i++){
			String frameType = game.get(i).getType();
			if(frameType.equals("regular")){
				totalScore += calculateRegular(game.get(i));
			} else if (frameType.equals("spare")) {
				totalScore += calculateSpare(game.get(i+1)); 
			} else {
				totalScore += calculateStrike(game.get(i+1), i+1);
			}
		}
		
		System.out.println("Your total score is " + totalScore + ".");
		return totalScore;
	}
	
	public int calculateRegular(Frame frame){
		return frame.addFirstAndSecond();
	}
	
	public int calculateSpare(Frame nextFrame){
		return PERFECT_FRAME_SCORE + nextFrame.getFirst();
	}
	
	public int calculateStrike(Frame nextFrame, int indexOfNextFrame){
		String nextFrameType = game.get(indexOfNextFrame).getType();
		if(nextFrameType.equals("strike")){
			return PERFECT_FRAME_SCORE*2 + game.get(indexOfNextFrame+1).getFirst();
		} else {
			return PERFECT_FRAME_SCORE + nextFrame.addFirstAndSecond();
		}
	}

	public int setCounter(){
		
		if(numberOfFrames>MAX_NUM_OF_FRAMES){
			return MAX_NUM_OF_FRAMES;
		} 
		
		return game.size();
	}
	
}
