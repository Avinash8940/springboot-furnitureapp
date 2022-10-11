package com.furnitureapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.furnitureapp.model.Category;
import com.furnitureapp.model.Furniture;
import com.furnitureapp.model.Material;
import com.furnitureapp.model.Type;
import com.furnitureapp.service.IFurnitureService;

@SpringBootApplication
public class SpringassignmentsApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringassignmentsApplication.class, args);
		
	}
	@Autowired
	IFurnitureService furnitureService;
	@Override
	public void run(String... args) throws Exception {
		//furnitureService.addFurniture(new Furniture(1,"table",Material.IRON.material,Type.BEDS.type,Category.BEDROOM.category,"round",10000,2));
		//System.out.println(furnitureService.deleteFurniture(3));
		//System.out.println( furnitureService.updateFurniture(1, 200));
		furnitureService.getByCategory("Bed Room").forEach(System.out::println);
		furnitureService.getByType(Type.BEDS.type).forEach(System.out::println);
		furnitureService.getByCategoryAndType("studyroom","singlebed").forEach(System.out::println);
		furnitureService.getByNameAndCategory("diwani", "Hall").forEach(System.out::println);
		furnitureService.getByNameAndMaterial("table", "iron").forEach(System.out::println);
		furnitureService.getByNameAndPrice("table", 10000).forEach(System.out::println);
		furnitureService.getByNameAndShape("table", "round").forEach(System.out::println);
	}
	
	

}
