package edu.norcocollege.cis18b.week2.demo;
import java.util.List;
import java.util.Optional;
/**
 * This class is a review of basic Java language features. It’s not
 * meant to be comprehensive, but it should cover the basics and provide
 * a refresher on syntax and concepts.
 **/
public class ModernFeaturesDemo {
    //Record Dinosaur Type
    public record Dinosaur(String name,String diet,int age);
    //Demonstrate Modern Features
    public void demonstrate() {
        //Create Greeting
        String intro="""
                Welcome to newly and questionable built Dinosaur Park!
                I hope nothing goes wrong during your tour!
                Enjoy!
                """;
        //Display Greeting
        System.out.println(intro);
        //Create Dinosaurs
        var dino1=new Dinosaur("Velociraptor","CARNIVORE",8);
        var dino2=new Dinosaur("Gallimimus","OMNIVORE",5);
        var dino3=new Dinosaur("Pteranodon","CARNIVORE",10);
        var dino4=new Dinosaur("Triceratops","HERBIVORE",3);
        //Create a list of Dinosuars
        var dinosaurs=List.of(dino1,dino2,dino3,dino4);
        //Demonstrate Stream Operation For Carnivores
        var carnivoreNames=dinosaurs.stream()
            .filter(d->d.diet().equals("CARNIVORE"))
            .map(Dinosaur::name)
            .toList();
        System.out.println("Carnivores: " + carnivoreNames);
        //Demonstrate Optional Method
        Optional<Dinosaur>selectedDino=dinosaurs.stream()
            .filter(d-> d.name().equals("Pteranodon"))
            .findFirst();
        var result=selectedDino
            .map(d->"Found dinosaur: "+d.name())
            .orElse("Dinosaur not found!");
        System.out.println(result);
    }
}