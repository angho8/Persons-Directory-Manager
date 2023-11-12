class Employee extends Person{
    private String department;
    
    Employee(String newName, String address, String phone, String department) {
        super(newName, address, phone);
        this.department = department;
    }
    
    String getDepartment() {
        return this.department;
    }
    
    void setDepartment(String newDepartment) {
        this.department = newDepartment;
    }
    
    public String toString() {
        return super.toString() + ("\n Department: " + department);
    }
}
