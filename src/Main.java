
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * PENEVAL Descifrado - FASE 3 ----------------------------
 *
 * @author Rubén
 */
public class Main {

    private static File ficheroOrigen, ficheroClave, ficheroClaveOrigen, ficheroDescodificado;
    private static String rutaFicheroOrigen;
    private static String rutaFicheroDescodificado;
    private static String rutaFicheroClave;
    private static String rutaFicheroClaveOrigen;
    private static Ventana ventana;

    public static void main(String[] args) {
        //Creación y visualización de la interfaz gráfica.
        ventana = new Ventana();
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);

        rutaFicheroOrigen = "./src/ficheros/fichero_codificado.txt";
        rutaFicheroClaveOrigen = "./src/ficheros/fichero_clave_codificado.txt";
        rutaFicheroClave = "./src/ficheros/fichero_clave_privada.txt";
        rutaFicheroDescodificado = "./src/ficheros/fichero_descodificado.txt";
    }

    public static void descifrarClave() {
        BufferedReader br = null;
        try {
            ventana.setTextoConsola("Leyendo clave...");
            br = new BufferedReader(new FileReader(ficheroClave));
            BigInteger modulus = new BigInteger(br.readLine());
            BigInteger exponente = new BigInteger(br.readLine());
            RSAPublicKeySpec keyspec = new RSAPublicKeySpec(modulus, exponente);
            KeyFactory keyfac = KeyFactory.getInstance("RSA");
            Key public_key = keyfac.generatePublic(keyspec);
            ventana.setTextoConsola("Generando factoría de clave RSA...");
            Cipher desCipher = Cipher.getInstance("RSA");
            desCipher.init(Cipher.DECRYPT_MODE, public_key);
            ventana.setTextoConsola("Desencriptando clave...");
            FileInputStream is = new FileInputStream(ficheroClaveOrigen);
            byte[] clave = null;
            byte[] buffer = new byte[128];
            int bytes_leidos = is.read(buffer);
            while (bytes_leidos != -1) {
                clave = desCipher.doFinal(buffer, 0, bytes_leidos);
                bytes_leidos = is.read(buffer);
            }
            br.close();
            ventana.setTextoConsola("Clave desencriptada almacenada.");
            descifrarContenido(clave);
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR en la decodificación de la clave: " + ex);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeySpecException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void descifrarContenido(byte[] clave) {
        if (asignarRutaFicheroDescodificad() && abrirFicheroOrigen()) {
            try {
                ventana.setTextoConsola("Descifrando contenido original...");
                DESKeySpec keyspec = new DESKeySpec(clave);
                SecretKeyFactory keyfac = SecretKeyFactory.getInstance("DES");
                ventana.setTextoConsola("Generando factoría de clave DES...");
                SecretKey key = keyfac.generateSecret(keyspec);
                Cipher desCipher = Cipher.getInstance("DES");
                desCipher.init(Cipher.DECRYPT_MODE, key);
                ventana.setTextoConsola("Desencriptado contenido del fichero original.");
                FileInputStream is = new FileInputStream(ficheroOrigen);
                FileOutputStream os = new FileOutputStream(ficheroDescodificado);
                byte[] buffer = new byte[16];
                int bytes_leidos = is.read(buffer);
                while (bytes_leidos != -1) {
                    os.write(desCipher.doFinal(buffer, 0, bytes_leidos));
                    bytes_leidos = is.read(buffer);
                }
                os.close();
                ventana.setTextoConsola("Fichero desencriptado almacenado.");
                ventana.setProcesoTerminado();
            } catch (InvalidKeyException | IOException | IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeySpecException ex) {
                System.out.println("ERROR en la decodificación del contenido: " + ex);
            }
        } else {

        }

    }

    //Abre el directoio del fichero original encriptado en la fase 1
    public static boolean abrirFicheroOrigen() {
        JFileChooser selector = new JFileChooser(rutaFicheroOrigen);
        selector.setDialogTitle("Abrir fichero original encriptado en la fase 1");
        selector.showOpenDialog(ventana);
        if (selector.getSelectedFile() != null) {
            ficheroOrigen = new File(selector.getSelectedFile().getPath());
            ventana.setTextoConsola("El fichero de origen que se utilizará se encuentra en:\n" + ficheroOrigen.getPath());
            ventana.setFicherosSeleccionados();
            return true;
        } else {
            JOptionPane.showConfirmDialog(ventana, "Debe seleccionar el fichero origen facilitado en la fase 1");
            return false;
        }
    }

    //Muestra el contenido del fichero en la aplicación predeterminada para .txt
    public static void abrirFicheroClave() {
        try {
            java.awt.Desktop.getDesktop().edit(ficheroClave);
        } catch (IOException ex) {
            System.out.println("ERROR en la apertura del fichero clave: " + ex);
        }
    }

    //Muestra el contenido del fichero en la aplicación predeterminada para .txt
    public static void abrirFicheroDescodificado() {
        try {
            java.awt.Desktop.getDesktop().edit(ficheroDescodificado);
        } catch (IOException ex) {
            System.out.println("ERROR en la apertura del fichero codificado: " + ex);
        }
    }

    //Asigna la ruta donde se guardará el fichero original de la fase 1 decodificado
    private static boolean asignarRutaFicheroDescodificad() {
        JFileChooser selector = new JFileChooser(rutaFicheroDescodificado);
        selector.setDialogTitle("Guardar fichero original descodificado");
        selector.showSaveDialog(ventana);
        if (selector.getSelectedFile() != null) {
            ficheroDescodificado = new File(selector.getSelectedFile().getPath());
            ventana.setTextoConsola("El fichero original con el contenido descodificado se almacenará en:\n" + ficheroDescodificado.getPath());
            return true;
        } else {
            return false;
        }
    }

    //Abre el fichero que contiene la clave de la fase 1 codificada con RSA en la fase 2
    public static boolean abrirFicheroClaveCodificada() {
        JFileChooser selector = new JFileChooser(rutaFicheroClaveOrigen);
        selector.setDialogTitle("Abrir fichero con la clave DES codificada RSA en la fase 2");
        selector.showOpenDialog(ventana);
        if (selector.getSelectedFile() != null) {
            ficheroClaveOrigen = new File(selector.getSelectedFile().getPath());
            ventana.setTextoConsola("El fichero con la clave RSA codificada se encuentra en:\n" + ficheroClaveOrigen.getPath());
            ventana.setFicherosSeleccionados();
            return true;
        } else {
            return false;
        }
    }

    //Abre el fichero que con tiene la clave RSA de la fase 2
    public static boolean abrirFicheroClaveFase2() {
        JFileChooser selector = new JFileChooser(rutaFicheroClave);
        selector.setDialogTitle("Abrir fichero con la clave RSA en la fase 2");
        selector.showOpenDialog(ventana);
        if (selector.getSelectedFile() != null) {
            ficheroClave = new File(selector.getSelectedFile().getPath());
            ventana.setTextoConsola("El fichero con la clave RSA se encuentra en:\n" + ficheroClave.getPath());
            return true;
        } else {
            return false;
        }
    }
}
