import java.util.Arrays;
class Dog extends Mammal implements PlayfulPet{
    public static final String SPECIES = "Dog";
    public static final double LIFE_EXPECTANCY = 4800;
    public static final double Body_TEMPERATURE = 39;
    
    private static final double PLAYFUL_HOURLY_COSTS = 35;
    private static final String[] LIKED_ACTIVITIES = {"eat","nap","chase","swim","drink","run","explore","pet"};
    private static final String[] DISLIKED_ACTIVITIES = {"hug","dressup"};

    public Dog(double heightM, double weightKg, String biologicalSex){
        super(Dog.SPECIES, heightM, weightKg, Dog.LIFE_EXPECTANCY, biologicalSex, Dog.LIFE_EXPECTANCY);
    }

    public String toString(){
        return super.toString() + " this is a dog";
    }

    public void woof(){
        System.out.println("Woof Woof");
    }

    public String getPetName(){
        return this.species;
    }

    public String play(){
        return "This dog starts running on the park and chases a ball.";
    }

    public String playwithPerson(Person person){
        String s = "The dog runs towards " + person.getName();
        s+= ". After the dog taking kin to " + person.getName() + ", " + person.getName() + " throws a frisbee disk and the dog chases it.";
        return s;
    }

    public String playNoise(){
        return "Wooooof Woooof";
    }

    public double cost(){
        return Dog.PLAYFUL_HOURLY_COSTS;
    }

    public boolean likesActivity(String activity){
        return Arrays.asList(Dog.LIKED_ACTIVITIES).contains(activity);
    };

    public boolean dislikesActivity(String activity){
        return Arrays.asList(Dog.DISLIKED_ACTIVITIES).contains(activity);
    };

    public String doActivity(String activity){
        if(activity == "eat"){
            this.eat();
            return "The dog ate the entire food in a few bites.";
        }
        else if(activity == "nap"){
            this.sleep();
            return "The dog took a quick nap.";
        }
        else if(this.likesActivity(activity)) return "Woof Woof. The dog really enjoyed the " + activity + " activity.";
        else if(this.likesActivity(activity)) return "The dog did not like " + activity + " activity. The dog walked away";
        return "The dog felt indiferent about the " + activity + " activity.";
    };
}