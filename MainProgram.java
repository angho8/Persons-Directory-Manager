import java.util.Scanner;

class MainProgram {
	static int input = 0;
	Scanner scanner = new Scanner(System.in);
	Persons persons = new Persons ();
	String option;


	public static void displayDirectory(Persons p) {
        if (p.getSize() == 0) {
            System.out.println("No records found.");
        } 
		else {
            for (Person person : p.getInternalList()) {
                System.out.println(person);
            }
        }
    }

	public void quitDirectory (Scanner k){
	String quit = k.nextLine();
	if (quit.equals("q") || quit.equals("Q")) {
    	System.exit(0);
		}
	}

	public static void enterNewPerson(Persons p, Scanner k){
        System.out.print("Enter name: ");
        String name = k.nextLine();
        System.out.print("Enter address: ");
        String address = k.nextLine();
        System.out.print("Enter phone: ");
        String phone = k.nextLine();
        System.out.print("Is this person an employee? (Yes/No): ");
        boolean isEmployee = k.nextLine().equals("Yes") ? true: false;
        //Request employee data
        
		if (isEmployee){
            System.out.print("Enter department: ");
			String department = k.nextLine();
			Employee employee = new Employee(name, address, phone, department);
			p.add (employee);
		}
		else {
			System.out.println("Is this person a student? (Yes/No): ");
			boolean isStudent = k.nextLine().equals("Yes") ? true: false;
			if (isStudent){
				System.out.print("Enter graduation year: ");
				int gradYear = Integer.parseInt(k.nextLine());
				Student student = new Student(name, address, phone, gradYear);
				p.add(student);
			}
		}
    }

	public static void addPerson (Persons p, Scanner k){
		System.out.println ("Enter name: ");
		String name = k.nextLine();
		Persons addPersons = p.add (new Persons ());
		System.out.println("\nPerson is added to the list.");
	}


	public static void searchPerson (Persons p, Scanner k){
		System.out.print ("Enter search: ");
		String name = k.nextLine();
		Persons searchPersons = p.search(name);

		if (searchPersons.getSize() == 0) {
			System.out.println("No records");
		}
		else {
			for (Person person : searchPersons.getInternalList()) {
				System.out.println(person);
			}
		}
	}

	public static void modifyInfo (Persons p, Scanner k){
		System.out.print("Enter name to modify: ");
        String name = k.nextLine();
        Persons seacPersons = p.search(name);

		for (Person person : seacPersons.getInternalList()) {
			System.out.println(person);
			System.out.print("Do you want to modify this record? (Yes/No): ");
			boolean modify = k.nextLine().equals("Yes") ? true: false;

			if (modify){			
				System.out.print("Enter new name: ");
				String newName = k.nextLine();
				System.out.print("Enter new address: ");
				String newAddress = k.nextLine();
				System.out.print("Enter new phone: ");
				String newPhone = k.nextLine();

				person.setName(newName);
				person.setAddress(newAddress);
				person.setPhone(newPhone);
			}
		}
	}


	public static void deletePerson (Persons p, Scanner k){
		System.out.print("Enter the name to delete: ");
        int index  = k.nextInt();
		k.nextLine();

        if (index < 0 || index >= p.getSize()) {
            System.out.println("No person found.");
        } 
		else {
            System.out.println("Record to delete: " + p.getInternalList().get(index));
            System.out.print("Do you want to delete this person? (Yes/No): ");
            boolean delete = k.nextLine().equals("Yes") ? true: false;
            if (delete) {
                k.delete(index);
                System.out.println("Record deleted.");
            }
		}
	}



    public static void main(String[] args){

		Persons p = new Persons();
		Scanner k = new Scanner(System.in);
		
		enterNewPerson(p, k);

		Person samplePerson1 = new Person("Jay", "Crashboat Beach", "111-222-3333");
        Person samplePerson2 = new Person("Phil", "Cape Code", "111-111-1111");
        Person samplePerson3 = new Person("Haley", "Malibu Beach", "123-123-1234");

        System.out.println("Size is " + p.getSize());
        System.out.println(samplePerson1);

        p.add(samplePerson1);
        p.add(samplePerson2);
        p.add(samplePerson3);

        System.out.println("After inserting 3 people, the size is " + p.getSize());
		displayDirectory(p);
        
        System.out.println("Searching for Jay");
        System.out.println("Phil is at index: " + p.search("Phil"));

		p.delete(1);
		System.out.println ("After deleting a person, the size is" + p.getSize());
		displayDirectory(p);
		
       
        System.out.println("\nTo String method:");
        System.out.println(p.toString());
	}
}
