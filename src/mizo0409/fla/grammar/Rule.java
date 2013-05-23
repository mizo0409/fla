package mizo0409.fla.grammar;

public class Rule implements Comparable<Rule> {

	private Sequence leftSide;
	
	private Sequence rightSide;
	
	public Rule(String string) {
		String[] spaceSeparatedStrings = string.split("\\s+->\\s+");
		this.leftSide = new Sequence(spaceSeparatedStrings[0].split("\\s+"));
		this.rightSide = new Sequence(spaceSeparatedStrings[1].split("\\s+"));
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.leftSide.toString(" "));
		builder.append(" -> ");
		builder.append(this.rightSide.toString(" "));
		return builder.toString();
	}
	
	public int compareTo(Rule rule) {
		int difference = 0;
		difference = this.leftSide.compareTo(rule.leftSide);
		if(difference != 0) {
			return difference;
		}
		difference = this.rightSide.compareTo(rule.rightSide);
		if(difference != 0) {
			return difference;
		}
		return difference;
	}
	
	public Sequence getLeftSide() {
		return this.leftSide;
	}
	
	public Sequence getRightSide() {
		return this.rightSide;
	}
	
}
