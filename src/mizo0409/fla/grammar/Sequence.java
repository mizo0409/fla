package mizo0409.fla.grammar;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class Sequence extends ArrayList<String> implements Comparable<Sequence> {
	
	public Sequence() {
	}
	
	public Sequence(String[] symbols) {
		for(String symbol : symbols) {
			this.add(symbol);
		}
	}
	
	public String toString(String delimiter) {
		StringBuilder builder = new StringBuilder();
		if(this.size() > 0) {
			builder.append(this.get(0));
		}
		for(int i = 1; i < this.size(); i++) {
			builder.append(delimiter);
			builder.append(this.get(i));
		}
		return builder.toString();
	}
	
	public int compareTo(Sequence sequence) {
		int count = Math.min(this.size(), sequence.size());
		for(int i = 0; i < count; i++) {
			int difference = this.get(i).compareTo(sequence.get(i));
			if(difference != 0) {
				return difference;
			}
		}
		return this.size() - sequence.size();
	}
	
}
