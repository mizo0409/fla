package mizo0409.fla.grammar;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class Language implements Set<Sequence>{

	private Grammar grammar;
	
	public Language(Grammar grammar) {
		this.grammar = grammar;
	}
	
	@Override
	public boolean add(Sequence sequence) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Sequence> c) {
		return false;
	}

	@Override
	public void clear() {
	}

	@Override
	public boolean contains(Object o) {
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean isEmpty() {
		LanguageIterator iterator = new LanguageIterator();
		return !iterator.hasNext();
	}

	@Override
	public Iterator<Sequence> iterator() {
		return new LanguageIterator();
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public Object[] toArray() {
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	class LanguageIterator implements Iterator<Sequence> {

		LinkedList<Sequence> queue = new LinkedList<Sequence>();
		
		Sequence nextSequence = null;

		LanguageIterator() {
			@SuppressWarnings("serial")
			Sequence initialSequence = new Sequence() {{
				add(grammar.getStartSymbol());
			}};
			
			this.queue.addLast(initialSequence);
		}
		
		@Override
		public boolean hasNext() {
			if(this.nextSequence == null) {
				this.nextSequence = this.next();
			}
			return this.nextSequence != null;
		}

		@Override
		public Sequence next() {
			Sequence nextSequence = null;
			if(this.nextSequence == null) {
				while(!queue.isEmpty()) {
					Sequence sequence = queue.removeFirst();
					int derivationCount = 0;
					for(Rule rule : grammar.getRules()) {
						Sequence leftSide = rule.getLeftSide();
						for(int i = 0; i < (sequence.size() - leftSide.size() + 1); i++) {
							boolean match = true;
							for(int j = 0; j < leftSide.size(); j++) {
								if(!sequence.get(i + j).equals(leftSide.get(j))) {
									match = false;
								}
							}
							if(match) {
								Sequence derivedString = new Sequence();
								derivedString.addAll(sequence.subList(0, i));
								derivedString.addAll(rule.getRightSide());
								derivedString.addAll(sequence.subList(i + leftSide.size(), sequence.size()));
								this.queue.addLast(derivedString);
								derivationCount++;
							}
						}
					}
					if(derivationCount == 0) {
						nextSequence = sequence;
						break;
					}
				}
			}
			else {
				nextSequence = this.nextSequence;
				this.nextSequence = null;
			}
			return nextSequence;
		}

		@Override
		public void remove() {
		}
		
	}
	
}
