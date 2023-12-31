import java.util.Scanner;

class Car{
    public int pass = 0;
    public int passMax = 2; // limite de Passageiros
    public int gas = 0; // tanque
    public int gasMax = 100; // limite do tanque
    public int km = 0; // quantidade de quilometragem
    
    public Car() {
    
    }
    public String toString(){
        return "pass: " + this.pass + ", gas: " + this.gas + ", km: " + this.km;
    }
    public void enter(){
        if (pass == passMax){
            System.out.println("fail: limite de pessoas atingido");
        }
        else {
            pass += 1;
        }
            
    }
    public void leave(){
        if (pass == 0){
            System.out.println("fail: nao ha ninguem no carro");
        }
        else {
            pass -= 1;
        }
    }
    public void fuel(int gas){
        if(gas > gasMax){
            this.gas = gasMax % gas;
        }
        else {
            this.gas += gas;
        }
    }
    public void drive (int km){
        if(pass == 0) {
            System.out.println("fail: nao ha ninguem no carro");
            return;
        }
        if(gas == 0) {
            System.out.println("fail: tanque vazio");
            return;
        }
        if(gas < km) {
            System.out.println("fail: tanque vazio apos andar " + this.gas + " km");
            this.km += this.gas;
            this.gas = 0;
            return;
        }
        this.km = km % this.gasMax;
        this.gas -= km;
        
    }

    
}

class Solver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car car = new Car();

        while(true) {
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            System.out.println("$" + line);
            if(ui[0].equals("end")) {
                break;
            } else if(ui[0].equals("enter")) {
                car.enter();
            } else if(ui[0].equals("leave")) {
                car.leave();
            } else if(ui[0].equals("show")) {
                System.out.println(car.toString());
            } else if (ui[0].equals("drive")) {//km
                car.drive(Integer.parseInt(ui[1]));
            } else if (ui[0].equals("fuel")) {//gas
                car.fuel(Integer.parseInt(ui[1]));
            } else{
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}