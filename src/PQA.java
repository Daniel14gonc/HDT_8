/*
 *  Nombre: Daniel Gonzalez Carrillo
 *  Clase: PQA
 *  Modificacion: 21.04.2021
 *  Descripcion: Clase que permite simular un hospital utilizando la implementacion de
 *               priority queue hecha por el estudiante.
 *
 */



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PQA {

    public PQA(){

    }

    public void administrar(){
        try {
            //Post: Se lee el archivo de pacientes y se devuelve el siguiente en cola.
            File myObj = new File("pacientes.txt");
            Scanner myReader = new Scanner(myObj);
            PriorityQueue<Paciente> priorityQueue = new VectorHeap<Paciente>();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] splitData = data.split(",");
                Paciente temp = new Paciente(splitData[0].trim(), splitData[1].trim(),splitData[2].trim());
                priorityQueue.add(temp);
            }
            myReader.close();

            myReader = new Scanner(System.in);
            int op =0;
            while(op != 2){
                try{
                    //Se solicita la opcion que se desea hacer en el hospital.
                    System.out.println("Elija la opcion que desea realizar con la cola de pacientes.");
                    System.out.println("1. Retirar un paciente.");
                    System.out.println("2. Salir del programa.");

                    op = myReader.nextInt();

                    if(op > 0 && op < 3){
                        if(op == 1){
                            //Se muestra
                            Paciente actual = priorityQueue.remove();
                            if(actual != null)
                                System.out.println("El siguiente paciente es: " + actual.toString());
                            else{
                                System.out.println("Ya no hay pacientes en fila. Gracias por usar el programa.");
                                op = 2;
                            }
                        }
                    }
                    else{
                        System.out.println("Elija una opcion correcta.");
                    }
                }
                catch (Exception e){
                    System.out.println("Ingrese una opcion valida");
                }

            }


        } catch (FileNotFoundException e) {
            System.out.println("Ocurrio un error. Intente de nuevo.");
            //e.printStackTrace();
        }
    }
}
