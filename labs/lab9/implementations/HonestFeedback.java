package lab9.implementations;

import java.util.HashSet;
import java.util.Set;

import lab9.Guess;
import lab9.providers.ProvidesFeedback;

/**
 * Correctly responds to a given Guess
 * 
 * @author roncytron
 *
 */
public class HonestFeedback implements ProvidesFeedback {

	private final Guess code;

	/** 
	 * Capture the code that will be compared with Guesses
	 * @param code
	 */
	public HonestFeedback(Guess code) {
		this.code = code;
	}

	/**
	 * For the supplied Guess, how many peg ids occur in the correct position
	 *   with respect to the desired goal?
	 * For example, if the goal is 0 2 3 1
	 *            and the guess is 0 1 3 4
	 * then the result is 2, because the pegs with ids 0 and 3 are in exactly the
	 * right position.
	 * @param guess the Guess to be judged with respect to the goal
	 * @return the number of peg ids in the correct position
	 */

	@Override
	public int numSamePosition(Guess other) {
		int num = 0;
		for(int i=0;i < code.size();++i) {
			if(code.getChoice(i) == other.getChoice(i)) {
				num++;
			}
		}
		return num;
	}

	/**
	 * Given the supplied Guess, how many peg ids are in common with the desired
	 *    goal and the guess?
	 *    
	 * For example, if the goal is 0 2 3 1
	 *            and the guess is 0 1 3 4
	 * then the result is 3 because peg ids 0, 1, and 3 occur in both the goal and
	 * the guess.
	 * @param guess the Guess to be judged with respect to the goal
	 * @return the number of peg ids in common with the goal and the guess
	 */

	@Override
	public int numIntersection(Guess other) {
		Set<Integer> s1 = new HashSet<Integer>();
		for(int i=0;i<code.size();++i) {
			s1.add(code.getChoice(i));
		}
		Set<Integer> s2 = new HashSet<Integer>();
		for(int i=0;i<other.size();++i) {
			s2.add(other.getChoice(i));
		}
		Set<Integer> same = new HashSet<Integer>(s1);
		same.retainAll(s2);

		return same.size();
	}
	// looked at Stackoverflow for ideas(retainAll)

	/**
	 * Is the solution correct?   This can be reduced from numSamePosition(guess)
	 *   returning an answer showing all pegs of the Guess are in the correct
	 *   position.
	 * @param guess the supplied Guess to be judged
	 * @return true iff the guess is completely correct
	 */

	public boolean isSolution(Guess other) {
		int ans = numSamePosition(other);
		if(ans == code.size()) {
			return true;
		}
		else {
			return false;
		}
	}
}
