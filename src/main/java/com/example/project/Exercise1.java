package com.example.project;

import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) {
        Exercise1 obj = new Exercise1();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            System.out.println(obj.esBalanceado(s));
        }
    }

    public boolean esBalanceado(String s) {
        MyStack<Character> stack = new LinkedListStack<>();
        for(int i = 0; i < s.length(); i++) {
        	Character miCaracter = s.charAt(i);   //Extraemos caracter de la pocision i de la cadena
        	if (miCaracter.compareTo('(') == 0 || miCaracter.compareTo('[') == 0 || miCaracter.compareTo('{') == 0) {
        		stack.push(miCaracter);  //Si el caracter es de inicio lo insertaremos en la pila
        	}
        	else {  //si los caracteres son de cierre
        		if (miCaracter.compareTo(')') == 0) {    
        			Character miCaracterPrimero = stack.pop();   //Extraemos y eliminamos el ultimo elemento de la pila
        			if(miCaracterPrimero.compareTo('(') != 0)     //Para que este correcto despues de un simbolo de inicio debe de haber uno de cierre
        				return false;                             //del mismo tipo o otro simbolo de inicio, con el else ya verificamos de que vendra 
        			                                              //un simbolo de cierre por eso ahora solo verificamos que venga un simbolo de cierre
        			                                              //del mismo tipo, si viene no hara nada pero si no retornara falso
        		}
        		else if (miCaracter.compareTo(']') == 0) {
        			Character miCaracterPrimero = stack.pop();
        			if(miCaracterPrimero.compareTo('[') != 0)
        				return false;
        		}
        		else if (miCaracter.compareTo('}') == 0) {
        			Character miCaracterPrimero = stack.pop();
        			if(miCaracterPrimero.compareTo('{') != 0)
        				return false;
        		}
        	}
        }
       return stack.isEmpty();   //Si la pila esta vacia es porque todos los simbolos estaban bien y sera true, de lo contrario seria porque un simbolo
                                 //de inicio se quedo y retornara false
    }
}
