class PlayfulDogAssistant extends PlayfulPetAssistant{
    public PlayfulPet createPlayfulPet(){
        return new Dog(RandomWrapper.getRanDouble(0.15,0.3), RandomWrapper.getRanDouble(2.0,4.9), RandomWrapper.ranBoolean() ? "male" : "female");   
    }
}