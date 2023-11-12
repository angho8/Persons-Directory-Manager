class Student extends Person{
    private int graduationYear;
    
    Student(String newName, String address, String phone, int graduationYear) {
        super (newName, address, phone);
        this.graduationYear = graduationYear;
    }
    
    int getGraduationYear() {
        return this.graduationYear;
    }
    
    void setGraduationYear(int graduationYear) {
        this.graduationYear = graduationYear;
    }
    
    public String toString() {
        return super.toString() + ("\nGraduation Year: " + graduationYear );
    }
}
