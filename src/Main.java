import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            PQA priorityA = new PQA();
            PQC priorityC = new PQC();
            Scanner scan = new Scanner(System.in);
            System.out.println("Bienvenido al administrador de prioridad hospitalaria.");
            System.out.println("Por favor, indique el tipo de estructura donde desea almacenar los pacientes.");
            System.out.println("1. Priority Queue Artesanal (hecha por un estudiante UVG).");
            System.out.println("2. Priority Queue de Java collections framework (la mas gacha).");
            System.out.print("> ");
            int op = scan.nextInt();

            if(op == 1)
                priorityA.administrar();
            else if(op == 2)
                priorityC.administrar();
            else
                System.out.println("Ingrese una opcion valida.");
        }catch (Exception e){
            System.out.println("Ingrese una opcion valida.");
        }

    }
}
