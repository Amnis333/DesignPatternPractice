import java.util.Arrays;

class Cat extends Mammal implements PlayfulPet{
    public static final String SPECIES = "cat";
    public static final double BODY_TEMPERATURE = 37;
    public static final double LIFE_EXPECTANCY = 5500;

    private static final double PLAYFUL_HOURLY_COSTS = 50;
    private static final String[] LIKED_ACTIVITIES = {"eat","nap","groom","drink","crawl","explore","pet"};
    private static final String[] DISLIKED_ACTIVITIES = {"bath"};

    public Cat(double heightM, double weightKg, String biologicalSex){
        super(SPECIES, heightM, weightKg, LIFE_EXPECTANCY, biologicalSex, BODY_TEMPERATURE);
    }

    public String toString(){
        return super.toString() + "this is cat.";
    }

    public String playwithPerson(Person p){
        return "This cat is playing with " + p.getName();
    }
    
    public String play(){
        return "This cat starts rolling on the floor, and pretends to play predator";
    }

    public String playNoise(){
        return "Meow";
    }

    public double cost(){
        return PLAYFUL_HOURLY_COSTS;
    }

    public boolean likesActivity(String activity){
        return Arrays.asList(LIKED_ACTIVITIES).contains(activity);
    }

    public boolean dislikesActivity(String activity){
        return Arrays.asList(DISLIKED_ACTIVITIES).contains(activity);
    }

    public String doActivity(String activity){
        if (activity == "eat"){
            super.eat();
            return "This cat enjoyed eating";
        }
        else if (activity == "nap"){
            super.sleep();
            return "This cat took a good nap";
        }
        else if (this.likesActivity(activity)){
            return "This cat enjoyed " + activity;
        }
        else if (this.dislikesActivity(activity)){
            return "This cat did not enjoy " + activity;
        }
        else{
            return "This cat does not know how to " + activity;
        }
    }
}