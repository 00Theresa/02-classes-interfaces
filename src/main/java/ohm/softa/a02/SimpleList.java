package ohm.softa.a02;

public interface SimpleList {
	/**
	 * Add a given object to the back of the list.
	 */
	void add(Object o);

	/**
	 * @return current size of the list
	 */
	int size();

	/**
	 * Generate a new list using the given filter instance.
	 * @return a new, filtered list
	 */
	SimpleList filter(SimpleFilter filter);

	//test lecture notes
	static SimpleList makeInstance() {
		//dadurch kann man eine Instanz bauen, beispiel:
		// SimpleList myInterface = SimpleList.makeInstance();
		//--> das gibt dann eine konkrete Klasse zurück, die das Interface einbaut und die Methoden vom Interface implementiert hat
		return new SimpleListImpl();
	}
	default void method2(){
		//dadurch kann man eine default mrthode implementieren, die aber auch von den Klassen, die da sinterface implementeiren, überschreiben werden kann
		//bespielsweise kann simpleListImpl auch method2 haben und was anderes reinschreibn. Tut sie das nicht, hat sie die
		//default implementation von dem interface
		System.out.println("Ah, seems not implemented");
	}


}
