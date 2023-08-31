import java.util.Scanner;
import java.text.*;

class Pet{
    private int energyMax, hungryMax, cleanMax;
    private int energy, hungry, shower, clean;
    private int diamonds = 0;
    private int age = 0;
    private boolean alive;
    
    void setEnergy(int value){
        if(value <= 0){
           this.energy = 0;
           System.out.println("fail: pet morreu de fraqueza");
           this.alive = false;
        }
        if(value > this.energyMax){
            this.energy = this.energyMax;
        }
        this.energy = value;
    }
    
    public void setHungry(int value){
        if(value <= 0){
            this.hungry = 0;
            System.out.println("fail: pet morreu de fome");
            this.alive = false;
        }
        if(value > this.hungryMax){
            this.hungry = this.hungryMax;
        }
        this.hungry = value;
    }
    
    void setClean(int value){
        if(value <= 0){
            this.clean = 0;
            System.out.println("fail: pet morreu de sujeira");
            this.alive = false;
        }
        if(value > this.cleanMax){
            this.clean = this.cleanMax;
        }
        this.clean = value;
    }
    
    public Pet(int energy , int hungry, int clean){
        this.energy = energy;
        this.hungry = hungry;
        this.clean = clean;
        energyMax = energy;
        hungryMax = hungry;
        cleanMax = clean;
        diamonds = 0;
        age = 0;
        alive = true;
        
        
    }
    public String toString(){
        return "E:" + energy + "/" + energyMax + 
        ", " + "S:" + hungry + "/" + hungryMax + 
        ", " + "L:" + clean + "/" + cleanMax + 
        ", " + "D:" + diamonds + 
        ", " + "I:" + age;
    }
    
    private boolean testAlive(){
        if (alive)
            return true;
            System.out.println("fail: pet esta morto");
        return false;
    }
    
    public void play(){
        if(!testAlive())
            return;
        setEnergy(getEnergy() - 2);
        setHungry(getHungry() - 1);
        setClean(getClean() - 3);
        diamonds += 1;
        age += 1;
    }
    public void shower(){
        if (!testAlive())
            return;
        setEnergy(getEnergy() - 3);
        setHungry(getHungry() - 1);
        setClean(getCleanMax());
        age += 2;
    }
    public void eat(){
        if(!testAlive())
            return;
        setEnergy(getEnergy() - 1);
        setHungry(getHungry() + 2);
        setClean(getClean() - 2);
        age += 1;
    }
    public void sleep(){
         if (!testAlive())
            return;
        if (getEnergy() <= getEnergyMax() - 5)
        {
            age += getEnergyMax() - getEnergy();
            setEnergy(getEnergyMax());
            setHungry(getHungry() - 1);
        }
        else
        {
            System.out.println("fail: nao esta com sono");
            return;
        }
    }
    
    //Métodos GET
    int getClean(){
        return clean;
    }
    int getHungry(){
        return hungry;
    }
    int getEnergy(){
        return energy;
    }
    int getEnergyMax(){
        return energyMax;
    }
    int getCleanMax(){
        return cleanMax;
    }
    int getHungryMax(){
        return hungryMax;
    }
}
class Solver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pet pet = new Pet(0, 0, 0);
        
        while(true) {
            String line = scanner.nextLine();
            System.out.println("$" + line);
            String ui[] = line.split(" ");
            if(ui[0].equals("end")) {
                break;
            } else if(ui[0].equals("show")) {
                System.out.println(pet.toString());
            } else if(ui[0].equals("init")) {
                int energy = Integer.parseInt(ui[1]);
                int hungry = Integer.parseInt(ui[2]);
                int clean = Integer.parseInt(ui[3]);
                pet = new Pet(energy, hungry, clean);
            } else if(ui[0].equals("play")) {
                pet.play();
            } else if(ui[0].equals("eat")) {
                pet.eat();
            } else if(ui[0].equals("clean")) {
                pet.shower();
            } else if(ui[0].equals("sleep")) {
                pet.sleep();
            } else {
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}
