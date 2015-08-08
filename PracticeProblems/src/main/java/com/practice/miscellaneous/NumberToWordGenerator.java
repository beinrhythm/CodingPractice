package com.practice.miscellaneous;

public class NumberToWordGenerator {

	String[] ABOVE_NUMBERS = {"","","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
	String[] FIRST_TWENTY = {"","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
	String[] POSITIONS = {"","","","hundred","thousand","thousand","thousand","million","million","million"}; 
	public final static String ZERO = "zero"; 
	
	public static void main(String[] args){
		NumberToWordGenerator nsg = new NumberToWordGenerator();
		System.out.println(nsg.translate(101,new StringBuffer(),true));
		System.out.println(nsg.translate(0,new StringBuffer(),true));
		System.out.println(nsg.translate(113,new StringBuffer(),true));
		System.out.println(nsg.translate(123,new StringBuffer(),true));
		System.out.println(nsg.translate(53,new StringBuffer(),true));
		System.out.println(nsg.translate(1153,new StringBuffer(),true));
		System.out.println(nsg.translate(422353,new StringBuffer(),true));
		System.out.println(nsg.translate(5422353,new StringBuffer(),true));
		System.out.println(nsg.translate(542422353,new StringBuffer(),true));
		
	}
	
	
	public String translate(int number,StringBuffer str,boolean shouldAppend){
		if(number == 0){
			str.append(ZERO);
			return str.toString();
		}
		if(number < 20){
			str.append(FIRST_TWENTY[number] + " ");
			return str.toString();
		}
		
		String numStr = Integer.toString(number);
		char[] chars = numStr.toCharArray();
		
		if(chars.length == 2){
			str.append(ABOVE_NUMBERS[Integer.parseInt(Character.toString(chars[0]))] + " ");
			str.append(FIRST_TWENTY[Integer.parseInt(Character.toString(chars[1]))] + " ");
			return str.toString();
		}
		
		if(chars.length == 3){
			str.append(FIRST_TWENTY[Integer.parseInt(Character.toString(chars[0]))] + " ");
			if(shouldAppend){
				str.append(POSITIONS[chars.length] + " ");
			}
			StringBuffer formNumber = new StringBuffer();
			for(int i=1; i<chars.length;i++){
				formNumber.append(chars[i]);
			}
			translate(Integer.parseInt(formNumber.toString()),str,true);
		}

		if(chars.length > 3){
			StringBuffer formNumber = new StringBuffer();
			int i=0;
			int groups = chars.length / 3;
			if(chars.length % 3 ==0){
				groups--;
			}
			for(i=0;i< chars.length - 3*groups;i++){
				formNumber.append(chars[i]);
			}
			translate(Integer.parseInt(formNumber.toString()),str,false);
			str.append(POSITIONS[chars.length] + " ");
			formNumber = new StringBuffer();
			for(;i<chars.length;i++){
				formNumber.append(chars[i]);
			}
			translate(Integer.parseInt(formNumber.toString()),str,true);
		}
		return str.toString();
	}
	

	
}
