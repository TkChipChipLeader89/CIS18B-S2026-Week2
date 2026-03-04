package edu.norcocollege.cis18b.week2.demo;
import java.util.List;
/**
 * This class is a review of basic Java language features. It’s not
 * meant to be comprehensive, but it should cover the basics and provide
 * a refresher on syntax and concepts.
 *
 * TODO:
 *  - Demonstrate variable declarations and types
 *  - Demonstrate control flow (if, switch, loops)
 *  - Demonstrate methods and parameters
 *  - Demonstrate basic OOP concepts (classes, objects, inheritance)
 */
public class LanguageBasicsReview {
    //Private Variables
    private String dinosaurName;
    //no-arg Constuctor
    public LanguageBasicsReview(){
        this.dinosaurName="Dinosaur";
    }
    //one-arg Constuctor
    public LanguageBasicsReview(String dinosaur){
        this.dinosaurName=dinosaur;
    }
    //Roar Method
    public void roar(){
        System.out.println(dinosaurName+" ROARS LOUDLY!");
    }
    //isExtinct Method
    public static boolean isExtinct(int year){
        return year<65_000_000;
    }
    //Overloaded Eat Methods
    public int eat(int plants){
        return plants*2;
    }
    public double eat(double lbsOfMeat){
        return lbsOfMeat*2.5;
    }
    //Custom UnknownDinosaurTypeException
    static class UnknownDinosaurTypeException extends Exception{
        public UnknownDinosaurTypeException(String message){
            super(message);
        }
    }
    //Diet Switch Expression
    public String dietType(String type) throws UnknownDinosaurTypeException{
        return switch (type.toUpperCase()){
            case "CARNIVORE"->"Eats meat!";
            case "HERBIVORE"->"Eats plants!";
            case "OMNIVORE"->"Eats both plants and meat!";
            default -> throw new UnknownDinosaurTypeException("Unknown Dinosaur Type Diet: "+type);
        };
    }
    //Demonstrate All Features
    public void demonstrate() {
        //Create Var Trex & initialize
        var trex=new LanguageBasicsReview("T-rex");
        //Demonstrate Roar Method
        trex.roar();
        //Demonstrate isExtinct Method
        var extinct=isExtinct(2026);
        System.out.println("Is dinosaur extinct? "+extinct);
        //Demonstrate Eat Methods
        var plantSource=trex.eat(10);
        var meatSource=trex.eat(15.5);
        System.out.println("Energy from plants: "+plantSource);
        System.out.println("Energy from meat: "+meatSource);
        //Creating a List of Dinosaurs
        var dinosaurs=List.of("T-rex","Tenontosaurus","Oviraptor");
        System.out.println("Known dinosaurs: "+dinosaurs);
        //Demonstrate DietType & Custom Exception Method
        try{
            var diet=trex.dietType("Carnivore");
            System.out.println("Diet type: "+diet);
            //Trigger the Custom Exception
            trex.dietType("Rock");
        }catch(UnknownDinosaurTypeException e){
            System.out.println("Caught Exception: "+e.getMessage());
        }
        System.out.println("Completed Dinosaur Demonstation!");
    }
}