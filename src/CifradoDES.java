import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class CifradoDES {

    // Función para obtener selección de usuario en el menu
    public static int getData() {
        Scanner entradaDeDatos = new Scanner(System.in);
        int seleccionUsuario = 0;
        seleccionUsuario = entradaDeDatos.nextInt();
        return seleccionUsuario;
    }

    // Función para generar una clave y guardarla en un archivo
    public static void generarYGuardarClave(String rutaArchivo) throws NoSuchAlgorithmException, IOException {
        KeyGenerator keygen = KeyGenerator.getInstance("DES");
        SecretKey key = keygen.generateKey();

        FileOutputStream keyFos = new FileOutputStream(rutaArchivo);
        ObjectOutputStream keyOos = new ObjectOutputStream(keyFos);
        keyOos.writeObject(key);
        keyOos.close();
    }

    // Función para leer una clave desde un archivo
    public static SecretKey leerClave(String rutaArchivo) throws IOException, ClassNotFoundException {
        FileInputStream keyFis = new FileInputStream(rutaArchivo);
        ObjectInputStream keyOis = new ObjectInputStream(keyFis);
        SecretKey storedKey = (SecretKey) keyOis.readObject();
        keyOis.close();
        return storedKey;
    }

    public static void main(String[] args) {
        // Programa principal, cifra y descifra el contenido de un fichero utilizando una clave.

        int seleccionUsuario = 0;
        Scanner entradaDeDatos = new Scanner(System.in);
        String nombreArchivo = "";
        String rutaPrincipal = "";
        Path rutaFinal;
        File fichero;
        Cipher desCipher;
        byte[] lectura;
        byte[] mensajeCifrado;
        byte[] mensajeDescifrado;

        try {
            // Verificar si existe el archivo de clave, si no, generarlo
            String rutaArchivoClave = rutaPrincipal + "clave.key";
            File archivoClave = new File(rutaArchivoClave);
            if (!archivoClave.exists()) {
                generarYGuardarClave(rutaArchivoClave);
            }

            do {
                System.out.println("CIFRADOR DES");
                System.out.println("Selecciona una opción (Salir del programa para guardar textos encriptados):");
                System.out.println("    1. Cifrar en DES");
                System.out.println("    2. Descifrar en DES");
                System.out.println("    3. Salir");

                System.out.print("Opción: ");
                try {
                    seleccionUsuario = getData();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                switch (seleccionUsuario) {
                    case 1:
                        // Obtener nombre de fichero para cifrar
                        System.out.print("Introduce el nombre del fichero para cifrar: ");
                        nombreArchivo = entradaDeDatos.next();
                        rutaFinal = Paths.get(rutaPrincipal + nombreArchivo);
                        fichero = new File(rutaPrincipal + nombreArchivo);

                        if (!fichero.exists()) {
                            System.out.println("El fichero no existe, volviendo al menu principal");
                            continue;
                        } else if (!fichero.canRead()) {
                            System.out.println("No se puede leer el fichero, volviendo al menu principal");
                        } else {
                            try {
                                // Leer el archivo y guardar sus datos en una cadena
                                lectura = Files.readAllBytes(rutaFinal); // Leer el contenido del fichero
                                System.out.println("El contenido del fichero para cifrar es: " + new String(lectura));

                                // Introducir la key en el cifrador
                                desCipher = Cipher.getInstance("DES");
                                desCipher.init(Cipher.ENCRYPT_MODE, leerClave(rutaArchivoClave));

                                // Cifrar el contenido del fichero
                                mensajeCifrado = desCipher.doFinal(lectura);
                                System.out.println("El mensaje cifrado es: " + new String(mensajeCifrado));

                                // Guardar el contenido del fichero cifrado en un nuevo fichero
                                fichero = new File("CIFRADO_" + nombreArchivo);
                                FileOutputStream fos = new FileOutputStream(fichero, false);
                                fos.write(mensajeCifrado);
                                fos.close();
                                System.out.println("Fichero cifrado creado: " + rutaPrincipal + "CIFRADO_" + nombreArchivo);

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                    case 2:
                        // Obtener nombre de fichero para cifrar
                        System.out.print("Introduce el nombre del fichero para descifrar: ");
                        nombreArchivo = entradaDeDatos.next();
                        rutaFinal = Paths.get(rutaPrincipal + nombreArchivo);
                        fichero = new File(rutaPrincipal + nombreArchivo);

                        if (!fichero.exists()) {
                            System.out.println("El fichero no existe, volviendo al menu principal");
                            continue;
                        } else if (!fichero.canRead()) {
                            System.out.println("No se puede leer el fichero, volviendo al menu principal");
                        } else {
                            try {
                                // Leer el archivo y guardar sus datos en una cadena
                                lectura = Files.readAllBytes(rutaFinal); // Leer el contenido del fichero
                                System.out.println("El contenido del fichero cifrado es: " + new String(lectura));

                                // Introducir la key en el cifrador
                                desCipher = Cipher.getInstance("DES");
                                desCipher.init(Cipher.DECRYPT_MODE, leerClave(rutaArchivoClave));

                                // Cifrar el contenido del fichero
                                mensajeDescifrado = desCipher.doFinal(lectura);
                                System.out.println("El mensaje original era: " + new String(mensajeDescifrado));

                                // Guardar el contenido del fichero cifrado en un nuevo fichero
                                fichero = new File(rutaPrincipal + "DESCIFRADO_" + nombreArchivo.substring(nombreArchivo.indexOf("_")));
                                FileOutputStream fos = new FileOutputStream(fichero, false);
                                fos.write(mensajeDescifrado);
                                fos.close();
                                System.out.println("Fichero cifrado creado: " + rutaPrincipal + "DESCIFRADO_" + nombreArchivo.substring(nombreArchivo.indexOf("_")));

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Fin del programa");
                        break;
                    default:
                        System.out.println("Introduzca un valor válido");
                        break;
                }
            } while (seleccionUsuario != 3);
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
    }
}
