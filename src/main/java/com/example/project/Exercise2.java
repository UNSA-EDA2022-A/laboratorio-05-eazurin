package com.example.project;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Exercise2 obj = new Exercise2();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            System.out.println(obj.existenDuplicados(s));
        }
    }

    public boolean existenDuplicados(String str) {
        MyStack<Character> stack = new LinkedListStack<>();
        for(int i = 0; i < str.length(); i++) {
        	Character miCaracter = str.charAt(i);   //Extraemos caracter de la pocision i de la cadena
        	if (miCaracter.compareTo(')') != 0) {
        		stack.push(miCaracter);  //Si el caracter no es un ) lo agregara
        	}
        	else {  //De lo contrario
        		if (stack.top().compareTo('(') == 0) {  //Si encontramos en el tope un ( la expresion sera ((exp)) y retornaremos true
        			return true;   
        	    }
        		else { //Si en el tope no hay un ( es porque hay un + - a o b
        			while (stack.top() != '(') {  //por lo tanto elimiraremos esa expresion  
                        stack.pop();
                    }
        			stack.pop();     //hasta el (, por ejemplo todo esto (exp) por eso de esa manera si la expresion fuera ((exp)) 
        			//primero eliminaria (exp) y quedaria () y en la siguiente pasada entraria al if
        		}
 
        		
        	}
        }
        //Si no entraria al if es porque no tiene parentesis extras
       return false;   
                                 
    }
}
