package mizo0409.fla.grammar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Writer {

	public static void main(String[] args) {
		@SuppressWarnings("serial")
		Set<String> nonterminalSymbols = new TreeSet<String>() {{
			add("S");
			add("R");
		}};
		
		@SuppressWarnings("serial")
		Set<String> terminalSymbols = new TreeSet<String>() {{
			add("0");
			add("1");
		}};
		
		@SuppressWarnings("serial")
		Set<Rule> rules = new TreeSet<Rule>() {{
			add(new Rule("S -> 1"));
			add(new Rule("S -> 1 R"));
			add(new Rule("R -> 0"));
			add(new Rule("R -> 1"));
			add(new Rule("R -> 0 R"));
			add(new Rule("R -> 1 R"));
		}};
		
		Grammar grammar = new Grammar(nonterminalSymbols, terminalSymbols, rules, "S");
		
		Writer writer = new Writer();
		writer.setGrammar(grammar);
		
		int numberOfStrings = 10;
		List<Sequence> sequences = writer.write(numberOfStrings);
		for(Sequence sequence : sequences) {
			for(String symbol : sequence) {
				System.out.print(symbol);
			}
			System.out.println();
		}
	}
	
	private Grammar grammar;
	
	public void setGrammar(Grammar grammar) {
		this.grammar = grammar;
	}
	
	public List<Sequence> write(int numberOfSequences) {
		List<Sequence> sequences = new ArrayList<Sequence>();
		
		Language language = new Language(this.grammar);
		Iterator<Sequence> iterator = language.iterator();
		
		for(int i = 0; iterator.hasNext() && i < numberOfSequences; i++) {
			Sequence sequence = iterator.next();
			sequences.add(sequence);
		}
		
		return sequences;
	}
	
}
