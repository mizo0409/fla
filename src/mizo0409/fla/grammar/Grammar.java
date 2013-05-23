package mizo0409.fla.grammar;

import java.util.Iterator;
import java.util.Set;

public class Grammar {

	private Set<String> nonterminalSymbols;
	
	private Set<String> terminalSymbols;
	
	private Set<Rule> rules;
	
	private String startSymbol;
	
	public Grammar(Set<String> nonterminalSymbols, Set<String> terminalSymbols, Set<Rule> rules, String startSymbol) {
		this.nonterminalSymbols = nonterminalSymbols;
		this.terminalSymbols = terminalSymbols;
		this.rules = rules;
		this.startSymbol = startSymbol;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("(");
		Iterator<String> nonterminalSymbolIterator = this.nonterminalSymbols.iterator();
		builder.append("{");
		if(nonterminalSymbolIterator.hasNext()) {
			String nonterminalSymbol = nonterminalSymbolIterator.next();
			builder.append(nonterminalSymbol);
		}
		while(nonterminalSymbolIterator.hasNext()) {
			String nonterminalSymbol = nonterminalSymbolIterator.next();
			builder.append(",");
			builder.append(nonterminalSymbol);
		}
		builder.append("}");
		builder.append(",");
		Iterator<String> terminalSymbolIterator = this.terminalSymbols.iterator();
		builder.append("{");
		if(terminalSymbolIterator.hasNext()) {
			String terminalSymbol = terminalSymbolIterator.next();
			builder.append(terminalSymbol);
		}
		while(terminalSymbolIterator.hasNext()) {
			String terminalSymbol = terminalSymbolIterator.next();
			builder.append(",");
			builder.append(terminalSymbol);
		}
		builder.append("}");
		builder.append(",");
		Iterator<Rule> ruleIterator = rules.iterator();
		builder.append("{");
		if(ruleIterator.hasNext()) {
			Rule rule = ruleIterator.next();
			builder.append(rule.toString());
		}
		while(ruleIterator.hasNext()) {
			Rule rule = ruleIterator.next();
			builder.append(",");
			builder.append(rule.toString());
		}
		builder.append("}");
		builder.append(",");		
		builder.append(this.startSymbol);
		builder.append(")");
		return builder.toString();
	}
	
	public Set<String> getNonterminalSymbols() {
		return this.nonterminalSymbols;
	}
	
	public Set<String> getTerminalSymbols() {
		return this.terminalSymbols;
	}
	
	public Set<Rule> getRules() {
		return this.rules;
	}
	
	public String getStartSymbol() {
		return this.startSymbol;
	}
	
}
