import java.util.ArrayList;

public class Persons {
    private int size;
    private ArrayList<Person> persons;


    public Persons() {
        persons = new ArrayList<Person> ();
    }


	ArrayList <Person> getInternalList(){
        return persons;
    }

    Persons search (String name) {
        Persons searchPersons = new Persons ();
        for (Person person : persons){
            if (person.getName().equalsIgnoreCase(name)){
                searchPersons.add (person);
            }
        }
        return searchPersons;
    }


    void add(Person person) {
        persons.add (person);
        size++;
	}


    int getSize() {
        return size;
    }

    void delete(int i) {
        if (i >= 0 && i < size){
            persons.remove (i);
            size --;
        }

	}


    public String toString(){
        return "ArrayList [size = " + size +"]";
    }

}

