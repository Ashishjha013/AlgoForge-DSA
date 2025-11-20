class Student {
  // Enter the password to set and get marks
  private int marks;
  static String password = "secure123";


  public int getMarks() {
    return this.marks;
  }
  
  public void setMarks(int marks, String password) {
    if (Student.password.equals(password)) {
      this.marks = marks;
    } else {
      System.out.println("Invalid password. Marks not updated.");
    }
  }

  public static void main(String[] args) {
    Student student = new Student();

    // Attempt to set marks with correct password
    student.setMarks(95, "secure123");
    System.out.println("Marks: " + student.getMarks());
    // Attempt to set marks with incorrect password
  }
}
