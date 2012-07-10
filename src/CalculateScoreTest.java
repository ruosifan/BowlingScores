import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class CalculateScoreTest {

	
	@Test
	public void BowlingZeroShouldScoreZero(){
		Frame frame = new Frame(0, 0);
		ArrayList<Frame> game = new ArrayList<Frame>();
		game.add(frame);
		
		CalculateScore calculator = new CalculateScore(game);
		assertEquals(0, calculator.evaluate());
	}
	
	@Test
	public void BowlingOneAndOneShouldScoreTwo(){
		Frame frame = new Frame(1, 1);
		ArrayList<Frame> game = new ArrayList<Frame>();
		game.add(frame);
		
		CalculateScore calculator = new CalculateScore(game);
		assertEquals(2, calculator.evaluate());
	}
	
	@Test
	public void BowlingTwoNormalFramesShouldBeSumOfIndividualRolls(){
		Frame frame = new Frame(1, 1);
		Frame frameTwo = new Frame(3, 4);
		ArrayList<Frame> game = new ArrayList<Frame>();
		game.add(frame);
		game.add(frameTwo);
		
		CalculateScore calculator = new CalculateScore(game);
		assertEquals(9, calculator.evaluate());
	}
	
	@Test
	public void BowlingOneSpareAndOneNormalShouldAddTenToNormalRoll(){
		Frame frame = new Frame(1, 9);
		Frame frameTwo = new Frame(3, 4);
		ArrayList<Frame> game = new ArrayList<Frame>();
		game.add(frame);
		game.add(frameTwo);
		
		CalculateScore calculator = new CalculateScore(game);
		assertEquals(20, calculator.evaluate());
	}
	
	@Test
	public void BowlingTwoSparesAndNineShouldBe39(){
		Frame frame = new Frame(1, 9);
		Frame frameTwo = new Frame(1, 9);
		Frame frameThree = new Frame(9, 0);
		ArrayList<Frame> game = new ArrayList<Frame>();
		game.add(frame);
		game.add(frameTwo);
		game.add(frameThree);
		
		CalculateScore calculator = new CalculateScore(game);
		assertEquals(39, calculator.evaluate());
	}
	
	@Test
	public void BowlingOneStrikeFollowedByNormalFrame(){
		Frame frame = new Frame(10, 0);
		Frame frameTwo = new Frame(1, 4);
		ArrayList<Frame> game = new ArrayList<Frame>();
		game.add(frame);
		game.add(frameTwo);
		
		CalculateScore calculator = new CalculateScore(game);
		assertEquals(20, calculator.evaluate());
	}
	
	@Test
	public void BowlingOneStrikeFollowedBySpareAndNormalFrame(){
		Frame frame = new Frame(10, 0);
		Frame frameTwo = new Frame(9, 1);
		Frame frameThree = new Frame(1, 4);
		ArrayList<Frame> game = new ArrayList<Frame>();
		game.add(frame);
		game.add(frameTwo);
		game.add(frameThree);
		
		CalculateScore calculator = new CalculateScore(game);
		assertEquals(36, calculator.evaluate());
	}
	
	@Test
	public void BowlingTwoStrikesAndANormalFrame(){
		Frame frame = new Frame(10, 0);
		Frame frameTwo = new Frame(10, 0);
		Frame frameThree = new Frame(1, 4);
		ArrayList<Frame> game = new ArrayList<Frame>();
		game.add(frame);
		game.add(frameTwo);
		game.add(frameThree);
		
		CalculateScore calculator = new CalculateScore(game);
		assertEquals(41, calculator.evaluate());
	}

	@Test
	public void BowlingThreeStrikesFollowedByNormalFrame(){
		Frame frame = new Frame(10, 0);
		Frame frameTwo = new Frame(10, 0);
		Frame frameThree = new Frame(10, 0);
		Frame frameFour = new Frame(1, 1);
		ArrayList<Frame> game = new ArrayList<Frame>();
		game.add(frame);
		game.add(frameTwo);
		game.add(frameThree);
		game.add(frameFour);
		
		CalculateScore calculator = new CalculateScore(game);
		assertEquals(65, calculator.evaluate());
	}
	
	@Test
	public void BowlingStrikeSpareNormal(){
		Frame frame = new Frame(10, 0);
		Frame frameTwo = new Frame(0, 10);
		Frame frameThree = new Frame(5, 3);
		ArrayList<Frame> game = new ArrayList<Frame>();
		game.add(frame);
		game.add(frameTwo);
		game.add(frameThree);
		
		CalculateScore calculator = new CalculateScore(game);
		assertEquals(43, calculator.evaluate());
	}
	
	@Test
	public void BowlingSpareStrikeNormal(){
		Frame frame = new Frame(0, 10);
		Frame frameTwo = new Frame(10, 0);
		Frame frameThree = new Frame(5, 3);
		ArrayList<Frame> game = new ArrayList<Frame>();
		game.add(frame);
		game.add(frameTwo);
		game.add(frameThree);
		
		CalculateScore calculator = new CalculateScore(game);
		assertEquals(46, calculator.evaluate());
	}
	
	@Test
	public void BowlingAllGutterballsIsZero(){
		ArrayList<Frame> game = new ArrayList<Frame>();
		for(int i = 0; i < 10; i++){
			Frame frame = new Frame(0, 0);
			game.add(frame);
		}
		
		CalculateScore calculator = new CalculateScore(game);
		assertEquals(0, calculator.evaluate());
	}
	

	@Test
	public void BowlingAllThreesIsSixty(){
		ArrayList<Frame> game = new ArrayList<Frame>();
		for(int i = 0; i < 10; i++){
			Frame frame = new Frame(3, 3);
			game.add(frame);
		}
		
		CalculateScore calculator = new CalculateScore(game);
		assertEquals(60, calculator.evaluate());
	}
	
	
	@Test
	public void BowlingPerfectScoreIsThreeHundred(){
		ArrayList<Frame> game = new ArrayList<Frame>();
		for(int i = 0; i < 12; i++){
			Frame frame = new Frame(10, 0);
			game.add(frame);
		}
		
		CalculateScore calculator = new CalculateScore(game);
		assertEquals(300, calculator.evaluate());
	}
	
	@Test
	public void BowlingNineStrikesAndGutterballIs240(){
		ArrayList<Frame> game = new ArrayList<Frame>();
		for(int i=0; i<9; i++){
			Frame frame = new Frame(10, 0);
			game.add(frame);
		}
		
		Frame frame = new Frame(0, 0);
		game.add(frame);

		CalculateScore calculator = new CalculateScore(game);
		assertEquals(240, calculator.evaluate());
	}

	@Test
	public void BowlingTenStrikesAndGutterballIs270(){
		ArrayList<Frame> game = new ArrayList<Frame>();
		for(int i=0; i<10; i++){
			Frame frame = new Frame(10, 0);
			game.add(frame);
		}
		
		Frame frame = new Frame(0, 0);
		game.add(frame);

		CalculateScore calculator = new CalculateScore(game);
		assertEquals(270, calculator.evaluate());
	}
	
	@Test
	public void BowlingTenStrikesAndThreeTwoIs275(){
		ArrayList<Frame> game = new ArrayList<Frame>();
		for(int i=0; i<10; i++){
			Frame frame = new Frame(10, 0);
			game.add(frame);
		}
		
		Frame frame = new Frame(3, 2);
		game.add(frame);

		CalculateScore calculator = new CalculateScore(game);
		assertEquals(278, calculator.evaluate());
	}
	
	@Test
	public void BowlingNineOneZeroesAndFiveFiveFive(){
		ArrayList<Frame> game = new ArrayList<Frame>();
		for(int i=0; i<9; i++){
			Frame frame = new Frame(1, 0);
			game.add(frame);
		}
		
		Frame frame = new Frame(5, 5);
		Frame frameOne = new Frame(5, 0);
		game.add(frame);
		game.add(frameOne);

		CalculateScore calculator = new CalculateScore(game);
		assertEquals(24, calculator.evaluate());
	}
	
	@Test
	public void BowlingTenSparesThen4(){
		ArrayList<Frame> game = new ArrayList<Frame>();
		for(int i=0; i<10; i++){
			Frame frame = new Frame(4, 6);
			game.add(frame);
		}
		
		Frame frameOne = new Frame(4, 0);
		game.add(frameOne);

		CalculateScore calculator = new CalculateScore(game);
		assertEquals(140, calculator.evaluate());
	}


}
