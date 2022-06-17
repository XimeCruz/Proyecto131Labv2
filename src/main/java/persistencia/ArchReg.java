/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import estructuras.Listas.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author W10
 */
public class ArchReg {

    private String PATH = "";   // Ubicacion del archivo
    private String nombre;      // nombre del archivo con xtension
                                // PATH + nombre = la ubicacion del archivo y su nombre
                                // Ej: persistencia/nombre.txt
                                // Usar ubicacion relativa
    public ArchReg(String nombre) {
        this.nombre = nombre;
    }

    public void crear() throws FileNotFoundException, IOException {
        ObjectOutputStream archivo = new ObjectOutputStream(new FileOutputStream(PATH + nombre)); 
        archivo.close();
        System.out.println("Creacion correcta");
    }
    /*
        Metodos para n cantidad de objetos
    */
    /**
     * Lista todos los objetos encontrados en el archivo
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void listarEstructuras() throws FileNotFoundException, IOException {
        ObjectInputStream archivo = new ObjectInputStream(new FileInputStream(PATH + nombre));
        try {
            while (true) {
                Object listaX = archivo.readObject();
                System.out.println(listaX);
            }
        } catch (Exception e) {
            archivo.close();
        }
    }
    /**
     * Lee los objetos guardados en la estructura y los retorna en
     * una lista de objetos
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public LinkedList<Object> leerEstructuras() throws FileNotFoundException, IOException {
        ObjectInputStream archivo = new ObjectInputStream(new FileInputStream(PATH + nombre));
        LinkedList<Object> estruct = new LinkedList<>();
        try {
            while (true) {
                estruct.addLast(archivo.readObject());
            }
        } catch (Exception e) {
            archivo.close();
            return estruct;
        }
    }

    /**
     * Guarda los objetos de la lista estruct en el archivo 
     * Los objetos que estaban escritos en el archivo son reemplazados
     * con los nuevos objetos
     * @param estruct
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void guardarEstructuras(LinkedList<Object> estruct) throws FileNotFoundException, IOException {
        ObjectInputStream archivo = new ObjectInputStream(new FileInputStream(PATH + nombre));
        ObjectOutputStream temp = new ObjectOutputStream(new FileOutputStream(PATH + "tempFile.txt"));
        try {
            while (true) {
                LDNormal listaX = (LDNormal) archivo.readObject();
            }
        } catch (Exception e) {
            // guardar los objetos 
            ListIterator<Object> it = estruct.listIterator();
            while(it.hasNext()){
                Object x = it.next();
                temp.writeObject(x);
            }

            archivo.close();
            temp.close();

            // Reemplazar archivo con temp
            File fArchivo = new File(PATH + nombre);
            File fTemp = new File(PATH + "tempFile.txt");
            fArchivo.delete();
            fTemp.renameTo(fArchivo);

            System.out.println("Escritura correcta");
        }
    }
    /*
        Metodos para un solo objeto del tipo LSimpleP
    */
    /*public void listar() throws FileNotFoundException, IOException {
        ObjectInputStream archivo = new ObjectInputStream(new FileInputStream(PATH + nombre));
        try {
            while (true) {
                LSimpleP listaX = (LSimpleP) archivo.readObject();
                listaX.mostrar();
            }
        } catch (Exception e) {
            archivo.close();
        }
    }*/

    public LDNormal leerObjeto() throws FileNotFoundException, IOException {
        ObjectInputStream archivo = new ObjectInputStream(new FileInputStream(PATH + nombre));
        LDNormal elem = new LDNormal();
        try {
            while (true) {
                elem = (LDNormal) archivo.readObject();
            }
        } catch (Exception e) {
            archivo.close();
            return elem;
        }
    }

    public void guardarObjeto(LDNormal x) throws FileNotFoundException, IOException {
        ObjectInputStream archivo = new ObjectInputStream(new FileInputStream(PATH + nombre));

        ObjectOutputStream temp = new ObjectOutputStream(new FileOutputStream(PATH + "tempFile.txt"));
        try {
            while (true) {
                LDNormal elem = (LDNormal) archivo.readObject();
            }
        } catch (Exception e) {
            temp.writeObject(x);

            archivo.close();
            temp.close();

            // Reemplazar archivo con temp
            File fArchivo = new File(PATH + nombre);
            File fTemp = new File(PATH + "tempFile.txt");
            fArchivo.delete();
            fTemp.renameTo(fArchivo);

            System.out.println("Escritura exitosa");
        }
    }
    
    
    
}
