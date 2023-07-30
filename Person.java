class Person extends Mammal{
    public static final String SPICIES = "human";
    public static final double BODY_TEMPERATURE = 36;
    public static final double LIFE_EXPECTANCY = 30000;

    private String name;
    private int age;

    public Person(String firstName, String lastName, int age, double heightM, double weightKg, String biologicalSex){
        super(SPICIES, heightM, weightKg, LIFE_EXPECTANCY, biologicalSex, BODY_TEMPERATURE);
        this.name = firstName + " " + lastName;
        this.age = age;
    }

    public String getName(){
        return this.name.toString();
    }

    public String toString(){
        return super.toString() + ". The name of this Person is " + this.getName() + ". This person is " + this.age + " years old.";
    }
}