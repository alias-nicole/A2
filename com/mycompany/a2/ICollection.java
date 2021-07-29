package com.mycompany.a2;

public interface ICollection 
{
	public void add(GameObject newGameObject);
	public void remove(GameObject gameObject);
	//instantiate iterator to go thru the collection of GameObjects
	public IIterator getIterator();

}
