class Person {
    private String name;
    private String address;
    private String phone; 
    
    Person(String newName, String address, String phone){
        this.name = newName;
        this.address = address;
        this.phone = phone;
    }

    Person(){
        this.name="none";
        this.address= "none";
        this.phone="999-999-9999";
    }

    void setName(String name){
        this.name = name;
    }

    String getName(){
        return(this.name);
    }

    String getPhone(){
        return (this.phone);
    }

    void setAddress(String address){
        this.address = address;
    }
    
    String getAddress(){
        return (this.address);
    }

    public String toString (){
        return ("Name: " + this.name + "\nAddress: " + this.address +" \nPhone: " + this.phone);
    }

    public static void main (String[] args){
        System.out.println("testing Person");
        Person aNewPersonObject = new Person("Mark", "Vancouver", "800-365-1999");
        System.out.println(aNewPersonObject.getName());
    }
}
