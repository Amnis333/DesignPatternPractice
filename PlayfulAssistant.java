import java.util.Arrays;
import java.util.List;
import java.util.Random;

abstract class PlayfulPetAssistant{
    protected static final double DEFAULT_RENT_TIME = 1.0;
    protected static final String DEFAULT_TOUR = "all-rounder pack";

    protected Person currentPerson;
    protected double currentRentTime = PlayfulPetAssistant.DEFAULT_RENT_TIME;
    protected static String[] availableActivities = {"eat","walk","drink","nap","pet","run","explore"};
    protected static String[] availableTours = {"all-rounder pack", "deluxe rounder pack"};

    public String[] getActivities(){
        return PlayfulPetAssistant.availableActivities;
    }

    public String[] getAvailableTours(){
        return PlayfulPetAssistant.availableTours;
    }

    public boolean isValidTour(String tour){
        return Arrays.asList(this.getAvailableTours()).contains(tour);
    }

    protected String getRandomActivity(){
        List<String> activities = Arrays.asList(this.getActivities());
        int ran = new Random().nextInt(activities.size());
        return activities.get(ran);
    }

    public void setPerson(Person person){
        this.currentPerson = person;
    }

    public void setHours(double hours){
        this.currentRentTime = hours;
    }

    public double getCurrentRentTime(){
        return this.currentRentTime;
    }

    public void reset(){
        this.currentPerson = null;
        this.currentRentTime = PlayfulPetAssistant.DEFAULT_RENT_TIME;
    }

    public double runAssistenceTour(Person person){
        return this.runAssistenceTour(person, PlayfulPetAssistant.DEFAULT_TOUR);
    }

    public double runAssistenceTour(Person person, String tour){
        if(!this.isValidTour(tour)){
            throw new IllegalArgumentException("Invalid tour");
        }
        PlayfulPet playfulPet = this.createPlayfulPet();
        System.out.println("");
        System.out.println("Booting up... Playful Pet Assistance robot at your service.");
        System.out.println("Printing information about the Person to service..." + person);
        System.out.println("");
        System.out.println("Printing information about the Playful Pet - " + playfulPet.getPetName() + " to service..." + playfulPet);

        if(tour == "all-rounder pack" || tour == "deluxe rounder pack"){
            int count = tour == "all-rounder pack" ? 1 : 3;
            this.genericRounderTour(count, person, playfulPet);
        }
        
        // ここにさらにツアーを追加することができます。
        else{
            System.out.println("The tour assistant robot for " + playfulPet.getPetName() + " and " + person.getName() + " did nothing.");
        }

        double rentalCosts = playfulPet.cost() * this.currentRentTime;
        // ツアーが終了すると、このアシスタントロボットをリセットします。
        this.reset();

        // レンタルにいくらかかったか返します。
        return rentalCosts;

    }
    private void genericRounderTour(int activityCount, Person person, PlayfulPet pet){
        String newLine = System.lineSeparator();
        System.out.println(newLine + "Now starting the generic rounder tour with " + activityCount + " activity(s)");
        System.out.println(person.getName() + " greets " + pet.getPetName() + newLine);
        System.out.println(pet.play() + newLine);
        System.out.println(pet.playNoise() + newLine);
        System.out.println(pet.playwithPerson(person) + newLine);
        for(int i = 0; i < activityCount; i++){
            String activity = this.getRandomActivity();
            System.out.println(pet.getPetName() + " will now " + activity);
            System.out.println("--------");
            System.out.println(pet.doActivity(activity));
            System.out.println("--------" + newLine);
        }
    }
    // Factory Method
    // ここでは抽象メソッドとして定義し、実際のインスタンス生成はサブクラスに任せる
    public abstract PlayfulPet createPlayfulPet();
}
