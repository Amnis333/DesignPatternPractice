class Main{
    public static void main(String[] args) {
        FairlyWorld fairlyWorld = new FairlyWorld();
        Person jessica = new Person("Jessica", "Roller", 30, 1.65, 95, "female");
        fairlyWorld.rentPet(new PlayfulCatAssistant(), jessica);
        fairlyWorld.rentPet(new PlayfulDogAssistant(), jessica);
    }
}