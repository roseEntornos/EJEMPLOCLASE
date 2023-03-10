import java.util.*;

/**
 *
 * @author administrador
 */
public class Ppal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nombre, marca;
        char otroComercial;
        int numComerciales = 0, numVentas, numMarca = 0, empleVenta = 0, ventasMínimas;
        Scanner sc = new Scanner(System.in);
        Comercial comerciales[] = new Comercial[8];

        do {
            otroComercial = 'S';
            System.out.print("Introduce nombre del comercial: ");
            nombre = sc.nextLine();
            comerciales[numComerciales] = new Comercial(nombre);
            numComerciales++;
            if (numComerciales >= 2 && numComerciales <= 7) {
                System.out.print("¿Otro comercial? (S para otro) --> ");
                otroComercial = sc.nextLine().charAt(0);
            }
        } while (Character.toUpperCase(otroComercial) == 'S' && numComerciales <= 7);

        do {
            do {
                System.out.print("\nIntroduce nombre del comercial de la venta: ");
                nombre = sc.nextLine();
                if (nombre.equalsIgnoreCase("FIN")) {
                    break;
                } else {
                    empleVenta = buscarComercial(comerciales, numComerciales, nombre);
                }
            } while (empleVenta == -1);

            if (nombre.equalsIgnoreCase("FIN")) {
                break;
            }

            do {
                System.out.print("Introduce marca: ");
                marca = sc.nextLine();
                numMarca = Comercial.buscarMarca(marca);
            } while (numMarca == -1);

            do {
                System.out.print("Introduce número de ventas: ");
                numVentas = sc.nextInt();
            } while (numVentas <= 0);

            sc.nextLine();
            comerciales[empleVenta].setUnidadesVendidas(numVentas, numMarca);
            for (int i = 0; i < numComerciales; i++) {
                System.out.println(comerciales[i].toString());
            }
        } while (!nombre.equalsIgnoreCase("FIN"));

        for (int i = 0; i < numComerciales; i++) {
            System.out.println(comerciales[i].toString());
        }

        /* Subida del importe fijo */

        /* Pago a los empleados */

    }

    public static int buscarComercial(Comercial comerciales[], int numComerciales, String nombre) {
        for (int i = 0; i < numComerciales; i++) {
            if (nombre.equals(comerciales[i].getNombre())) {
                return i;
            }
        }
        return -1;
    }

}
