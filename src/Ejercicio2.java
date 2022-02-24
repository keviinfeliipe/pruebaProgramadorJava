import java.util.*;

public class Ejercicio2 {

    public static List<Integer> paquetes = new ArrayList();
    public static List<Integer> camion = new ArrayList();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int tamanioCamion=0;
        int cantidadCajas=0;

        System.out.println("Ingrese el tamanio camion");
        tamanioCamion = Integer.parseInt(sc.nextLine())-30;

        System.out.println("Ingrese la cantidad de cajas");
        cantidadCajas = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < cantidadCajas; i++) {
            System.out.println("Ingrese el tamanio del paquete#"+(i+1));
            paquetes.add(Integer.parseInt(sc.nextLine()));
        }

        calcularCajas(tamanioCamion);
        System.out.println("La parajeda de cajas cargada es:");
        System.out.println(camion.toString());
    }

    public static void calcularCajas(int tamanioCamion){
        Comparator<Integer> comparador = Collections.reverseOrder();
        Collections.sort(paquetes, comparador);

        for (int i = 0; i < paquetes.size() ; i++) {
            if (!camion.isEmpty()){
                break;
            }
            for (int j = 0; j < paquetes.size() ; j++) {
                if (cargarCamion(tamanioCamion,i,j)){
                    break;
                }
            }
        }

    }

    public static boolean cargarCamion(int tamanioCamion,int tamanio1,int tamanio2){

        if (tamanio1==tamanio2){
            return false;
        }
        var tamanioTotal=paquetes.get(tamanio1)+paquetes.get(tamanio2);
        if(tamanioTotal<=tamanioCamion){
            camion.add(paquetes.get(tamanio1));
            camion.add(paquetes.get(tamanio2));
            return true;
        }
        return false;
    }
}
