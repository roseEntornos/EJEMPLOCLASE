/**
 *
 * @author administrador
 */
public class Comercial {

    private String nombre;
    private int[] unidadesVendidas;
    private static String marcas[] = { "Nike", "Adidas", "Converse" };

    public Comercial(String nombre) {
        this.nombre = nombre;
        this.unidadesVendidas = new int[marcas.length];
    }

    public String getNombre() {
        return nombre;
    }

    public void setUnidadesVendidas(int numVentas, int numMarca) {
        this.unidadesVendidas[numMarca] += numVentas;
    }

    public int getUnidadesVendidas(int numMarca) {
        return unidadesVendidas[numMarca];
    }

    public static int buscarMarca(String marca) {
        for (int i = 0; i < marcas.length; i++) {
            if (marcas[i].equalsIgnoreCase(marca)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        String aux = "Comercial{" + "nombre=" + nombre + ", unidadesVendidas=";
        for (int i = 0; i < marcas.length; i++) {
            aux += "\t" + unidadesVendidas[i];
        }
        return aux;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Comercial other = (Comercial) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        return true;
    }

}
