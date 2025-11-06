// ------------------------------------------------------------
// 🧮 OOP Basics: Car Class Example
// ------------------------------------------------------------
// 🧩 Demonstrates core OOP concepts: class, object, constructors, methods
// 🔑 Core Concept: Encapsulation - data and methods bundled together
// 💡 Pattern: Constructor Chaining
//
// Level: 🟢 Easy
// Tags: #OOP #Constructors #Encapsulation
// ------------------------------------------------------------

// WHY: Define blueprint for Car objects
// WHAT: Class containing properties and behaviors of a car
// HOW: Class with attributes, constructors, and methods
class Car {

  // ========== ATTRIBUTES ==========

  // WHY: Store car characteristics
  // WHAT: Instance variables that each car object will have
  // HOW: Declare variables (accessible by all methods in class)
  String engineType;
  String color;
  int horsePower;

  // ========== CONSTRUCTORS ==========

  // WHY: Default constructor - create car with no values
  // WHAT: No-argument constructor
  // HOW: Empty constructor (fields stay null/0)
  public Car() {
  }

  // WHY: Create car with just engine type
  // WHAT: Constructor with one parameter
  // HOW: this.engineType assigns parameter to instance variable
  public Car(String engineType) {
    this.engineType = engineType;
  }

  // WHY: Create car with engine and color
  // WHAT: Constructor with two parameters
  // HOW: this(engineType) calls first constructor (constructor chaining)
  public Car(String engineType, String color) {
    this(engineType); // Call 1-param constructor
    this.color = color; // Set additional field
  }

  // WHY: Create car with all properties
  // WHAT: Constructor with three parameters
  // HOW: this(engineType, color) calls 2-param constructor (chaining continues)
  public Car(String engineType, String color, int horsePower) {
    this(engineType, color); // Call 2-param constructor
    this.horsePower = horsePower;
  }

  // ========== METHODS ==========

  // WHY: Modify car's horsepower
  // WHAT: Method to double the current horsepower
  // HOW: Multiply horsePower by 2 using *= operator
  public void doubleHorsePower() {
    this.horsePower *= 2;
  }

  // WHY: Change car's color
  // WHAT: Method to update color property
  // HOW: Assign new color to this.color
  public void changeColor(String newColor) {
    this.color = newColor;
  }

  // WHY: Display car information
  // WHAT: Override toString() to provide readable representation
  // HOW: Return formatted string with all properties
  public String toString() {
    return "Car [engineType = " + engineType + ", color=" + color +
        ", horsePower=" + horsePower + "]";
  }
}

// WHY: Test the Car class
// WHAT: Main class to demonstrate Car functionality
// HOW: Create objects and call methods
class Question1 {

  public static void main(String[] args) {

    // WHY: Create a Car object with all properties
    // WHAT: rangeRover is a Car instance
    // HOW: new Car() calls 3-parameter constructor
    Car rangeRover = new Car("V8", "Black", 626);

    // WHY: Display initial car state
    // WHAT: Print car object (calls toString())
    // HOW: println automatically calls toString() method
    System.out.println(rangeRover);
    // Output: Car [engineType = V8, color=Black, horsePower=626]

    System.out.println("\nModifying the car properties...\n");

    // WHY: Demonstrate object modification
    // WHAT: Call methods to change car properties
    // HOW: Method calls on rangeRover object
    rangeRover.doubleHorsePower(); // 626 → 1252
    rangeRover.changeColor("White"); // Black → White

    System.out.println("After modifications:");
    System.out.println(rangeRover);
    // Output: Car [engineType = V8, color=White, horsePower=1252]
  }
}

// ⚡ Complexity: N/A (OOP concept demonstration)
// 🗣️ Interview: "Class defines blueprint with properties and methods.
// Constructor chaining reduces code duplication. Methods
// operate on object's data (encapsulation)."

// ------------------------------------------------------------
// 🔑 KEY OOP CONCEPTS DEMONSTRATED
// ------------------------------------------------------------
//
// 1. CLASS: Blueprint for objects (Car)
// 2. OBJECT: Instance of class (rangeRover)
// 3. ATTRIBUTES: Data stored in object (engineType, color, horsePower)
// 4. METHODS: Behaviors/operations (doubleHorsePower, changeColor)
// 5. CONSTRUCTOR CHAINING: this() calls other constructors
// 6. ENCAPSULATION: Data and methods bundled together
// 7. this KEYWORD: Refers to current object

// ------------------------------------------------------------
// 🧠 CONSTRUCTOR CHAINING FLOW
// ------------------------------------------------------------
//
// new Car("V8", "Black", 626)
// ↓
// Calls: Car(String, String, int)
// this(engineType, color) → Calls: Car(String, String)
// this(engineType) → Calls: Car(String)
// Sets: this.engineType = "V8"
// Back to Car(String, String)
// Sets: this.color = "Black"
// Back to Car(String, String, int)
// Sets: this.horsePower = 626
//
// Result: All three fields initialized!

// ------------------------------------------------------------
// 🧠 EDGE CASES / VARIATIONS
// ------------------------------------------------------------
//
// Default constructor: Car c1 = new Car();
// → engineType=null, color=null, horsePower=0
//
// Partial initialization: Car c2 = new Car("V6");
// → engineType="V6", color=null, horsePower=0
//
// Full initialization: Car c3 = new Car("V8", "Red", 500);
// → All fields set
