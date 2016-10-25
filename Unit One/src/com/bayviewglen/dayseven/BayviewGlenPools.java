package com.bayviewglen.dayseven;

import java.util.Scanner;

public class BayviewGlenPools {
	
	static final double LEVEL_OF_WATER = 0.9;
	static final int CONVERSION_TO_LITRES = 1000;

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		//entering in all values and dimensions of the pool and liner prices 
		System.out.print("Enter length of the pool ");
		double length = keyboard.nextDouble();
		
		System.out.print("Enter width of the pool ");
		double width = keyboard.nextDouble();
		
		System.out.print("Enter depth at shallow end "); 
		double shallowDepth = keyboard.nextDouble();
		
		System.out.print("Enter depth at deep end ");
		double deepDepth = keyboard.nextDouble();
		
		System.out.print("Enter length of drop-off from shallow to deep ");
		double transitionLength = keyboard.nextDouble();
		
		System.out.print("Enter length of the shallow end ");
		double shallowLength = keyboard.nextDouble();
		
		System.out.print("Enter price of first liner ");
		double liner1 = keyboard.nextDouble();
		
		System.out.print("Enter price of second liner ");
		double liner2 = keyboard.nextDouble();
		
		System.out.print("Enter price of third liner ");
		double liner3 = keyboard.nextDouble();
		
		keyboard.close();
		
		//volume of shallow end 
		
		double shallowVolume = CONVERSION_TO_LITRES *(shallowDepth * width * shallowLength); 
		
		//length of deep end, pythagorus formula to find missing side of triangle
		
		double heightIncline = deepDepth - shallowDepth; 
		double xSqrd = (transitionLength * transitionLength) - (heightIncline * heightIncline); //add 'if' statement to make sure values work 
		double xLength = Math.sqrt(xSqrd);
		double deepLength = length - shallowLength - xLength;
		
		//volume of deep end 
		
		double deepVolume = CONVERSION_TO_LITRES * (deepLength * width * deepDepth);//times 1 thousand to convert to liters 
		
		//volume of transition area. Gonna calculate as if it was a rectangle than subtract area of triangle outside rectangle 
		double transitionRectangle = xLength * width * deepDepth;
		double volumeTriangleOutside = .5 * xLength * heightIncline * width;
		double transitionVolume = CONVERSION_TO_LITRES * (transitionRectangle - volumeTriangleOutside);
		
		//total volume and amount of water that needs to be filled
		
		double totalVolume = transitionVolume + deepVolume + shallowVolume;
		double waterLevelUnrounded = totalVolume * LEVEL_OF_WATER;
		double waterLevelMult = (int)(waterLevelUnrounded * 100);
		double waterLevel = waterLevelMult / 100;
		
		//MOVING ON TO POOL LINER CALCULATIONS 
		
		//deep end liner 
		double deepSides = (deepDepth * deepLength) * 2; //times two for both sides 
		double deepFront = deepDepth * width;
		double deepBottom = deepLength * width;
		double deepLiner = deepSides + deepFront + deepBottom;
		
		
		//shallow end liner 
		double shallowSides = (shallowLength * shallowDepth) * 2; //two sides 
		double shallowFront = shallowDepth * width;
		double shallowBottom = shallowLength * width;
		double shallowLiner = shallowSides + shallowFront +shallowBottom;
		
		//transition liner 
		double transitionTriSide = deepDepth * xLength;
		double areaOutsideTriangle = .5 * xLength * heightIncline;
		double transitionBottom = transitionLength * width;
		double transitionLiner = ((transitionTriSide - areaOutsideTriangle) * 2) + transitionBottom;
		 
		// Total liner and costs 
		
		double linerTotal = transitionLiner + shallowLiner + deepLiner;
		
		double linerCost1Unrounded = linerTotal * liner1;
		double linerCost1Mult = (int)(linerCost1Unrounded * 100);
		double linerCost1 = linerCost1Mult / 100;
		
		double linerCost2Unrounded = linerTotal * liner2;
		double linerCost2Mult = (int)(linerCost2Unrounded * 100);
		double linerCost2 = linerCost2Mult / 100;
		
		double linerCost3Unrounded = linerTotal * liner3;
		double linerCost3Mult = (int)(linerCost3Unrounded * 100);
		double linerCost3 = linerCost3Mult / 100;
		
		System.out.print(deepLiner + " " + shallowLiner + " " + transitionLiner);
		
		
		
		if (xSqrd < 0) {
			
			System.out.println("Invalid dimensions for the pool");
			
		} else {
			if (linerCost1 < linerCost2 && linerCost1 < linerCost3){
				System.out.println("There should be " + waterLevel + " liters of in the pool");
				System.out.println("Option one for liners is cheapest at $" + linerCost1 + " where option two and three cost $" + linerCost2 + "and $" + linerCost3 + " respectivly");
				
			} else if (linerCost2 < linerCost1 && linerCost2 < linerCost3){
				System.out.println("There should be " + waterLevel + " liters of in the pool");
				System.out.println("Option two for liners is cheapest at $" + linerCost2 + " where option one and three cost $" + linerCost1 + "and $" + linerCost3 + " respectivly");
				
			} else if (linerCost3 < linerCost2 && linerCost3 < linerCost1){
				System.out.println("There should be " + waterLevel + " liters of in the pool");
				System.out.println("Option three for liners is cheapest at $" + linerCost3 + " where option one and two cost $" + linerCost1 + " and $" + linerCost2 + " respectivly");
				
			} else {
				System.out.println("There should be " + waterLevel + " liters of in the pool");
				System.out.println("All three prices on liner are equal with option one being $" + linerCost1 + "option two being $" + linerCost2 + "and option three being $" + linerCost3);
			}
			
			
			
			
		}
		
		
		
		

	}

}
